package edu.prj.barbershop.data;

import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Item;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class FakeData {
    List<Item> items = Stream.of(
            new Item("11", "Coca-Cola", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("22", "Pepsi", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("33", "Fanta", "Drink",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

        List<Client> clients = Stream.of(
                new Client("1","Edgar Yurivich","Chernivtsi","12345",
                        LocalDate.of(1996, Month.JUNE,6),"Chetkiy Paca"),
                new Client("2","Alex","Chernivtsi","12345",
                        LocalDate.of(1996,Month.JUNE,6),"Chetkiy Paca"),
                new Client("3","Lewa","Chernivtsi","12345",
                        LocalDate.of(1996,Month.JUNE,6),"Chetkiy Paca"),
                new Client("4","Kolia","Chernivtsi","12345",
                        LocalDate.of(1996,Month.JUNE,6),"Chetkiy Paca")

        ).collect(Collectors.toList());

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
