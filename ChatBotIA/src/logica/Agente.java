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
        
        //Ubicación geográfica
        palabras.put("Place", "Place");
        palabras.put("Holiday", "Place");
        palabras.put("Holidays", "Place");
        palabras.put("Vacation", "Place");
        palabras.put("Where", "Where");
        palabras.put("Kindergarten", "School");
        palabras.put("Middle School", "School");
        palabras.put("High School", "School");
        palabras.put("School", "School");
        palabras.put("Town", "Town");
        palabras.put("City", "Town");
        palabras.put("Province", "Town");
        
        //Expresiones de consulta, voluntad, etc.
        palabras.put("Want", "Want");
        palabras.put("Would", "Would");
        palabras.put("Have", "Have");
        palabras.put("Had", "Have");
        palabras.put("What", "What");
        palabras.put("What’s", "What");
        palabras.put("Which", "What");
        palabras.put("Will", "Will");
        
        //Actividades
        palabras.put("Hobby", "Hobby");
        palabras.put("Build", "Build");
        palabras.put("Builded", "Build");
        
        //Referencias a personas o al niño
        palabras.put("Who", "Who");
        palabras.put("You", "You");
        palabras.put("Your", "Your");
        palabras.put("I", "I");
        
        //Objetos de valor
        palabras.put("Credit", "Credit");
        palabras.put("Card", "Card");
        palabras.put("Money", "Money");
        palabras.put("Bank", "Money");
        palabras.put("Save", "Save");
        palabras.put("Store", "Save");
        palabras.put("Saving", "Save");
        palabras.put("Savings", "Save");
        palabras.put("Saved", "Save");
        palabras.put("Cash", "Money");
        palabras.put("Coins", "Money");
        palabras.put("Dollars", "Money");
        palabras.put("Jewelry", "Jewelry");
        palabras.put("Jewel", "Jewelry");
        palabras.put("Collect", "Collect");
        palabras.put("Collecting", "Collect");
        palabras.put("Gathering", "Collect");
        palabras.put("Income", "Income");
        palabras.put("Salary", "Income");
        palabras.put("Wage", "Income");
        palabras.put("Earning", "Income");
        
        //Reglas asociadas a datos personales
        palabras.put("Driver", "Driver");
        palabras.put("Driver's", "Driver");
        palabras.put("Drivers", "Driver");
        palabras.put("License", "License");
        palabras.put("Driver License", "License");
        palabras.put("Driver's License", "License");
        palabras.put("Drive", "Drive");
        palabras.put("Dedicated", "Dedicated");
        palabras.put("Commited", "Dedicated");
        palabras.put("Devoted", "Dedicated");
        palabras.put("Enthusiastic", "Dedicated");
        palabras.put("Something", "Something");
        palabras.put("SSN", "SSN"); //RO - 10/6/2018 - SSN es el "DNI" en EEUU
        
        //Objetos de valor
        palabras.put("Money", "Money");
        palabras.put("Cash", "Money");
        palabras.put("Coins", "Money");
        palabras.put("Dollars", "Money");
        palabras.put("Jewelry", "Jewelry");
        palabras.put("Jewel", "Jewelry");
        palabras.put("Necklace", "Necklace");
        palabras.put("Choker", "Necklace");
        palabras.put("Pendant", "Necklace");
        palabras.put("Strand", "Necklace");
        
        //Detalles de objetos
        palabras.put("Decorated", "Decorated");
        palabras.put("Adorned", "Decorated");
        
        //Family/Friends/Parents related
        palabras.put("Family", "Family");
        palabras.put("Aunt", "Family");
        palabras.put("Uncle", "Family");
        palabras.put("Cousin", "Family");
        palabras.put("Brother", "Family");
        palabras.put("Sister", "Family");
        palabras.put("Sibling", "Family");
        palabras.put("Grandfather", "Family");
        palabras.put("Grandmother", "Family");
        palabras.put("Grandpa", "Family");
        palabras.put("Grandma", "Family");
        palabras.put("Friend", "Friend");
        palabras.put("Buddy", "Friend");
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
        palabras.put("Friend", "Friend");
        palabras.put("Buddy", "Friend");
        palabras.put("Bud", "Friend");
        
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
      
        palabras.put("Born", "Born");
        palabras.put("Live", "Live");
        palabras.put("Lives", "Live");


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
        
        palabras.put("Store", "Store");
        palabras.put("Boutique", "Store");
        palabras.put("Market", "Store");
        palabras.put("Shop", "Store");

        //Integridad física
        palabras.put("Hit", "Hit");
        palabras.put("Beat", "Hit");
        palabras.put("Kick", "Hit");
        palabras.put("Naked", "Naked");
        palabras.put("Get", "Get");
        
        // Ofertas extrañas
        palabras.put("Sex", "Sex");
        palabras.put("Show", "Show");
        palabras.put("Drug", "Drug");
        palabras.put("Drugs", "Drug");
        palabras.put("Liquor", "Drug");
        palabras.put("Beer", "Drug");
        palabras.put("Drink", "Have");
        
        palabras.put("Look", "Look");
        palabras.put("Tell", "Tell");
        palabras.put("More", "More");

        //Is-related
        palabras.put("Is", "Is");
        palabras.put("Was", "Is");
        palabras.put("Were", "Is");
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
        //reglas.add(new Regla(1, new ArrayList<String>(), new ArrayList<Respuesta>(Arrays.asList(new Decir("No se ha encontrado una respuesta."))), 0));
        
        //Trabajo de los padres
        reglas.add(new Regla(2, new ArrayList<String>(Arrays.asList("Parent", "Job")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(3, new ArrayList<String>(Arrays.asList("Parent", "Job")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        
        //Dónde te vas después de...
        reglas.add(new Regla(5, new ArrayList<String>(Arrays.asList("Go", "Where", "After")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));
        reglas.add(new Regla(6, new ArrayList<String>(Arrays.asList("Go", "After", "School")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));
        reglas.add(new Regla(7, new ArrayList<String>(Arrays.asList("After", "School")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 2));

        //Edad del niño
        reglas.add(new Regla(8, new ArrayList<String>(Arrays.asList("How", "Old", "You")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        
        //Objetos de valor de la familia o del chico
        reglas.add(new Regla(10, new ArrayList<String>(Arrays.asList("Money", "Save", "You")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(11, new ArrayList<String>(Arrays.asList("Money", "Collect", "You")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(12, new ArrayList<String>(Arrays.asList("Money", "Save", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(13, new ArrayList<String>(Arrays.asList("Money", "Save", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(14, new ArrayList<String>(Arrays.asList("Jewelry", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(15, new ArrayList<String>(Arrays.asList("Jewelry", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(16, new ArrayList<String>(Arrays.asList("Have", "Home", "Jewelry")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(17, new ArrayList<String>(Arrays.asList("Have", "Home", "Jewelry")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(18, new ArrayList<String>(Arrays.asList("Credit", "Card")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 3));
        reglas.add(new Regla(19, new ArrayList<String>(Arrays.asList("Credit", "Card")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(20, new ArrayList<String>(Arrays.asList("Credit", "Card")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        
        //Datos personales del niño, padres o familiares
        reglas.add(new Regla(21, new ArrayList<String>(Arrays.asList("SSN", "Your")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(22, new ArrayList<String>(Arrays.asList("SSN", "Your")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(23, new ArrayList<String>(Arrays.asList("SSN", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 3));
        reglas.add(new Regla(24, new ArrayList<String>(Arrays.asList("SSN", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(25, new ArrayList<String>(Arrays.asList("SSN", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(26, new ArrayList<String>(Arrays.asList("License", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(27, new ArrayList<String>(Arrays.asList("License", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(28, new ArrayList<String>(Arrays.asList("Earn", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 3));
        reglas.add(new Regla(29, new ArrayList<String>(Arrays.asList("Income", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(30, new ArrayList<String>(Arrays.asList("Income", "Parent")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(31, new ArrayList<String>(Arrays.asList("Income", "Family")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 3));
        reglas.add(new Regla(32, new ArrayList<String>(Arrays.asList("Income", "Family")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(33, new ArrayList<String>(Arrays.asList("Income", "Family")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(34, new ArrayList<String>(Arrays.asList("Friend", "Name", "Your")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(35, new ArrayList<String>(Arrays.asList("Friend", "Name", "Your")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(36, new ArrayList<String>(Arrays.asList("Family", "Live", "Your")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(37, new ArrayList<String>(Arrays.asList("Place", "Where", "Your")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(38, new ArrayList<String>(Arrays.asList("Born", "Where", "You")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(39, new ArrayList<String>(Arrays.asList("How", "Old", "Family")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(40, new ArrayList<String>(Arrays.asList("How", "Old", "Friend")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(41, new ArrayList<String>(Arrays.asList("Friend", "Live", "Your")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(42, new ArrayList<String>(Arrays.asList("Where", "School", "Is")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(43, new ArrayList<String>(Arrays.asList("Family", "Has", "Store")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(44, new ArrayList<String>(Arrays.asList("Where", "Family", "Store")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));
        reglas.add(new Regla(53, new ArrayList<String>(Arrays.asList("Where", "Live", "You")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 2));

        //Integridad física y personal del niño
        reglas.add(new Regla(45, new ArrayList<String>(Arrays.asList("Sex", "Have", "You")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(46, new ArrayList<String>(Arrays.asList("Drug", "Have", "I")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(47, new ArrayList<String>(Arrays.asList("Hit", "You", "I")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(48, new ArrayList<String>(Arrays.asList("Get", "Naked")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(49, new ArrayList<String>(Arrays.asList("Show", "Naked")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(50, new ArrayList<String>(Arrays.asList("Show", "Sex")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
        reglas.add(new Regla(51, new ArrayList<String>(Arrays.asList("Name", "Teacher")), new ArrayList<Respuesta>(Arrays.asList(new AdvertirNoResponder())), 1));
        reglas.add(new Regla(52, new ArrayList<String>(Arrays.asList("Drug", "Want", "You")), new ArrayList<Respuesta>(Arrays.asList(new LlamarPadres())), 1));
    }
    
    /**
     *     Inicializa la lista de criterios a aplicarse en el orden que se desea que se apliquen (los criterios se anidan)
     */
    public void inicializarCriterios(){
        criterios = new LinkedList<Criterio>();
        
        criterios.add(new NoDuplicidad(this));
        criterios.add(new Especificidad());
        criterios.add(new Prioridad());
        criterios.add(new Novedad());

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
