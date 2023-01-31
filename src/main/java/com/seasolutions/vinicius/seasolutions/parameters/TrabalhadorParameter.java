package com.seasolutions.vinicius.seasolutions.parameters;

import com.seasolutions.vinicius.seasolutions.entities.CargoEntity;
import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;
import com.seasolutions.vinicius.seasolutions.models.Cargo;
import com.seasolutions.vinicius.seasolutions.models.Setor;
import com.seasolutions.vinicius.seasolutions.models.Trabalhador;

public class TrabalhadorParameter {

    private String name;

    private Long id;

    private String cpf;

    private Setor setor;

    private Cargo cargo;

    public TrabalhadorParameter() {
    }

    public TrabalhadorParameter(String name, Long id, String cpf, Setor setor, Cargo cargo) {
        this.name = name;
        this.id = id;
        this.cpf = cpf;
        this.setor = setor;
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Trabalhador toModel(){
        Trabalhador cargo = new Trabalhador();

        cargo.setName(this.name);
        cargo.setId(this.id);
        cargo.setCpf(this.cpf);
        cargo.setIdCargo(new CargoEntity(this.cargo));
        cargo.setIdSetor(new SetorEntity(this.setor));

        return cargo;

    }
}
