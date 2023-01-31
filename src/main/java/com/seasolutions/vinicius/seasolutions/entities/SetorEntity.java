package com.seasolutions.vinicius.seasolutions.entities;

import com.seasolutions.vinicius.seasolutions.models.Setor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tb_setor")
public class SetorEntity implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "idSetor", cascade = CascadeType.ALL)
    private List<CargoEntity> cargos;

    public SetorEntity() {
    }

    public SetorEntity(Long id, String name, List<CargoEntity> idCargo) {
        this.id = id;
        this.name = name;
    }

    public SetorEntity(Long idSetor) {
        this.id = idSetor;
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

    public SetorEntity(Setor model) {
        if ( model != null) {
            this.id = model.getId();
            this.name = model.getName();
        }
    }

    public Setor toModel(){
        Setor model = new Setor();
        model.setId(this.id);
        model.setName(this.name);
        return model;
    }

}
