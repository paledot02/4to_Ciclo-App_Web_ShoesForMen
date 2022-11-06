
<%@page import="entidad.Empleado"%>
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
			Empleado obj = (Empleado) request.getAttribute("obj");
			List<Distrito> listaDistrito = (List<Distrito>) request.getAttribute("listaDistrito");
			List<Cargo> listaCargo= (List<Cargo>) request.getAttribute("listaCargo"); 
			%>
			
			<form action="#" id="frmAddDepartamento">
			
				CODIGO: <br>
				<input class="form-control" type="text" name="txt_codigo_empleado" id="txt_codigo_empleado" value="<%=obj.getCod_empleado()%>" readonly> <br>
				
				NOMBRE: <br>
				<input class="form-control" type="text" name="txt_b" id="txt_nombre" value="<%=obj.getNombre()%>"> <br>
				
				APELLIDOS: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_apellidos" value="<%=obj.getApellidos()%>"> <br>
				
				DNI: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_dni" value="<%=obj.getDni()%>"> <br>
				
				DIRECCION: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_direccion" value="<%=obj.getDireccion()%>"> <br>
				
				TELEFONO: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_telefono" value="<%=obj.getTelefono()%>"> <br>
				
				EMAIL: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_email" value="<%=obj.getEmail()%>"> <br>
				
				DISTRITO: <br>
				<select class="form-control" name="cbo_distrito" id="cbo_distrito">
				<% if(listaDistrito != null)
					for(Distrito items:listaDistrito){
						%>
						<option value="<%=items.getCod_distrito()%>" <% if(items.getCod_distrito()==obj.getCod_distrito()) {%> selected <%} %>><%=items.getDescripcion() %></option>
						<%		
					}
				%>
				</select><br>
				
				CARGO: <br>
				<select class="form-control" name="cbo_cargo" id="cbo_cargo">
				<% if(listaCargo != null)
					for(Cargo items:listaCargo){
						%>
						<option value="<%=items.getCod_cargo()%>" <% if(items.getCod_cargo()==obj.getCod_cargo()) { %> selected <%} %>><%=items.getDescripcion() %></option>
						<%			
					}
				%>
				</select><br>
				
				<%//System.out.println(obj.getCod_estado()==1);%>
				ESTADO: 
				<div class="form-check form-switch">
  					<input class="form-check-input" type="checkbox" id="txt_estado"
  						<% if(obj.getCod_estado() == 1){
  							%> 
  							checked 
  							<%
  							} 
  						%>
  					>
  					<label class="form-check-label" for="txt_estado">Activo</label>
				</div><br>
				
				
				<input class="btn btn-outline-primary" type="button" onclick="actualizarEmpleado();" id ="accion" name="accion" value="Actualizar">
			
				<a  class="btn btn-outline-danger" href="javascript:;" onclick="listarEmpleado();">Regresar</a> <br>		
			
			</form>
		</div>