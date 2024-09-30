import java.io.*;
import java.util.ArrayList;
/**
 * RecuentoPalabaras
 * Catherine AM
 */

public class CalificacionesEstudiantes {

    public static void main(String[] args) {
        String archivoEntrada = "/home/catalvman/Documents/estudiantes.csv";
        String archivoSalida = "/home/catalvman/Documents/medias.csv";

        calcularMediaEstudiantes(archivoEntrada, archivoSalida);
    }

    public static void calcularMediaEstudiantes(String archivoEntrada, String archivoSalida) {
        BufferedReader lector = null;
        BufferedWriter escritor = null;

        try {
            lector = new BufferedReader(new FileReader(archivoEntrada));
            escritor = new BufferedWriter(new FileWriter(archivoSalida));

            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(";");

                String nombreEstudiante = datos[0];

                ArrayList<Double> notas = new ArrayList<>();

                for (int i = 1; i < datos.length; i++) {
                    double nota = Double.parseDouble(datos[i]);
                    notas.add(nota);
                }

                double suma = 0;
                for (double nota : notas) {
                    suma += nota;
                }
                double media = suma / notas.size();

                escritor.write(nombreEstudiante + ";" + String.format("%.2f", media));
                escritor.newLine();
            }

            System.out.println("Proceso realizado.\nMedias calculadas en el archivo: " + archivoSalida);

        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        } finally {
            try {
                if (lector != null) {
                    lector.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar los archivos: " + e.getMessage());
            }
        }
    }
}
    
