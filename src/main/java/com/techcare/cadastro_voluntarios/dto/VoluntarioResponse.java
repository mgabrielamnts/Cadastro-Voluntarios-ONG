package com.techcare.cadastro_voluntarios.dto;

import java.time.LocalDate;
import java.util.List;

public class VoluntarioResponse {

    private Integer idVoluntario;
    private String nome;
    private String profissao; // <-- ADICIONADO
    private String cpf;       // <-- ADICIONADO
    private String cidade;
    private Integer horasSemanaisDisponiveis;
    private LocalDate dataCadastro;
    private Boolean ativo;

    private List<TelefoneResponse> telefones;
    private List<DisponibilidadeResponse> disponibilidades;
    private List<String> areas;

    public Integer getIdVoluntario() { return idVoluntario; }
    public void setIdVoluntario(Integer idVoluntario) { this.idVoluntario = idVoluntario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // --- ADICIONE ESTES MÉTODOS ---
    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    // --- FIM DA ADIÇÃO ---

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public Integer getHorasSemanaisDisponiveis() { return horasSemanaisDisponiveis; }
    public void setHorasSemanaisDisponiveIS(Integer horasSemanaisDisponiveis) { this.horasSemanaisDisponiveis = horasSemanaisDisponiveis; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public List<TelefoneResponse> getTelefones() { return telefones; }
    public void setTelefones(List<TelefoneResponse> telefones) { this.telefones = telefones; }

    public List<DisponibilidadeResponse> getDisponibilidades() { return disponibilidades; }
    public void setDisponibilidades(List<DisponibilidadeResponse> disponibilidades) { this.disponibilidades = disponibilidades; }

    public List<String> getAreas() { return areas; }
    public void setAreas(List<String> areas) { this.areas = areas; }
}