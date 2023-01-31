package com.seasolutions.vinicius.seasolutions.models;

import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;

public class Cargo {

    private Long id;

    private String name;

    private SetorEntity idSetor;

    public Cargo() {
    }

    public Cargo(Long id, String name, SetorEntity idSetor) {
        this.id = id;
        this.name = name;
        this.idSetor = idSetor;
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

    public SetorEntity getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(SetorEntity idSetor) {
        this.idSetor = idSetor;
    }
}
