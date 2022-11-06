package service;

import java.util.List;

import entidad.Cargo;
import interfaces.CargoInterfaceDAO;
import manager.DAOManager;

public class CargoService {

	
	DAOManager factory = DAOManager.getInstancia();
	CargoInterfaceDAO dao = factory.getCargoDAO();
	
	public List<Cargo> listar() throws Exception {
		return dao.listar();
		
	}
	
}
