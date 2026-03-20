package com.softwarePinas.turnos.service;

import com.softwarePinas.turnos.model.Paciente;
import com.softwarePinas.turnos.model.Turno;
import com.softwarePinas.turnos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepo;

    @Autowired
    private RestTemplate apiConsumir;//mismo apodo del @bean


    @Override
    public List<Turno> getTurnos() {
        return turnoRepo.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {//El controller pasa el dniPaciente

        //Busca el paciente en la api
        Paciente pac = apiConsumir.getForObject("http://localhost:9001/pacientes/traerdni/"+dniPaciente,Paciente.class);
        String nombreCompletoPaciente = pac.getNombre()+ "" +pac.getApellido();//trae lo que consume el nombre de la api

        Turno turno = new Turno();
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);//se obtiene del consumo de la api

        turnoRepo.save(turno);
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepo.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public void editTurno(Long id, Turno turno) {

        Turno turn = this.findTurno(id);//busca el turno por id
        turn.setFecha(turno.getFecha());
        turn.setTratamiento(turno.getTratamiento());
        turn.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());

        turnoRepo.save(turn);
    }
}
