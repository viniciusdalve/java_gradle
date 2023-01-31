package com.seasolutions.vinicius.seasolutions.services.imp;

import com.seasolutions.vinicius.seasolutions.entities.TrabalhadorEntity;
import com.seasolutions.vinicius.seasolutions.models.Trabalhador;
import com.seasolutions.vinicius.seasolutions.repositories.CargoRepository;
import com.seasolutions.vinicius.seasolutions.repositories.SetorRepository;
import com.seasolutions.vinicius.seasolutions.repositories.TrabalhadorRepository;
import com.seasolutions.vinicius.seasolutions.services.TrabalhadorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;


import static java.util.stream.Collectors.toList;

@Service
public class TrabalhadorBaseServices implements TrabalhadorServices {

    @Autowired
    private TrabalhadorRepository trabalhadorRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private CargoRepository cargoRepository;

    public List<Trabalhador> listTrabalhadores() {

        List<TrabalhadorEntity> list = this.trabalhadorRepository.findAll();

        List<Trabalhador> results = list.stream().map(a -> a.toModel()).collect(toList());

        return results;
    }

    public Trabalhador addTrabalhador(Trabalhador model) {

        TrabalhadorEntity trabalhadorEntity = this.trabalhadorRepository.findByCpf(model.getCpf());

        Trabalhador trabalhador = null;

        if (trabalhadorEntity == null) {

            if (model.getName() != null) {

                TrabalhadorEntity results = new TrabalhadorEntity();
                results.setName(model.getName());
                results.setCpf(model.getCpf());
                results.setIdSetor(model.getIdSetor());
                results.setIdCargo(model.getIdCargo());

                this.trabalhadorRepository.save(results);

                trabalhador = new Trabalhador();
                trabalhador.setId(results.getId());
                trabalhador.setName(results.getName());
                trabalhador.setCpf(results.getCpf());

            }
            return trabalhador;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Trabalhador já registrado com este CPF!");
        }

    }


    @Transactional
    public Trabalhador deleteTrabalhador(Trabalhador model) {

        if (model != null) {
            try {
                this.trabalhadorRepository.deleteById(model.getId());
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trabalhador não encontrado");
            }
        }
        return null;
    }

}

