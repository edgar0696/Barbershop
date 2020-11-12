package edu.prj.barbershop.service.item.impls;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.repository.ItemRepository;
import edu.prj.barbershop.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrudItemMongoImpl implements ICrudItem {

    @Autowired
    ItemRepository repository;

    @Autowired
    FakeData data;

    private List<Item> list = new ArrayList<>();

    @PostConstruct
    void init(){
        list = data.getItems();
        System.out.println(list);
        repository.saveAll(list);
    }


    @Override
    public Item create(Item item) {
        item.setModified_at(LocalDateTime.now());
        item.setCreated_at(LocalDateTime.now());
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

    public List<Item> getAllSortedByName() {
        List<Item> list = repository.findAll();
        List<Item> sorted = list.stream()
                .sorted(Comparator.comparing(Item::getName))
                .collect(Collectors.toList());
        return sorted;
    }
}
