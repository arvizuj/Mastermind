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
    
    public MastermindGame() 
    {
        combinación = new ArrayList();
        combinaciónSecreta = new ArrayList();
        combinaciónString = new ArrayList();
        combinaciónSecretaString = new ArrayList();
        controlLógico = new ControlLógico();
        controlGráfico= new ControlGráfico(controlLógico.getTamaño(),controlLógico.getIntentos());
        
        empezarJuego();
    }
    
    private void empezarJuego()
    {
        combinaciónString = controlLógico.getStringCombinaciónDePrueba();
        combinaciónSecretaString = controlLógico.getStringCombinaciónSecreta();
        combinaciónSecreta = controlGráfico.setColoresCombinación(combinaciónSecretaString);
        
        int i=1;
        while(i<=controlLógico.getIntentos() && !combinaciónString.equals(combinaciónSecretaString))
        {
            combinaciónString.removeAll(combinaciónString);
            combinación.removeAll(combinación);
            
            controlLógico.jugar();
            combinaciónString = controlLógico.getStringCombinaciónDePrueba();
            
            combinación = controlGráfico.setColoresCombinación(combinaciónString);
            
            controlGráfico.mostrarIntento(controlLógico.getIntentos()-i, controlLógico.getTamaño(), combinación);
            controlGráfico.mostrarRetroalimentación(controlLógico.getIntentos()-i, controlLógico.getStringRetroalimentación());
            i++;
        }
        if(combinaciónString.equals(combinaciónSecretaString))
            {
                System.out.printf("COMBINACIÓN ACERTADA EN EL INTENTO %d\n",i-1);
            } else {
            System.out.printf("COMBINACIÓN NO ACERTADA.\n");
        }
        controlGráfico.mostrarCombinaciónSecreta(controlLógico.getTamaño(),combinaciónSecreta);
        controlLógico.mostrarCombinaciónSecreta();
    }
    
    
}
