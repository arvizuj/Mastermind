/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package uabc.ic.michelarvizu.mastermind;

//crear método para la puntuación
/**
 *
 * @author arviz
 */
public class Mastermind {
    private static MastermindGame control;
    
    /**
     * Constructor de la clase principal Mastermind.
     * Su único atributo es la clase MastermindGame que lleva el control total del juego.
     */
    public static void main(String[] args) 
    {
        control = new MastermindGame();
    }
}
