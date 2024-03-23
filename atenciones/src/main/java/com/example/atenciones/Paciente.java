package com.example.atenciones;

import java.util.List;
import java.util.Map;

public class Paciente {
    
    //Atributos
    private Integer id;
    private String nombre;
    private String rut;
    private List<Historial> historiales;
    private Map<String, List<String>> consultasPorHistorial;


    public Paciente(int id, String nombre, String rut, List<Historial> historiales, Map<String, List<String>> consultasPorHistorial){
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.historiales = historiales;
        this.consultasPorHistorial = consultasPorHistorial;
    }
    
       // Métodos Getters para acceder a los atributos de la clase
       public int getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getRut(){
        return rut;
    }
    
    public List<Historial> getHistoriales(){
        return historiales;
    }
    
    public Map<String, List<String>> getConsultasPorHistorial(){
        return consultasPorHistorial;
    }
    


}



