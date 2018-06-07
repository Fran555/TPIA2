package frsf.ia.tp.chatbot.agent;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;
import frsf.ia.tp.chatbot.preprocessing.Oracion;

/**
 * Clase que implementa la meta del agente.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotGoal extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    
    	/*
    	 * Sera estado de meta si la oracion percibida es igual a la
    	 * oracion formada en el estado del agente.
    	 */
        if(percepcionNull(agentState) || percepcionEsIgualA(agentState))
        	return true;
        return false;
	}
    
    /**
     * Metodo que determina si la percepcion es igual a la cadena
     * actual que ha formado el agente.
     * @return True si es igual, False en otro caso.
     */
    private boolean percepcionEsIgualA(AgentState state){
    	ChatbotState agentState = (ChatbotState) state;
    	Oracion percep = agentState.getpercepcion();
    	Oracion formada = agentState.getcadenaActual();
    	return percep.equals(formada);
    }
    
    /**
     * Metodo que determina si la percepcion es nula.
     * @return True si es igual, False en otro caso.
     */
    private boolean percepcionNull(AgentState state){
    	ChatbotState agentState = (ChatbotState) state;
    	return !agentState.tienePercepcionValida();
    }

}