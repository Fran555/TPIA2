/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package respuestas;

/**
 *
 * @author fede_
 */
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
    public void ejecutar(){
        //Realmente lo importante en esta accion es el metodo toString(), este método no haría nada
    }
    
    @Override
    public String toString(){
        return texto;
    }
    
}
