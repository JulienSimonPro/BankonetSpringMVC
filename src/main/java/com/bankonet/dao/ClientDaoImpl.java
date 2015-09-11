package com.bankonet.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bankonet.model.Client;

public class ClientDaoImpl implements IClientDao {

	private EntityManager entityManager;

	public void addClient(Client c) {
		entityManager.persist(c);
	}

	public List<Client> listClients() {
		return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
	}

	public void deleteClient(int idClient) {
		Client c = editClient(idClient);
		entityManager.remove(c);
	}

	public Client editClient(int idClient) {
		return entityManager.find(Client.class, idClient);
	}

	public void updateClient(Client c) {
		entityManager.merge(c);
	}

	public List<Client> chercherClients(String motCle) {
		return entityManager.createQuery("SELECT c FROM Client c WHERE c.nom LIKE :cle OR c.prenom LIKE :cle", Client.class)
				.setParameter("cle", "%" + motCle + "%").getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
