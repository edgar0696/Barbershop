package edu.prj.barbershop.service.client.impls;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.service.client.interfaces.ICrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrudClientIServiseFakempl implements ICrudClient {

    @Autowired
    FakeData data;

    @Override
    public Client create(Client client) {
        return null;
    }

    @Override
    public Client get(String id) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public Client delete(String id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return data.getClients();
    }
}
