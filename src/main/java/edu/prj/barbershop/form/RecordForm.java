package edu.prj.barbershop.form;

import edu.prj.barbershop.model.Client;
import edu.prj.barbershop.model.Haircut;

import java.time.LocalDateTime;

public class RecordForm {
    private String id ="";
    private String name ="";
    private String description ="";
    private String start ="";
    private String finish ="";
    private String client ="";
    private String haircut ="";
    private String create_at ="";
    private String modified_at ="";

    public RecordForm() {
    }

    public RecordForm(String name, String description, String start, String finish, String client, String haircut) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.haircut = haircut;
    }

    public RecordForm(String id, String name, String description, String start, String finish, String client, String haircut, String create_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.client = client;
        this.haircut = haircut;
        this.create_at = create_at;
        this.modified_at = modified_at;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getHaircut() {
        return haircut;
    }

    public void setHaircut(String haircut) {
        this.haircut = haircut;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    @Override
    public String toString() {
        return "RecordForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", client='" + client + '\'' +
                ", haircut='" + haircut + '\'' +
                ", create_at='" + create_at + '\'' +
                ", modified_at='" + modified_at + '\'' +
                '}';
    }
}
