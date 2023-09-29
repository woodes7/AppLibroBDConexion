package ConexionServicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import ConexionDtos.LibroDto;
import ConexionUtil.ADto;
import Entidad.Empleado;

public class ImplementacionConsultas implements interfazConexionConsultas {

	@Override
	public ArrayList<LibroDto> ListaselecionarLibros(Connection conexionGenerada) {
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();
		try {
			// Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			// Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");

			// Llamada a la conversión a dtoAlumno
			listaLibros = adto.resultsALibrosDto(resultadoConsulta);
			int i = listaLibros.size();
			System.out.println(
					"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);
			System.out.println(
					"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
			resultadoConsulta.close();
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {
			System.out.println(
					"[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);
			return listaLibros;
		}
		return listaLibros;
	}

	@Override
	public ArrayList<LibroDto> modificarLibro(Connection conexionGenerada){
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();		
		try {			
		Scanner entradaValor = new Scanner(System.in);
		System.out.println("¿Quieres ver la lista de libros? s/S o n/N");
		if(entradaValor.equals("s") || entradaValor.equals("S")) 
			resultadoConsulta = declaracionSQL.executeQuery("SELECT id_libro, titulo  FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");
		

		return listaLibros;
	}catch(Exception e){
		System.out.println("Se produjo un error: " + e.getMessage());
		e.printStackTrace();
		return listaLibros;
	}
		
	}

	@Override
	public ArrayList<LibroDto> insertarLibro(Connection conexionGenerada) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Metodo para las opciones del Menu de modificar libro
	 * 
	 * @param empleado
	 */
	public void OpcionesModificacion() {
		do {
			try {
				// Mostramos el menú
				MostraMenuModificacion();
				
				opcion = entradaValor.nextInt();
				entradaValor.nextLine(); // Consumir la nueva línea después de la entrada numérica
				switch (opcion) {
				case 0:
					System.out.println("Adios");
					opcionValida = true;
					break;
				case 1:
					System.out.println("Dime el id del libro que deseas cambiar");
					int idLibro = entradaValor.nextInt();
					libro.setIdLibro(idLibro);
					
					System.out.println("Escribe el titulo nuevo del libro: ");			
					String nuevoTitulo = entradaValor.next();					
					libro.setTitulo(nuevoTitulo);
				
					consultaUpdate = "UPDATE \"gbp_almacen\".\"gbp_alm_cat_libros\" SET titulo = '" + nuevoTitulo
							+ "' WHERE id_libro = " + idLibro + ";";
					// Llamada a la conversión a dtoAlumno
					listaLibros = adto.resultsALibrosDto(resultadoConsulta);					
					i = listaLibros.size();
					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);

					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
					resultadoConsulta.close();
					declaracionSQL.close();
					conexionGenerada.close();
					break;
				case 2:
					System.out.println("Dime el id del libro que deseas cambiar");
					idLibro = entradaValor.nextInt();
					libro.setIdLibro(idLibro);
					
					System.out.println("Escribe el nuevo nombre del autor del libro: ");
					String nuevoAutor = entradaValor.next();
					libro.setAutor(nuevoAutor);
					
					consultaUpdate = "UPDATE \"gbp_almacen\".\"gbp_alm_cat_libros\" SET titulo = '" + nuevoAutor
							+ "' WHERE id_libro = " + idLibro + ";";
					// Llamada a la conversión a dtoAlumno
					listaLibros = adto.resultsALibrosDto(resultadoConsulta);					
					 i = listaLibros.size();
					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);

					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
					resultadoConsulta.close();
					declaracionSQL.close();
					conexionGenerada.close();
					break;
				case 3:
					System.out.println("Dime el id del libro que deseas cambiar");
					idLibro = entradaValor.nextInt();
					libro.setIdLibro(idLibro);
					
					System.out.println("Escribe el nuevo isbn del libro: ");
					String nuevosIsbn = entradaValor.next();
					libro.setIsbn(nuevosIsbn);
					
					consultaUpdate = "UPDATE \"gbp_almacen\".\"gbp_alm_cat_libros\" SET titulo = '" + nuevoAutor
							+ "' WHERE id_libro = " + idLibro + ";";
					// Llamada a la conversión a dtoAlumno
					listaLibros = adto.resultsALibrosDto(resultadoConsulta);					
					 i = listaLibros.size();
					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);

					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
					resultadoConsulta.close();
					declaracionSQL.close();
					conexionGenerada.close();					
					break;
				case 4:					
					System.out.println("Escribe la nueva edicion del libro: ");
					idLibro = entradaValor.nextInt();
					libro.setIdLibro(idLibro);
					
					System.out.println("Escribe el nuevo isbn del libro: ");
					int nuevaEdicion = entradaValor.nextInt();
					libro.setEdicion(nuevaEdicion);
					
					consultaUpdate = "UPDATE \"gbp_almacen\".\"gbp_alm_cat_libros\" SET titulo = '" + nuevoAutor
							+ "' WHERE id_libro = " + idLibro + ";";
					// Llamada a la conversión a dtoAlumno
					listaLibros = adto.resultsALibrosDto(resultadoConsulta);					
					 i = listaLibros.size();
					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);

					System.out.println(
							"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
					resultadoConsulta.close();
					declaracionSQL.close();
					conexionGenerada.close();
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
		
		try {
			// Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			// Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");

			// Llamada a la conversión a dtoAlumno
			listaLibros = adto.resultsALibrosDto(resultadoConsulta);
			int i = listaLibros.size();
			System.out.println(
					"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);
			System.out.println(
					"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
			resultadoConsulta.close();
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {
			System.out.println(
					"[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);
			return listaLibros;
		}
		return listaLibros;
	}

	/**
	 * Metodo para mostrar el menu de Modificacion
	 * 
	 */
	public void MostraMenuModificacion() {
		// Mostramos el menú
		System.out.println("Menú: ¿Que de sea modificar?");
		System.out.println("1. Modificar titulo");
		System.out.println("2. Modificar autor");
		System.out.println("3. Modificar isbn");
		System.out.println("4. Modificar edición");
		System.out.println("0. Salir");
	}

}
