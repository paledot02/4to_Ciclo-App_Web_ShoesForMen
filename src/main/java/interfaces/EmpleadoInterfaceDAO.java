package interfaces;

import java.util.ArrayList;

import entidad.Empleado;
import entidad.EmpleadoReporte;

public interface EmpleadoInterfaceDAO extends GenericDAO<Empleado, String>{

	public ArrayList<EmpleadoReporte> listarAlterado() throws Exception;
	
	public ArrayList<EmpleadoReporte> buscar(String valor) throws Exception;
	
	public ArrayList<Empleado> buscarOriginalPorCodigo(String valor);
	
	public String generarCodigo();
	
	
	
}
