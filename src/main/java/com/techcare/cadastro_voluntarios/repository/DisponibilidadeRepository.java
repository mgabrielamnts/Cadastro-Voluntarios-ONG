package com.techcare.cadastro_voluntarios.repository;

import com.techcare.cadastro_voluntarios.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Integer> {
}
