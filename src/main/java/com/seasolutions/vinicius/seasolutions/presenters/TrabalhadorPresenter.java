package com.seasolutions.vinicius.seasolutions.presenters;

import com.seasolutions.vinicius.seasolutions.models.Cargo;
import com.seasolutions.vinicius.seasolutions.models.Trabalhador;

public class TrabalhadorPresenter {

    private String name;

    private Long id;

    private String cpf;

    private Cargo cargo;


    public TrabalhadorPresenter() {
    }

    public TrabalhadorPresenter(String name, Long id, String cpf, Cargo cargo) {
        this.name = name;
        this.id = id;
        this.cpf = cpf;
        this.cargo = cargo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public TrabalhadorPresenter(Trabalhador model){
        if(model != null) {
            this.id = model.getId();
            this.name = model.getName();
            this.cpf = model.getCpf();
            this.cargo = model.getIdCargo().toModel();
        }
    }

}
