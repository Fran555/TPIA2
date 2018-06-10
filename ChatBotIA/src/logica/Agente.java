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
        
        palabras.put("Parent", "Parent");
        palabras.put("Parents", "Parent");
        palabras.put("Dad", "Parent");
        palabras.put("Mom", "Parent");
        palabras.put("Father", "Parent");
        palabras.put("Mother", "Parent");
        palabras.put("Daddy", "Parent");
        palabras.put("Mommy", "Parent");
        palabras.put("Family Member", "Parent");
        palabras.put("What", "What");
        palabras.put("What’s", "What");
        palabras.put("Which", "What");
        palabras.put("How", "How");
        palabras.put("How's", "How");
        palabras.put("Who", "Who");
        palabras.put("Who's", "How");
        palabras.put("You", "You");
        palabras.put("Your", "You");
        palabras.put("Name", "Name");
        palabras.put("First Name", "Name");
        palabras.put("Middle Name", "Name");
        palabras.put("Last Name", "Name");
        palabras.put("Friend", "Friend");
        palabras.put("Buddy", "Friend");
        palabras.put("Family", "Family");
        palabras.put("After", "After");
        palabras.put("Old", "Old");
        palabras.put("Age", "Old");
        palabras.put("Be", "Be");
        palabras.put("Being", "Be");
        palabras.put("Number", "Number");
        palabras.put("One", "Number");
        palabras.put("Two", "Number");
        palabras.put("Three", "Number");
        palabras.put("Four", "Number");
        palabras.put("Five", "Number");
        palabras.put("Six", "Number");
        palabras.put("Seven", "Number");
        palabras.put("Eight", "Number");
        palabras.put("Nine", "Number");
        palabras.put("Ten", "Number");
        palabras.put("Born", "Born");
        palabras.put("Live", "Live");
        palabras.put("School", "School");
        palabras.put("Kindergarten", "School");
        palabras.put("Middle School", "School");
        palabras.put("High School", "School");
        palabras.put("Grade", "Grade");
        palabras.put("Teacher", "Teacher");
        palabras.put("Proffesor", "Teacher");
        palabras.put("Tutor", "Teacher");
        palabras.put("Class", "Class");
        palabras.put("Fun", "Fun");
        palabras.put("Bank", "Bank");
        palabras.put("Save", "Save");
        palabras.put("Saving", "Save");
        palabras.put("Saved", "Save");
        palabras.put("Money", "Money");
        palabras.put("Cash", "Money");
        palabras.put("Coins", "Money");
        palabras.put("Dollars", "Money");
        palabras.put("Jewelry", "Jewelry");
        palabras.put("Jewel", "Jewelry");
        palabras.put("Store", "Store");
        palabras.put("Boutique", "Store");
        palabras.put("Market", "Store");
        palabras.put("Shop", "Store");
        palabras.put("Necklace", "Necklace");
        palabras.put("Choker", "Necklace");
        palabras.put("Pendant", "Necklace");
        palabras.put("Strand", "Necklace");
        palabras.put("Job", "Job");
        palabras.put("Activity", "Job");
        palabras.put("Business", "Job");
        palabras.put("Career", "Job");
        palabras.put("Profession", "Job");
        palabras.put("Work", "Job");
        palabras.put("Occupation", "Job");
        palabras.put("Home", "Home");
        palabras.put("House", "Home");
        palabras.put("Household", "Home");
        palabras.put("Apartment", "Home");
        palabras.put("Place", "Home");
        palabras.put("Look", "Look");
        palabras.put("Tell", "Tell");
        palabras.put("More", "More");
        palabras.put("Home", "Home");
        palabras.put("Is", "Is");
        palabras.put("Was", "Is");
        palabras.put("Were", "Is");
        palabras.put("Decorated", "Decorated");
        palabras.put("Adorned", "Decorated");
        palabras.put("Dream", "Dream");
        palabras.put("Help", "Help");
        palabras.put("Helped", "Help");
        palabras.put("Build", "Build");
        palabras.put("Builded", "Build");
        palabras.put("Have", "Have");
        palabras.put("Had", "Have");
        palabras.put("Vacation", "Vacation");
        palabras.put("Town", "Town");
        palabras.put("City", "Town");
        palabras.put("Province", "Town");
        palabras.put("License", "License");
        palabras.put("Driver's License", "License");
        palabras.put("Drive", "Drive");
        palabras.put("Dedicated", "Dedicated");
        palabras.put("Commited", "Dedicated");
        palabras.put("Devoted", "Dedicated");
        palabras.put("Enthusiastic", "Dedicated");
        palabras.put("Something", "Something");
        palabras.put("Collecting", "Collecting");
        palabras.put("Gathering", "Collecting");
        palabras.put("Book", "Book");
        palabras.put("Books", "Book");
        palabras.put("Hobby", "Hobby");

        
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
