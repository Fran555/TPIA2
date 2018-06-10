/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import respuestas.Respuesta;

/**
 *
 * @author fede_
 */
public class Regla {
    
    private int id;
    private List<String> palabrasClaves;
    private List<Respuesta> respuestas;
    private int prioridad;

    public Regla(int id, List<String> palabrasClaves, List<Respuesta> respuestas, int prioridad) {
        this.id = id;
        this.palabrasClaves = palabrasClaves;
        this.respuestas = respuestas;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(List<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    
    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    public String toString(){
        String respuesta = "";
        String palabra;
        respuesta += "\n\tPalabras claves:\n\t\t";
        for(int i = 0; i<palabrasClaves.size(); i++){
            palabra = palabrasClaves.get(i);
            respuesta += palabra;
            if(i < palabrasClaves.size() - 1){
                respuesta += " ,";
            }
        }
        respuesta += "\n\tRespuestas: ";
        for(Respuesta resp : respuestas){
            respuesta += "\n\t\t" + resp.toString();
        }
        respuesta += "\n\tPrioridad:\n\t\t" + prioridad;
        return respuesta;
    }
}
