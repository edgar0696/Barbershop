package edu.prj.barbershop.service.item.interfaces;

import edu.prj.barbershop.Repository.ItemRepository;
import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CrudItemMongoImpl implements ICrudItem {

    @Autowired
    FakeData data;

    @Autowired
    ItemRepository repository;

    private List<Item> list = new ArrayList<>();

    @PostConstruct
    void init() {
        list = data.getItems();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Item create(Item item) {
        item.setCreated_at(LocalDateTime.now());
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Item update(Item item) {
        item.setModified_at(LocalDateTime.now());
        return repository.save(item);
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        repository.deleteById(id);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }
}
