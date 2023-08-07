package cplaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CPLaboratorioFinal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Scanner leer2 = new Scanner(System.in);
        String nombreArchivo = "D:\\PROYECTOS\\CatalogoCine\\peliculas.txt";
        int opc = -1;
        CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        do {
            System.out.println("Elige opcion:\n1. Iniciar catalogo peliculas"
                    + "\n2. Agregar Pelicula \n3. Listar Peliculas"
                    + "\n4. Buscar Pelicula \n0. Salir");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    catalogoPeliculas.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingresar nombre de la pelicula:");
                    String nombrePelicula = leer2.nextLine();
                    catalogoPeliculas.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogoPeliculas.listarPeliculas();
                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("Buscar pelicula:");
                    String buscar = leer.nextLine();
                    catalogoPeliculas.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta luego...");
                    break;
                default:
                    System.out.println("Ingresar una opcion valida\n");
            }
        } while (opc != 0);
    }
}
