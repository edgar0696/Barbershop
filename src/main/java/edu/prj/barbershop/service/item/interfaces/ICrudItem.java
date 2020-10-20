package edu.prj.barbershop.service.item.interfaces;

import edu.prj.barbershop.model.Item;

import java.util.List;

public interface ICrudItem {
    Item create(Item item);
    Item get(String id);
    Item update(Item item);
    Item delete(String id);
    List<Item> getAll();

}
