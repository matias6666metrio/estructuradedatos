import java.util.ArrayList;
import java.util.List;

public class JuegoAventura {
    public static void main(String[] args) {
        List<Acertijo> acertijos = new ArrayList<>();
        acertijos.add(new Acertijo("¿Cuánto es 2 + 2?", "4", false));
        acertijos.add(new Acertijo("Palabra mágica", "abracadabra", false));
        acertijos.add(new Acertijo("Dame un número entre 1 y 10", "7", false));
        acertijos.add(new Acertijo("Secuencia: 1, 2, 3, ¿qué sigue?", "4", false));
        acertijos.add(new Acertijo("¿Qué es algo que se rompe al nombrarlo?", "silencio", false));

        Juego juego = new Juego(acertijos);
        juego.iniciar();
    }
}
