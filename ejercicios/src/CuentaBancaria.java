public class CuentaBancaria {
    // Atributos
    private String numeroCuenta;
    private double saldo;
    private String nombrePropietario;

    // Constructor
    public CuentaBancaria(String numeroCuenta, double saldoInicial, String nombrePropietario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0;
        this.nombrePropietario = nombrePropietario;
        if (saldoInicial < 0) {
            System.out.println("El saldo inicial no puede ser negativo. Se ha establecido en 0.");
        }
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Cantidad depositada: " + cantidad + ". Saldo actual: " + saldo);
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
                System.out.println("Retiro exitoso. Cantidad retirada: " + cantidad + ". Saldo actual: " + saldo);
            } else {
                System.out.println("Saldo insuficiente. No se puede realizar el retiro.");
            }
        } else {
            System.out.println("La cantidad a retirar debe ser mayor que 0.");
        }
    }

    // Método para obtener el saldo
    public double obtenerSaldo() {
        return saldo;
    }

    // Método para obtener el número de cuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    // Método para obtener el nombre del propietario
    public String getNombrePropietario() {
        return nombrePropietario;
    }

    // Método principal para probar la clase CuentaBancaria
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("1234567890", 1000.0, "Juan Pérez");

        System.out.println("Saldo inicial: " + cuenta.obtenerSaldo());
        cuenta.depositar(500.0);
        cuenta.retirar(200.0);
        cuenta.retirar(1500.0); // Intento de retiro mayor al saldo
        System.out.println("Saldo final: " + cuenta.obtenerSaldo());
    }
}
