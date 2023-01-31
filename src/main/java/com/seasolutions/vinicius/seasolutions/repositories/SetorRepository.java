package com.seasolutions.vinicius.seasolutions.repositories;

import com.seasolutions.vinicius.seasolutions.entities.SetorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<SetorEntity, Long> {

   SetorEntity findByName(String name);

}

