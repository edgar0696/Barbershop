package edu.prj.barbershop.form;

import java.time.LocalDate;

public class ClientForm {
    private String id = "";
    private String name = "";
    private String gender = "";
    private String description = "";
    private String phone = "";
    private String adress = "";
    private String dateOfBirthday = "";
    private String created_at = "";

    public ClientForm() {
    }

    public ClientForm(String name, String gender, String description, String phone, String adress, String dateOfBirthday) {
        this.name = name;
        this.gender = gender;
        this.description = description;
        this.phone = phone;
        this.adress = adress;
        this.dateOfBirthday = dateOfBirthday;
    }

    public ClientForm(String id, String name, String gender, String description, String phone, String adress, String dateOfBirthday, String created_at, String modified_at) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.description = description;
        this.phone = phone;
        this.adress = adress;
        this.dateOfBirthday = dateOfBirthday;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }

    public ClientForm(String id, String name, String gender, String description, String phone, String adress, String dateOfBirthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.description = description;
        this.phone = phone;
        this.adress = adress;
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    private String modified_at = "";

    @Override
    public String toString() {
        return "ClientForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
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

}