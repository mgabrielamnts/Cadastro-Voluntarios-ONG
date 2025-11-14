package com.techcare.cadastro_voluntarios.dto;

public class TelefoneResponse {

    private Integer idTelefoneVoluntario;
    private String telefoneResidencial;
    private String telefonePessoal;
    private String telefoneConsultorio;

    public Integer getIdTelefoneVoluntario() { return idTelefoneVoluntario; }
    public void setIdTelefoneVoluntario(Integer idTelefoneVoluntario) { this.idTelefoneVoluntario = idTelefoneVoluntario; }

    public String getTelefoneResidencial() { return telefoneResidencial; }
    public void setTelefoneResidencial(String telefoneResidencial) { this.telefoneResidencial = telefoneResidencial; }

    public String getTelefonePessoal() { return telefonePessoal; }
    public void setTelefonePessoal(String telefonePessoal) { this.telefonePessoal = telefonePessoal; }

    public String getTelefoneConsultorio() { return telefoneConsultorio; }
    public void setTelefoneConsultorio(String telefoneConsultorio) { this.telefoneConsultorio = telefoneConsultorio; }
}
