package frsf.ia.tp.chatbot.agent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import frsf.ia.tp.chatbot.agent.ChatbotAgentMain;
import frsf.ia.tp.chatbot.screens.PantallaPpal;

/**
 * Esta es la clase main.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotMain {

	/**
	 * Metodo main.
	 * @param args
	 */
	public static void main(String[] args) {

        try 
        {
       	 	PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("ArchivoDeLog.txt"))), true);
       	 	System.setOut(ps);         
       	 	System.setErr(ps);
           
        } 
        catch (Exception e)
        {
           System.out.println(e.getMessage());
        }
        
		ChatbotAgentMain main = new ChatbotAgentMain();
		new PantallaPpal(main);
				
		//ChatbotAgentMain.probarPreprocesamiento();
		//ChatbotAgentMain.probarBusqueda();
        //ChatbotAgentMain.probarSistemaDeProduccion();
        //ChatbotAgentMain.probarAgente();
	     
	}
}
