package edu.prj.barbershop.service.client.interfaces;

import edu.prj.barbershop.model.Client;

import java.util.List;

public interface ICrudClient {
    Client create(Client client);
    Client get(String id);
    Client update(Client client);
    Client delete(String id);
    List<Client> getAll();

}
