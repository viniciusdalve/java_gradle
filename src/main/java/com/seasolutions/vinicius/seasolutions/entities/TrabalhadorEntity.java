package com.seasolutions.vinicius.seasolutions.entities;

import com.seasolutions.vinicius.seasolutions.models.Trabalhador;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_trabalhador")
public class TrabalhadorEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cpf;

    @ManyToOne
    @JoinColumn(name = "id_setor")
    private SetorEntity idSetor;

    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private CargoEntity idCargo;

    public TrabalhadorEntity() {
    }

    public TrabalhadorEntity(Long id, String name, String cpf, SetorEntity idSetor, CargoEntity idCargo) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.idSetor = idSetor;
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



    public Trabalhador toModel(){
        Trabalhador model = new Trabalhador();
        model.setId(this.id);
        model.setName(this.name);
        model.setIdCargo(this.idCargo);
        model.setCpf(this.cpf);

        return model;
    }
}
