package reglas;

import criterios.Criterio;
import java.util.List;

public class ReglaDato {
    
    Regla regla;
    List<String> palabrasClaves;
    String frase;
    List<Criterio> criteriosAplicados;

    public ReglaDato(Regla regla, List<String> palabrasClaves, String frase, List<Criterio> criteriosAplicados) {
        this.regla = regla;
        this.palabrasClaves = palabrasClaves;
        this.frase = frase;
        this.criteriosAplicados = criteriosAplicados;
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

    public List<Criterio> getCriteriosAplicados() {
        return criteriosAplicados;
    }

    public void setCriteriosAplicados(List<Criterio> criteriosAplicados) {
        this.criteriosAplicados = criteriosAplicados;
    }

    
    
}
