package logica;

import reglas.ReglaDato;
import reglas.Regla;
import criterios.Especificidad;
import criterios.Criterio;
import criterios.Prioridad;
import criterios.Novedad;
import criterios.NoDuplicidad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import respuestas.AdvertirNoResponder;
import respuestas.Decir;
import respuestas.LlamarPadres;
import respuestas.Respuesta;

public class Agente {
    
    List<ReglaDato> reglaDatoUsadas;
    Map <String,String> palabras;
    List<Regla> reglas;
    List<Criterio> criterios;
    
    public Agente(){
        inicializarAgente();
    } 
    
    public void inicializarAgente(){
        inicializarPalabrasClaves();
        inicializarReglas();
        inicializarCriterios();
        inicializarReglaDatoUsadas();
    }
    
    //Se inicializa el Map de sinonimo - palabra clave
    public void inicializarPalabrasClaves(){
        
        palabras = new HashMap <String,String>();
        
        //Ubicación espacio-temporal
        palabras.put("After", "After");
        palabras.put("Before", "Before");
        palabras.put("Be", "Be");
        palabras.put("Being", "Be");
        palabras.put("Go", "Go");
        palabras.put("Going", "Go");
        palabras.put("Holiday", "Place");
        palabras.put("Holidays", "Place");
        palabras.put("Place", "Place");
        palabras.put("Vacation", "Place");
        palabras.put("Where", "Place");
        
        //Expresiones de voluntad
        palabras.put("Want", "Want");
        palabras.put("Would", "Would");
        palabras.put("Have", "Have");
        palabras.put("Had", "Have");
        
        //Actividades
        palabras.put("Hobby", "Hobby");
        palabras.put("Build", "Build");
        palabras.put("Builded", "Build");
        
        //Referencias a personas o al niño
        palabras.put("Who", "Who");
        palabras.put("You", "You");
        palabras.put("Your", "You");
        
        //Family/Friends/Parents related
        palabras.put("Family", "Family");
        palabras.put("Dad", "Parent");
        palabras.put("Daddy", "Parent");
        palabras.put("Family", "Parent");
        palabras.put("Family Member", "Parent");
        palabras.put("Father", "Parent");
        palabras.put("Mom", "Parent");
        palabras.put("Mommy", "Parent");
        palabras.put("Mother", "Parent");
        palabras.put("Parent", "Parent");
        palabras.put("Parents", "Parent");
        
        //Home-related
        palabras.put("Home", "Home");
        palabras.put("House", "Home");
        palabras.put("Household", "Home");
        palabras.put("Apartment", "Home");
        palabras.put("Place", "Home");
        
        //How-related
        palabras.put("How", "How");
        palabras.put("How's", "How");
        palabras.put("Who's", "How");
        
        //Job-related
        palabras.put("Job", "Job");
        palabras.put("Jobs", "Job");
        palabras.put("Activity", "Job");
        palabras.put("Business", "Job");
        palabras.put("Career", "Job");
        palabras.put("Profession", "Job");
        palabras.put("Work", "Job");
        palabras.put("Occupation", "Job");
        
        //Name-related
        palabras.put("Name", "Name");
        palabras.put("First Name", "Name");
        palabras.put("Middle Name", "Name");
        palabras.put("Last Name", "Name");
        
        //Number-related
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
        
        //Old (age) related
        palabras.put("Old", "Old");
        palabras.put("Age", "Old");
       
        //School-related
        palabras.put("Kindergarten", "School");
        palabras.put("Middle School", "School");
        palabras.put("High School", "School");
        
        //Town-related
        palabras.put("Town", "Town");
        palabras.put("City", "Town");
        palabras.put("Province", "Town");

        //What-related
        palabras.put("What", "What");
        palabras.put("What’s", "What");
        palabras.put("Which", "What");
       

        palabras.put("Friend", "Friend");
        palabras.put("Buddy", "Friend");



        palabras.put("Born", "Born");
        palabras.put("Live", "Live");
        palabras.put("School", "School");

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

        palabras.put("Sex", "Sex");
        palabras.put("Show", "Show");
        
        palabras.put("Look", "Look");
        palabras.put("Tell", "Tell");
        palabras.put("More", "More");

        //Is-related
        palabras.put("Is", "Is");
        palabras.put("Was", "Is");
        palabras.put("Were", "Is");
        
        palabras.put("Decorated", "Decorated");
        palabras.put("Adorned", "Decorated");
        
        palabras.put("Dream", "Dream");
        
        palabras.put("Help", "Help");
        palabras.put("Helped", "Help");



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


    }
   
