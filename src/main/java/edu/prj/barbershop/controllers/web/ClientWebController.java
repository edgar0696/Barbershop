package edu.prj.barbershop.controllers.web;

import edu.prj.barbershop.form.ItemForm;
import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.client.impls.CrudClientIServiseFakempl;
import edu.prj.barbershop.service.client.impls.CrudClientServiceMongoImpl;
import edu.prj.barbershop.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/client")
public class ClientWebController {

    @Autowired
    CrudClientServiceMongoImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("clients", service.getAll());
        return "clientsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        /*System.out.println("Нажали Delete");
        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/
        return "redirect:/web/client/all";
        //crud CRUD -> create read update delete
    }

}
