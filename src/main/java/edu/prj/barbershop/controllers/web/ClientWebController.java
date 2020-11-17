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

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        client.setGender(form.getGender());
        client.setAdress(form.getAdress());
        String birthdayAsString = form.getDateOfBirthday();
        //    client.setDateOfBirthday(form.getDateOfBirthday());
        LocalDate birthdayAsDate = LocalDate.parse(birthdayAsString);
        client.setDateOfBirthday(birthdayAsDate);
        service.create(client);
        return "redirect:/web/client/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model){
        Client client = service.get(id);
        ClientForm clientForm = new ClientForm();
        clientForm.setId(client.getId());
        clientForm.setName(client.getName());
        clientForm.setAdress(client.getAdress());
        clientForm.setGender(client.getGender());
        clientForm.setPhone(client.getPhone());
        clientForm.setDateOfBirthday(client.getDateOfBirthday().toString());
        clientForm.setDescription(client.getDescription());
        model.addAttribute("form", clientForm);
        /*Client client = service.get(id);
        ClientForm form = new ClientForm();
        form.setName(client.getName());
        form.setDescription(client.getDescription());
        model.addAttribute("form", form);*/
        return "updateClient";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute("form") ClientForm form, @PathVariable("id") String id, Model model){
        Client client = service.get(id);
        client.setName(form.getName());
        client.setAdress(form.getAdress());
        client.setGender(form.getGender());
        client.setPhone(form.getPhone());
        String birthdayAsString = form.getDateOfBirthday();
//        client.setDateOfBirthday(clientForm.getDateOfBirthday());
        LocalDate birthdayAsDate = LocalDate.parse(birthdayAsString);
        client.setDateOfBirthday(birthdayAsDate);
        client.setDescription(form.getDescription());
        service.update(client);
        /*Client client = service.get(id);
        client.setName(form.getName());
        client.setDescription(form.getDescription());
        service.update(client);*/
        return "redirect:/web/client/list";
    }

}