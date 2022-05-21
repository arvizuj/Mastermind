/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author arviz
 */
public final class Decodificador {
    private ArrayList <Pin> combinaciónDePrueba;
    private HashSet <String> setDeIntentos;
    
    public Decodificador(int tamaño)
    {
        combinaciónDePrueba = new ArrayList();
        setDeIntentos = new HashSet();
    }
    
    /**
     * Permite ingresar una nueva combinación de colores con el método ingresarCombinación
     * y la evalúa para saber si ya se ingresó antes.
     */
    public void intentarCombinación(int tamaño)
    {
        ingresarColores(tamaño);
        boolean guardado = validarIntento(combinaciónDePrueba); 
        
        while(!guardado)
        {
            System.out.printf("La combinación ya fue ingresada.\n\n");
            ingresarColores(tamaño);
            guardado = validarIntento(combinaciónDePrueba);
        }
    }
    
    /**
     * Permite ingresar una combinación de colores y evalúa que no se repitan dentro de ella.
     */
    public void ingresarColores(int tamaño)
    {
        combinaciónDePrueba.clear();
        System.out.println("Ingrese una combinación.");
        for(int i=0; i<tamaño; i++)
        {
            System.out.println("Ingrese un color: ");
            Scanner scan = new Scanner(System.in);
            String nombre = scan.nextLine();
            Pin pin = new Pin(nombre.toUpperCase());
            
            while(!validarColor(pin))
            {
                System.out.println("El color ingresado ya se encuentra en la combinación.");
                System.out.println("Ingrese otro color: ");
                nombre = scan.nextLine();
                pin = new Pin(nombre.toUpperCase());
            }
            combinaciónDePrueba.add(pin);
        }
    }

    public ArrayList <Pin> getCombinaciónDePrueba() 
    {
        return combinaciónDePrueba;
    }
    
    /**
     * Busca el identificador de intento ingresado en el HashSet de intentos. Retorna false si el intento ya se
     * encuentra guardado y true de lo contrario y lo guarda en el HashSet.
     */
    public boolean validarIntento(ArrayList <Pin> combinación)
    {
        Intento intento = new Intento(combinación);
        if(setDeIntentos.contains(intento.getIdentificador()))
        {
            return false;
        } else {
            setDeIntentos.add(intento.getIdentificador());
        }
        return true;
    }
    
    /**
     * Busca el pin de argumento en la combinación de prueba. Retorna true si el pin no se encuentra
     * en la combinación y false si el pin se está repitiendo.
     */
    public boolean validarColor(Pin colorDePrueba)
    {
        for(Pin color: combinaciónDePrueba)
        {
            if(color.esIgual(colorDePrueba))
                return false;
        }
        return true;
    }
}
