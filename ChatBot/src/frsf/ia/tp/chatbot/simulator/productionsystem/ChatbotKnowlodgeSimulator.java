package frsf.ia.tp.chatbot.simulator.productionsystem;

import java.util.Vector;

import frsf.cidici.faia.simulator.KnowledgeBasedAgentSimulator;
import frsf.cidici.faia.solver.productionsystem.ProductionSystemAction;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;
import frsf.ia.tp.chatbot.agent.ChatbotAgent;

/**
 * Clase que implementa el simulador especifico del Chatbot. 
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotKnowlodgeSimulator extends KnowledgeBasedAgentSimulator {

	public ChatbotKnowlodgeSimulator(Environment environment,Vector<Agent> agents) {
		super(environment, agents);	
	}
	
	public ChatbotKnowlodgeSimulator(Environment environment,Agent agent) {
		super(environment, agent);	
	}

	public void start() {

        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();

        Action action;
        ChatbotAgent agent;

        agent = (ChatbotAgent) this.getAgents().firstElement();

        System.out.println("------------------------------------");

        System.out.println("Agent State: " + agent.getAgentState());
        System.out.println("Environment: " + environment);

        System.out.println("Asking the agent that start the learning process...");
        action = agent.learn();

        if (action == null)
        	System.out.println("\nRule to execute: None");
        else
        {
        	ProductionSystemAction act = (ProductionSystemAction) action;
        	System.out.println("\nRule to execute: " + act.getPeerRuleData().getRule().getId());
        }

        this.ruleReturned(agent, action);

        // Leave a blank line
        System.out.println();

        // This call can be moved to the Simulator class
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
		
	}
	
}
