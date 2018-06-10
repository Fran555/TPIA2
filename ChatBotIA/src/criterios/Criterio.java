/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criterios;

import reglas.ReglaDato;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author fede_
 */
public abstract class Criterio {
    
    public abstract LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list);
    public abstract String toString();
    
}
