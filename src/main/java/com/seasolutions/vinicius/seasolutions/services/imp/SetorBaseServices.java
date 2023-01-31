package com.seasolutions.vinicius.seasolutions.services.imp;

import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;
import com.seasolutions.vinicius.seasolutions.models.Setor;
import com.seasolutions.vinicius.seasolutions.repositories.SetorRepository;
import com.seasolutions.vinicius.seasolutions.services.SetorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class SetorBaseServices implements SetorServices {

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> listSetores() {

        List<SetorEntity> list = this.setorRepository.findAll();

        List<Setor> results = list.stream().map(a -> a.toModel()).collect(toList());

        return results;
    }

    public Setor addSetor(Setor model) {

        if (model.getName() != null) {

            SetorEntity findEqual = this.setorRepository.findByName(model.getName());

            if (findEqual == null) {

                SetorEntity results = new SetorEntity();
                results.setName(model.getName());

                this.setorRepository.save(results);

                Setor setor = new Setor();
                setor.setId(results.getId());
                setor.setName(results.getName());

                return setor;
            }
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Setor já existente");
        }
        return null;
    }

    @Transactional
    public Setor deleteSetor(Setor model) {

        if (model != null) {
            try {
                this.setorRepository.deleteById(model.getId());
            } catch (RuntimeException e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Setor não encontrado");
            }
        }
        return null;
    }

    public Setor updateSetor(Setor model) {

        Optional<SetorEntity> findSetor;

        Setor setor = null;

        if (model.getId() != null && model.getName() != null) {

            findSetor = this.setorRepository.findById(model.getId());
            if (findSetor.isPresent()) {

                if (model.getName() != null) {
                    findSetor.get().setName(model.getName());
                    setor = this.setorRepository.save(findSetor.get()).toModel();
                }
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id incorreto!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id ou nome vazios!");
        }
        return setor;
    }
}

