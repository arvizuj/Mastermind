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
public class ControlLógico {
    private Decodificador jugador;
    private Retroalimentación retroalimentación;
    private CódigoSecreto códigoSecreto;
    private Tablero tablero;
    private int intentos;
    private int tamaño;
    private ArrayList <String> combinaciónDePrueba;
    private ArrayList <String> combinaciónSecreta;
    
    public ControlLógico()
    {
        tablero = new Tablero();
        setIntentos(tablero.getCantidadDeIntentos());
        setTamaño(tablero.getCantidadDeColores());
        jugador = new Decodificador(tamaño);
        códigoSecreto = new CódigoSecreto(tamaño);
    }
    
    public void jugar()
    {
        jugador.intentarCombinación(tamaño);
        tablero.mostrarIntento(jugador.getCombinaciónDePrueba());
        retroalimentación = new Retroalimentación(jugador.getCombinaciónDePrueba(),códigoSecreto.getCombinaciónSecreta());
    }
    
    private void setIntentos(int intentos)
    {
        this.intentos = intentos;
    }
    
    private void setTamaño(int tamaño)
    {
        this.tamaño = tamaño;
    }
    
    public int getIntentos()
    {
        return intentos;
    }
    
    public int getTamaño()
    {
        return tamaño;
    }
    
    /**
     * Devuelve la cadena de la combinación de prueba que ingresa el jugador.
     */
    public ArrayList <String> getStringCombinaciónDePrueba()
    {
        ArrayList <Pin> combinaciónPin = new ArrayList();
        combinaciónDePrueba = new ArrayList();
        combinaciónPin = jugador.getCombinaciónDePrueba();
        for(int i=0; i<combinaciónPin.size(); i++)
        {
            combinaciónDePrueba.add(combinaciónPin.get(i).getNombre());
        }
        return combinaciónDePrueba;
    }
    
    /**
     * Devuelve la cadena de la combinación secreta.
     */
    public ArrayList <String> getStringCombinaciónSecreta()
    {
        ArrayList <Pin> combinaciónPin = new ArrayList();
        combinaciónSecreta = new ArrayList();
        combinaciónPin = códigoSecreto.getCombinaciónSecreta();
        for(int i=0; i<combinaciónPin.size(); i++)
        {
            combinaciónSecreta.add(combinaciónPin.get(i).getNombre());
        }
        return combinaciónSecreta;
    }
}
