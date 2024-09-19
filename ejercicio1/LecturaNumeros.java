package primerTrimestre.ejercicio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * LecturaNumeros
 * Catherine AM
 */
public class LecturaNumeros {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner lect = new Scanner(System.in);
        int suma = 0;
        double media = 0;

        System.out.println("Dame numeros enteros(para parar ingresa -99): ");
        int numEntr = 0;

        while (numEntr!= -99) {
            numEntr = lect.nextInt();
            if (numEntr == -99) {
               break; 
            }
            lista.add(numEntr);
        }

  

        for (int i = 0; i < lista.size(); i++) {
            suma = suma + lista.get(i);  
        }
        media = (double)suma / lista.size();


        Iterator<Integer> resultados = lista.iterator(); 
        int num;
        System.out.println("\n\nLectura de valores: ");
        while(resultados.hasNext()){
            num = resultados.next();
            System.out.print(" [" + num + "] ");
        }

        System.out.println("\n\nLa suma total de los valores es " + suma + " y la media es de " + media);
        System.out.print("Los valores que son mayores a la media son: ");
    
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > media) {
                System.out.print(" [" +lista.get(i)+ "] ");
            }
        }
        lect.close();

    }

}

/*public class LecturaNumeros {

    public static void main(String[] args) {
        // Crear la lista para almacenar los números
        ArrayList<Integer> lista = leerValores();
        
        // Calcular la suma de los valores
        int suma = calcularSuma(lista);
        
        // Mostrar los resultados
        mostrarResultados(lista, suma);
    }

    // Método para leer los valores ingresados por el usuario
    public static ArrayList<Integer> leerValores() {
        ArrayList<Integer> lista = new ArrayList<>();
        Scanner lect = new Scanner(System.in);
        int numEntr = 0;
        
        System.out.println("Dame números enteros (para parar ingresa -99): ");
        
        while (numEntr != -99) {
            numEntr = lect.nextInt();
            if (numEntr == -99) {
                break;
            }
            lista.add(numEntr);
        }
        
        return lista;
    }

    // Método para calcular la suma de los valores en la lista
    public static int calcularSuma(ArrayList<Integer> lista) {
        int suma = 0;
        for (int num : lista) {
            suma += num;
        }
        return suma;
    }

    // Método para mostrar la suma, la media y los valores mayores que la media
    public static void mostrarResultados(ArrayList<Integer> lista, int suma) {
        if (lista.isEmpty()) {
            System.out.println("No se han ingresado números.");
            return;
        }

        // Calcular la media
        double media = (double) suma / lista.size();

        // Mostrar los valores ingresados
        System.out.println("\nLectura de valores:");
        for (int num : lista) {
            System.out.print(" [" + num + "] ");
        }

        // Mostrar la suma y la media
        System.out.println("\n\nLa suma total de los valores es " + suma + " y la media es de " + media);

        // Mostrar los valores mayores que la media
        System.out.print("Los valores que son mayores a la media son: ");
        for (int num : lista) {
            if (num > media) {
                System.out.print(" [" + num + "] ");
            }
        }
        System.out.println();
    }
} */