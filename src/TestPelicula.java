import java.util.*;

public class TestPelicula {
    public static void buscarEnList(List<Pelicula> lista, String nombre) {
        for (Pelicula p : lista) {
            if (p.getNombre().equals(nombre)) {
                System.out.println("Se encontro la pelicula: " + p);
                return;
            }
        }
        System.out.println("No se encuentra en la lista." + nombre);
    }

    public static void buscarSet(Set<Pelicula> set, String nombre) {
        for (Pelicula p : set) {
            if (p.getNombre().equals(nombre)) {
                System.out.println("Se encontro en Set: " + p);
                return;
            }
        }
        System.out.println("No se encuentra en Set." + nombre);
    }

    public static void buscarMap(Map<String, List<Pelicula>> mapa, String nombre) {
        System.out.println("\n Buscando \"" + nombre + "\" en Map");
        for (Map.Entry<String, List<Pelicula>> entrada : mapa.entrySet()) {
            for (Pelicula p : entrada.getValue()) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("Se encontro en genero " + entrada.getKey() + ": " + p);
                    return;
                }
            }
        }
        System.out.println("No se encontro en Map.");
    }

    public static void main(String[] args) {
        List<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("La vida es bella", "Roberto Benigni", "Drama", 116, 1997, 8.6));
        lista.add(new Pelicula("Titanic", "James Cameron", "Drama", 194, 1997, 7.9));
        lista.add(new Pelicula("Toy Story", "Lasseter", "Animacion", 81, 1995, 8.3));
        lista.add(new Pelicula("Shrek", "Andrew Adamson", "Animacion", 90, 2001, 7.9));

        System.out.println("Lista de peliculas: (" + lista.size() + " peliculas):");
        for (Pelicula p : lista) {
            System.out.println(" " + p);
        }

        // Modificar
        System.out.println("-----Modificar una pelicula-----");
        lista.remove(new Pelicula("Shrek", " ", " ", 0, 0, 0.0));
        lista.add(new Pelicula("Shrek", "Andrew Adamson", "Animacion", 90, 2001, 7.9));
        System.out.println("Lista modificada: ");
        for (Pelicula p : lista) {
            System.out.println(" " + p);
        }

        // Que no se duplique la pelicula
        Set<Pelicula> hashSet = new HashSet<>(lista);
        System.out.println("Agregar 'Titanic' ");
        boolean agregado = hashSet.add(new Pelicula("Titanic", "James Cameron", "Drama", 194, 1997, 7.9));
        System.out.println("Agregado 'Titanic' " + agregado + "(false= duplicado)");
        System.out.println(" Contenido hashSet (" + hashSet.size() + " peliculas): ");
        for (Pelicula p : hashSet) {
            System.out.println(" " + p);
        }

        // Map
        Map<String, List<Pelicula>> mapaGenero = new HashMap<>();
        for (Pelicula p : lista) {
            if (!mapaGenero.containsKey(p.getGenero())) {
                mapaGenero.put(p.getGenero(), new ArrayList<>());
            }
            mapaGenero.get(p.getGenero()).add(p);
        }
        for (Map.Entry<String, List<Pelicula>> entrada : mapaGenero.entrySet()) {
            System.out.println("Genero: " + entrada.getKey());
            for (Pelicula p : entrada.getValue()) {
                System.out.println(" " + p);
            }
        }

        // Buscar
        buscarEnList(lista, "Titanic");
        buscarEnList(lista, "Matrix");
        buscarSet(hashSet, "Toy Story");
        buscarMap(mapaGenero, "El Padrino");
        buscarMap(mapaGenero, "La vida es bella");

        // Agregar con Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres agregar una pelicula? s/n: ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.println("Nombre :");    String nombre = sc.nextLine();
            System.out.println("Director:");  String director = sc.nextLine();
            System.out.println("Genero :");   String genero = sc.nextLine();
            System.out.println("Duracion:");  int duracion = Integer.parseInt(sc.nextLine());
            System.out.println("Año Estreno:"); int anio = Integer.parseInt(sc.nextLine());
            System.out.println("Rating:");    double rating = Double.parseDouble(sc.nextLine());

            Pelicula nueva = new Pelicula(nombre, director, genero, duracion, anio, rating);
            if (hashSet.contains(nueva)) {
                System.out.println("La pelicula ya existe");
            } else {
                lista.add(nueva);
                hashSet.add(nueva);
                if (!mapaGenero.containsKey(nueva.getGenero())) {
                    mapaGenero.put(nueva.getGenero(), new ArrayList<>());
                }
                mapaGenero.get(nueva.getGenero()).add(nueva);
                System.out.println("Pelicula agregada: " + nueva);
            }
        }

        // Ordenar por duracion
        lista.sort(Comparator.comparingInt(Pelicula::getDuracion));
        System.out.println("\nOrdenadas por duracion:");
        for (Pelicula p : lista) {
            System.out.println(" " + p);
        }

        // Ordenar por nombre con TreeSet
        Set<Pelicula> treeSet = new TreeSet<>((p1, p2) -> p1.getNombre().compareToIgnoreCase(p2.getNombre()));
        treeSet.addAll(lista);
        System.out.println("Ordenadas por nombre :");
        for (Pelicula p : treeSet) {
            System.out.println(" " + p);
        }
    }
}