
<%@page import="entidad.Cargo"%>
<%@page import="entidad.Distrito"%>
<%@page import="entidad.Modelo"%>
<%@page import="java.util.List"%>
		
		<header>
		<label>EMPLEADO</label>
		</header>
		
		<div class="col-lg-8">
			<h1>AGREGAR EMPLEADO</h1>
			
			<%
			List<Distrito> listaDistrito = (List<Distrito>) request.getAttribute("listaDistrito");
			List<Cargo> listaCargo= (List<Cargo>) request.getAttribute("listaCargo"); 
			String codigoGenerado = (String) request.getAttribute("codigoGenerado");
			%>
			
			<form action="#" id="frmAddDepartamento">
			
				CODIGO: <br>
				<input class="form-control" type="text" name="txt_codigo_empleado" id="txt_codigo_empleado" value="<%=codigoGenerado%>" readonly> <br>
				
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_b" id="txt_nombre"> <br>
				
				APELLIDOS: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_apellidos"> <br>
				
				DNI: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_dni"> <br>
				
				DIRECCION: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_direccion"> <br>
				
				TELEFONO: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_telefono"> <br>
				
				EMAIL: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_email"> <br>
				
				DISTRITO: <br>
				<select class="form-control" name="cbo_distrito" id="cbo_distrito">
				<% if(listaDistrito != null)
					for(Distrito items:listaDistrito){
					%>
					<option value="<%=items.getCod_distrito()%>"><%=items.getDescripcion() %></option>
					<%		
					}
				%>
				</select><br>
				
				CARGO: <br>
				<select class="form-control" name="cbo_cargo" id="cbo_cargo">
				<% if(listaCargo != null)
					for(Cargo items:listaCargo){
					%>
					<option value="<%=items.getCod_cargo()%>"><%=items.getDescripcion() %></option>
					<%		
					}
				%>
				</select><br>
				
				ESTADO: 
				<div class="form-check form-switch">
  					<input class="form-check-input" type="checkbox" id="txt_estado">
  					<label class="form-check-label" for="txt_estado">Activo</label>
				</div><br>
				
				
				<input class="btn btn-outline-primary" type="button" onclick="agregarEmpleado();" id ="accion" name="accion" value="Agregar">
			
				<a  class="btn btn-outline-danger" href="javascript:;" onclick="listarEmpleado();">Regresar</a> <br>		
			
			</form>
		</div>