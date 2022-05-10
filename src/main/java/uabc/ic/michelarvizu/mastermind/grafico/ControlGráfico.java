/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.grafico;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author arviz
 */
public class ControlGráfico {
    
    private TableroGráfico tableroGráfico;
    
    
    public ControlGráfico(int tamaño, int intentos)
    {
        tableroGráfico = new TableroGráfico(tamaño,intentos);
    }
    
    /**
     * Retorna una ArrayList de tipo Color donde guarda los respectivos colores de cada pin de la combinación dada como argumento.
     */
    public ArrayList <Color> setColoresCombinación(ArrayList <String> combinación)
    {
        ArrayList <Color> combinaciónGráfica = new ArrayList();
        for(int i=0; i<combinación.size(); i++)
        {
            switch(combinación.get(i))
            {
                case "RO":
                    combinaciónGráfica.add(Color.RED);
                    break;
                case "AZ":
                    combinaciónGráfica.add(Color.BLUE);
                    break;
                case "AM":
                    combinaciónGráfica.add(Color.YELLOW);
                    break;
                case "VE":
                    combinaciónGráfica.add(Color.GREEN);
                    break;
                case "MO":
                    combinaciónGráfica.add(Color.MAGENTA);
                    break;
                case "NA":
                    combinaciónGráfica.add(Color.ORANGE);
                    break;
            }
        }
        return combinaciónGráfica;
    }
    
    /**
     * Muestra gráficamente en el tablero el intento correspondiente.
     */
    public void mostrarIntento(int intento, int tamaño, ArrayList <Color> combinación)
    {
        tableroGráfico.setColoresDeIntento(tamaño, intento, combinación);
    }
    
    /**
     * Muestra gráficamente en el tablero la retroalimentación correspondiente al intento hecho.
     */
    public void mostrarRetroalimentación(int intento, int tamaño, ArrayList <Color> coloresSecretos, ArrayList <Color> coloresPrueba)
    {
        for(int i=0; i<tamaño; i++)
        {
            for(int j=0; j<tamaño; j++)
            {
                if(coloresSecretos.get(i).equals(coloresPrueba.get(i)))
                {
                    tableroGráfico.setColoresRetroalimentación(intento,i,Color.BLACK);
                } else {
                    if(coloresSecretos.get(i).equals(coloresPrueba.get(j)) && j!=i)
                    {
                        tableroGráfico.setColoresRetroalimentación(intento,i,Color.WHITE);
                    }
                }
            }
        }
    }
    
    /**
     * Muestra gráficamente en el tablero la combinación secreta.
     */
    public void mostrarCombinaciónSecreta(int tamaño, ArrayList <Color> combinación)
    {
        for(int i=0; i<tamaño; i++)
        {
            tableroGráfico.setColoresDeCombinaciónSecreta(tamaño, combinación);
        }
    } 
}
