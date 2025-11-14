package com.techcare.cadastro_voluntarios.repository;

import com.techcare.cadastro_voluntarios.model.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Integer> {
    boolean existsByCpf(String cpf);
}
