package com.softwarePinas.pacientes.controller;

import com.softwarePinas.pacientes.model.Paciente;
import com.softwarePinas.pacientes.service.IPacienteService;
import com.softwarePinas.pacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    @Autowired
    private IPacienteService pacienteServ;

    //1.-crear nuevo paciente
    @PostMapping("/Pacientes/crear")
    public String savePaciente(@RequestBody Paciente pac){
        pacienteServ.savePaciente(pac);
        return "Paciente creado correctamente.";
    }

    //2.-obtener todos los pacientes
    @GetMapping("/pacientes/traer")
    public List<Paciente> getPacientes(){
        return pacienteServ.getPacientes();
    }

    //3.-eliminar paciente
    @DeleteMapping("/pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable long id){
        pacienteServ.deletePaciente(id);
        return "Paciente eliminado";
    }

    //4.-editar paciente
    @PutMapping("/pacientes/editar/{id_original}")
    public Paciente editPaciente(@PathVariable Long id_original,
                             @RequestBody Paciente pacienteEditar){

        pacienteServ.editPaciente(id_original, pacienteEditar);
        Paciente pacienteEditado = pacienteServ.findPaciente(id_original);
        return pacienteEditado;
    }

    //5.-obtener un paciente en particual
    @GetMapping("/pacientes/traer/{id}")
    public Paciente findPaciente(@PathVariable Long id){
        return  pacienteServ.findPaciente(id);
    }

    //6.-Traer pacientes dni
    @GetMapping("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni(@PathVariable String dni){
        return pacienteServ.findPacienteDni(dni);
    }

}
