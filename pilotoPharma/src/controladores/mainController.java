package controladores;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import modelos.DTOs.opr_cat_productosDTO;
import modelos.conexiones.conexionPostgreSQL;
import modelos.consultas.consultasPostgreSQl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utils.variablesConexionPostgreSQL;

public class mainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instanciamos los datos de conexion de utils y los desestructuramos
				conexionPostgreSQL conexion = new conexionPostgreSQL();
				
				// Instanciamos variablesConexionPostgreSQL para poder recoger los credenciales
				// de inicio de sesion
				variablesConexionPostgreSQL vc = new variablesConexionPostgreSQL();
				
				// Instanciamos las listas
				List<opr_cat_productosDTO> listProductos = new ArrayList<opr_cat_productosDTO>();
				// Hacemos su desestructuracion
				final String HOST = vc.getHost();
				final String PORT = vc.getPort();
				final String DB = vc.getDb();
				final String USER = vc.getUser();
				final String PASS = vc.getPass();
				
				// Hacemos la conexion
				System.out.println("ABRIMOS LA CONEXION");
				Connection cn = conexion.añadirConexionPostgreSql(USER, PASS, PORT, HOST, DB);
				//hacemos la insercion para pdoer ver los cambios al enseñar la base de datos
				consultasPostgreSQl.insertarProductos(cn);
				// Una vez hecha la conexión hacemos la consulta
				consultasPostgreSQl.listarProductos(cn);
				// metemos los valores en la lista
				listProductos = consultasPostgreSQl.listarProductos(cn);
				System.out.println("----------------------------------------------------------------");
				System.out.println("                          Productos                               ");
				System.out.println("----------------------------------------------------------------");
				for (int i=0;i<listProductos.size();i++) {
					System.out.println("md_uuid: " + listProductos.get(i).md_uuid + " " + "md_fch: " +listProductos.get(i).md_fch +" "+ "id_producto: " + listProductos.get(i).id_producto + " " +"cod_producto: " + listProductos.get(i).cod_producto+" " + "nombre_producto: " + listProductos.get(i).nombre_producto+ " " + "tipo_producto_origen: " + listProductos.get(i).tipo_producto_origen +" "+ "tipo_producto_clase: " + listProductos.get(i).tipo_producto_clase+ " " + "fch_alta_producto: " + listProductos.get(i).fch_alta_producto + " "+"fch_baja_producto: " + listProductos.get(i).fch_baja_producto);
				}
				
				//Cerramos la conexion
				try {
					System.out.println("CERRAMOS LA CONEXION");
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
