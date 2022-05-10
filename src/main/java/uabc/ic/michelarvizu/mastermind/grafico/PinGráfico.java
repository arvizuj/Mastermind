/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uabc.ic.michelarvizu.mastermind.grafico;

import java.awt.Color;

/**
 *
 * @author arviz
 */
public class PinGráfico {
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Color color;
    
    /**
     * Constructor de la clase PinGráfico. Recibe argumentos de tamaño, color, posición y canvas.
     */
    public PinGráfico(int tamaño, Color color, int xPos, int yPos, Canvas canvas)
    {
        diameter = tamaño;
        xPosition = xPos;
        yPosition = yPos;
        this.color = color;
        draw(canvas);
    }
    
    /**
     * Dibuja el pin en el canvas dado como argumento.
     */
    private void draw(Canvas tablero)
    {
        tablero.setNewColor(color);
        tablero.fillCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * Cambia el color del pin por el color y en el canvas dados como argumentos.
     */
    public void cambiarColorPin(Canvas tablero, Color color)
    {
        tablero.setNewColor(color);
        tablero.fillCircle(xPosition, yPosition, diameter);
    }
    
}
