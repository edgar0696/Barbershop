package edu.prj.barbershop.controllers.rest;

import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.client.impls.CrudClientIServiseFakempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
   @Autowired
   CrudClientIServiseFakempl service;

    @RequestMapping("/list")
    List<Client> getClients(){
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Client deleteById(@PathVariable("id") String id) {
        /*Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/
        return service.delete(id);
    }

    @RequestMapping("/get/{id}")
    Client getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PutMapping("/create")
    Client create(@RequestParam Client client) {
        return service.create(client);
    }

    @PutMapping("/update")
    Client update(@RequestParam Client client) {
        return service.update(client);
    }
}
