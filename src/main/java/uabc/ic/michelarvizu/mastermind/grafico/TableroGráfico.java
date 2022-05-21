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
public class TableroGráfico {

    private Canvas tablero;
    private PinGráfico pinesSecretos[];
    private PinGráfico matrizPines[][];
    private PinGráfico retroalimentación[][];

    /**
     * Constructor de la clase TableroGráfico. Crea el tablero gráfico de
     * acuerdo a los argumentos recibidos.
     */
    public TableroGráfico(int tamaño, int intentos) {
        if (intentos < 10) {
            tablero = new Canvas("Tablero", 350, 550, Color.LIGHT_GRAY);
        } else if (intentos > 9 && intentos < 12) {
            tablero = new Canvas("Tablero", 350, 620, Color.LIGHT_GRAY);
        } else {
            tablero = new Canvas("Tablero", 350, 760, Color.LIGHT_GRAY);
        }
        crearTablero(tamaño, intentos);
    }

    /**
     * Crea en el tablero los círculos que representan los pines. También
     * muestra los colores que se pueden utilizar en el juego.
     */
    public void crearTablero(int tamaño, int intentos) {
        retroalimentación = new PinGráfico[intentos][tamaño];
        matrizPines = new PinGráfico[intentos][tamaño];
        int xPos = 20;
        int yPos = 80;
        int x = 0;
        for (int i = 0; i < intentos; i++) {
            for (int j = 0; j < tamaño; j++) {
                matrizPines[i][j] = new PinGráfico(35, Color.GRAY, xPos, yPos, tablero);
                xPos += 40;
            }
            for (int k = 0; k < tamaño; k++) {
                if (k >= tamaño / 2) {
                    xPos += 17;
                    retroalimentación[i][k] = new PinGráfico(15, Color.GRAY, xPos, yPos, tablero);
                } else {
                    if (x == xPos + 17 || x == xPos + 34) {
                        x = x + 17;
                    } else {
                        x = xPos + 17;
                    }
                    retroalimentación[i][k] = new PinGráfico(15, Color.GRAY, x, yPos + 17, tablero);
                }
            }
            x = 0;
            xPos = 20;
            yPos += 40;
        }
        mostrarColoresDisponibles(xPos, yPos + 40);
        pinesSecretos = new PinGráfico[tamaño];
        yPos = 20;
        for (int i = 0; i < tamaño; i++) {
            pinesSecretos[i] = new PinGráfico(35, Color.GRAY, xPos, yPos, tablero);
            xPos += 40;
        }
    }

    /**
     * Dibuja en el canvas los colores disponibles para el juego.
     */
    public void mostrarColoresDisponibles(int posX, int posY) {
        PinGráfico coloresDisponibles[] = new PinGráfico[6];
        coloresDisponibles[0] = new PinGráfico(35, Color.BLUE, posX, posY, tablero);
        coloresDisponibles[1] = new PinGráfico(35, Color.RED, posX + 40, posY, tablero);
        coloresDisponibles[2] = new PinGráfico(35, Color.YELLOW, posX + 80, posY, tablero);
        coloresDisponibles[3] = new PinGráfico(35, Color.GREEN, posX + 120, posY, tablero);
        coloresDisponibles[4] = new PinGráfico(35, Color.ORANGE, posX + 160, posY, tablero);
        coloresDisponibles[5] = new PinGráfico(35, Color.MAGENTA, posX + 200, posY, tablero);
    }

    /**
     * Crea los espacios en gris para los pines de retroalimentación.
     */
    public void pinesRetroalimentación(int intento, int tamaño, int posX, int posY) {
        retroalimentación = new PinGráfico[intento][tamaño];

        for (int i = 0; i < tamaño; i++) {
            retroalimentación[intento][i] = new PinGráfico(8, Color.GRAY, posX, posY, tablero);
            posX += 8;
        }
    }

    public void setColoresRetroalimentación(int intento, int posición, Color color) {
        retroalimentación[intento][posición].cambiarColorPin(tablero, color);
    }

    public void setColoresDeIntento(int intento, ArrayList<Color> combinación) {
        for (int i = 0; i < combinación.size(); i++) {
            matrizPines[intento][i].cambiarColorPin(tablero, combinación.get(i));
        }
    }

    public void setColoresDeCombinaciónSecreta(ArrayList<Color> combinación) {
        for (int i = 0; i < combinación.size(); i++) {
            pinesSecretos[i].cambiarColorPin(tablero, combinación.get(i));
        }
    }
}
