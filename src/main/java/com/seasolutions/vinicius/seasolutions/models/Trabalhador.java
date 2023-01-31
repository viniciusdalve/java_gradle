package com.seasolutions.vinicius.seasolutions.models;

import com.seasolutions.vinicius.seasolutions.entities.CargoEntity;
import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;

public class Trabalhador {

    private Long id;

    private String name;

    private String cpf;

    private CargoEntity idCargo;

    private SetorEntity idSetor;

    public Trabalhador() {
    }

    public Trabalhador(Long id, String name, String cpf, CargoEntity idCargo, SetorEntity idSetor) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.idCargo = idCargo;
        this.idSetor = idSetor;
    }

    public SetorEntity getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(SetorEntity idSetor) {
        this.idSetor = idSetor;
    }

    public CargoEntity getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(CargoEntity idCargo) {
        this.idCargo = idCargo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}




