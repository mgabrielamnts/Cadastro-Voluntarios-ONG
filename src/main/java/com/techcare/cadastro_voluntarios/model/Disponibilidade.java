package com.techcare.cadastro_voluntarios.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidade")
public class Disponibilidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisponibilidade;

    @ManyToOne
    @JoinColumn(name = "id_voluntario")
    private Voluntario voluntario;

    private String diaSemana;
    private String horario;

    public Disponibilidade() { }

    public Disponibilidade(
            Integer idDisponibilidade,
            Voluntario voluntario,
            String diaSemana,
            String horario
    ) {
        this.idDisponibilidade = idDisponibilidade;
        this.voluntario = voluntario;
        this.diaSemana = diaSemana;
        this.horario = horario;
    }

    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }
}
