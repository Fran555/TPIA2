package frsf.cidici.faia.solver.productionsystem;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que implementa el criterio de no duplicacion.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class NoDuplication extends Criteria {
	
	@Override
	public LinkedList<PeerRuleData> apply(LinkedList<PeerRuleData> list) {
			
		LinkedList<PeerRuleData> ret = new LinkedList<PeerRuleData>();
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		PeerRuleData prd = i.next();
    		Rule r = prd.getRule();
    		Object d = prd.getData();
    		if(!used(r,d)) ret.add(prd);
    	}
		return ret;	
		
	}

	@Override
	public String toString() {	
		return "No Duplication (No duplicación)";
	}

	private boolean used(Rule r,Object d){
    	for(Iterator<PeerRuleData> i = ProductionSystem.used.iterator(); i.hasNext();)
    	{
    		PeerRuleData prd = i.next();
    		Rule ru = prd.getRule();
    		Object du = prd.getData();
    		if((r.getId().intValue()==ru.getId().intValue())&& (d.equals(du)))return true;
    	}
    	return false;
	}
}
