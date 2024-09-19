import java.io.File;
import java.util.Scanner;

public class ExploradorArchivos {
    private static File directorioActual;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Se solicita la ruta inicial del explorador
        System.out.print("Introduce la ruta inicial del explorador de ficheros: ");
        String rutaInicial = scanner.nextLine();
        directorioActual = new File(rutaInicial);

        // Verificar que la ruta inicial es válida
        if (!directorioActual.exists() || !directorioActual.isDirectory()) {
            System.out.println("Ruta no válida. Finalizando el programa.");
            scanner.close();
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            System.out.print("\n¿Qué opción quieres realizar? ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarFicheros();
                    break;
                case 2:
                    modificarDirectorio(scanner);
                    break;
                case 3:
                    volverAtras();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Método para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n----------------------------------------------------");
        System.out.println("                       MENU                         ");
        System.out.println("----------------------------------------------------");
        System.out.println("1. Mostrar ficheros del directorio actual");
        System.out.println("2. Modificar el directorio actual");
        System.out.println("3. Volver atrás");
        System.out.println("4. Salir del programa");
        System.out.println("----------------------------------------------------");
    }

    // Método para mostrar los ficheros del directorio actual
    private static void mostrarFicheros() {
        File[] ficheros = directorioActual.listFiles();

        if (ficheros == null || ficheros.length == 0) {
            System.out.println("No hay ficheros en el directorio actual.");
            return;
        }

        System.out.println("----------------------------------------------------");
        System.out.println("                      FICHEROS                      ");
        System.out.println("----------------------------------------------------");
        for (File fichero : ficheros) {
            if (fichero.isDirectory()) {
                System.out.println("[Directorio] " + fichero.getName());
            } else {
                System.out.println("[Archivo] " + fichero.getName());
            }
        }
    }

    // Método para modificar el directorio actual
    private static void modificarDirectorio(Scanner scanner) {
        System.out.print("Introduce el nombre del directorio a añadir: ");
        String nuevoDirectorio = scanner.nextLine();

        File nuevoDir = new File(directorioActual, nuevoDirectorio);

        if (nuevoDir.exists() && nuevoDir.isDirectory()) {
            directorioActual = nuevoDir;
            System.out.println("La nueva ruta es: " + directorioActual.getAbsolutePath());
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
        }
    }

    // Método para volver al directorio anterior
    private static void volverAtras() {
        File directorioPadre = directorioActual.getParentFile();

        if (directorioPadre != null && directorioPadre.isDirectory()) {
            directorioActual = directorioPadre;
            System.out.println("La nueva ruta es: " + directorioActual.getAbsolutePath());
        } else {
            System.out.println("No se puede volver atrás.");
        }
    }
}
