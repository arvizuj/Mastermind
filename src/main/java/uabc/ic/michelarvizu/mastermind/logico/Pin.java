/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

import java.util.Objects;

/**
 *
 * @author arviz
 */
public class Pin {
    private String nombre;
    
    public Pin(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Compara este pin con el pin de argumento. 
     * Retorna true si los pines son iguales y false si los pines no son iguales.
     */
    public boolean esIgual(Pin otroPin)
    {
        return getNombre().equals(otroPin.getNombre());
    }

    @Override
    public String toString() {
        return nombre;
    }
}
