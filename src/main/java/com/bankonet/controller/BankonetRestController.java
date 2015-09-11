package com.bankonet.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
@RequestMapping(value = "rest")
public class BankonetRestController {

	private IBankonetMetier metier;

	@Resource(name = "bankonetMetier")
	public void setMetier(IBankonetMetier metier) {
		this.metier = metier;
	}

	@RequestMapping(value = "/listClients/{motCle}", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> listClients(@PathVariable("motCle") String motCle) {
		return metier.chercherClients(motCle);
	}

	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void addClient(@RequestBody Client client) {
		metier.addClient(client);
	}

	@RequestMapping(value = "/deleteClient/{idClient}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteClient(@PathVariable("idClient") int idClient) {
		metier.deleteClient(idClient);
	}
}
