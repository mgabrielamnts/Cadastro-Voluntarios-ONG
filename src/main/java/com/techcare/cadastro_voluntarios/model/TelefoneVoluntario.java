package com.techcare.cadastro_voluntarios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone_voluntario")
public class TelefoneVoluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefoneVoluntario;

    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Voluntario voluntario;

    private String telefoneResidencial;
    private String telefonePessoal;
    private String telefoneConsultorio;

    public TelefoneVoluntario() { } // construtor vazio ✅

    public TelefoneVoluntario(
            Integer idTelefoneVoluntario,
            Voluntario voluntario,
            String telefoneResidencial,
            String telefonePessoal,
            String telefoneConsultorio
    ) {
        this.idTelefoneVoluntario = idTelefoneVoluntario;
        this.voluntario = voluntario;
        this.telefoneResidencial = telefoneResidencial;
        this.telefonePessoal = telefonePessoal;
        this.telefoneConsultorio = telefoneConsultorio;
    }

    // ✅ Getters / Setters
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }
}
