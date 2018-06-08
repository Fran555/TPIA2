package frsf.ia.tp.chatbot.graph;

import java.util.Iterator;
import java.util.LinkedList;

import frsf.cidici.faia.solver.productionsystem.Rule;
import frsf.ia.tp.chatbot.preprocessing.Frase;
import frsf.ia.tp.chatbot.preprocessing.Oracion;
import frsf.ia.tp.chatbot.preprocessing.Palabra;

/**
 * Clase que implementa las reglas.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Regla extends Rule{
		
	/**
	 * Constructor.
	 */
	public Regla(){
		super();
	}
	
	/**
	 * Constructor.
	 * @param n
	 * @param aString
	 */
	public Regla(int id,String condicion,String rta){
		super();
		this.setId(id);
		this.setType(0);
		this.setCondition(condicion);
		this.setThen(rta);
	}
	
	/**
	 * Constructor.
	 * @param n
	 * @param aString
	 */
	public Regla(int id, int s,int p, int n,String condicion,String rta){
		this.setId(id);
		this.setSpecificity(s);
		this.setPriority(p);
		this.setNovelty(n);
		this.setType(0);
		this.setCondition(condicion);
		this.setThen(rta);
	}
	
	/**
	 * Método que retorna la respuesta de una regla.
	 * @return La respuesta.
	 */
	public String getRespuesta(){
		return (String) this.getThen();
	}

	@Override
	public boolean isActive(Object status) {
		Oracion ingresada = (Oracion) status;		
		if(this.getCondition().equals("")) return true;
		Oracion cond = new Frase((String) this.getCondition());
		LinkedList<Palabra> condicionante = cond.getPalabras();
		for(Iterator<Palabra> i = condicionante.iterator();i.hasNext();)
		{
			String s = i.next().getPalabra();
			if(ingresada.contienePalabra(s));
			else return false;
		}	
		return true;
	}
	
}
