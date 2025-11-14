package com.techcare.cadastro_voluntarios.service;

import com.techcare.cadastro_voluntarios.dto.*;
import com.techcare.cadastro_voluntarios.exception.*;
import com.techcare.cadastro_voluntarios.mapper.VoluntarioMapper;
import com.techcare.cadastro_voluntarios.model.*;
import com.techcare.cadastro_voluntarios.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techcare.cadastro_voluntarios.utils.CpfValidator;
import com.techcare.cadastro_voluntarios.exception.BusinessException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepo;

    @Autowired
    private AreaAtuacaoRepository areaRepo;

    public List<VoluntarioResponse> listarTodos() {
        return voluntarioRepo.findAll().stream()
                .filter(v -> v.getAtivo() == null || v.getAtivo())
                .map(VoluntarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public VoluntarioResponse salvar(VoluntarioRequest req) {

        // Valida CPF
        if (!CpfValidator.isValidCPF(req.getCpf())) {
            throw new BusinessException("CPF inválido");
        }

        // Verifica se já existe no banco
        if (voluntarioRepo.existsByCpf(req.getCpf())) {
            throw new BusinessException("CPF já cadastrado");
        }

        Voluntario v = VoluntarioMapper.toEntity(req);
        v.setDataCadastro(LocalDate.now());
        v.setAtivo(true);

        if (req.getAreas() != null && !req.getAreas().isEmpty()) {
            List<AreaAtuacao> areas = areaRepo.findAllById(req.getAreas());
            if (areas.size() != req.getAreas().size()) {
                throw new BusinessException("Uma ou mais áreas inválidas");
            }
            v.setAreas(areas);
        }

        Voluntario salvo = voluntarioRepo.save(v);
        return VoluntarioMapper.toResponse(salvo);
    }

    public VoluntarioResponse buscarPorId(Integer id) {
        Voluntario v = voluntarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado"));
        if (v.getAtivo() != null && !v.getAtivo()) {
            throw new ResourceNotFoundException("Voluntário não encontrado");
        }
        return VoluntarioMapper.toResponse(v);
    }

    @Transactional
    public VoluntarioResponse atualizar(Integer id, VoluntarioUpdateRequest req) {
        Voluntario v = voluntarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado"));

        if (v.getAtivo() != null && !v.getAtivo()) {
            throw new BusinessException("Voluntário inativo não pode ser editado");
        }

        if (req.getNome() != null) v.setNome(req.getNome());
        if (req.getProfissao() != null) v.setProfissao(req.getProfissao());
        if (req.getCidade() != null) v.setCidade(req.getCidade());
        if (req.getHorasSemanaisDisponiveis() != null) v.setHorasSemanaisDisponiveis(req.getHorasSemanaisDisponiveis());

        final Voluntario voluntarioFinal = v;

        // Telefones
        if (req.getTelefones() != null) {
            v.getTelefones().clear();
            req.getTelefones().forEach(t ->
                    voluntarioFinal.getTelefones().add(new TelefoneVoluntario(
                            null,
                            voluntarioFinal,
                            t.getTelefoneResidencial(),
                            t.getTelefonePessoal(),
                            t.getTelefoneConsultorio()))
            );
        }

        // Disponibilidades
        if (req.getDisponibilidades() != null) {
            v.getDisponibilidades().clear();
            req.getDisponibilidades().forEach(d ->
                    voluntarioFinal.getDisponibilidades().add(new Disponibilidade(
                            null,
                            voluntarioFinal,
                            d.getDiaSemana(),
                            d.getHorario()))
            );
        }

        // Áreas
        if (req.getAreas() != null) {
            List<AreaAtuacao> areas = areaRepo.findAllById(req.getAreas());
            if (areas.size() != req.getAreas().size()) {
                throw new BusinessException("Uma ou mais áreas inválidas");
            }
            v.setAreas(areas);
        }

        v = voluntarioRepo.save(v);
        return VoluntarioMapper.toResponse(v);
    }

    @Transactional
    public void deletar(Integer id) {
        Voluntario v = voluntarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado"));

        if (v.getAtivo() != null && !v.getAtivo()) {
            throw new BusinessException("Voluntário já inativo");
        }

        v.setAtivo(false);
        voluntarioRepo.save(v);
    }

    @Transactional
    public VoluntarioResponse reativar(Integer id) {
        Voluntario v = voluntarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado"));

        if (v.getAtivo() != null && v.getAtivo()) {
            throw new BusinessException("Voluntário já está ativo");
        }

        v.setAtivo(true);
        voluntarioRepo.save(v);

        return VoluntarioMapper.toResponse(v);
    }
}
