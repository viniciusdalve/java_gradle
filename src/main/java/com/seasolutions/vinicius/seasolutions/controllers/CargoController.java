package com.seasolutions.vinicius.seasolutions.controllers;

import com.seasolutions.vinicius.seasolutions.models.Cargo;
import com.seasolutions.vinicius.seasolutions.services.CargoServices;
import com.seasolutions.vinicius.seasolutions.parameters.CargoParameter;
import com.seasolutions.vinicius.seasolutions.presenters.CargoPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cargos")
//@Api(value = "API REST DESAFIO SEA SOLUTIONS")
//@CrossOrigin(origins = "*")
public class CargoController {

    @Autowired
    private CargoServices cargoServices;

    @GetMapping
    //@ApiOperation(value = "Retorna uma lista de todos os cargos", tags = { "Cargo" })
    public ResponseEntity<List<Cargo>> findAll() {

        List<Cargo> list = this.cargoServices.listCargos();

        if (list != null) {

            return new ResponseEntity(list.stream().map(a -> new CargoPresenter(a)).collect(Collectors.toList()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/addCargos")
    //@ApiOperation(value = "Adiciona um Cargo", tags = { "Cargo" })
    public ResponseEntity<CargoPresenter> addCargo(@RequestBody CargoParameter param
    ) {
        if (param != null) {

            Cargo result = (this.cargoServices.addCargo(param.toModel()));

            return new ResponseEntity(new CargoPresenter(result), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/deleteCargos")
    //@ApiOperation(value = "Deleta um Cargo", tags = { "Cargo" })
    public ResponseEntity<CargoPresenter> deleteCargo(@RequestBody CargoParameter param) {

            if (param != null) {

                Cargo result = this.cargoServices.deleteCargo(param.toModel());

                return new ResponseEntity(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/updateCargos")
    //@ApiOperation(value = "Atualiza um Cargo", tags = { "Cargo" })
    public ResponseEntity<CargoPresenter> updateCargo(@RequestBody CargoParameter param) {

        if ((param != null)) {

            Cargo result = this.cargoServices.updateCargo(param.toModel());

            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
