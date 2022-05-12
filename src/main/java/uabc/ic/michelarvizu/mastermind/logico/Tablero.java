/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.logico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arviz
 */

public class Tablero {
    private int cantidadDeColores;
    private int cantidadDeIntentos;
    
    public Tablero()
    {
        System.out.println("CREACIÓN DE NUEVO JUEGO");
        ingresarCantidadDeColores();
        ingresarCantidadDeIntentos();
    }
    
    private void ingresarCantidadDeColores()
    {
        System.out.println("Ingrese la cantidad de colores a utilizar (4 - 6): ");
        Scanner scan = new Scanner(System.in);
        cantidadDeColores = scan.nextInt();
        
        while(cantidadDeColores>6||cantidadDeColores<4)
        {
            System.out.println("El rango de colores debe estar entre 4 y 6. Ingrese otra cantidad: ");
            scan = new Scanner(System.in);
            cantidadDeColores = scan.nextInt(); 
        }
    }
    
    private void ingresarCantidadDeIntentos()
    {
        System.out.println("Ingrese la cantidad de intentos para adivinar (hasta 15): ");
        Scanner scan = new Scanner(System.in);
        cantidadDeIntentos = scan.nextInt();
       
        while(cantidadDeIntentos>15||cantidadDeIntentos<1)
        {
            System.out.println("El máximo de intentos es 15. Ingrese otra cantidad: ");
            scan = new Scanner(System.in);
            cantidadDeIntentos = scan.nextInt(); 
        }
    }
    
    public void mostrarIntento(ArrayList <Pin> combinaciónDePrueba)
    {
        System.out.printf("COMBINACIÓN INGRESADA: \n");
        for(int i=0; i<combinaciónDePrueba.size(); i++)
        {
            System.out.printf("%s ", combinaciónDePrueba.get(i).getNombre());
        }
        System.out.printf("\n");
    }
    
    public void mostrarCombinaciónSecreta(ArrayList <Pin> combinaciónSecreta)
    {
        System.out.printf("COMBINACIÓN SECRETA: \n");
        for(int i=0; i<combinaciónSecreta.size(); i++)
        {
            System.out.printf("%s ", combinaciónSecreta.get(i).getNombre());
        }
        System.out.printf("\n");
    }

    public int getCantidadDeColores() {
        return cantidadDeColores;
    }

    public int getCantidadDeIntentos() {
        return cantidadDeIntentos;
    }
    
    
}
