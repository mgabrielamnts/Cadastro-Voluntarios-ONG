package com.techcare.cadastro_voluntarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

public class VoluntarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String profissao;

    @NotBlank
    private String rg;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    private String registroConselho;

    @NotNull
    private Integer cep;

    @NotBlank
    private String logradouro;

    @NotNull
    private Integer numeroResidencial;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    private Integer horasSemanaisDisponiveis;

    private List<TelefoneRequest> telefones;

    private List<DisponibilidadeRequest> disponibilidades;

    // lista de ids de áreas escolhidas
    private List<Integer> areas;

    // getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getProfissao() { return profissao; }
    public void setProfissao(String profissao) { this.profissao = profissao; }

    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getRegistroConselho() { return registroConselho; }
    public void setRegistroConselho(String registroConselho) { this.registroConselho = registroConselho; }

    public Integer getCep() { return cep; }
    public void setCep(Integer cep) { this.cep = cep; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public Integer getNumeroResidencial() { return numeroResidencial; }
    public void setNumeroResidencial(Integer numeroResidencial) { this.numeroResidencial = numeroResidencial; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public Integer getHorasSemanaisDisponiveis() { return horasSemanaisDisponiveis; }
    public void setHorasSemanaisDisponiveis(Integer horasSemanaisDisponiveis) { this.horasSemanaisDisponiveis = horasSemanaisDisponiveis; }

    public List<TelefoneRequest> getTelefones() { return telefones; }
    public void setTelefones(List<TelefoneRequest> telefones) { this.telefones = telefones; }

    public List<DisponibilidadeRequest> getDisponibilidades() { return disponibilidades; }
    public void setDisponibilidades(List<DisponibilidadeRequest> disponibilidades) { this.disponibilidades = disponibilidades; }

    public List<Integer> getAreas() { return areas; }
    public void setAreas(List<Integer> areas) { this.areas = areas; }
}
