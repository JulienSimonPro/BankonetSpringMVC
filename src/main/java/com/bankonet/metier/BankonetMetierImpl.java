package com.bankonet.metier;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

public class BankonetMetierImpl implements IBankonetMetier {
	private IClientDao dao;

	public IClientDao getDao() {
		return dao;
	}

	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void addClient(Client c) {
		dao.addClient(c);
	}

	@Transactional(readOnly = true)
	public List<Client> listClients() {
		return dao.listClients();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void deleteClient(int idClient) {
		dao.deleteClient(idClient);
	}

	@Transactional(readOnly = true)
	public Client editClient(int idClient) {
		return dao.editClient(idClient);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void updateClient(Client c) {
		dao.updateClient(c);
	}

	@Transactional(readOnly = true)
	public List<Client> chercherClients(String motCle) {
		return dao.chercherClients(motCle);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public List<Client> SupprimerClientDontLeNomContient(String motCle) {
		List<Client> clientsASupprimer = dao.chercherClients(motCle);
		for (Client c : clientsASupprimer)
			dao.deleteClient(c.getId());
		return dao.listClients();
	}
}
