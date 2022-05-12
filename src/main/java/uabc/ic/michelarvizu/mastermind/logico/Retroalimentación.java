/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author arviz
 */
public class Retroalimentación {
    
    private ArrayList <Pin> pinesRetroalimentación;
    
    public Retroalimentación(ArrayList <Pin> combinaciónDePrueba, ArrayList <Pin> códigoSecreto)
    {
        compararCombinaciones(combinaciónDePrueba, códigoSecreto);
        mostrarRetroalimentación();
    }
    
    public void compararCombinaciones(ArrayList <Pin> combinaciónDePrueba, ArrayList <Pin> códigoSecreto)
    {
        pinesRetroalimentación = new ArrayList();
        for(int j=0; j<códigoSecreto.size(); j++)
        {
            for(int i=0; i<códigoSecreto.size(); i++)
            {
               if(códigoSecreto.get(j).getNombre().equals(combinaciónDePrueba.get(i).getNombre()) && j==i)
               {
                   pinesRetroalimentación.add(new Pin("NE"));
               } else {
                   if(códigoSecreto.get(j).getNombre().equals(combinaciónDePrueba.get(i).getNombre()) && j!=i)
                   {
                       pinesRetroalimentación.add(new Pin("BL"));
                   }
               }
            } 
        }
        Collections.shuffle(pinesRetroalimentación);
    }
    
    public void mostrarRetroalimentación()
    {
        System.out.println("RETROALIMENTACIÓN:");
        for(int i=0; i<pinesRetroalimentación.size(); i++)
        {
            System.out.printf("%s ",pinesRetroalimentación.get(i).getNombre());
        }
        System.out.printf("\n\n");
    }
    
    public ArrayList <Pin> getRetroalimentación()
    {
        return pinesRetroalimentación;
    }
}
