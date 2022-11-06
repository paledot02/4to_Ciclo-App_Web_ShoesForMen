package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import entidad.Calzado;
import entidad.CalzadoReporte;
import interfaces.CalzadoInterfaceDAO;

public class CalzadoDAO implements CalzadoInterfaceDAO{

	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Calzado> listaOriginal;
	private ArrayList<CalzadoReporte> listaReporte;
	
	// Sentencias
	final String GETALL = "{call pa_listar_calzado()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_calzado()}";
	final String INSERT = "{call pa_insertar_calzado(?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_calzado(?,?,?,?,?)}";
	
	final String SEARCH_ORIGINAL_CODE = "{call pa_buscar_calzado_original_por_codigo(?)}";
	final String SEARCH_CODE = "{call pa_buscar_calzado_por_codigo(?)}";
	final String SEARCH_CODE_EXACT = "{call pa_buscar_calzado_por_codigo_exacto(?)}";
	
	final String SEARCH_MODEL = "{call pa_buscar_calzado_por_modelo(?)}";
	final String SEARCH_CATEGORY = "{call pa_buscar_calzado_por_categoria(?)}";
	final String SEARCH_BRAND = "{call pa_buscar_calzado_por_marca(?)}";
	final String SEARCH_TALLA = "{call pa_buscar_calzado_por_talla(?)}";
	final String SEARCH_COLOR = "{call pa_buscar_calzado_por_color(?)}";
	
	public CalzadoDAO(Connection cn) {
		this.cn = cn;
	}
	
	
	@Override
	public boolean agregar(Calzado o) throws Exception {
		int respuesta = -1;
		try {
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, o.getCod_calzado());
			cs.setString(i++, o.getCod_modelo());
			cs.setInt(i++, o.getTalla());
			cs.setString(i++, o.getColor());
			cs.setInt(i++, o.getStock());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - CALZADO --> " + e1.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia registrar() - CALZADO --> " + e.getMessage());
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
		return (respuesta>0);
	}

	@Override
	public boolean modificar(Calzado o) throws Exception {
		
		int respuesta = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, o.getCod_calzado());
			cs.setString(i++, o.getCod_modelo());
			cs.setInt(i++, o.getTalla());
			cs.setString(i++, o.getColor());
			cs.setInt(i++, o.getStock());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - CALZADO --> " + e1.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia actualizar() - CALZADO --> " + e.getMessage());
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
		return (respuesta>0);
	}

	@Override
	public boolean eliminar(String id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Calzado> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calzado obtenerByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<CalzadoReporte> listarAlterado() throws Exception { // HAY UN ERROR NO DEBEMOS CERRAR LA CONEXION ACA 
											// PORQUE LA CONEXION YA ESTA LIMITADA POR MANAGER
		listaReporte = new ArrayList<CalzadoReporte>();
		CalzadoReporte objR;
		try{

			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listar() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listar() - CALZADO --> " + e.getMessage());
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
		return listaReporte;
		
	}


	@Override
	public ArrayList<CalzadoReporte> buscar(String valor) throws Exception {
		
		listaReporte = new ArrayList<CalzadoReporte>();
		CalzadoReporte objR = null;
		try{
			cs = cn.prepareCall(SEARCH_BRAND);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new CalzadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getInt(i++),
						rs.getString(i++),
						rs.getDouble(i++),
						rs.getDouble(i++),
						rs.getInt(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorMarca() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorMarca() - CALZADO --> " + e.getMessage());
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
		return listaReporte;
		
	}


	@Override
	public String generarCodigo() {

		String codCalzado = "CZ10001";
		
		try{
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("00000");
				codCalzado = "CZ" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia generarCodigo() - CALZADO --> " + e.getMessage());
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
		return codCalzado;
		
	}


	@Override
	public ArrayList<Calzado> buscarOriginalPorCodigo(String valor) {
		
		listaOriginal = new ArrayList<Calzado>();
		Calzado obj;
		try{
			cs = cn.prepareCall(SEARCH_ORIGINAL_CODE);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Calzado(
						rs.getString(i++), 
						rs.getString(i++), 
						rs.getInt(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigoSimple() - CALZADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorCodigoSimple() - CALZADO --> " + e.getMessage());
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

	
	
}

