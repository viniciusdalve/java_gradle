package com.seasolutions.vinicius.seasolutions.entities;

import com.seasolutions.vinicius.seasolutions.models.Cargo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tb_cargo")
public class CargoEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "id_setor")
    private SetorEntity idSetor;

    @OneToMany(mappedBy = "idCargo", cascade = CascadeType.ALL)
    private List<TrabalhadorEntity> trabalhadores;

    public CargoEntity() {
    }

    public CargoEntity(Long id, String name) {
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

    public SetorEntity getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(SetorEntity idSetor) {
        this.idSetor = idSetor;
    }

    public CargoEntity(Cargo model) {
        if ( model != null) {
            this.id = model.getId();
            this.name = model.getName();
            this.idSetor = model.getIdSetor();
        }
    }

    public Cargo toModel(){
        Cargo model = new Cargo();
        model.setId(this.id);
        model.setName(this.name);
        model.setIdSetor(this.idSetor);

        return model;
    }
}
