import java.util.InputMismatchException;
import java.util.Scanner;

public class ObservatorioConArreglos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número máximo de temperaturas a registrar: ");
        int limiteTemperaturas;
        try {
            limiteTemperaturas = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada no válida. Estableciendo límite en 10.");
            limiteTemperaturas = 10;
            scanner.next(); // Clear the invalid input
        }

        double[] temperaturas = new double[limiteTemperaturas];
        int count = 0;
        scanner.nextLine(); // Consume newline

        System.out.println("Ingrese temperaturas en grados Celsius. Escriba 'fin' para terminar.");

        while (count < limiteTemperaturas) {
            System.out.print("Ingrese una temperatura (o 'fin' para terminar): ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                double temperatura = Double.parseDouble(entrada);
                temperaturas[count] = temperatura;
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número o 'fin'.");
            }
        }

        if (count == 0) {
            System.out.println("No se ingresaron temperaturas.");
            return;
        }

        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        double suma = 0;

        for (int i = 0; i < count; i++) {
            double temp = temperaturas[i];
            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
            suma += temp;
        }

        double promedio = suma / count;

        System.out.println("Temperatura máxima: " + maxTemp);
        System.out.println("Temperatura mínima: " + minTemp);
        System.out.println("Temperatura promedio: " + promedio);

        System.out.print("Temperaturas por encima del promedio: ");
        for (int i = 0; i < count; i++) {
            if (temperaturas[i] > promedio) {
                System.out.print(temperaturas[i] + " ");
            }
        }
    }
}
