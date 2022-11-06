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
import entidad.Empleado;
import entidad.EmpleadoReporte;
import interfaces.EmpleadoInterfaceDAO;

public class EmpleadoDAO implements EmpleadoInterfaceDAO{
	
	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	
	private ArrayList<Empleado> listaOriginal;
	private ArrayList<EmpleadoReporte> listaReporte;
	
	final String VALIDATE = "{call pa_validar_empleado(?,?)}";
	final String GETALLORIGINAL = "{call pa_listar_empleado_original()}";
	final String GETALL = "{call pa_listar_empleado()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_empleado()}";
	final String INSERT = "{call pa_insertar_empleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_empleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
	//final String DELETE = "{call pa_eliminar_empleado(?)}";
	
	final String SEARCH_ORIGINAL_CODE = "{call pa_buscar_empleado_original_por_codigo(?)}";
	final String SEARCH_CODE_EXACT = "{call pa_buscar_empleado_por_codigo_exacto(?)}";
	final String SEARCH_CODE = "{call pa_buscar_empleado_por_codigo(?)}";

	final String SEARCH_NAME = "{call pa_buscar_empleado_por_nombre_apellido(?)}";
	final String SEARCH_DNI = "{call pa_buscar_empleado_por_dni(?)}";
	final String SEARCH_DISTRITO = "{call pa_buscar_empleado_por_distrito(?)}";
	
	
	public EmpleadoDAO(Connection cn) {
		this.cn = cn;
	}
	
	@Override
	public boolean agregar(Empleado o) throws Exception {
		int respuesta = -1;
		try {
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, o.getCod_empleado());
			cs.setString(i++, o.getNombre());
			cs.setString(i++, o.getApellidos());
			cs.setString(i++, o.getDni());
			cs.setString(i++, o.getDireccion());
			cs.setString(i++, o.getTelefono());
			cs.setString(i++, o.getEmail());
			cs.setString(i++, o.getCod_distrito());
			cs.setString(i++, o.getCod_cargo());
			cs.setString(i++, o.getUsuario());
			cs.setString(i++, o.getContraseña());
			cs.setInt(i++, o.getCod_estado());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia registrar() - EMPLEADO --> " + e.getMessage());
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
	public boolean modificar(Empleado o) throws Exception {
		
		int respuesta = -1;
		try {
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, o.getCod_empleado());
			cs.setString(i++, o.getNombre());
			cs.setString(i++, o.getApellidos());
			cs.setString(i++, o.getDni());
			cs.setString(i++, o.getDireccion());
			cs.setString(i++, o.getTelefono());
			cs.setString(i++, o.getEmail());
			cs.setString(i++, o.getCod_distrito());
			cs.setString(i++, o.getCod_cargo());
			cs.setString(i++, o.getUsuario());
			cs.setString(i++, o.getContraseña());
			cs.setInt(i++, o.getCod_estado());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia actualizar() - EMPLEADO --> " + e.getMessage());
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
	public List<Empleado> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado obtenerByID(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EmpleadoReporte> listarAlterado() throws Exception {
		listaReporte = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte objR;
		try{

			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listar() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia listar() - EMPLEADO --> " + e.getMessage());
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
	public ArrayList<EmpleadoReporte> buscar(String valor) throws Exception {
		
		listaReporte = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte objR = null;
		try{
			cs = cn.prepareCall(SEARCH_NAME);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				objR = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				listaReporte.add(objR);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorMarca() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorMarca() - EMPLEADO --> " + e.getMessage());
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
	public ArrayList<Empleado> buscarOriginalPorCodigo(String valor) {
		listaOriginal = new ArrayList<Empleado>();
		Empleado obj;
		try{
			cs = cn.prepareCall(SEARCH_ORIGINAL_CODE);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigoSimple() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorCodigoSimple() - EMPLEADO --> " + e.getMessage());
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
	public String generarCodigo() {
		
		String codEmpleado = "EM001";
		
		try{
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("000");
				codEmpleado = "EM" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
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
		return codEmpleado;
		
	}

	
	
}
