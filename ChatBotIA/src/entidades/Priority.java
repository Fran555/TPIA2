package entidades;

import entidades.Regla;
import entidades.ReglaDato;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa el criterio de prioridad.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Priority extends Criterio {

	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {

            int priority, mayor = 0;		
            for(ReglaDato prd : list)
            {
                    Regla r = prd.getRegla();
                    priority = r.getPriority();
                    if(priority > mayor) mayor = priority;
            }
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            for(ReglaDato prd : list)
            {
                    Regla r = prd.getRegla();
                    if(r.getPriority() == mayor) ret.add(prd);
            }    	
            return ret;
		
	}

	@Override
	public String toString() {
		return "Priority (Prioridad)";
	}

}
