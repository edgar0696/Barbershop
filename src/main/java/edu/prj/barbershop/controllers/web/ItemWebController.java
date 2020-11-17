package edu.prj.barbershop.controllers.web;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.form.ItemForm;
import edu.prj.barbershop.form.SearchForm;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.service.item.impls.CrudItemMongoImpl;
import edu.prj.barbershop.service.item.impls.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/item")
public class ItemWebController {

    @Autowired
    CrudItemMongoImpl service;

    @RequestMapping("/all")
    String getAll(Model model) {
        model.addAttribute("items", service.getAll());
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
        return "itemsTable";
    }

    @PostMapping("/all")
    String getAll(@ModelAttribute("search")SearchForm form, Model model) {
        String name = form.getName();
        model.addAttribute("items", service.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search", search);
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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model,@PathVariable("id") String id ){
        Item item = service.get(id);
        ItemForm itemForm = new ItemForm();
        itemForm.setId(item.getId());
        itemForm.setName(item.getName());
        itemForm.setDescription(item.getDescription());
//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());
        model.addAttribute("form" , itemForm);
        return "UpdateItem";

    }   @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model,@PathVariable("id") String id,@ModelAttribute("form") ItemForm form ){
        Item item = service.get(id);
        item.setName(form.getName());
        item.setDescription(form.getDescription());
//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());
        service.update(item);
        return "redirect:/web/item/all";
    }

    @RequestMapping(value = "/all/sort/name",method = RequestMethod.GET)
    public String sortedByName(Model model) {
        model.addAttribute("items", service.getAllSortedByName());
        return "itemsTable";
    }

    @RequestMapping(value ="/all/sort/id",method = RequestMethod.GET)
    public String sortedById(Model model) {
        model.addAttribute("items",service.getAllSortedById());
        return "itemsTable";
    }

    @RequestMapping(value ="/all/sort/description",method = RequestMethod.GET)
    public String sortedByDescription(Model model) {
        model.addAttribute("items",service.getAllSortedByDescription());
        return "itemsTable";
    }

    @RequestMapping(value ="/all/sort/created",method = RequestMethod.GET)
    public String sortedByCreated(Model model) {
        model.addAttribute("items",service.getAllSortedByCreated());
        return "itemsTable";
    }

    @RequestMapping(value ="/all/sort/modified",method = RequestMethod.GET)
    public String sortedByModified(Model model) {
        model.addAttribute("items",service.getAllSortedByModified());
        return "itemsTable";
    }
}
