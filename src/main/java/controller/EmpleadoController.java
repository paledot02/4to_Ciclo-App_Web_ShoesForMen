package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Calzado;
import entidad.CalzadoReporte;
import entidad.Cargo;
import entidad.Distrito;
import entidad.Empleado;
import entidad.EmpleadoReporte;
import entidad.Modelo;
import service.CargoService;
import service.DistritoService;
import service.EmpleadoService;
import service.ModeloService;


@WebServlet(name="/EmpleadoController", urlPatterns="/empleado")
public class EmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final String url_list ="./vistas/Empleado/list.jsp";
	final String url_add="./vistas/Empleado/add.jsp";
	final String url_edit = "./vistas/Empleado/edit.jsp";
	final String url_report = "./vistas/Empleado/report.jsp";
	
	
	EmpleadoService empleadoServ = null;
	DistritoService distritoServ = null;
	CargoService cargoServ = null;
	
	String valor = "";
	List<EmpleadoReporte> lista;
	String acceso = "";
	String accion = "";
	
	// atributos de calzado
	String cod_empleado;
	String nombre;
	String apellidos;
	String dni;
	String direccion;
	String telefono;
	String email;
	String cod_distrito;
	String cod_cargo;
//	String usuario;
//	String contraseña;
	Integer cod_estado;
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		accion = request.getParameter("accion");
		empleadoServ = new EmpleadoService();
		
		try {
			if(accion.equalsIgnoreCase("listar")){
				listar(request, empleadoServ.listarAlterado(), url_list);
			}else if(accion.equalsIgnoreCase("add")) {
				distritoServ = new DistritoService();
				cargoServ = new CargoService();
				List<Distrito> listaDistrito = distritoServ.listar();
				List<Cargo> listaCargo = cargoServ.listar();
				request.setAttribute("listaDistrito", listaDistrito);
				request.setAttribute("listaCargo", listaCargo);
				
				String codigoGenerado = empleadoServ.generarCodigo();
				request.setAttribute("codigoGenerado", codigoGenerado);
				
				acceso = url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				empleadoServ.agregar(getEntidad(request));
				listar(request, empleadoServ.listarAlterado(), url_list);
			}else if(accion.equalsIgnoreCase("editar")) {
				cod_empleado = request.getParameter("cod_empleado");
				Empleado obj = empleadoServ.buscarOriginalPorCodigo(cod_empleado).get(0);
				request.setAttribute("obj", obj);
				
				distritoServ = new DistritoService();
				cargoServ = new CargoService();
				List<Distrito> listaDistrito = distritoServ.listar();
				List<Cargo> listaCargo = cargoServ.listar();
				request.setAttribute("listaDistrito", listaDistrito);
				request.setAttribute("listaCargo", listaCargo);
				
				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
				empleadoServ.modificar(getEntidad(request));
				listar(request, empleadoServ.listarAlterado(), url_list);
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("valor");
				listar(request, empleadoServ.buscar(valor), url_list);
			}else if(accion.equalsIgnoreCase("report")) {
				request.setAttribute("valor", valor);
				List<EmpleadoReporte> lista = empleadoServ.buscar(valor); // la lista viene de la busqueda no del metodo listar
				request.setAttribute("lista", lista);
				acceso = url_report;
			}
			
		} catch (Exception e) {
			System.out.println("SIS-CAL-EMP_001" + e.getMessage());
		}
		
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	
	}
	
	private void listar(HttpServletRequest request, List<EmpleadoReporte> lista, String url) throws Exception {
		request.setAttribute("lista", lista);
		acceso = url;
	}
	
	private Empleado getEntidad(HttpServletRequest request) {
		
		boolean estado;
		
		cod_empleado = request.getParameter("txt_codigo_empleado");
		nombre = request.getParameter("txt_nombre");
		apellidos = request.getParameter("txt_apellidos");
		dni = request.getParameter("txt_dni");
		direccion = request.getParameter("txt_direccion");
		telefono = request.getParameter("txt_telefono");
		email = request.getParameter("txt_email");
		cod_distrito = request.getParameter("cbo_distrito");
		cod_cargo = request.getParameter("cbo_cargo");
//		usuario = request.getParameter("txt_usuario");
//		contraseña = request.getParameter("txt_contraseña");
		estado = Boolean.parseBoolean(request.getParameter("txt_estado"));
		cod_estado = 0;
		
		if(estado == true) {
			cod_estado = 1;
		}

		
		return new Empleado(cod_empleado, nombre, apellidos, dni, direccion, telefono, email, cod_distrito, cod_cargo, cod_estado);
	}

}
