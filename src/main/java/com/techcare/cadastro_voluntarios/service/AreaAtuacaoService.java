package com.techcare.cadastro_voluntarios.service;

import com.techcare.cadastro_voluntarios.exception.BusinessException;
import com.techcare.cadastro_voluntarios.exception.ResourceNotFoundException;
import com.techcare.cadastro_voluntarios.model.AreaAtuacao;
import com.techcare.cadastro_voluntarios.repository.AreaAtuacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaAtuacaoService {

    @Autowired
    private AreaAtuacaoRepository areaRepo;

    public List<AreaAtuacao> listarTodas() {
        return areaRepo.findAll();
    }

    public AreaAtuacao buscarPorId(Integer id) {
        return areaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Área não encontrada"));
    }

    public AreaAtuacao salvar(AreaAtuacao area) {
        return areaRepo.save(area);
    }

    @Transactional
    public void deletar(Integer id) {
        AreaAtuacao area = areaRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Área não encontrada"));

        // Antes de deletar, verificamos se tem voluntários ligados a ela
        if (!area.getVoluntarios().isEmpty()) {
            throw new BusinessException("Não é possível excluir: existe voluntário vinculado a esta área.");
        }

        areaRepo.delete(area);
    }
}
