package edu.prj.barbershop.controllers.web;

import edu.prj.barbershop.form.ItemForm;
import edu.prj.barbershop.form.SearchForm;
import edu.prj.barbershop.model.Item;
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

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("records", service.getAll());
        return "recordsTable";
    }


}
