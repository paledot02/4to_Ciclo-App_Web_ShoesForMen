package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Distrito;
import interfaces.DistritoInterfaceDAO;

public class DistritoDAO implements DistritoInterfaceDAO {

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	
	private ArrayList<Distrito> listaOriginal;
	
	final String GETALL = "{call pa_listar_distrito()}";
	final String SEARCH = "{call pa_buscar_distrito(?)}";
	
	
	public DistritoDAO(Connection cn) {
		this.cn = cn;
	}


	@Override
	public boolean agregar(Distrito o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean modificar(Distrito o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Distrito> listar() throws Exception {
		listaOriginal = new ArrayList<Distrito>();
		Distrito obj;
		
		try{
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Distrito(
						rs.getString(i++),
						rs.getString(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarOriginal() - DISTRITO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listarOriginal() - DISTRITO--> " + e.getMessage());
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
	public Distrito obtenerByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
