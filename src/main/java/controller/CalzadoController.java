package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Calzado;
import entidad.CalzadoReporte;
import entidad.Modelo;
import service.CalzadoService;
import service.ModeloService;

/**
 * Servlet implementation class CalzadoController
 */
@WebServlet(name="CalzadoController", urlPatterns = {"/calzado"})
public class CalzadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final String url_list ="./vistas/Calzado/list.jsp";
	final String url_add="./vistas/Calzado/add.jsp";
	final String url_edit = "./vistas/Calzado/edit.jsp";
	final String url_report = "./vistas/Calzado/report.jsp";
	
	CalzadoService calzadoServ = null;
	ModeloService modeloServ = null;
	
	String valor = "";
	List<CalzadoReporte> lista;
	String acceso = "";
	String accion = "";
	
	// atributos de calzado
	String cod_calzado;
	String cod_modelo;
	Integer talla;
	String color;
	Integer stock;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		accion = request.getParameter("accion");
		calzadoServ = new CalzadoService();
//		HttpSession session = request.getSession(true);
	
		try {
			
			if(accion.equalsIgnoreCase("listar")){
				listar(request, calzadoServ.listarAlterado(), url_list);
			}else if(accion.equalsIgnoreCase("add")) {
				modeloServ = new ModeloService();
				List<Modelo> listaModelo = modeloServ.listar();
				request.setAttribute("listaModelo", listaModelo);
				
				String codigoGenerado = calzadoServ.generarCodigo();
				request.setAttribute("codigoGenerado", codigoGenerado);
				
				acceso = url_add;
			}else if(accion.equalsIgnoreCase("agregar")) {
				calzadoServ.agregar(getEntidad(request));
				listar(request, calzadoServ.listarAlterado(), url_list);
			}else if(accion.equalsIgnoreCase("editar")) {
				cod_calzado = request.getParameter("cod_calzado");
				Calzado obj = calzadoServ.buscarOriginalPorCodigo(cod_calzado).get(0);
				request.setAttribute("obj", obj);
				
				modeloServ = new ModeloService();
				List<Modelo> listaModelo = modeloServ.listar();
				request.setAttribute("listaModelo", listaModelo);
				
				acceso = url_edit;
			}else if(accion.equalsIgnoreCase("actualizar")) {
				calzadoServ.modificar(getEntidad(request));
				listar(request, calzadoServ.listarAlterado(), url_list);
			}else if(accion.equalsIgnoreCase("buscar")) {
				valor = request.getParameter("valor");
				listar(request, calzadoServ.buscar(valor), url_list);
			}else if(accion.equalsIgnoreCase("report")) {
				request.setAttribute("valor", valor);
				List<CalzadoReporte> lista = calzadoServ.buscar(valor); // la lista viene de la busqueda no del metodo listar
				request.setAttribute("lista", lista);
				acceso = url_report;
			}
			
		} catch (Exception e) {
			System.out.println("SIS-MAT-DEP_001" + e.getMessage());
		}
		
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}
	
	private void listar(HttpServletRequest request, List<CalzadoReporte> lista, String url) throws Exception {
		request.setAttribute("lista", lista);
		acceso = url;
	}
	
	private Calzado getEntidad(HttpServletRequest request) {
		
		cod_calzado = request.getParameter("txt_codigo_calzado");
		cod_modelo = request.getParameter("cbo_modelo");
		talla = Integer.parseInt(request.getParameter("txt_talla"));
		color = request.getParameter("txt_color");
		stock = Integer.parseInt(request.getParameter("txt_stock"));
		
		return new Calzado(cod_calzado, cod_modelo, talla, color, stock);
	}
	

}





// -->