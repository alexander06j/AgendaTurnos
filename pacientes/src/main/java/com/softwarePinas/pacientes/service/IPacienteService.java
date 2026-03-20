package com.softwarePinas.pacientes.service;

import com.softwarePinas.pacientes.model.Paciente;

import java.util.List;

public interface IPacienteService {

    //READ
    public List<Paciente> getPacientes();

    //ADD
    public void savePaciente(Paciente pac);

    //DELETE
    public void deletePaciente(Long id);

    //READ-ONE
    public Paciente findPaciente(Long id);

    //EDIT
    public void editPaciente(Long id, Paciente pac);


    Paciente findPacienteDni(String dni);
}
