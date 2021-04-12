package practica2021a;

import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
         Malla malla = new Malla(24, 10, 10, 97);
         Estado es = new EstadoMalla(malla, malla.getposIni()[0], malla.getposIni()[1]);
         Estado eo = new EstadoMalla(malla, malla.getposFin()[0], malla.getposFin()[1]);

         System.out.println("POSICION INICIAL" + Arrays.toString(malla.getposIni()));
         System.out.println("POSICION FINAL" + Arrays.toString(malla.getposFin()));
         
         AgenteA prueba = new AgenteA();
         List<Estado> solucion = prueba.resuelve(es, eo);
         System.out.println("\n Camino Solucion \n");

         for (int i=solucion.size()-1; i>=0; i--) {
            solucion.get(i).ver();
        }
    }
}