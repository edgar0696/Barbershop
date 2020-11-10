package edu.prj.barbershop.service.client.impls;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.repository.ClientRepository;
import edu.prj.barbershop.service.client.interfaces.ICrudClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class CrudClientServiceMongoImpl implements ICrudClient {

    @Autowired
    ClientRepository repository;

    @Autowired
    FakeData data;

    private List<Client> list = new ArrayList<>();

   // @PostConstruct
    void init(){
        list = data.getClients();
        repository.saveAll(list);
    }


    @Override
    public Client create(Client client) {
        client.setModified_at(LocalDateTime.now());
        client.setCreated_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client) {
        client.setModified_at(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = this.get(id);
        repository.deleteById(id);
        return client;
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
