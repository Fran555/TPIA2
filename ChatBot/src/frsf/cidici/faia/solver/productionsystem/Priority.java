package frsf.cidici.faia.solver.productionsystem;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que implementa el criterio de prioridad.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Priority extends Criteria {

	@Override
	public LinkedList<PeerRuleData> apply(LinkedList<PeerRuleData> list) {

		int priority, mayor = 0;		
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		Rule r = i.next().getRule();
    		priority = r.getPriority();
    		if(priority > mayor) mayor = priority;
    	}
    	LinkedList<PeerRuleData> ret = new LinkedList<PeerRuleData>();
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		PeerRuleData prd = i.next();
    		Rule r = prd.getRule();
    		if(r.getPriority() == mayor) ret.add(prd);
    	}    	
		return ret;
		
	}

	@Override
	public String toString() {
		return "Priority (Prioridad)";
	}

}
