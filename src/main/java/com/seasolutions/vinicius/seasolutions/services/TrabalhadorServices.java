package com.seasolutions.vinicius.seasolutions.services;

import com.seasolutions.vinicius.seasolutions.models.Trabalhador;
import java.util.List;

public interface TrabalhadorServices {

    public List<Trabalhador> listTrabalhadores();

    public Trabalhador addTrabalhador (Trabalhador model);

    public Trabalhador deleteTrabalhador (Trabalhador model);

}
