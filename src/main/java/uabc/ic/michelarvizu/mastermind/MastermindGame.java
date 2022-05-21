/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind;

import java.awt.Color;
import java.util.ArrayList;
import uabc.ic.michelarvizu.mastermind.grafico.ControlGráfico;
import uabc.ic.michelarvizu.mastermind.logico.ControlLógico;

/**
 *
 * @author arviz
 */
public class MastermindGame {
    
    private ControlGráfico controlGráfico;
    private ControlLógico controlLógico;
    private ArrayList <Color> combinación;
    private ArrayList <Color> combinaciónSecreta;
    private ArrayList <String> combinaciónString;
    private ArrayList <String> combinaciónSecretaString;
    private float puntuación;
    
    /**
     * Constructor sin parámetros.
     * Crea los objetos indicados e inicia el juego.
     */
    public MastermindGame() 
    {
        puntuación = 1000;
        combinación = new ArrayList();
        combinaciónSecreta = new ArrayList();
        combinaciónString = new ArrayList();
        combinaciónSecretaString = new ArrayList();
        controlLógico = new ControlLógico();
        controlGráfico= new ControlGráfico(controlLógico.getTamaño(),controlLógico.getIntentos());
        
        empezarJuego();
    }
    
    /**
     * Método que se encarga de utilizar los métodos de otras clases para realizar el juego.
     * Lleva el control sobre cuándo se pueden seguir ingresando intentos.
     */
    private void empezarJuego()
    {
        int intentos = controlLógico.getIntentos();
        float puntosMenos = puntuación/intentos;
        combinaciónString = controlLógico.getStringCombinaciónDePrueba();
        combinaciónSecretaString = controlLógico.getStringCombinaciónSecreta();
        combinaciónSecreta = controlGráfico.setColoresCombinación(combinaciónSecretaString);
        //controlLógico.mostrarCombinaciónSecreta();
        
        int i=1;
        while(i<=intentos && !combinaciónString.equals(combinaciónSecretaString))
        {
            combinaciónString.removeAll(combinaciónString);
            combinación.removeAll(combinación);
            
            controlLógico.jugar();
            combinaciónString = controlLógico.getStringCombinaciónDePrueba();
            
            combinación = controlGráfico.setColoresCombinación(combinaciónString);
            
            controlGráfico.mostrarIntento(controlLógico.getIntentos()-i, combinación);
            controlGráfico.mostrarRetroalimentación(controlLógico.getIntentos()-i, controlLógico.getStringRetroalimentación());
            
            i++;
        }
        puntuación = puntuación-(puntosMenos*(i-2));
        if(combinaciónString.equals(combinaciónSecretaString))
            {
                System.out.printf("COMBINACIÓN ACERTADA EN EL INTENTO %d\n",i-1);
                System.out.printf("Puntuación: %.2f\n", puntuación);
            } else {
            System.out.printf("COMBINACIÓN NO ACERTADA.\n");
        }
        controlGráfico.mostrarCombinaciónSecreta(combinaciónSecreta);
        controlLógico.mostrarCombinaciónSecreta();
    }
}
