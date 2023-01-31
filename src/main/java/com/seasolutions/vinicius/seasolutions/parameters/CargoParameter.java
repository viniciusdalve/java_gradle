package com.seasolutions.vinicius.seasolutions.parameters;

import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;
import com.seasolutions.vinicius.seasolutions.models.Cargo;
import com.seasolutions.vinicius.seasolutions.models.Setor;

public class CargoParameter {

    private String name;

    private Long id;

    private Setor setor;

    public CargoParameter() {
    }

    public CargoParameter(String name, Long id, Setor idSetor) {
        this.name = name;
        this.id = id;
        this.setor = idSetor;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
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

    public Cargo toModel(){
        Cargo cargo = new Cargo();

        cargo.setName(this.name);
        cargo.setId(this.id);
        cargo.setIdSetor(new SetorEntity(this.setor));

        return cargo;

    }
}
