/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

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
    
    public boolean esIgual(Pin otroPin)
    {
        return getNombre().equals(otroPin.getNombre());
    }
    
}
