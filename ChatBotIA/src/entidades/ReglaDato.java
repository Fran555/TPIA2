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
public class ReglaDato {
    
    Regla regla;
    List<String> palabrasClaves;
    String frase;

    public ReglaDato(Regla regla, List<String> palabrasClaves, String frase) {
        this.regla = regla;
        this.palabrasClaves = palabrasClaves;
        this.frase = frase;
    }

    public Regla getRegla() {
        return regla;
    }

    public void setRegla(Regla regla) {
        this.regla = regla;
    }

    public List<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    public void setPalabrasClaves(List<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    
}
