package com.seasolutions.vinicius.seasolutions.repositories;

import com.seasolutions.vinicius.seasolutions.entities.TrabalhadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhadorRepository extends JpaRepository<TrabalhadorEntity, Long> {

    TrabalhadorEntity findByCpf(String cpf);

}

