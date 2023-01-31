package com.seasolutions.vinicius.seasolutions.models;

public class Setor {

    private Long id;

    private String name;

    public Setor() {
    }

    public Setor(Long id, String name, Long idSetor) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
