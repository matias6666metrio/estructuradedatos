import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ObservatorioConListas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        String entrada;

        System.out.println("Ingrese temperaturas en grados Celsius. Escriba 'fin' para terminar.");

        while (true) {
            System.out.print("Ingrese una temperatura (o 'fin' para terminar): ");
            entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            try {
                double temperatura = Double.parseDouble(entrada);
                temperaturas.add(temperatura);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número o 'fin'.");
            }
        }

        if (temperaturas.isEmpty()) {
            System.out.println("No se ingresaron temperaturas.");
            return;
        }

        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;
        double suma = 0;

        for (double temp : temperaturas) {
            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
            suma += temp;
        }

        double promedio = suma / temperaturas.size();

        System.out.println("Temperatura máxima: " + maxTemp);
        System.out.println("Temperatura mínima: " + minTemp);
        System.out.println("Temperatura promedio: " + promedio);

        System.out.print("Temperaturas por encima del promedio: ");
        for (double temp : temperaturas) {
            if (temp > promedio) {
                System.out.print(temp + " ");
            }
        }
    }
}


