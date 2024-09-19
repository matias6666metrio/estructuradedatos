import java.util.ArrayList;
import java.util.List;

public class Acertijo {
    private String pregunta;
    private String respuestaCorrecta;
    private boolean resuelto;
    private boolean dependeDeAnterior;

    public Acertijo(String pregunta, String respuestaCorrecta, boolean dependeDeAnterior) {
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.dependeDeAnterior = dependeDeAnterior;
        this.resuelto = false;
    }

    public String getPregunta() {
        return pregunta;
    }

    public boolean comprobarRespuesta(String respuesta) {
        if (respuesta.equalsIgnoreCase(respuestaCorrecta)) {
            resuelto = true;
            return true;
        }
        return false;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public boolean isDependeDeAnterior() {
        return dependeDeAnterior;
    }
}
