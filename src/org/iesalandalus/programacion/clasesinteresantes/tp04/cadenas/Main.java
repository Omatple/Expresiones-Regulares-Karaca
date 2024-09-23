package org.iesalandalus.programacion.clasesinteresantes.tp04.cadenas;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Main {
    public static void main(String[] args) {
        String texto = "";
        boolean validar = false;
        while (!validar) {
            try {
                System.out.print("Introduce el texto a aplicarle el algoritmo de Karaca: ");
                texto = Entrada.cadena();
                texto = Karaca.aplicar(texto);
                validar = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Aplicar el algoritmo de Karaca al texto: " + texto);
    }
}
