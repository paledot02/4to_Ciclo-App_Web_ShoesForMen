package manager;

import interfaces.CalzadoInterfaceDAO;
import interfaces.CargoInterfaceDAO;
import interfaces.CategoriaInterfaceDAO;
import interfaces.DistritoInterfaceDAO;
import interfaces.EmpleadoInterfaceDAO;
import interfaces.MarcaInterfaceDAO;
import interfaces.ModeloInterfaceDAO;

public interface DAOManagerInterface {
	
	CalzadoInterfaceDAO getCalzadoDAO();
	CargoInterfaceDAO getCargoDAO();
	CategoriaInterfaceDAO getCategoriaDAO();
	DistritoInterfaceDAO getDistritoDAO();
	EmpleadoInterfaceDAO getEmpleadoDAO();
	MarcaInterfaceDAO getMarcaDAO();
	ModeloInterfaceDAO getModeloDAO();
	
	
}
