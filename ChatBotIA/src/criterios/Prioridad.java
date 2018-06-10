package criterios;

import reglas.Regla;
import reglas.Regla;
import reglas.ReglaDato;
import reglas.ReglaDato;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa el criterio de prioridad.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Prioridad extends Criterio {

	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {

            int priority, mayor = 0;
            //Se obtiene la mayor prioridad dentro de la lista de ReglaDato del agente
            for(ReglaDato prd : list)
            {
                Regla r = prd.getRegla();
                //La prioridad es un valor asignado a la regla
                priority = r.getPrioridad();
                if(priority > mayor) mayor = priority;
            }
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            //Se obtienen las reglas con la mayor prioridad
            for(ReglaDato prd : list)
            {
                Regla r = prd.getRegla();
                if(r.getPrioridad()== mayor) ret.add(prd);
            }    	
            return ret;
		
	}

	@Override
	public String toString() {
            return "Priority (Prioridad)";
	}

}
