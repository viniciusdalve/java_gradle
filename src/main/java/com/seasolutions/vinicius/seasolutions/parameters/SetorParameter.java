package com.seasolutions.vinicius.seasolutions.parameters;

import com.seasolutions.vinicius.seasolutions.models.Setor;

public class SetorParameter {

    private String name;

    private Long id;

    public SetorParameter() {
    }

    public SetorParameter(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Setor toModel(){
        Setor setor = new Setor();

        setor.setName(this.name);
        setor.setId(this.id);

        return setor;

    }
}
