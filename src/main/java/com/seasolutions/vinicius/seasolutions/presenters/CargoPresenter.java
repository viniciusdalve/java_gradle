package com.seasolutions.vinicius.seasolutions.presenters;

import com.seasolutions.vinicius.seasolutions.models.Cargo;
import com.seasolutions.vinicius.seasolutions.models.Setor;

public class CargoPresenter {

    private String name;

    private Long id;

    private Setor setor;


    public CargoPresenter() {
    }

    public CargoPresenter(String name, Long id, Setor setor) {
        this.name = name;
        this.id = id;
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public CargoPresenter(Cargo model){
        if(model != null) {
            this.id = model.getId();
            this.name = model.getName();
            this.setor = model.getIdSetor().toModel();

        }
    }

}
