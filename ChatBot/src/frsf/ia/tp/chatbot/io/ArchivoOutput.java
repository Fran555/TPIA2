package frsf.ia.tp.chatbot.io;

import java.io.*;
import java.util.LinkedList;

/**
 * Clase auxiliar.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ArchivoOutput {
	
		String nombre;
		LinkedList<String> respuestas;
	
	    public ArchivoOutput(String n) {
	    	nombre = n;
	    	respuestas = new LinkedList<String>();
	    }
	    
	    public void agregarRespuesta(String rta){
	    	respuestas.addLast(rta);
	    }
	    
	    public void grabar()
	    {
	        try
	        {
	        	FileOutputStream fstream = new FileOutputStream(nombre);
	            DataOutputStream salida = new DataOutputStream(fstream);
	            BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(salida));		            
	            while(!respuestas.isEmpty()){
	            	buffer.write(respuestas.removeFirst());
	            	buffer.newLine();
	            }
	            buffer.close();
	            fstream.close();
	        }
	        catch (Exception e){}
	    }    
}