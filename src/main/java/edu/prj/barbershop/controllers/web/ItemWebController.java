package edu.prj.barbershop.controllers.web;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.form.ItemForm;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {

    @Autowired
    ItemServiceImpl service;

    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("items", service.getAll());
        return "itemsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        /*System.out.println("Нажали Delete");
        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/
        return "redirect:/web/item/all";
        //crud CRUD -> create read update delete
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        ItemForm itemForm = new ItemForm();
        model.addAttribute("form" , itemForm);

        return "ItemAddForm";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form, Model model){
        Item item = new Item();
//        item.getName() = form.setName(form.getName());
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);

        return "redirect:/web/item/all";
    }
}
