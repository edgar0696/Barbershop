package edu.prj.barbershop.controllers.web;

import edu.prj.barbershop.form.ClientForm;
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
@RequestMapping("web/client")
public class ClientWebController {
    @Autowired
    CrudClientServiceMongoImpl service;
    /*    List<Client> clients = Stream.of(
                new Client("0", "Alexandr Botezat", "0507072384",
                        LocalDateTime.now(), LocalDateTime.now()),
                new Client("1", "Alexandr NeBotezat", "1507072384",
                        LocalDateTime.now(), LocalDateTime.now()),
                new Client("2", "Alexandr Gotezat", "2507072384",
                        LocalDateTime.now(), LocalDateTime.now())
        ).collect(Collectors.toList());*/
    @RequestMapping("/list")
    String getList(Model model){
        model.addAttribute("clients", service.getAll());
        return "clientsTable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id){
        service.delete(id);
        /*Client client = clients.stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);*/
        /*        clients.remove(client);*/
        return "redirect:/web/client/list";
    }
    @RequestMapping("/edit/{id}")
    String editById(@PathVariable("id") String id, Model model){
        Client client = service.get(id);
        ClientForm form = new ClientForm();
        form.setName(client.getName());
        form.setDescription(client.getDescription());
        model.addAttribute("form", form);
        return "ClientAddForm";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String editById(@ModelAttribute("form") ClientForm form, @PathVariable("id") String id, Model model){
        Client client = service.get(id);
        client.setName(form.getName());
        client.setDescription(form.getDescription());
        service.update(client);
        return "redirect:/web/client/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        ClientForm clientForm = new ClientForm();
        model.addAttribute("form", clientForm);
        return "ClientAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") ClientForm form, Model model) {
        Client client = new Client();
        client.setName(form.getName());
        client.setDescription(form.getDescription());
        client.setPhone(form.getPhone());
        service.create(client);
        return "redirect:/web/client/list";
    }

}