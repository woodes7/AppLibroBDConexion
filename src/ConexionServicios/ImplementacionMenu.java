package ConexionServicios;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import ConexionDtos.LibroDto;

public class ImplementacionMenu implements InterfazConexionMenu {
	//Instanciamos
	
	InterfazConexion ImplConecxion = new ImplementacionConexion();
	interfazConexionConsultas ImplConsulta = new ImplementacionConsultas();	
	ArrayList<LibroDto> listaLibros = new ArrayList<>();
	@Override
	public void MostrarMenu() {
		System.out.println("---------Menu--------------");
		System.out.println("1. ¿Quieres ver la lista de todos los libros?");
		System.out.println("2. ¿Quieres ver un libro?");		
		System.out.println("3. ¿Quieres modificar algun dato de un libro?");
		System.out.println("4. ¿Quieres agrerar u libro nuevo?");
		System.out.println("5. ¿Quieres borrar un libro?");
		System.out.println("0. Cerrar");
	}

	@Override
	public void opcionesMenu() {
		Scanner entradaValor = new Scanner(System.in);
		int opcion;
		boolean opcionValida = false;
		
		do {
			try {
				// Mostramos el menú
				MostrarMenu();

				opcion = entradaValor.nextInt();
				entradaValor.nextLine(); // Consumir la nueva línea después de la entrada numérica

				switch (opcion) {
				case 0:
					System.out.println("Salir");
						
					break;
				case 1:					
					
					try {
						Connection conexion = ImplConecxion.establecerConexion();						
						if(conexion != null) {
							System.out.println("Aqui tienes la lista de libros");
							listaLibros = ImplConsulta.ListaselecionarLibros(conexion);
							for(int i=0;i<listaLibros.size();i++) {
								System.out.println(listaLibros.get(i).toString());
							}
						}	
						
					} catch (Exception e) {
						System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
					}
					break;
				case 2:
					System.out.println("¿Que libro quieres ver?");
	
					break;
				case 3:
					System.out.println("¿Que libro quieres modificar?");
					
					break;
				case 4:
					System.out.println("¿Quie libro quieres agregar");
					
					break;
				case 5:
					System.out.println("¿Que libro quieres borrar?");
					
					break;
					
				default:
					System.out.println("Opción inválida. Por favor, introduce un número válido.");
					break;
				}
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Debes introducir un número válido.");
				entradaValor.nextLine(); // Limpiar la entrada incorrecta
			} catch (Exception e) {
				System.out.println("Se produjo un error: " + e.getMessage());
			}
		} while (!opcionValida);
	}
		
}


