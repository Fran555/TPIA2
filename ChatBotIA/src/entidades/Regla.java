/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

/**
 *
 * @author fede_
 */
public class Regla {
    
    private int id;
    private List<String> palabrasClaves;
    private String respuesta;
    private int priority;

    public Regla(int id, List<String> palabrasClaves, String respuesta, int priority) {
        this.id = id;
        this.palabrasClaves = palabrasClaves;
        this.respuesta = respuesta;
        this.priority = priority;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
