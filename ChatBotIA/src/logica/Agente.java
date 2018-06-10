/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import respuestas.Decir;
import respuestas.LlamarPadres;
import respuestas.Respuesta;

/**
 *
 * @author fede_
 */
public class Agente {
    
    static List<ReglaDato> reglaDatoUsadas;
    
    static Map <String,String> palabras;
    static List<Regla> reglas;
    static List<Criterio> criterios;
    
    //Se inicializa el Map de sinonimo - palabra clave
    public static void inicializarPalabrasClaves(){
        
        palabras = new HashMap <String,String>();
        
        palabras.put("Parent","Parent");
        palabras.put("Parents", "Parent");
        palabras.put("Parent","Dad");
        palabras.put("Parent","Mom");
        palabras.put("Parent","Father");
        palabras.put("Parent","Mother");
        palabras.put("Parent","Daddy");
        palabras.put("Parent","Mommy");
        palabras.put("Parent","Family Member");
        
        palabras.put("What","What");
        palabras.put("What","What’s");
        palabras.put("What","Which");

        palabras.put("How","How");
        palabras.put("How","How's");
        
        palabras.put("Who","Who");
        palabras.put("How","Who's");
        
        palabras.put("You","You");
        palabras.put("You","Your");
        
        palabras.put("Name","Name");
        palabras.put("Name","First Name");
        palabras.put("Name","Middle Name");
        palabras.put("Name","Last Name");
        
        palabras.put("Friend","Friend");
        palabras.put("Friend","Buddy");
        
        palabras.put("Family","Family");
        
        palabras.put("After","After");
        
        palabras.put("Old","Old");
        
        palabras.put("Old","Age");
        
        palabras.put("Be","Be");
        palabras.put("Be","Being");
        
        palabras.put("Number","Number");
        palabras.put("Number","One");
        palabras.put("Number","Two");
        palabras.put("Number","Three");
        palabras.put("Number","Four");
        palabras.put("Number","Five");
        palabras.put("Number","Six");
        palabras.put("Number","Seven");
        palabras.put("Number","Eight");
        palabras.put("Number","Nine");
        palabras.put("Number","Ten");
        
        palabras.put("Born","Born");
        
        palabras.put("Live","Live");
        
        palabras.put("School","School"); 
        palabras.put("School","Kindergarten");
        palabras.put("School","Middle School");
        palabras.put("School","High School");
        
        palabras.put("Grade","Grade");
        
        palabras.put("Teacher","Teacher");
        palabras.put("Teacher","Proffesor");
        palabras.put("Teacher","Tutor");
        
        palabras.put("Class","Class");
        
        palabras.put("Fun","Fun");
        
        palabras.put("Bank","Bank");
        
        palabras.put("Save","Save");
        palabras.put("Save","Saving");
        palabras.put("Save","Saved");
        
        palabras.put("Money","Money");
        palabras.put("Money","Cash");
        palabras.put("Money","Coins");
        palabras.put("Money","Dollars");
        
        palabras.put("Jewelry","Jewelry");
        palabras.put("Jewelry","Jewel");
        
        palabras.put("Store","Store");
        palabras.put("Store","Boutique");
        palabras.put("Store","Market");
        palabras.put("Store","Shop");
        
        palabras.put("Necklace","Necklace");
        palabras.put("Necklace","Choker");
        palabras.put("Necklace","Pendant");
        palabras.put("Necklace","Strand");
        
        palabras.put("Job","Job");
        palabras.put("Job","Activity");
        palabras.put("Job","Business");
        palabras.put("Job","Career");
        palabras.put("Job","Profession");
        palabras.put("Job","Work");
        palabras.put("Job","Occupation");
        
        palabras.put("Home","Home");
        palabras.put("Home","House");
        palabras.put("Home","Household");
        palabras.put("Home","Apartment");
        palabras.put("Home","Place");
        
        palabras.put("Look","Look");
        
        palabras.put("Tell","Tell");
        
        palabras.put("More","More");
        
        palabras.put("Home","Home");
        
        palabras.put("Is","Is");
        palabras.put("Is","Was");
        palabras.put("Is","Were");
        
        palabras.put("Decorated","Decorated");
        palabras.put("Decorated","Adorned");
        
        palabras.put("Dream","Dream");
        
        palabras.put("Help","Help");
        palabras.put("Help","Helped");
        
        palabras.put("Build","Build");
        palabras.put("Build","Builded");
        
        palabras.put("Have","Have");
        palabras.put("Have","Had");
        
        palabras.put("Vacation","Vacation");
        
        palabras.put("Town","Town");
        palabras.put("Town","City");
        palabras.put("Town","Province");
        
        palabras.put("License","License");
        palabras.put("License","Driver's License");
        
        palabras.put("Drive","Drive");
        
        palabras.put("Dedicated","Dedicated");
        palabras.put("Dedicated","Commited");
        palabras.put("Dedicated","Devoted");
        palabras.put("Dedicated","Enthusiastic");
        
        palabras.put("Something","Something");
        
        palabras.put("Collecting","Collecting");
        
        palabras.put("Collecting","Gathering");
        
        palabras.put("Book","Book");
        palabras.put("Book","Books");
        
        palabras.put("Hobby","Hobby");
        
    }
    
