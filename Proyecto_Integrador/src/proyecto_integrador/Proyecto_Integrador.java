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

    // SubProceso Mostrar Matriz
    public static void mostrarMatrizMozo(int[][] matriz, String[] mozos) {
        System.out.println("\n\nGráfico de mozos por mesa atendida.");
        System.out.println("\nGastos por Mesa\n");

        for (int i = 0; i < 4; i++) {
            System.out.print("Mozo " + mozos[i]);

            int letrasM = 15 - mozos[i].length();
            for (int k = 0; k < letrasM; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] >= 10000 ? "$" + matriz[i][j] + "   " : "$0" + matriz[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    // SubProceso Llenar Delivery y calcular total
    public static int deliveryTotal2(int[] delivery) {
        int ventaDelivery = 0; // Inicializar aquí
        for (int i = 0; i < 7; i++) {
            delivery[i] = random.nextInt(20001) + 5000;
            ventaDelivery += delivery[i];
        }
        return ventaDelivery; // Devolver el total
    }

    // SubProceso Mostrar Delivery
    public static void deliveryTotal(int[] delivery, int ventaDelivery) {
        System.out.println("\nGráfico de delivery por día de semana.");
        System.out.println("\n             Lun      Mart     Mierc    Juev     Vier     Sab      Dom");
        System.out.print("Delivery:   ");

        for (int i = 0; i < 7; i++) {
            System.out.print(delivery[i] >= 10000 ? "$" + delivery[i] + "   " : "$0" + delivery[i] + "   ");
        }

        System.out.println("\n\nLas ganancias totales en una semana de delivery son de $" + ventaDelivery + "\n");
    }

    // SubProceso Sueldos
    public static void sueldoTotal(double[] precioHora, int[] horaSemanal, String[] mozos) {
        for (int i = 0; i < 4; i++) {
            System.out.print("Ingrese el pago por hora del mozo " + mozos[i] + ": ");
            precioHora[i] = scanner.nextDouble();
            System.out.print("Ingrese las horas trabajadas en la semana del mozo " + mozos[i] + ": ");
            horaSemanal[i] = scanner.nextInt();
            System.out.println();
        }

        System.out.println("\n\nSueldo de cada mozo:\n");

        for (int i = 0; i < 4; i++) {
            System.out.print(" Sueldo del mozo " + mozos[i]);

            int letrasM = 15 - mozos[i].length();
            for (int k = 0; k < letrasM; k++) {
                System.out.print(" ");
            }

            System.out.println("$" + (precioHora[i] * horaSemanal[i]));
        }
        System.out.println();
    }

       // SubProceso Promedio
       public static void promedio(double gananciaSemana) {
        double promedioSemana = gananciaSemana / 7;
        System.out.println("El promedio general de ganancias por día es $" + promedioSemana);
    }

    // Cuerpo principal
    public static void main(String[] args) {
        int[][] matriz = new int[4][5];
        int[] propina = new int[4];
        String[] mozos = new String[4];
        int[] delivery = new int[7];
        double[] precioHora = new double[4];
        int[] horaSemanal = new int[4];

        double sumaTotalMesas = 0, propinaTotal = 0, gananciaSemana = 0, promedioSemana = 0;
        int ventaDelivery = 0, resp;

        // Llenar matriz con ganancias y propinas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = random.nextInt(90001) + 5000;
            }
            propina[i] = random.nextInt(61) * 100 + 4000;
        }

        // Total Mesas
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                sumaTotalMesas += matriz[i][j];
            }
            propinaTotal += propina[i];
        }

        // Llamar SubProceso Delivery y capturar el valor devuelto
        int ventaDelivery = deliveryTotal2(delivery);

        // Ganancias por semana
        double gananciaSemana = (sumaTotalMesas * 7) + (propinaTotal * 7) + ventaDelivery;
    
        // Llamar SubProceso Pedir Mozos
        pedirMozo(mozos);

    // Menú principal
        do {
            System.out.println("\n-------MENU DE CONTROL---------");
            System.out.println("1. Ganancias de mesas por día.");
            System.out.println("2. Propinas por día.");
            System.out.println("3. Delivery por día de la semana.");
            System.out.println("4. Ganancia de la semana.");
            System.out.println("5. Calcular el sueldo de los mozos.");
            System.out.println("6. Promedio de venta.");
            System.out.println("7. Propina por empleado.");
            System.out.println("0. Para salir.");
            System.out.print("Digite una opción de menú: ");
            resp = scanner.nextInt();
            System.out.println("");


    }

             switch (resp) {
                case 1:
                    mostrarMatrizMozo(matriz, mozos);
                    System.out.println("Los ingresos totales por día en las mesas es: $" + sumaTotalMesas);
                    break;
                case 2:
                    System.out.println("\nLa propina total del día es de: $" + propinaTotal);
                    break;
                case 3:
                    deliveryTotal(delivery, ventaDelivery);
                    break;
                case 4:
                    System.out.println("\nTeniendo en cuenta la ganancia por mesa, propina y delivery, el total en una semana corresponde a $" + gananciaSemana);
                    break;
                case 5:
                    System.out.println("");
                    sueldoTotal(precioHora, horaSemanal, mozos);
                    break;
                case 6:
                    promedio(gananciaSemana);
                    break;
                case 7:
                    double propinaEmpleado = propinaTotal / 4;
                    System.out.println("\nLa propina que le toca a cada empleado es: $" + propinaEmpleado);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("\nEntrada no válida. Ingrese una opción de menú válida.");
                    System.out.println("");
                    break;
            }
        } while (resp != 0);
    }
}

}
