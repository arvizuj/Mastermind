/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author arviz
 */
public final class CódigoSecreto {
    ArrayList <Pin> coloresDisponibles = new ArrayList();
    private ArrayList <Pin> combinaciónSecreta;
    
    /**
     * Constructor de la clase CódigoSecreto. Crea una ArrayList de los colores disponibles y llama a los
     * métodos para generar una nueva combinación secreta.
     * El argumento tamaño representa la cantidad de colores a utilizar en la combinación.
     */
    public CódigoSecreto(int tamaño)
    {
        coloresDisponibles.add(new Pin("AZ")); //AZUL
        coloresDisponibles.add(new Pin("RO")); //ROJO
        coloresDisponibles.add(new Pin("AM")); //AMARILLO
        coloresDisponibles.add(new Pin("VE")); //VERDE
        coloresDisponibles.add(new Pin("MO")); //MORADO/MAGENTA
        coloresDisponibles.add(new Pin("NA")); //NARANJA
        
        combinaciónSecreta = generarCombinación(tamaño);
    }
    
    /**
     * Genera la combinación secreta a partir de números aleatorios que simbolizan las posiciones dentro de la
     * ArrayList de colores disponibles.
     */
    private ArrayList <Pin> generarCombinación(int tamaño)
    { 
        combinaciónSecreta = new ArrayList();
        
        for(int i=0; i<tamaño; i++)
        {
            Random r = new Random();
            int posición = r.nextInt(coloresDisponibles.size());
            combinaciónSecreta.add(coloresDisponibles.remove(posición));
        }
        return combinaciónSecreta;
    }

    public ArrayList <Pin> getCombinaciónSecreta()
    {
        return combinaciónSecreta;
    }
    
    /**
     * Muestra en consola la combinación secreta en modo de cadena.
     */
    public void mostrarCombinación()
    {
        System.out.printf("Combinación secreta: \n");
        for(int i=0; i<combinaciónSecreta.size(); i++)
        {
            System.out.printf("%s ", combinaciónSecreta.get(i).getNombre());
        }
    }
    
}