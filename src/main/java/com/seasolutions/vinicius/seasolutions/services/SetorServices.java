package com.seasolutions.vinicius.seasolutions.services;

import com.seasolutions.vinicius.seasolutions.exceptions.SetorExceptions;
import com.seasolutions.vinicius.seasolutions.models.Setor;
import java.util.List;

public interface SetorServices {

    public List<Setor> listSetores();

    public Setor addSetor (Setor model);

    public Setor deleteSetor (Setor model) throws SetorExceptions;

    public Setor updateSetor (Setor model);
}
