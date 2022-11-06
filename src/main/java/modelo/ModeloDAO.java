package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Modelo;
import interfaces.ModeloInterfaceDAO;

public class ModeloDAO implements ModeloInterfaceDAO{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Modelo> listaOriginal;
	
	final String GET_ALL_ORIGINAL = "{call pa_listar_modelo_original()}";
	
	public ModeloDAO(Connection cn) {
		this.cn = cn;
	}
	
	@Override
	public boolean agregar(Modelo o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificar(Modelo o) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Modelo> listar() throws Exception {
		
		listaOriginal = new ArrayList<Modelo>();
		Modelo obj;
		
		try{
			cs = cn.prepareCall(GET_ALL_ORIGINAL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Modelo(
						rs.getString(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
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
	public Modelo obtenerByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
