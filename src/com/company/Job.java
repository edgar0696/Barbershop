package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Job {
    private String id;
    private Haircut haircut;
    private Client client;
    private LocalDateTime date;

    public Job() {
    }

    public Job(Haircut haircut, Client client, LocalDateTime date) {
        this.haircut = haircut;
        this.client = client;
        this.date = date;
    }

    public Job(String id, Haircut haircut, Client client, LocalDateTime date) {
        this.id = id;
        this.haircut = haircut;
        this.client = client;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Haircut getHaircut() {
        return haircut;
    }

    public void setHaircut(Haircut haircut) {
        this.haircut = haircut;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id='" + id + '\'' +
                ", haircut=" + haircut +
                ", client=" + client +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId().equals(job.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
