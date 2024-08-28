import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Lista de libros
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        libros = new ArrayList<>();
    }

    // Método para agregar un libro a la colección
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado: " + libro);
    }

    // Método para prestar un libro
    public void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (libro.isDisponible()) {
                    libro.setDisponible(false);
                    System.out.println("Libro prestado: " + libro);
                } else {
                    System.out.println("El libro '" + titulo + "' no está disponible.");
                }
                return;
            }
        }
        System.out.println("El libro '" + titulo + "' no se encuentra en la biblioteca.");
    }

    // Método para devolver un libro
    public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!libro.isDisponible()) {
                    libro.setDisponible(true);
                    System.out.println("Libro devuelto: " + libro);
                } else {
                    System.out.println("El libro '" + titulo + "' ya estaba disponible.");
                }
                return;
            }
        }
        System.out.println("El libro '" + titulo + "' no se encuentra en la biblioteca.");
    }

    // Método para buscar libros
    public void buscarLibros(String consulta) {
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(consulta.toLowerCase()) ||
                    libro.getAutor().toLowerCase().contains(consulta.toLowerCase())) {
                System.out.println(libro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros que coincidan con la búsqueda.");
        }
    }

    // Método principal para probar la clase Biblioteca
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Crear algunos libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", true);
        Libro libro2 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", true);
        Libro libro3 = new Libro("1984", "George Orwell", true);

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);

        // Buscar libros
        biblioteca.buscarLibros("Cien años");
        biblioteca.buscarLibros("George Orwell");

        // Prestar y devolver libros
        biblioteca.prestarLibro("Cien años de soledad");
        biblioteca.devolverLibro("Cien años de soledad");

        // Intentar buscar un libro no disponible
        biblioteca.buscarLibros("1984");
    }
}
