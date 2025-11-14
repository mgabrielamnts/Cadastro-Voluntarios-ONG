package com.techcare.cadastro_voluntarios.mapper;

import com.techcare.cadastro_voluntarios.dto.VoluntarioRequest;
import com.techcare.cadastro_voluntarios.dto.VoluntarioResponse;
import com.techcare.cadastro_voluntarios.model.Voluntario;
import com.techcare.cadastro_voluntarios.model.TelefoneVoluntario;
import com.techcare.cadastro_voluntarios.model.Disponibilidade;
import com.techcare.cadastro_voluntarios.model.AreaAtuacao;

import java.util.stream.Collectors;

public class VoluntarioMapper {

    public static Voluntario toEntity(VoluntarioRequest req) {
        Voluntario v = new Voluntario();
        v.setNome(req.getNome());
        v.setProfissao(req.getProfissao());
        v.setRg(req.getRg());
        v.setCpf(req.getCpf());
        v.setRegistroConselho(req.getRegistroConselho());
        v.setCep(req.getCep());
        v.setLogradouro(req.getLogradouro());
        v.setNumeroResidencial(req.getNumeroResidencial());
        v.setBairro(req.getBairro());
        v.setCidade(req.getCidade());
        v.setHorasSemanaisDisponiveis(req.getHorasSemanaisDisponiveis());

        if (req.getTelefones() != null) {
            v.setTelefones(req.getTelefones().stream()
                    .map(t -> new TelefoneVoluntario(null, v,
                            t.getTelefoneResidencial(),
                            t.getTelefonePessoal(),
                            t.getTelefoneConsultorio()))
                    .collect(Collectors.toList()));
        }

        if (req.getDisponibilidades() != null) {
            v.setDisponibilidades(req.getDisponibilidades().stream()
                    .map(d -> new Disponibilidade(null, v,
                            d.getDiaSemana(),
                            d.getHorario()))
                    .collect(Collectors.toList()));
        }

        return v;
    }

    public static VoluntarioResponse toResponse(Voluntario v) {
        VoluntarioResponse resp = new VoluntarioResponse();
        resp.setIdVoluntario(v.getIdVoluntario());
        resp.setNome(v.getNome());
        resp.setProfissao(v.getProfissao());
        resp.setCpf(v.getCpf());
        resp.setCidade(v.getCidade());
        resp.setDataCadastro(v.getDataCadastro());

        resp.setAreas(v.getAreas().stream()
                .map(AreaAtuacao::getNomeArea)
                .collect(Collectors.toList()));

        return resp;
    }
}
