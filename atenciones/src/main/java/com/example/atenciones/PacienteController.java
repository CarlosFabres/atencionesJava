package com.example.atenciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PacienteController {

    // Lista para almacenar los pacientes
    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteController(){

        // Se agregan pacientes con su información 
        pacientes.add(new Paciente(1, "Carlos", "20330806-K",
        Arrays.asList(
            new Historial(1, "Alérgico"),
            new Historial(2, "Problemas Cardiacos")
        ),
        llenarConsultasHistorial("Alérgico", "Problema respiratorio", "23/03/2024", "Sebastian")));


        pacientes.add(new Paciente(2, "Vicente", "12345678-9",
        Arrays.asList(
            new Historial(3, "Diabetes"),
            new Historial(4, "Asmatico")
        ),
        llenarConsultasHistorial("Asmatico", "Control de azúcar en sangre", "10/03/2024", "Pedro")));

        pacientes.add(new Paciente(3, "Alexis", "11223344-0",
        Arrays.asList(
            new Historial(2, "Problemas Cardiacos"),
            new Historial(3, "Diabetes")
        ),
        llenarConsultasHistorial("Problemas Cardiacos", "Revision de ritmo cardiaco", "05/03/2024", "Juanin")));

    }

    // Método para llenar las consultas por historial
    public Map<String, List<String>> llenarConsultasHistorial(String historial, String motivo, String fecha, String doctor) {
        Map<String, List<String>> retorno = new HashMap<>();
        List<String> detalles = Arrays.asList(motivo, fecha);
        retorno.put(historial, detalles);
        return retorno;
    }


    // Endpoint para obtener todos los pacientes
    @GetMapping("/pacientes")
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    // Endpoint para obtener un paciente por su ID
    @GetMapping("/pacientes/{id}")
    public Paciente getPacienteById(@PathVariable int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    // Endpoint para obtener los historiales de un paciente por su ID
    @GetMapping("/pacientes/{id}/historiales")
    public List<Historial> getHistorialesByPacienteId(@PathVariable int id) {
        Paciente paciente = getPacienteById(id);
        if (paciente != null) {
            return paciente.getHistoriales();
        }
        return null;
    }

    // Endpoint para obtener las consultas por historial de un paciente por su ID
    @GetMapping("/pacientes/{id}/historiales/consultas")
    public Map<String, List<String>> getConsultasPorHistorial(@PathVariable int id) {
        Paciente paciente = getPacienteById(id);
        if (paciente != null) {
            return paciente.getConsultasPorHistorial();
        }
        return null;
    }

    

}
