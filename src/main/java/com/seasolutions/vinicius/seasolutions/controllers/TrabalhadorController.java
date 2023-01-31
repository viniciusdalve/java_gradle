package com.seasolutions.vinicius.seasolutions.controllers;

import com.seasolutions.vinicius.seasolutions.models.Trabalhador;
import com.seasolutions.vinicius.seasolutions.parameters.TrabalhadorParameter;
import com.seasolutions.vinicius.seasolutions.presenters.TrabalhadorPresenter;
import com.seasolutions.vinicius.seasolutions.services.TrabalhadorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/trabalhadores")
public class TrabalhadorController {

    @Autowired
    private TrabalhadorServices trabalhadorServices;

    @GetMapping
    public ResponseEntity<List<Trabalhador>> findAll() {

        List<Trabalhador> list = this.trabalhadorServices.listTrabalhadores();

        if (list != null) {
            return new ResponseEntity(list.stream().map(a -> new TrabalhadorPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/addTrabalhadores")
    public ResponseEntity<TrabalhadorPresenter> addTrabalhador(@RequestBody TrabalhadorParameter param
    ) {
        if (param != null) {

            Trabalhador result = (this.trabalhadorServices.addTrabalhador(param.toModel()));

            return new ResponseEntity(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/deleteTrabalhadores")
    public ResponseEntity<TrabalhadorPresenter> deleteTrabalhador(@RequestBody TrabalhadorParameter param) {

            if (param != null) {

                Trabalhador result = this.trabalhadorServices.deleteTrabalhador(param.toModel());

                return new ResponseEntity(new TrabalhadorPresenter(result), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
