/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author fede_
 */
public class ReglaDato {
    
    Regla regla;
    String dato;

    public ReglaDato(Regla regla, String dato) {
        this.regla = regla;
        this.dato = dato;
    }

    public Regla getRegla() {
        return regla;
    }

    public void setRegla(Regla regla) {
        this.regla = regla;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
}
