package com.techcare.cadastro_voluntarios.dto;

public class DisponibilidadeResponse {

    private Integer idDisponibilidade;
    private String diaSemana;
    private String horario; // "HH:mm"

    public Integer getIdDisponibilidade() { return idDisponibilidade; }
    public void setIdDisponibilidade(Integer idDisponibilidade) { this.idDisponibilidade = idDisponibilidade; }

    public String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
