/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.AirportsTest.model;

/**
 *
 * @author 2133832
 */
public class Airport {
    private String codigo;
    private String nombre;
    private String ciudad;
    private String codigoPais;
    
    public Airport(){
        
    }
    
    public void setcodigo(String codigo){
        this.codigo=codigo;
    }
    public void setName(String nombre){
        this.nombre=nombre;
    }
    public void setciudad(String ciudad){
        this.ciudad=ciudad;
    }
    public void setcodigoPais(String codigoPais){
        this.codigoPais=codigoPais;
    }
    
    public String getcodigo() {
        return this.codigo;
    }
    public String getciudad() {
        return this.ciudad;
    }
    public String getcodigoPais() {
        return this.codigoPais;
    }
    public String getnombre() {
        return this.nombre;
    }
}
