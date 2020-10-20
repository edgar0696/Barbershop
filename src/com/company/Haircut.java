package com.company;

import java.util.Objects;

public class Haircut {
    private String id;
    private String haircutName;
    private String gender;
    private int cost;

    public Haircut() {
    }

    public Haircut(String haircutName, String gender, int cost) {
        this.haircutName = haircutName;
        this.gender = gender;
        this.cost = cost;
    }

    public Haircut(String id, String haircutName, String gender, int cost) {
        this.id = id;
        this.haircutName = haircutName;
        this.gender = gender;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHaircutName() {
        return haircutName;
    }

    public void setHaircutName(String haircutName) {
        this.haircutName = haircutName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Haircut{" +
                "id='" + id + '\'' +
                ", haircutName='" + haircutName + '\'' +
                ", gender='" + gender + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Haircut haircut = (Haircut) o;
        return getId().equals(haircut.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
