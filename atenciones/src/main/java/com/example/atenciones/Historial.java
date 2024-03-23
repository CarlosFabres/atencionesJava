package com.example.atenciones;

public class Historial {
    
    //Atributos
    private Integer id;
    private String nombre;

    public Historial (Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }


    // Métodos Getters para acceder a los atributos de la clase
    public Integer getId(){
        return id;
    }

    
    public String getNombre(){
        return nombre;
    }

    

}
