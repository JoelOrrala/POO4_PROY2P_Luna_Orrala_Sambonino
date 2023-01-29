/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.poo4_proy2p_modelo;

import java.util.Comparator;

/**
 *
 * @author joelorrala
 */
public class ComparadorDePrecios implements Comparator<Menu>{
    
    @Override
    public int compare(Menu m1, Menu m2) {
        int resultado = 0;
        if (m1.getPrecio() > m2.getPrecio()) {
            resultado = 1;
        } else if (m1.getPrecio() < m2.getPrecio()) {
            resultado = -1;
        }

        return resultado;
    }
    
}
