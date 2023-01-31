package com.seasolutions.vinicius.seasolutions.controllers;

import com.seasolutions.vinicius.seasolutions.exceptions.SetorExceptions;
import com.seasolutions.vinicius.seasolutions.models.Setor;
import com.seasolutions.vinicius.seasolutions.parameters.SetorParameter;
import com.seasolutions.vinicius.seasolutions.presenters.SetorPresenter;
import com.seasolutions.vinicius.seasolutions.services.SetorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/setores")
public class SetorController {

    @Autowired
    private SetorServices setorServices;

    @GetMapping
    public ResponseEntity<List<Setor>> findAll() {

        List<Setor> list = this.setorServices.listSetores();

        if (list != null) {

            return new ResponseEntity(list.stream().map(a -> new SetorPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/addSetores")
    public ResponseEntity<SetorPresenter> addSetor(@RequestBody SetorParameter param
    ) {

        if (param != null) {

            Setor result = this.setorServices.addSetor(param.toModel());

            return new ResponseEntity(new SetorPresenter(result), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/deleteSetores")
    public ResponseEntity<SetorPresenter> deleteSetor(@RequestBody SetorParameter param) throws SetorExceptions {

            if (param != null) {

                Setor result = this.setorServices.deleteSetor(param.toModel());

                return new ResponseEntity(new SetorPresenter(result), HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateSetores")
    public ResponseEntity<SetorPresenter> updateSetor(@RequestBody SetorParameter param) {

        if ((param != null)) {

            Setor result = this.setorServices.updateSetor(param.toModel());

            return new ResponseEntity(new SetorPresenter(result), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
