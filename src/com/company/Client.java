package com.company;

import java.util.Objects;

public class Client {
    private String id;
    private String fulName;
    private String gender;
    private boolean regularClient;

    public Client() {
    }

    public Client(String fulName, String gender, boolean regularClient) {
        this.fulName = fulName;
        this.gender = gender;
        this.regularClient = regularClient;
    }

    public Client(String id, String fulName, String gender, boolean regularClient) {
        this.id = id;
        this.fulName = fulName;
        this.gender = gender;
        this.regularClient = regularClient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isRegularClient() {
        return regularClient;
    }

    public void setRegularClient(boolean regularClient) {
        this.regularClient = regularClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", fulName='" + fulName + '\'' +
                ", gender='" + gender + '\'' +
                ", regularClient=" + regularClient +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return getId().equals(client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
