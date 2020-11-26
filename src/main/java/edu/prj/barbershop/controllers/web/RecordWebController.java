package edu.prj.barbershop.controllers.web;

import edu.prj.barbershop.data.FakeData;
import edu.prj.barbershop.form.ItemForm;
import edu.prj.barbershop.form.RecordForm;
import edu.prj.barbershop.form.SearchForm;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.model.Record;
import edu.prj.barbershop.service.item.impls.CrudItemMongoImpl;
import edu.prj.barbershop.service.record.impls.ServiceRecordMongoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/record")
public class RecordWebController {

    @Autowired
    ServiceRecordMongoImpl service;

    @Autowired
    FakeData fakeData;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("records", service.getAll());
        return "recordsTable";
    }

    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        service.delete(id);
        /*System.out.println("Нажали Delete");
        Item item = service.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
        service.getAll().remove(item);*/
        return "redirect:/web/record/list";
        //crud CRUD -> create read update delete
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        RecordForm recordForm = new RecordForm();
        model.addAttribute("form" , recordForm);

        return "recordAddForm";
    }
    /*@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ItemForm form, Model model){
        Item item = new Item();
//        item.getName() = form.setName(form.getName());
        item.setName(form.getName());
        item.setDescription(form.getDescription());
        service.create(item);

        return "redirect:/web/item/all";
    }*/

    @RequestMapping("/renew")
    String renew(Model model) {
        model.addAttribute("records", fakeData.renewRecords());
        return "recordsTable";
    }

}
