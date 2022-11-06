package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cargo;
import interfaces.CargoInterfaceDAO;

public class CargoDAO implements CargoInterfaceDAO{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	
	private ArrayList<Cargo> listaOriginal;
	
	// Sentencias
	final String GETALL = "{call pa_listar_cargo()}";
	final String SEARCH = "{call pa_buscar_cargo(?)}";
	
	// constructor
	public CargoDAO(Connection cn) {
		this.cn = cn;
	}
	
	
	@Override
	public boolean agregar(Cargo o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean modificar(Cargo o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Cargo> listar() throws Exception {

		listaOriginal = new ArrayList<Cargo>();
		Cargo obj;
		
		try{
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cargo(
						rs.getString(i++),
						rs.getString(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarOriginal() - MODELO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listarOriginal() - MODELO --> " + e.getMessage());
		}finally {
			try {
				if(ps != null) ps.close();
//				if( rs != null ) rs.close();
//				if( cs != null ) cs.close();
//				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaOriginal;
		
	}
	@Override
	public Cargo obtenerByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
