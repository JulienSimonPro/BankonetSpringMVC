package com.bankonet.controller;

import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
public class BankonetController {

	private IBankonetMetier metier;

	@Autowired
	private MessageSource messageSource;

	@Resource(name = "bankonetMetier")
	public void setMetier(IBankonetMetier metier) {
		this.metier = metier;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("clients", metier.listClients());

		return "clientsview";
	}

	@RequestMapping(value = "/saveClient", method = RequestMethod.POST)
	public String saveClient(@Valid Client client, BindingResult result, Model model, Locale locale) {

		if (!result.hasErrors()) {
			String msg;
			if (client.getId() == 0) {
				metier.addClient(client);
				msg = messageSource.getMessage("page.client.ajout", new Object[] { client.getId() }, locale);
			} else {
				metier.updateClient(client);
				msg = messageSource.getMessage("page.client.edition", new Object[] { client.getId() }, locale);
			}

			model.addAttribute("flashMsg", msg);
			model.addAttribute("client", new Client());
		} else {
			model.addAttribute("client", client);
		}

		model.addAttribute("clients", metier.listClients());

		return "clientsview";
	}

	@RequestMapping(value = "/editClient/{idClient}", method = RequestMethod.GET)
	public String editClient(@PathVariable int idClient, Model model, Locale locale) {
		model.addAttribute("client", metier.editClient(idClient));
		model.addAttribute("clients", metier.listClients());

		return "clientsview";
	}

	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String deleteClient(@RequestParam(value = "id", required = true) int idClient, Model model, Locale locale) {
		metier.deleteClient(idClient);

		model.addAttribute("client", new Client());
		model.addAttribute("clients", metier.listClients());

		String msg = messageSource.getMessage("page.client.suppression", new Object[] { idClient }, locale);
		model.addAttribute("flashMsg", msg);

		return "clientsview";
	}

}