    /**
     * Se inicializa la lista de reglas
     * Formato: new Regla(id, lista de palabras claves, lista de respuestas, prioridad);
     */
    public void inicializarReglas(){
        
        reglas = new ArrayList<Regla>();
        
        //Reglas de prueba (Definir bien las reglas que se van a utilizar en funcion de las palabras claves y las acciones que deben realizar)
        //Toda regla que no tenga palabras claves se considera regla por defecto y solo se va a usar cuando no encuentre una regla activa con palabras claves
        
        //Reglas por defecto:
        reglas.add(new Regla(1, new ArrayList<String>(), new ArrayList<Respuesta>(Arrays.asList(new Decir("No se ha encontrado una respuesta."))), 0));
        
        //Reglas posta:
        reglas.add(new Regla(2, new ArrayList<String>(Arrays.asList("After")), new ArrayList<Respuesta>(Arrays.asList(new Decir("Regla de solo after"))), 1));
        reglas.add(new Regla(3, new ArrayList<String>(Arrays.asList("After", "Hobby")), new ArrayList<Respuesta>(Arrays.asList(new Decir("After y hobby 2"))), 2));
        reglas.add(new Regla(4, new ArrayList<String>(Arrays.asList("After", "Hobby")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres(), new AdvertirNoResponder())), 2));
        
        //Trabajo de los padres
        reglas.add(new Regla(5, new ArrayList<String>(Arrays.asList("Parent", "Job")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(6, new ArrayList<String>(Arrays.asList("Parent", "Job")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        
        //Dónde te vas después de...
        reglas.add(new Regla(7, new ArrayList<String>(Arrays.asList("Going", "Where")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));
        reglas.add(new Regla(8, new ArrayList<String>(Arrays.asList("Going", "Where", "After")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));
        reglas.add(new Regla(9, new ArrayList<String>(Arrays.asList("Going", "After", "School")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));
        reglas.add(new Regla(10, new ArrayList<String>(Arrays.asList("After", "School")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));

        //Definir más reglas
    }
    
    /**
     *     Inicializa la lista de criterios a aplicarse en el orden que se desea que se apliquen (los criterios se anidan)
     */
    public void inicializarCriterios(){
        criterios = new LinkedList<Criterio>();
        
        //Criterios de prueba (Definir bien los criterios que se van a utilizar realmente y su orden)
        criterios.add(new NoDuplicidad(this));
        criterios.add(new Especificidad());
        criterios.add(new Prioridad());
        criterios.add(new Novedad());
        
        //TODO: Definir criterios
    }
    
    //Se pone el blanco la lista de las reglas aplicadas
    public void inicializarReglaDatoUsadas(){
        reglaDatoUsadas = new ArrayList<ReglaDato>();
    }
    
    //Se aplican las tres etapas de Sistemas de Produccion para obtener una respuesta a la frase de entrada
    public List<Respuesta> generarRespuesta(String frase){
        try{
            List<String> palabrasClaves = PreProcesador.preprocesarEntrada(this, palabras, frase);
            List<Regla> reglasActivas = Cotejador.cotejarReglas(this, reglas, palabrasClaves, frase);
            List<Respuesta> respuesta = Respondedor.obtenerRespuesta(this, criterios, reglasActivas, palabrasClaves, frase);
            return respuesta;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return new ArrayList<Respuesta>();
    }
    
    public List<ReglaDato> getReglaDatoUsadas() {
        return reglaDatoUsadas;
    }

    public void setReglaDatoUsadas(List<ReglaDato> reglaDatoUsadas) {
        reglaDatoUsadas = reglaDatoUsadas;
    }
    
    public void agregarReglaDatoUsada(ReglaDato reglaDato){
        reglaDatoUsadas.add(reglaDato);
    }

    public Map<String, String> getPalabras() {
        return palabras;
    }

    public void setPalabras(Map<String, String> palabras) {
        palabras = palabras;
    }

    public List<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(List<Regla> reglas) {
        reglas = reglas;
    }
    
    public void addRegla(Regla regla){
        reglas.add(regla);
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<Criterio> criterios) {
        criterios = criterios;
    }
    
}
