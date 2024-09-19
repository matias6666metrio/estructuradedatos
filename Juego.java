import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    private List<Acertijo> acertijos;
    private int indiceActual;
    private Pila<Integer> pilaDeshacer;
    private Pila<Integer> pilaRehacer;
    private Cola<String> colaEventos;

    public Juego(List<Acertijo> acertijos) {
        this.acertijos = acertijos;
        this.indiceActual = 0;
        this.pilaDeshacer = new Pila<>(10);
        this.pilaRehacer = new Pila<>(10);
        this.colaEventos = new Cola<>();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (indiceActual < acertijos.size()) {
            Acertijo acertijo = acertijos.get(indiceActual);
            if (!acertijo.isResuelto()) {
                System.out.println(acertijo.getPregunta());
                String respuesta = scanner.nextLine();
                if (acertijo.comprobarRespuesta(respuesta)) {
                    System.out.println("Correcto!");
                    pilaDeshacer.push(indiceActual);
                    colaEventos.enqueue("Acertijo resuelto: " + acertijo.getPregunta());
                    indiceActual++;
                } else {
                    System.out.println("Incorrecto, intenta de nuevo.");
                }
            }
        }
        System.out.println("¡Felicidades, has resuelto todos los acertijos!");
        scanner.close();
    }
}
