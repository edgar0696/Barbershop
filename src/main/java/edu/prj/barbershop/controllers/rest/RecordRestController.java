package edu.prj.barbershop.controllers.rest;

import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.model.Record;
import edu.prj.barbershop.service.item.impls.CrudItemMongoImpl;
import edu.prj.barbershop.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordRestController {
    @Autowired
    ServiceRecordMongoImpl service;

    @RequestMapping("/get/all")
    List<Record> getAll() {
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Record deleteById(@PathVariable("id") String id) {
        /*Record record = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(record);*/
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Record getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping("/create")
    Record create(@RequestParam Record record) {
        return service.create(record);
    } //@RequestBody ??

    @PutMapping("/update")
    Record update(@RequestParam Record record) {
        return service.update(record);
    }
}
