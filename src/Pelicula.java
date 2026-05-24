import java.util.ArrayList;
import java.util.Objects;

public class Pelicula {
    private String nombre;
    private String director;
    private String genero;
    private int duracion;
    private int anioEstreno;
    private double rating;

    public Pelicula(String nombre, String director, String genero, int duracion, int anioEstreno, double rating){
        this.nombre = nombre;
        this.director = director;
        this.genero =genero;
        this.duracion= duracion;
        this.anioEstreno=anioEstreno;
        this.rating=rating;
    }
    public String getNombre(){return nombre;}
    public String getDirector(){return director;}
    public String getGenero(){return genero;}
    public int getDuracion(){return duracion; }
    public int getAnioEstrenoEstreno() {return anioEstreno;}
    public double getRating(){return rating;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return nombre.equalsIgnoreCase(pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    public int compareTo(Pelicula otra) {
        return this.nombre.compareToIgnoreCase(otra.nombre);
    }

    @Override
    public String toString() {
        return "Pelicula nombre='" + nombre +
                "', director='" + director +
                "', genero='" + genero +
                "', duracion=" + duracion +
                ", anioEstreno=" + anioEstreno +
                ", rating=" + rating ;
        }
    }

