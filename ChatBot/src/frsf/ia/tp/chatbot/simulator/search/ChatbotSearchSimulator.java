package frsf.ia.tp.chatbot.simulator.search;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;
import frsf.ia.tp.chatbot.agent.ChatbotAgent;

/**
 * Clase que implementa el metodo start utilizado para la simulación. 
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotSearchSimulator extends SearchBasedAgentSimulator{

    public ChatbotSearchSimulator(Environment environment, Agent agent) {
		super(environment, agent);
	}

	@Override
    public void start() {

    	System.out.println("----------------------------------------------------");
    	System.out.println("--- " + this.getSimulatorName() + " ---");
    	System.out.println("----------------------------------------------------");
    	System.out.println();

    	Perception perception;
    	Action action;
    	ChatbotAgent agent;

    	agent = (ChatbotAgent) this.getAgents().firstElement();

    	/*
    	 * Simulation starts. The environment sends perceptions to the agent, and
    	 * it returns actions. The loop condition evaluation is placed at the end.
    	 * This works even when the agent starts with a goal state (see agentSucceeded
    	 * method in the SearchBasedAgentSimulator).
    	 */

    	System.out.println("------------------------------------");
        System.out.println("Sending perception to agent...\n");
        perception = this.getPercept();
        agent.see(perception);
        System.out.println("Perception: " + perception);
        System.out.println("Agent State: " + agent.getAgentState());
        System.out.println("Environment: " + environment);
        System.out.println("------------------------------------");  
        System.out.println("Searching...\n");
        do
        {
        	 
            System.out.println("Asking the agent for an action...");
            System.out.println("Agent State: " + agent.getAgentState());
            
            action = agent.selectAction();

            if (action == null) 
            {
            	if(!this.agentSucceeded(action))
            	{
            		agent.actualizar();
            		System.out.println("Action returned: No encontrado");
            	}
            }
            else
            {
            	System.out.println("Action returned: " + action);
            	System.out.println();
            	this.actionReturned(agent,action);            
            }

         } while (!this.agentSucceeded(action));
         
         agent.eliminarReglasRepetidas();
        
         System.out.println("------------------------------------");
         System.out.println("After Search...\n");
         System.out.println("Agent Final State: " + agent.getAgentState());
         System.out.println("------------------------------------");
        
         // Leave a blank line
         System.out.println();

         // This call can be moved to the Simulator class
         this.environment.close();
         
         // Launch simulationFinished event
         SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
    }
    
}
