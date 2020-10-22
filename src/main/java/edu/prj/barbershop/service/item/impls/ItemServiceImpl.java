package edu.prj.barbershop.service.item.impls;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.item.interfaces.ICrudItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemServiceImpl implements ICrudItem {

    @Autowired
    FakeData data;

    @Override
    public Item create(Item item) {
        if (item.getId()!= null) {
            this.getAll().add(item);
        }else {

            Integer id =
                    //Берем список всех item - ов и превращаем в stream
                    this.getAll().stream()
                            //Превращаем его в стрим Айдишников
                            .map(el -> el.getId())
                    //Айдишники превращаем из стринга в Интеджер
                    .mapToInt(el -> Integer.valueOf(el))
                            //Находим максимальный
                            .max().orElse(0);
            //Максимальный Айдишник увеличиваем на 1 и превращаем
            item.setId(String.valueOf(id+1));
            //И превращаем в стринг
            //Нашему item присваиваем id
            //И закидываем в список
            LocalDateTime now = LocalDateTime.now();
            item.setModified_at(now);
            item.setCreated_at(now);
            this.getAll().add(item);
        }
        return item;
    }

    @Override
    public Item get(String id) {
        return this.getAll().stream().filter(item -> item.getId().equals(id)).findFirst()
                .orElse(null);
    }

    @Override
    public Item update(Item item) {
        String id = item.getId();
        Item itemToUpdate = this.getAll().stream().filter(el -> el.getId().equals(id))
                .findFirst().orElse(null);
        int index = this.getAll().indexOf(itemToUpdate);
        item.setModified_at(LocalDateTime.now());
        this.getAll().set(index, item);
        return item;
    }

    @Override
    public Item delete(String id) {
        Item item = this.get(id);
        this.getAll().remove(item);
        return item;
    }

    @Override
    public List<Item> getAll() {
        return data.getItems();
    }

}
