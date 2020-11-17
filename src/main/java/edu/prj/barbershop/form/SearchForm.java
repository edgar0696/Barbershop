package edu.prj.barbershop.form;

import java.util.stream.Stream;

public class SearchForm {
    private String name;

    public SearchForm() {
    }

    public SearchForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SearchForm{" +
                "name='" + name + '\'' +
                '}';
    }
}

