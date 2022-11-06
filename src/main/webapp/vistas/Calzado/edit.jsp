
<%@page import="entidad.Calzado"%>
<%@page import="entidad.Modelo"%>
<%@page import="java.util.List"%>
		
		<header>
		<label>CALZADO</label>
		</header>
		
		<div class="col-lg-8">
			<h1>EDITAR CALZADO</h1>
			
			<% Calzado obj = (Calzado) request.getAttribute("obj"); %>
			<% List<Modelo> listaModelo = (List<Modelo>) request.getAttribute("listaModelo"); %>
			
			<form action="#" id="frmAddDepartamento">
			
				CODIGO: <br>
				<input class="form-control" type="text" name="txt_codigo_calzado" id="txt_codigo_calzado" value="<%=obj.getCod_calzado()%>" readonly> <br>
				
				MODELO: <br>
				<select class="form-control" name="cbo_modelo" id="cbo_modelo">
				<% if(listaModelo != null)
					for(Modelo items:listaModelo){
					%>
					<option value="<%=items.getCod_modelo()%>" <% if(items.getCod_modelo()==obj.getCod_modelo()) { %> selected <%} %>><%=items.getNombre_modelo() %></option>
					<%		
					}
				%>
				</select><br>
				
				TALLA: <br>
				<input class="form-control" type="text" name="txt_talla" id="txt_talla" value="<%=obj.getTalla()%>"> <br>
				COLOR: <br>
				<input class="form-control" type="text" name="txt_color" id="txt_color" value="<%=obj.getColor()%>"> <br>
				STOCK: <br>
				<input class="form-control" type="text" name="txt_stock" id="txt_stock" value="<%=obj.getStock()%>"> <br>
				
				<input class="btn btn-outline-primary" type="button" onclick="actualizarCalzado();" id ="accion" name="accion" value="Actualizar">
			
				<a  class="btn btn-outline-danger" href="javascript:;" onclick="listarCalzado();">Regresar</a> <br>		
			
			</form>
		</div>