package com.softwarePinas.turnos.service;

import com.softwarePinas.turnos.model.Turno;

import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {

    //GET
    public List<Turno> getTurnos();

    //ADD
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);

    //DELETE
    public void deleteTurno(Long id);

    //GET-ONE
    public Turno findTurno(Long id);

    //EDIT
    public void editTurno(Long id, Turno turno);

}
