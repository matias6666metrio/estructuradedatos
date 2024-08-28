public class Coche {
    // Atributos
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private double nivelCombustible;
    private boolean motorEncendido;
    private final double capacidadMaximaCombustible = 12.0;

    // Constructor
    public Coche(String marca, String modelo, int año, String color, double nivelCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.nivelCombustible = nivelCombustible;
        this.motorEncendido = false;
    }

    // Método para encender el motor
    public void encender() {
        if (!motorEncendido) {
            motorEncendido = true;
            System.out.println("El motor está encendido.");
        } else {
            System.out.println("El motor ya está encendido.");
        }
    }

    // Método para apagar el motor
    public void apagar() {
        if (motorEncendido) {
            motorEncendido = false;
            System.out.println("El motor está apagado.");
        } else {
            System.out.println("El motor ya está apagado.");
        }
    }

    // Método para acelerar
    public void acelerar() {
        if (motorEncendido) {
            if (nivelCombustible > 0) {
                nivelCombustible -= 0.1;
                if (nivelCombustible < 0) {
                    nivelCombustible = 0;
                }
                System.out.println("Acelerando... Nivel de combustible: " + String.format("%.2f", nivelCombustible) + " galones.");
            } else {
                System.out.println("No hay suficiente combustible para acelerar.");
            }
        } else {
            System.out.println("El motor está apagado. No se puede acelerar.");
        }
    }

    // Método para recargar combustible
    public void recargar(double cantidad) {
        if (cantidad < 0) {
            System.out.println("No se puede recargar una cantidad negativa de combustible.");
            return;
        }
        nivelCombustible += cantidad;
        if (nivelCombustible > capacidadMaximaCombustible) {
            nivelCombustible = capacidadMaximaCombustible;
        }
        System.out.println("Se han recargado " + cantidad + " galones. Nivel actual de combustible: " + String.format("%.2f", nivelCombustible) + " galones.");
    }

    // Método para obtener el nivel de combustible
    public double obtenerNivelCombustible() {
        return nivelCombustible;
    }

    // Método principal para probar la clase Coche
    public static void main(String[] args) {
        Coche miCoche = new Coche("Toyota", "Corolla", 2020, "Rojo", 10);

        // Encender el motor
        miCoche.encender();

        // Intentar acelerar
        miCoche.acelerar();

        // Recargar combustible
        miCoche.recargar(5);

        // Intentar acelerar nuevamente
        miCoche.acelerar();

        // Obtener el nivel de combustible
        System.out.println("Nivel de combustible actual: " + String.format("%.2f", miCoche.obtenerNivelCombustible()) + " galones.");

        // Apagar el motor
        miCoche.apagar();
    }
}