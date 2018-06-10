package criterios;

import reglas.Regla;
import reglas.ReglaDato;
import reglas.ReglaDato;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa el criterio de novedad.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Novedad extends Criterio {

	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {

            int novelty, mayor = 0;
            //Se obtiene la mayor novedad de la lista de ReglaDato que están activas
            for(ReglaDato prd : list)
            {
                //La novedad se obtiene a partir la posicion en que está la regla dentro de la lista de reglas que tiene el agente
                novelty = list.indexOf(prd);
                if(novelty > mayor) mayor = novelty;
            }
            //Se obtiene las reglas que tienen la mayor novedad, es decir, las que fueron agregadas últimas
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            for(ReglaDato prd : list)
            {
                if(list.indexOf(prd) == mayor) ret.add(prd);
            }    	
            return ret;
		
	}

	@Override
	public String toString() {
            return "Novelty (Novedad)";
	}

}
