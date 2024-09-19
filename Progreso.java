import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Progreso {
    private List<Acertijo> acertijos;

    public Progreso(List<Acertijo> acertijos) {
        this.acertijos = acertijos;
    }

    public void guardar(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Acertijo acertijo : acertijos) {
                writer.write(acertijo.getPregunta() + "," + acertijo.isResuelto());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargar(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                String pregunta = partes[0];
                boolean resuelto = Boolean.parseBoolean(partes[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
