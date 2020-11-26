package edu.prj.barbershop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
@Document
public class Record {
    @Id
    private String id;
    private String name;
    private String description;
    private LocalDateTime start;
    private LocalDateTime finish;
    private Client client;
    private Haircut haircut;
    private LocalDateTime create_at;
    private LocalDateTime modified_at;

    public Record() {
    }

    public Record(String name, String description, LocalDateTime start, LocalDateTime finish, Client client, Haircut build) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.haircut = build;
    }

    public Record(String id, String name, String description, LocalDateTime start, LocalDateTime finish, Client client, Haircut build, LocalDateTime create_at, LocalDateTime modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.haircut = build;
        this.create_at = create_at;
        this.modified_at = modified_at;
    }

    public Haircut getHaircut() {
        return haircut;
    }

    public void setHaircut(Haircut haircut) {
        this.haircut = haircut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Haircut getBuild() {
        return haircut;
    }

    public void setBuild(Haircut build) {
        this.haircut = build;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getModified_at() {
        return modified_at;
    }

    public void setModified_at(LocalDateTime modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", client=" + client +
                ", haircut=" + haircut +
                ", create_at=" + create_at +
                ", modified_at=" + modified_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return getId().equals(record.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
