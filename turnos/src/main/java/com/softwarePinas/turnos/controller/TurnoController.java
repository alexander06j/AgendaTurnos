package com.softwarePinas.turnos.controller;

import com.softwarePinas.turnos.dto.TurnoDTO;
import com.softwarePinas.turnos.model.Turno;
import com.softwarePinas.turnos.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoServ;

    //1.-Crear nuevo turno
    @PostMapping("/crear")
    public String addTurno(@RequestBody TurnoDTO turno){
        turnoServ.saveTurno(turno.getFecha(),turno.getTratamiento(),turno.getDniPaciente());
        return "Turno creado.";
    }

    //2.-Obtener todos los turnos
    @GetMapping("/traer")
    public List<Turno> getTurnos(){
        return turnoServ.getTurnos();
    }

    //3.-Eliminar turno
    @DeleteMapping("/borrar/{id}")
    public String deleteTurno(@PathVariable Long id){
        turnoServ.deleteTurno(id);
        return "Turno eliminado.";
    }

    //4.-Editar turno
    @PutMapping("/editar/{id_original}")
    public Turno editTurno(@PathVariable Long id_original,
                           @RequestBody Turno turnoEditar){
        turnoServ.editTurno(id_original, turnoEditar);
        Turno turnoEditado = turnoServ.findTurno(id_original);

        return turnoEditado;
    }

    //5.-Obtener un turno en particular
    @GetMapping("/traer/{id}")
    public Turno findTurno(@PathVariable Long id){
        return turnoServ.findTurno(id);
    }


}
