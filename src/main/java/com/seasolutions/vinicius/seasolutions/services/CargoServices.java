package com.seasolutions.vinicius.seasolutions.services;

import com.seasolutions.vinicius.seasolutions.models.Cargo;

import java.util.List;

public interface CargoServices {

    public List<Cargo> listCargos();

    public Cargo addCargo (Cargo model);

    public Cargo deleteCargo (Cargo model);

    public Cargo updateCargo (Cargo model);
}
