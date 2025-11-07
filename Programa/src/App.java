import java.util.Scanner;

public class App {

    static String nombre = "N/A", estado = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;
    static double promedio = 0;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            MostrarMenu();
            opcion = LeerEntero(sc, "Seleccione una opción: ");

            sc.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    registrarEstudiante(sc);
                    break;

                case 2:
                    MostrarEstudiante();
                    break;

                case 3:
                    calcularPromedio();
                    break;

                case 4:
                    MostrarEstudiante();
                    System.out.printf("Promedio: %.2f\n", promedio);
                    setEstado();
                    break;

                case 5:
                    nombre = "N/A";
                    nota1 = -1;
                    nota2 = -1;
                    nota3 = -1;
                    promedio = 0;
                    estado = "N/A";
                    System.out.println("Datos reiniciados.");
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;

            }
        } while (opcion != 0);
        sc.close();

    }

    static void MostrarMenu() {

        System.out.println("\n----- Menú -----");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar nombre y notas");
        System.out.println("3. Calcular promedio");
        System.out.println("4. Mostrar estado (Aprobado/Reprobado)");
        System.out.println("5. Reiniciar datos");
        System.out.println("0. Salir");

    }

    public static int LeerEntero(Scanner sc, String mensaje) {

        int numero;
        System.out.print(mensaje);
        numero = sc.nextInt();
        return numero;

    }

    static void registrarEstudiante(Scanner sc) {

        System.out.print("Ingrese el nombre del estudiante: ");
        nombre = validarNombre(sc);

        nota1 = LeerNota(sc, "Ingrese la nota 1: ");
        nota2 = LeerNota(sc, "Ingrese la nota 2: ");
        nota3 = LeerNota(sc, "Ingrese la nota 3: ");

        System.out.println("Datos registrados correctamente.");

    }

    static double LeerNota(Scanner sc, String mensaje) {

        double nota;
        while (true) {
            System.out.println(mensaje);
            String linea = sc.nextLine().replace(",", ".");
            nota = Double.parseDouble(linea);
            if (validarNota(nota)) {
                break;
            } else {
                System.out.println("Nota inválida. Debe estar entre 0 y 100.");
            }
        }
        return nota;
    }

    static void MostrarEstudiante() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados.");
        } else {
            System.out.println("\n----- Datos del Estudiante -----");
            System.out.println("Nombre: " + nombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }

    }

    static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 100;
    }

    static void calcularPromedio() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados.");
        } else {
            promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("Promedio: %.2f\n", promedio);
        }
    }

    static void setEstado() {
        estado = (promedio >= 60) ? "Aprobado" : "Reprobado";
        System.out.println("Estado: " + estado);
    }

    static String validarNombre(Scanner sc) {
        String nombreInput;
        while (true) {
            nombreInput = sc.nextLine().trim();
            if (!nombreInput.isEmpty()) {
                break;
            } else {
                System.out.print("El nombre no puede estar vacío. Ingrese nuevamente: ");
            }
        }
        return nombreInput;
    }
}
