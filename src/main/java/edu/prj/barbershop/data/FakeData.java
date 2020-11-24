package edu.prj.barbershop.data;

import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Haircut;
import edu.prj.barbershop.model.Item;
import edu.prj.barbershop.model.Record;
import edu.prj.barbershop.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class FakeData {

    @Autowired
    RecordRepository recordRepository;

    List<Client> clients = Stream.of(
            new Client("1","Edgar Yurivich","","Chernivtsi","111",
                    LocalDate.of(1996, Month.JUNE,6),"Chetkiy Paca"),
            new Client("2","Alex","","Chernivtsi","222",
                    LocalDate.of(1996,Month.JUNE,6),"Bomj Paca"),
            new Client("3","Lewa","","Chernivtsi","333",
                    LocalDate.of(1996,Month.JUNE,6),"Hren Paca"),
            new Client("4","Kolia","","Chernivtsi","444",
                    LocalDate.of(1996,Month.JUNE,6),"Bom_bom Paca")

    ).collect(Collectors.toList());
    
    private List<Haircut> haircuts = Stream.of(
            new Haircut("1","haircut1","barbarshop",LocalDateTime.now(),LocalDateTime.now()),
            new Haircut("2","haircut2","barbarshop",LocalDateTime.now(),LocalDateTime.now()),
            new Haircut("3","haircut3","barbarshop",LocalDateTime.now(),LocalDateTime.now()),
            new Haircut("4","haircut4","barbarshop",LocalDateTime.now(),LocalDateTime.now())
    ).collect(Collectors.toList());

    private List<Record> records = Stream.of(
            new Record("1","record1","description1",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(0), haircuts.get(0), LocalDateTime.now(),LocalDateTime.now()),
            new Record("2","record2","description2",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(0), haircuts.get(0), LocalDateTime.now(),LocalDateTime.now()),
            new Record("3","record3","description3",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(0), haircuts.get(0), LocalDateTime.now(),LocalDateTime.now()),
            new Record("4","record4","description4",LocalDateTime.now(),LocalDateTime.now(),
                    clients.get(0), haircuts.get(0), LocalDateTime.now(),LocalDateTime.now()))
            .collect(Collectors.toList());

    List<Item> items = Stream.of(
            new Item("1", "Coca-Cola", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("2", "Pepsi", "Drink",
                    LocalDateTime.now(), LocalDateTime.now()),
            new Item("3", "Fanta", "Drink",
                    LocalDateTime.now(), LocalDateTime.now())
    ).collect(Collectors.toList());

    @PostConstruct
    void init(){
        recordRepository.deleteAll();
        recordRepository.saveAll(records);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    public List<Haircut> getHaircuts() {
        return haircuts;
    }

    public void setHaircuts(List<Haircut> haircuts) {
        this.haircuts = haircuts;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

}
