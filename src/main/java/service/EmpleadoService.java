package service;

import java.util.ArrayList;
import java.util.List;

import entidad.Empleado;
import entidad.EmpleadoReporte;
import interfaces.EmpleadoInterfaceDAO;
import manager.DAOManager;

public class EmpleadoService {

	DAOManager factory = DAOManager.getInstancia();
	EmpleadoInterfaceDAO dao = factory.getEmpleadoDAO();
	
	public boolean agregar(Empleado o) throws Exception {
		return dao.agregar(o);
	}

	public boolean modificar(Empleado o) throws Exception {
		return dao.modificar(o);
	}

	public boolean eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Empleado> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleado obtenerByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<EmpleadoReporte> listarAlterado() throws Exception {
		return dao.listarAlterado();
	}

	public ArrayList<EmpleadoReporte> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}

	public ArrayList<Empleado> buscarOriginalPorCodigo(String valor) {
		return dao.buscarOriginalPorCodigo(valor);
	}

	public String generarCodigo() {
		return dao.generarCodigo();
	}
	
}
