package criterios;

import reglas.ReglaDato;
import java.util.LinkedList;
import java.util.List;

public abstract class Criterio {
    
    public abstract LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list);
    public abstract String toString();
    
}
