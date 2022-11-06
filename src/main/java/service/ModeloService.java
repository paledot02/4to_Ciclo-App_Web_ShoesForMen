package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Modelo;
import interfaces.ModeloInterfaceDAO;
import manager.DAOManager;

public class ModeloService {

	DAOManager factory = DAOManager.getInstancia();
	ModeloInterfaceDAO dao = factory.getModeloDAO();
	
	public List<Modelo> listar() throws Exception {
		return dao.listar();
		
	}
	
}
