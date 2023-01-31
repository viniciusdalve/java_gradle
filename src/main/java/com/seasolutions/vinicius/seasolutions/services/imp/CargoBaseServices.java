package com.seasolutions.vinicius.seasolutions.services.imp;

import com.seasolutions.vinicius.seasolutions.entities.CargoEntity;
import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;
import com.seasolutions.vinicius.seasolutions.models.Cargo;
import com.seasolutions.vinicius.seasolutions.repositories.SetorRepository;
import com.seasolutions.vinicius.seasolutions.services.CargoServices;
import com.seasolutions.vinicius.seasolutions.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CargoBaseServices implements CargoServices {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private SetorRepository setorRepository;

    public List<Cargo> listCargos() {

        List<CargoEntity> list = this.cargoRepository.findAll();

        List<Cargo> results = list.stream().map(a -> a.toModel()).collect(toList());

        return results;
    }

    public Cargo addCargo(Cargo model) {

        if (model.getName() != null) {

            CargoEntity results = new CargoEntity();
            results.setName(model.getName());

            results.setIdSetor(model.getIdSetor());

            this.cargoRepository.save(results);

            Cargo cargo = new Cargo();
            cargo.setId(results.getId());
            cargo.setName(results.getName());
            cargo.setIdSetor(results.getIdSetor());

            Optional<SetorEntity> setorFind = this.setorRepository.findById(cargo.getIdSetor().getId());

            if(setorFind.isPresent()){

                cargo.setIdSetor(setorFind.get());
            }

            return cargo;
        }
        return null;
    }

    @Transactional
    public Cargo deleteCargo(Cargo model) {

        if (model != null) {
            try {
                this.cargoRepository.deleteById(model.getId());
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado");
            }
        }
        return null;
    }

    public Cargo updateCargo(Cargo model) {

        Optional<CargoEntity> findCargo = null;

        if (model.getId() != null && model.getName() != null) {

            findCargo = this.cargoRepository.findById(model.getId());
            if (findCargo.isPresent()) {

                if (model.getName() != null) {
                    findCargo.get().setName(model.getName());
                    this.cargoRepository.save(findCargo.get());
                }
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id incorreto!");

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id ou nome vazios!");

    }
}

