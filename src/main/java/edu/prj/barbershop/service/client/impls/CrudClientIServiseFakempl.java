package edu.prj.barbershop.service.client.impls;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.client.interfaces.ICrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CrudClientIServiseFakempl implements ICrudClient {

    @Autowired
    FakeData data;

    @Override
    public Client create(Client client) {
        UUID id = UUID.randomUUID();
        client.setId(id.toString());
        client.setCreated_at(LocalDateTime.now());
        client.setModified_at(LocalDateTime.now());
        data.getClients().add(client);
        return client;
    }

    @Override
    public Client get(String id) {
        return null;
    }

    @Override
    public Client update(Client client) {
        String id = client.getId();
        Client clientToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(clientToUpdate);
        client.setModified_at(LocalDateTime.now());
        this.getAll().set(index, client);
        return client;
    }

    @Override
    public Client delete(String id) {
        Client client = this.getAll().stream().filter(element -> element.getId()
                .equals(id)).findFirst().orElse(null);
        this.getAll().remove(client);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return data.getClients();
    }
}
