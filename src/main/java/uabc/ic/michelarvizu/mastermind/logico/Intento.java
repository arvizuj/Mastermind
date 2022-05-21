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
public class Intento {
    private ArrayList <Pin> combinación;
    private String identificador = "";
    
    /**
     * Constructor de la clase Intento. Guarda una ArrayList de Pin.
     */
    public Intento (ArrayList <Pin> combinación)
    {
        this.combinación = combinación;
        for(int i=0; i<combinación.size(); i++)
        {
            identificador += combinación.get(i).getNombre();
        }
    }
    
    public ArrayList <Pin> getCombinación()
    {
        return combinación;
    }
    
    public String getIdentificador()
    {
        return identificador;
    }

    
    /**
     * Determina si el intento es igual al intento ingresado como argumento.
     * Retorna true si el intento se está repitiendo y false si el intento no es igual.
     */
//    public boolean esIgual(ArrayList <Pin> otraCombinación)
//    public boolean esIgual(Intento otroIntento)
//    {
//        int iguales = 0;
//        for(int i=0; i<otroIntento.getCombinación().size(); i++)
//        {
//            System.out.println("Compara " + combinación.get(i).getNombre()+
//                    " con " + otraCombinación.get(i).getNombre());
//            if(combinación.get(i).esIgual(otraCombinación.get(i)))
//            {
//                iguales++;
//            }
//            if(identificador.equals(otroIntento.getIdentificador()))
//            {
//                return false;
//            }
//        }
//        return true;
//        return iguales == combinación.size();
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder buffer = new StringBuilder();
//        for(Pin pin: combinación)
//            buffer.append(pin.getNombre());
//        return "Intento:" + buffer;
//    }
}
