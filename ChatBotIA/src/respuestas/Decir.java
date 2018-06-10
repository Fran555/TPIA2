package respuestas;

public class Decir extends Respuesta {
    
    private String texto;

    public Decir(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    @Override
    public void ejecutar(int repeticionesPC){
        //Realmente lo importante en esta accion es el metodo toString(), este método no haría nada
    }
    
    @Override
    public String toString(int repeticionesPC){
        return texto;
    }
    
}
