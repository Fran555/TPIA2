package frsf.ia.tp.chatbot.search.actions;

import java.util.Iterator;
import java.util.LinkedList;

import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp.chatbot.preprocessing.Oracion;
import frsf.ia.tp.chatbot.preprocessing.Palabra;
import frsf.ia.tp.chatbot.agent.*;
import frsf.ia.tp.chatbot.graph.*;

/**
 * Clase que implementa los operadores de busqueda.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Ir extends SearchAction {

	String destino;
	
	/**
	 * Constructor.
	 * @param d
	 */
	public Ir(String d){
		destino = d;
	}
	
    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {

        ChatbotState agState = (ChatbotState) s;
        NodoG nodo = agState.getnodoActual(); 
        if(Grafo.esSucesor(destino,nodo.getEtiqueta()))
        {
        	ChatbotState ret = new ChatbotState();
        	ret.setpercepcion(agState.getpercepcion());
        	Oracion aux = agState.getcadenaActual();
        	Palabra sgte = new Palabra();
        	sgte.setPalabra(destino);
        	sgte.setEncontrada(true);
        	aux.agregarPalabra(sgte);
        	ret.setcadenaActual(aux);
        	ret.setnodoActual(new NodoG(destino));
        	LinkedList<Regla> aux1 = agState.getreglas();
        	LinkedList<Regla> rAux = new LinkedList<Regla>();
        	for(Iterator<Regla> i = aux1.iterator();i.hasNext();)
        	{
        		Regla r1 = i.next();
            	Regla r2 = new Regla(r1.getId().intValue(),r1.getSpecificity(),r1.getPriority(),r1.getNovelty(),(String) r1.getCondition(),(String) r1.getThen());            		
            	rAux.addLast(r2);
        	}    	        	        	
        	aux1 = ret.getnodoActual().getReglas();
        	for(Iterator<Regla> i = aux1.iterator();i.hasNext();)
        	{
        		Regla r1 = i.next();
        		if(r1.isActive(agState.getpercepcion()))
        		{
            		Regla r2 = new Regla(r1.getId().intValue(),r1.getSpecificity(),r1.getPriority(),r1.getNovelty(),(String) r1.getCondition(),(String) r1.getThen());            		
            		rAux.addLast(r2);
        		}
        	}         	
        	ret.setreglas(rAux);
        	return ret;
        }
        else return null;
        
    }

    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {

        ChatbotState agState = (ChatbotState) ast;
        NodoG nodo = agState.getnodoActual(); 
        if(Grafo.esSucesor(destino,nodo.getEtiqueta()))
        {
        	Oracion aux = agState.getcadenaActual();
        	Palabra sgte = new Palabra();
        	sgte.setPalabra(destino);
        	sgte.setEncontrada(true);
        	aux.agregarPalabra(sgte);
        	agState.setcadenaActual(aux);        	
        	agState.setnodoActual(new NodoG(destino));
        	LinkedList<Regla> aux1 = agState.getreglas();
        	LinkedList<Regla> rAux = new LinkedList<Regla>();
        	for(Iterator<Regla> i = aux1.iterator();i.hasNext();)
        	{
        		Regla r1 = i.next();
            	Regla r2 = new Regla(r1.getId().intValue(),r1.getSpecificity(),r1.getPriority(),r1.getNovelty(),(String) r1.getCondition(),(String) r1.getThen());            		
            	rAux.addLast(r2);
        	}    	        	        	
        	aux1 = agState.getnodoActual().getReglas();
        	for(Iterator<Regla> i = aux1.iterator();i.hasNext();)
        	{
        		Regla r1 = i.next();
        		if(r1.isActive(agState.getpercepcion()))
        		{
            		Regla r2 = new Regla(r1.getId().intValue(),r1.getSpecificity(),r1.getPriority(),r1.getNovelty(),(String) r1.getCondition(),(String) r1.getThen());            		
            		rAux.addLast(r2);
        		}
        	}      	        	
        	agState.setreglas(rAux);       	
        	return est;
        }
        else return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(0);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
    	String c = new String("" + destino.charAt(0));
        return "Ir" + c.toUpperCase() + destino.substring(1,destino.length());
    }
}