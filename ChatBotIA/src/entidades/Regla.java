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
    private List<Object> respuestas;
    private int priority;

    public Regla(int id, List<String> palabrasClaves, List<Object> respuestas, int priority) {
        this.id = id;
        this.palabrasClaves = palabrasClaves;
        this.respuestas = respuestas;
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

    public List<Object> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Object> respuestas) {
        this.respuestas = respuestas;
    }
    
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
