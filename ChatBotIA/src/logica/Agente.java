/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Criterio;
import entidades.Regla;
import entidades.ReglaDato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fede_
 */
public class Agente {
    
    static List<ReglaDato> reglaDatoUsadas;
    
    Map <String,String> palabras;
    List<Regla> reglas;
    List<Criterio> criterios;

    public Agente() {
        this.inicializarPc();
        this.inicializarReglas();
        this.inicializarCriterios();
    }
    
    private void inicializarPc(){
        
        palabras = new HashMap <String,String>();
        
        palabras.put("Parent","Parent");
        palabras.put("Parent","Parents");
        palabras.put("Parent","Dad");
        palabras.put("Parent","Mom");
        palabras.put("Parent","Father");
        palabras.put("Parent","Mother");
        palabras.put("Parent","Daddy");
        palabras.put("Parent","Mommy");
        
    }
    
    private void inicializarReglas(){
        
        reglas = new ArrayList<Regla>();
        
        //TODO: Definir reglas
    }
    
    private void inicializarCriterios(){
        criterios = new ArrayList<Criterio>();
        
        //TODO: Definir criterios
    }
    
    public String generarRespuesta(String frase){
        try{
            List<String> palabrasClaves = PreProcesador.preprocesarEntrada(palabras, frase);
            List<Regla> reglasActivas = Cotejador.cotejarReglas(reglas, palabrasClaves);
            String respuesta = Respondedor.obtenerRespuesta(criterios, reglasActivas);
            return respuesta;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
    
    public static List<ReglaDato> getReglaDatoUsadas() {
        return reglaDatoUsadas;
    }

    public static void setReglaDatoUsadas(List<ReglaDato> reglaDatoUsadas) {
        Agente.reglaDatoUsadas = reglaDatoUsadas;
    }
    
    
}
