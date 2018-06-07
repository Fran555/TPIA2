package frsf.ia.tp.chatbot.agent;

import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

/**
 * Esta clase representa la percepcion del ChatBot.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotAgentPerception extends Perception {

	private String oracion;
	
    public  ChatbotAgentPerception() {
    }

    public ChatbotAgentPerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    }
    
    @Override
    public String toString() {
        return "Oracion: " + oracion.toString() + "\n";
    }

    // The following methods are agent-specific
     public String getoracion(){
        return oracion;
     }
     
     public void setoracion(String arg){
        this.oracion = arg;
     }
  
}
