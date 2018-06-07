package frsf.ia.tp.chatbot.io;

import java.io.*;
import java.util.LinkedList;

/**
 * Clase auxiliar.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ArchivoInput {

		File inputFile;
		LinkedList<String> entradas;
	
	    public ArchivoInput(String nombre) {
	    	entradas = new LinkedList<String>();
	        try
	        {
	            FileInputStream fstream = new FileInputStream(nombre);
	            DataInputStream entrada = new DataInputStream(fstream);
	            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
	            String strLinea;
	            while((strLinea = buffer.readLine())!=null)
	            	entradas.addLast(strLinea);
	            entrada.close();
	        }
	        catch (Exception e){}
	    }
	    
	    public String getLinea(){
	    	if(entradas.isEmpty()) return null;
	    	return entradas.removeFirst();
	    }
	    
	    public boolean estaVacia(){
	    	return entradas.isEmpty();
	    }
	    
}