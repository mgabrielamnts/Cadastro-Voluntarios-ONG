package com.techcare.cadastro_voluntarios.repository;

import com.techcare.cadastro_voluntarios.model.TelefoneVoluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<TelefoneVoluntario, Integer> {
}
