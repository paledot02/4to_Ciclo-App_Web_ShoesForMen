package service;

import java.util.List;

import entidad.Distrito;
import interfaces.DistritoInterfaceDAO;
import manager.DAOManager;

public class DistritoService {

	
	DAOManager factory = DAOManager.getInstancia();
	DistritoInterfaceDAO dao = factory.getDistritoDAO();
	
	public List<Distrito> listar() throws Exception {
		return dao.listar();
		
	}
	
}
