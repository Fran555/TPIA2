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
    private int specificity;
    private int priority;
    private int novelty;

    public Regla(int id, List<String> palabrasClaves, String respuesta, int specificity, int priority, int novelty) {
        this.id = id;
        this.palabrasClaves = palabrasClaves;
        this.respuesta = respuesta;
        this.specificity = specificity;
        this.priority = priority;
        this.novelty = novelty;
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

    public int getSpecificity() {
        return specificity;
    }

    public void setSpecificity(int specificity) {
        this.specificity = specificity;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getNovelty() {
        return novelty;
    }

    public void setNovelty(int novelty) {
        this.novelty = novelty;
    }
    
    
    
}
