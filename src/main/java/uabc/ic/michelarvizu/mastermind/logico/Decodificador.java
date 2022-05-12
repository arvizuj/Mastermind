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
    private HashSet <Intento> setDeIntentos;
    
    public Decodificador(int tamaño)
    {
        combinaciónDePrueba = new ArrayList();
        setDeIntentos = new HashSet();
    }
    
    public void intentarCombinación(int tamaño)
    {
        combinaciónDePrueba.removeAll(combinaciónDePrueba);
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
        while(!guardarIntento(combinaciónDePrueba))
        {
            System.out.println("La combinación ya fue ingresada.");
            System.out.println("Ingrese otra combinación.");
            for(int i=0; i<tamaño; i++)
            {
                Scanner scan = new Scanner(System.in);
                String nombre = scan.nextLine();
                Pin pin = new Pin(nombre.toUpperCase());
                while(!validarColor(pin))
                {
                    System.out.println("El color ingresado ya se encuentra en la cobinación.");
                    System.out.println("Ingrese otro color: ");
                    nombre = scan.nextLine();
                    pin = new Pin(nombre.toUpperCase());
                }
                combinaciónDePrueba.add(pin);
            }
        }
    }
    
    /**
     * Guarda el intento en el Hashset de intentos (en caso de que no esté repetido).
     */
    private boolean guardarIntento(ArrayList <Pin> combinación)
    {
        Intento intento = new Intento(combinación);
        if(validarIntento(intento))
        {
            setDeIntentos.add(intento);
            return true;
        } else {
            System.out.println("La combinación ingresada ya se intentó.");
            return false;
        }
    }

    public ArrayList <Pin> getCombinaciónDePrueba() 
    {
        return combinaciónDePrueba;
    }
    
    /**
     * Busca el intento ingresado en el Hashset de intentos. Retorna false si el intento ya se
     * encuentra guardado y true de lo contrario.
     */
    public boolean validarIntento(Intento intento)
    {
        for(Intento intentoPasado: setDeIntentos)
        {
            if(intento.equals(intentoPasado))
                return false;
        }
        return true;
    }
    
    public boolean validarColor(Pin colorDePrueba)
    {
        for(Pin color: combinaciónDePrueba)
        {
            if(color.equals(colorDePrueba))
                return false;
        }
        return true;
    }
}
