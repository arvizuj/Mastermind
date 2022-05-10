/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

import java.util.ArrayList;

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
               if(códigoSecreto.get(i).getNombre().equals(combinaciónDePrueba.get(j).getNombre()) && i==j)
               {
                   pinesRetroalimentación.add(new Pin("NE"));
                   //System.out.printf("%s ",pinesRetroalimentación.get(i).getNombre());
               } else {
                   if(códigoSecreto.get(i).equals(combinaciónDePrueba.get(j)) && i!=j)
                   {
                       pinesRetroalimentación.add(new Pin("BL"));
                      // System.out.printf("%s ",pinesRetroalimentación.get(i).getNombre());
                   }
               }
            } 
        }
    }
    
    public void mostrarRetroalimentación()
    {
        System.out.println("RETROALIMENTACIÓN");
        for(int i=0; i<pinesRetroalimentación.size(); i++)
        {
            System.out.printf("%s ",pinesRetroalimentación.get(i).getNombre());
        }
        System.out.printf("\n\n");
    }
}
