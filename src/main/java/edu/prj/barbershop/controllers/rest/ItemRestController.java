package edu.prj.barbershop.controllers.rest;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {
    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/get/all")

    List<Item> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Item deleteById(@PathVariable("id") String id) {
        /*Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Item getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping("/create")
    Item create(@RequestParam Item item) {
        return service.create(item);
    }
}
