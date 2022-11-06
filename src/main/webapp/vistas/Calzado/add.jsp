
<%@page import="entidad.Modelo"%>
<%@page import="java.util.List"%>
		
		<header>
		<label>PRODUCTO</label>
		</header>
		
		<div class="col-lg-8">
			<h1>AGREGAR PRODUCTO</h1>
			
			<% List<Modelo> listaModelo = (List<Modelo>) request.getAttribute("listaModelo"); 
				String codigoGenerado = (String) request.getAttribute("codigoGenerado");
			%>
			
			<form action="#" id="frmAddDepartamento">
			
				CODIGO: <br>
				<input class="form-control" type="text" name="txt_codigo_calzado" id="txt_codigo_calzado" value="<%=codigoGenerado%>" readonly> <br>
				
				MODELO: <br>
				<select class="form-control" name="cbo_modelo" id="cbo_modelo">
				<% if(listaModelo != null)
					for(Modelo items:listaModelo){
					%>
					<option value="<%=items.getCod_modelo()%>"><%=items.getNombre_modelo() %></option>
					<%		
					}
				%>
				</select><br>
				
				TALLA: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_talla"> <br>
				COLOR: <br>
				<input class="form-control" type="text" name="txt_color" id="txt_color"> <br>
				STOCK: <br>
				<input class="form-control" type="text" name="txt_stock" id="txt_stock"> <br>
				
				<input class="btn btn-outline-primary" type="button" onclick="agregarCalzado();" id ="accion" name="accion" value="Agregar">
			
				<a  class="btn btn-outline-danger" href="javascript:;" onclick="listarCalzado();">Regresar</a> <br>		
			
			</form>
		</div>