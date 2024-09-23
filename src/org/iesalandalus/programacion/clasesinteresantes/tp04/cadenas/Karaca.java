package org.iesalandalus.programacion.clasesinteresantes.tp04.cadenas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Karaca {
    private static final String CONTROL = "aca";
    public static final String ER_TEXTO = "[a-z]+(?: [a-z]+)*|[^\\WA-Zaeiou5-9]+(?: [^\\WA-Zaeiou5-9]+)*aca";
    //NO HE PODIDO LLEGAR A CONCRETAR LA EXPRESION REGULAR
    // ADEMAS NO HE PODIDO LLENAR EL METODO REEMPLAZAR AUN ASI CREO
    // QUE AUNQUE NO ES LA FOORMA EN LA QUE SE DEBERIA HABER HECHO
    // YA QUE EL JERCICIO NO LO PEDIDA ASI, HE CONSEGUIDO QUE SI SE
    // PASA UN TEXTO CON EL FORMATO CORRECTO, LO CODIFICARA O DESCODIFICARA
    // SEGUN VEA CONVENIENTE EL ALGORITMO(CLARO, COMO NO HE PODIDO LLEGAR A CONCRETAR LA EXPRESION.R
    // PUES SIGUE SIENDO IGUAL QUE NO LO HUBIERA LOGRADO, YA QUE NO LO PUEDO DEMOSTRAR
    // AUNQUE USTED LO PUEDE OBSERVAR MIRANDO EL CODIGO)

    // NO ES EXCUSA PERO LLEVO UN FINDESEMANA SIN DORMIR YA QUE ESTOY ESTUDIANDO PARA LA RECUPERACION DE
    // BASE DE DATOS Y NO HE PODIDO DAR MI 100%

    private Karaca() {
    }

    public static String aplicar(String texto) {
        validarTexto(texto);
        if (texto.endsWith(CONTROL)) {
            texto = decodificar(texto);
        } else {
            texto = codificar(texto);
        }
        return texto;
    }

    private static void validarTexto(String texto) {
        Pattern patron = Pattern.compile(ER_TEXTO);
        Matcher comparador = patron.matcher(texto);
        if (!comparador.matches() || texto.isBlank()) {
            throw new IllegalArgumentException("ERROR: El formato escrito no es el correcto, intentelo de nuevo.");
        }
    }

    private static void reemplazar(StringBuilder cadena, String vieja, String nueva) {
        int indexOf = cadena.indexOf(vieja);
        while (indexOf != -1) {
            cadena.replace(indexOf, indexOf + vieja.length(), nueva);
            indexOf = cadena.indexOf(vieja);
        }
    }

    private static String codificar(String texto) {
        StringBuilder nuevoTexto = new StringBuilder();
        nuevoTexto.append(texto);
        reemplazar(nuevoTexto, "a", "0");
        reemplazar(nuevoTexto, "e", "1");
        reemplazar(nuevoTexto, "i", "2");
        reemplazar(nuevoTexto, "o", "3");
        reemplazar(nuevoTexto, "u", "4");
        nuevoTexto.reverse();
        nuevoTexto.append(CONTROL);
        return nuevoTexto.toString();
    }

    private static String decodificar(String texto) {
        StringBuilder nuevoTexto = new StringBuilder();
        nuevoTexto.append(texto);
        reemplazar(nuevoTexto, CONTROL, "");
        reemplazar(nuevoTexto, "0", "a");
        reemplazar(nuevoTexto, "1", "e");
        reemplazar(nuevoTexto, "2", "i");
        reemplazar(nuevoTexto, "3", "o");
        reemplazar(nuevoTexto, "4", "4");
        nuevoTexto.reverse();
        return nuevoTexto.toString();
    }

    // private static String codificar(String texto) {
    //   StringBuilder nuevoTexto = new StringBuilder();
    //   for (int i = texto.length() - 1; i >= 0; i--) {
    //       if (texto.charAt(i) == 'a') {
    //           nuevoTexto.append("0");
    //       } else if (texto.charAt(i) == 'e') {
    //           nuevoTexto.append("1");
    //       } else if (texto.charAt(i) == 'i') {
    //           nuevoTexto.append("2");
    //       } else if (texto.charAt(i) == 'o') {
    //           nuevoTexto.append("3");
    //       } else if (texto.charAt(i) == 'u') {
    //           nuevoTexto.append("4");
    //       } else {
    //           nuevoTexto.append(texto.charAt(i));
    //       }
    //   }
    //   nuevoTexto.append(CONTROL);
    //   return nuevoTexto.toString();
    // }

    //private static String decodificar(String texto) {
    //  StringBuilder nuevoTexto = new StringBuilder();
    //for (int i = texto.length() - 4; i >= 0; i--) {
    //  if (texto.charAt(i) == '0') {
    //    nuevoTexto.append("a");
    //} else if (texto.charAt(i) == '1') {
    //   nuevoTexto.append("e");
    //} else if (texto.charAt(i) == '2') {
    //   nuevoTexto.append("i");
    //} else if (texto.charAt(i) == '3') {
    //  nuevoTexto.append("o");
    //} else if (texto.charAt(i) == '4') {
    //   nuevoTexto.append("u");
    //} else {
    //  nuevoTexto.append(texto.charAt(i));
    //}
    // }
    //return nuevoTexto.toString();
    //}
}
