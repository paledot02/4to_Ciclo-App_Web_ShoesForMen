package interfaces;

import java.util.ArrayList;

import entidad.Calzado;
import entidad.CalzadoReporte;

public interface CalzadoInterfaceDAO extends GenericDAO<Calzado, String>{

	public ArrayList<CalzadoReporte> listarAlterado() throws Exception;
	
	public ArrayList<CalzadoReporte> buscar(String valor) throws Exception;
	
	public ArrayList<Calzado> buscarOriginalPorCodigo(String valor);
	
	public String generarCodigo();
	
	
	
}
