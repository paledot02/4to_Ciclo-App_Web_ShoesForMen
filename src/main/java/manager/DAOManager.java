package manager;

import java.sql.Connection;

import conexion.Conexion;
import interfaces.CalzadoInterfaceDAO;
import interfaces.CargoInterfaceDAO;
import interfaces.CategoriaInterfaceDAO;
import interfaces.DistritoInterfaceDAO;
import interfaces.EmpleadoInterfaceDAO;
import interfaces.MarcaInterfaceDAO;
import interfaces.ModeloInterfaceDAO;
import modelo.CalzadoDAO;
import modelo.CargoDAO;
import modelo.DistritoDAO;
import modelo.EmpleadoDAO;
import modelo.ModeloDAO;

public class DAOManager implements DAOManagerInterface{

	
	private static final DAOManager instancia = new DAOManager();
	private Connection cn;
	
	private DAOManager() {
		cn = new Conexion().getConn();
	}
	
	public static DAOManager getInstancia() {
		return instancia;
	}
	
	
	private CalzadoInterfaceDAO calzadoDAO = null;
	private CargoInterfaceDAO cargoDAO = null;
	private CategoriaInterfaceDAO categoriaDAO = null;
	private DistritoInterfaceDAO distritoDAO = null;
	private EmpleadoInterfaceDAO empleadoDAO = null;
	private MarcaInterfaceDAO marcaDAO = null;
	private ModeloInterfaceDAO modeloDAO = null;
	
	
	
	
	@Override
	public CalzadoInterfaceDAO getCalzadoDAO() {
		
		if(calzadoDAO == null) {
			calzadoDAO = new CalzadoDAO(cn);
		}
		return calzadoDAO;
	
	}

	@Override
	public CategoriaInterfaceDAO getCategoriaDAO() {
		
		if(calzadoDAO == null) {
			calzadoDAO = new CalzadoDAO(cn);
		}
		return null;
	
	}

	@Override
	public DistritoInterfaceDAO getDistritoDAO() {
		
		if(distritoDAO == null) {
			distritoDAO = new DistritoDAO(cn);
		}
		return distritoDAO;
	
	}

	@Override
	public EmpleadoInterfaceDAO getEmpleadoDAO() {
		
		if(empleadoDAO == null) {
			empleadoDAO = new EmpleadoDAO(cn);
		}
		return empleadoDAO;
	
	}

	@Override
	public MarcaInterfaceDAO getMarcaDAO() {
		
		if(calzadoDAO == null) {
			calzadoDAO = new CalzadoDAO(cn);
		}
		return null;
	
	}

	@Override
	public ModeloInterfaceDAO getModeloDAO() {
		if(modeloDAO == null) {
			modeloDAO = new ModeloDAO(cn);
		}
		return modeloDAO;
	}

	@Override
	public CargoInterfaceDAO getCargoDAO() {
		if(cargoDAO == null) {
			cargoDAO = new CargoDAO(cn);
		}
		return cargoDAO;
	}

	
	
}
