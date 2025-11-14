package com.techcare.cadastro_voluntarios.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "voluntarios")
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVoluntario;

    private String nome;
    private String profissao;
    private String rg;

    @Column(unique = true)
    private String cpf;

    private String registroConselho;
    private Integer cep;
    private String logradouro;
    private Integer numeroResidencial;
    private String bairro;
    private String cidade;
    private Integer horasSemanaisDisponiveis;

    private LocalDate dataCadastro;
    private Boolean ativo = true;

    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TelefoneVoluntario> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "voluntario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "voluntario_area",
            joinColumns = @JoinColumn(name = "id_voluntario"),
            inverseJoinColumns = @JoinColumn(name = "id_area")
    )
    private List<AreaAtuacao> areas = new ArrayList<>();

    public Integer getIdVoluntario() { return idVoluntario; }
    public void setIdVoluntario(Integer idVoluntario) { this.idVoluntario = idVoluntario; }

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

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public List<TelefoneVoluntario> getTelefones() { return telefones; }
    public void setTelefones(List<TelefoneVoluntario> telefones) { this.telefones = telefones; }

    public List<Disponibilidade> getDisponibilidades() { return disponibilidades; }
    public void setDisponibilidades(List<Disponibilidade> disponibilidades) { this.disponibilidades = disponibilidades; }

    public List<AreaAtuacao> getAreas() { return areas; }
    public void setAreas(List<AreaAtuacao> areas) { this.areas = areas; }
}
