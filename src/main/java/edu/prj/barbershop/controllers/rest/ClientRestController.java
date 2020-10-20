package edu.prj.barbershop.controllers.rest;

import com.sun.org.apache.xpath.internal.SourceTree;
import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {
   @Autowired
    ClientServiceImpl service;

    @RequestMapping("/list")

    List<Client> getAll(){
        return service.getAll();
    }

    @RequestMapping("/delete/{id}")
    Client deleteById(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
