package com.seasolutions.vinicius.seasolutions.presenters;

import com.seasolutions.vinicius.seasolutions.models.Setor;

public class SetorPresenter {

    private String name;

    private Long id;

    public SetorPresenter() {
    }

    public SetorPresenter(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SetorPresenter(Setor model){
        if(model != null) {
            this.id = model.getId();
            this.name = model.getName();
        }
    }

}
