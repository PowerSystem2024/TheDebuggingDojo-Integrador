/*
    Universidad Técnologica Nacional, Facultad Regional de San Rafael (UTN-FRSR)
    Proyecto Final Integrador del grupo The Debugging Dojo
    Integrantes:
        - Bruni Gabriel
        - Cattai Leandro
        - Cizmadija Florencia
        - Cizmadija Paula
        - Correa Pablo
        - Francia Nahuel
        - Juarez Gonzalo
        - Schutt Lázaro
        - Schutt Valentin
*/
package proyecto_integrador;
import java.util.Scanner;
import java.util.Random;


public class Proyecto_Integrador {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    // SubProceso Pedir Mozos
    public static void pedirMozo(String[] mozos) {
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite el nombre del mozo " + (i + 1) + ": ");
            mozos[i] = scanner.nextLine();
        }
        System.out.println();
    }



    
}
