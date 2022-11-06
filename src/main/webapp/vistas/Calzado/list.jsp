
<%@page import="java.util.Iterator"%>
<%@page import="entidad.CalzadoReporte"%>
<%@page import="java.util.ArrayList"%>
<header>
			<label>CALZADO</label>
		</header>
		
		
		<div class="navbar">
			<a class="btn btn-outline-success" href="javascript:;" onclick="mostrarAddCalzado();">+ Nuevo</a>
			<% String valor = String.valueOf(request.getAttribute("valor")); %>
			
			<form class="form-inline" method="post" action="./calzado"> <%-- AJAX PARA EL BOTON BUSCAR --%>
				<input class="form-control" type="search" id="valor" name="valor" value="<%=valor%>">
				<input class="btn btn-outline-success" type="button" onclick="buscarCalzado();" name="accion" value="Buscar">
				<a class="btn btn-outline-success" href="./calzado?accion=report" target="_blank">Reporte</a>
			</form>
			
		</div>
		
		
		
				<table class="table table-bordered">
			
			<thead>
				<tr>
					<th class="text-center">COD</th>
					<th class="text-center">MODELO</th>
					<th class="text-center">MARCA</th>
					<th class="text-center">CATEGORIA</th>
					<th class="text-center">TALLA</th>
					<th class="text-center">COLOR</th>
					<th class="text-center">P.C</th>
					<th class="text-center">P.V</th>
					<th class="text-center">STOCK</th>
				</tr>
			</thead>
	
			<tbody>
				<%
					ArrayList<CalzadoReporte> lista = (ArrayList<CalzadoReporte>) request.getAttribute("lista");
					Iterator<CalzadoReporte> itera = lista.iterator();
					CalzadoReporte obj = null;
					
					while(itera.hasNext()){
						obj = itera.next();
				    %>
			
					<tr>
						<td class="text-center"><%=obj.getCod_calzado() %></td>
						<td class="text-center"><%=obj.getNombre_modelo() %></td>
						<td class="text-center"><%=obj.getNombre_marca() %></td>
						<td class="text-center"><%=obj.getDescripcion_categoria() %></td>
						<td class="text-center"><%=obj.getTalla() %></td>
						<td class="text-center"><%=obj.getColor() %></td>
						<td class="text-center"><%=obj.getPrecio_compra() %></td>
						<td class="text-center"><%=obj.getPrecio_venta() %></td>
						<td class="text-center"><%=obj.getStock() %></td>
						
						
						<%-- AL PARECER EL VALOR DEL OBJETO CODIGO CALZADO LO OBTIENE PERO AL MANDARLO AL METODO EN AJAX NO LO PUEDE USAR, 
						     PIENSO QUE TALVEZ PODRIA SER POR EL TIPO DE DATO POR ESO LE AGREGE LAS COMILLAS SIMPLES Y FUNCIONO
						     ---> YA ENTENDIIIII--- LOS NUMERO NO NECESITAN COMILLAS POR LO QUE UN VALOR NUMERICO DENTRO DE LOS PARENTECIS
						     	 					SIEMPRE SABRAN QUE ES UN PARAMETRO CUYO VALOR ES NUMERICO, PERO UN VALOR DE TIPO STRING 
						     	 					DENTRO DE LOS PARENTESIS PUEDE HACER REFERENCIA A UNA VARIABLE DENTRO DE LA MISMA PAGINA 
						     	 					POR LO QUE SI QUIERES TOMAR EL VALOR COMO EL MISMO PARAMETRO QUE SE ENVIA DEBES 
						     	 					AGREGARLE LAS COMILLAS PARA AVISARLES QUE ESTE ES EL VALOR QUE QUIERES QUE SE ENVIE
						     	 					COMO EN MYSQL, TODO PARAMETRO DE CADENA DEBE IR DENTRO DE COMILLAS PERO LOS NUMEROS NO ES 
						     	 					OPCIONAL PORQUE LAS VARIABLES NO SE PUEDEN DEFINIR SOLO CON NUMEROS --%>
						<td class="text-center">
							<a class="btn btn-outline-warning" href="javascript:;" onclick="mostrarEditarCalzado('<%=obj.getCod_calzado()%>')">Editar</a>
							<a class="btn btn-outline-danger" href="javascript:;" onclick="eliminarCalzado('<%=obj.getCod_calzado()%>');" >Eliminar</a>
						</td>
					</tr>
				
				    <%
					}
				%>
			
			</tbody>
		</table>