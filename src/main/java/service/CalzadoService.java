package service;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import entidad.Calzado;
import entidad.CalzadoReporte;
import interfaces.CalzadoInterfaceDAO;
import manager.DAOManager;

public class CalzadoService {

	DAOManager factory = DAOManager.getInstancia();
	CalzadoInterfaceDAO dao = factory.getCalzadoDAO();
	
	
	public boolean agregar(Calzado o) throws Exception {
		return dao.agregar(o);
	}

	
	public boolean modificar(Calzado o) throws Exception {
		return dao.modificar(o);
	}

	
	public boolean eliminar(String id) throws Exception {
		return dao.eliminar(id);
	}

	
	public List<Calzado> listar() throws Exception {
		return dao.listar();
	}

	
	public Calzado obtenerByID(String id) throws Exception {
		return dao.obtenerByID(id);
	}
	
	public ArrayList<CalzadoReporte> listarAlterado() throws Exception {
		return dao.listarAlterado();
		
	}
	
	public ArrayList<CalzadoReporte> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
	
	public String generarCodigo() {
		return dao.generarCodigo();
		
	}
	
	public ArrayList<Calzado> buscarOriginalPorCodigo(String valor) {
		return dao.buscarOriginalPorCodigo(valor);
	}
	
}
