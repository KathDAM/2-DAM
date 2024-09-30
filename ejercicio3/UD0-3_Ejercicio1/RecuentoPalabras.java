import java.io.*;

/**
 * RecuentoPalabras
 * Catherine AM
 */

public class RecuentoPalabras {
    public static void main(String[] args) throws IOException {
        String rutaEntrada = "/home/catalvman/Documents/entrada.txt";
        String rutaSalida = "/home/catalvman/Documents/salida.txt";
        
        contarPalabrasLinea(rutaEntrada, rutaSalida);
    }

    public static void contarPalabrasLinea(String archivoEntrada, String archivoSalida) {
        BufferedReader fichero = null;
        BufferedWriter salida = null;

        try {
            fichero = new BufferedReader(new FileReader(archivoEntrada));
            salida = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;
            int numeroLinea = 1;

            while ((linea = fichero.readLine()) != null) {
                String[] palabras = linea.split("[,?.; ]+");

                int contadorPalabras = palabras.length;

                salida.write("Línea " + numeroLinea + ": " + contadorPalabras + " palabras.");
                salida.newLine();
                
                numeroLinea++;
            }

        } catch (IOException e) {
            System.out.println("Error de escritura del fichero: " + e.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
                if (salida != null) {
                    salida.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
            }
        }
    }
}