    //Se inicializa la lista de reglas
    //Formato: new Regla(id, lista de palabras claves, lista de respuestas, prioridad);
    public static void inicializarReglas(){
        
        reglas = new ArrayList<Regla>();
        
        //Reglas de prueba
        reglas.add(new Regla(1, new ArrayList<String>(Arrays.asList("After")), new ArrayList<Respuesta>(Arrays.asList(new Decir("Regla de solo after"))), 1));
        reglas.add(new Regla(2, new ArrayList<String>(Arrays.asList("After", "Hobby")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres(), new Decir("After y hobby 1"))), 2));
        reglas.add(new Regla(3, new ArrayList<String>(Arrays.asList("After", "Hobby")), new ArrayList<Respuesta>(Arrays.asList(new Decir("After y hobby 2"))), 2));
        
        //TODO: Definir reglas
    }
    
    //Se inicializa la lista de criterios a aplicarse en el orden que se desea que se apliquen (los criterios se anidan)
    public static void inicializarCriterios(){
        criterios = new LinkedList<Criterio>();
        
        //Criterios de prueba
        criterios.add(new Especificidad());
        criterios.add(new Prioridad());
        criterios.add(new NoDuplicidad());
        criterios.add(new Novedad());
        
        //TODO: Definir criterios
    }
    
    //Se pone el blanco la lista de las reglas aplicadas
    public static void inicializarReglaDatoUsadas(){
        reglaDatoUsadas = new ArrayList<ReglaDato>();
    }
    
    //Se aplican las tres etapas de Sistemas de Produccion para obtener una respuesta a la frase de entrada
    public static List<Respuesta> generarRespuesta(String frase){
        try{
            List<String> palabrasClaves = PreProcesador.preprocesarEntrada(palabras, frase);
            List<ReglaDato> reglasActivas = Cotejador.cotejarReglas(reglas, palabrasClaves, frase);
            List<Respuesta> respuesta = Respondedor.obtenerRespuesta(criterios, reglasActivas);
            return respuesta;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return new ArrayList<Respuesta>();
    }
    
    public static List<ReglaDato> getReglaDatoUsadas() {
        return reglaDatoUsadas;
    }

    public static void setReglaDatoUsadas(List<ReglaDato> reglaDatoUsadas) {
        Agente.reglaDatoUsadas = reglaDatoUsadas;
    }
    
    public static void agregarReglaDatoUsada(ReglaDato reglaDato){
        Agente.reglaDatoUsadas.add(reglaDato);
    }

    public static Map<String, String> getPalabras() {
        return palabras;
    }

    public static void setPalabras(Map<String, String> palabras) {
        Agente.palabras = palabras;
    }

    public static List<Regla> getReglas() {
        return reglas;
    }

    public static void setReglas(List<Regla> reglas) {
        Agente.reglas = reglas;
    }
    
    public static void addRegla(Regla regla){
        Agente.reglas.add(regla);
    }

    public static List<Criterio> getCriterios() {
        return criterios;
    }

    public static void setCriterios(List<Criterio> criterios) {
        Agente.criterios = criterios;
    }
    
}
