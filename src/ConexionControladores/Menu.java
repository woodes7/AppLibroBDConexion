package ConexionControladores;

import java.sql.Connection;
import java.util.ArrayList;
import ConexionDtos.LibroDto;
import ConexionServicios.ImplementacionConexion;
import ConexionServicios.ImplementacionConsultas;
import ConexionServicios.ImplementacionMenu;
import ConexionServicios.InterfazConexion;
import ConexionServicios.InterfazConexionMenu;
import ConexionServicios.interfazConexionConsultas;

public class Menu {

	public static void main(String[] args) {
		//Instanciamos
		
		InterfazConexion ImplConecxion = new ImplementacionConexion();
		interfazConexionConsultas ImplConsulta = new ImplementacionConsultas();	
		InterfazConexionMenu ImplMenu =new ImplementacionMenu();		
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		
		
		
		//Menu controlador 
		ImplMenu.opcionesMenu();
		
	}
}


