package com.bankonet.metier;

import java.util.List;

import com.bankonet.dao.IClientDao;
import com.bankonet.model.Client;

public interface IBankonetMetier {

	public abstract IClientDao getDao();

	public abstract void setDao(IClientDao dao);

	public abstract void addClient(Client c);

	public abstract List<Client> listClients();

	public abstract void deleteClient(int idClient);

	public abstract Client editClient(int idClient);

	public abstract void updateClient(Client c);

	public abstract List<Client> chercherClients(String motCle);

	public abstract List<Client> SupprimerClientDontLeNomContient(String motCle);

}
