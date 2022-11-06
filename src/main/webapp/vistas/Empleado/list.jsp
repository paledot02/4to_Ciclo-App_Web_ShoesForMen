
<%@page import="entidad.EmpleadoReporte"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
		<header>
			<label>EMPLEADO</label>
		</header>
		
		
		<div class="navbar">
			<a class="btn btn-outline-success" href="javascript:;" onclick="mostrarAddEmpleado();">+ Nuevo</a>
			<% String valor = String.valueOf(request.getAttribute("valor")); %>
			
			<form class="form-inline" method="post" action="./empleado"> <%-- AJAX PARA EL BOTON BUSCAR --%>
				<input class="form-control" type="search" id="valor" name="valor" value="<%=valor%>">
				<input class="btn btn-outline-success" type="button" onclick="buscarEmpleado();" name="accion" value="Buscar">
				<a class="btn btn-outline-success" href="./empleado?accion=report" target="_blank">Reporte</a>
			</form>
			
		</div>
		
		
		
				<table class="table table-bordered">
			
			<thead>
				<tr>
					<th class="text-center">COD</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">APELLIDO</th>
					<th class="text-center">DNI</th>
					<th class="text-center">TELEFONO</th>
					<th class="text-center">DISTRITO</th>
					<th class="text-center">CARGO</th>
					<th class="text-center">ESTADO</th>
				</tr>
			</thead>
	
			<tbody>
				<%
					ArrayList<EmpleadoReporte> lista = (ArrayList<EmpleadoReporte>) request.getAttribute("lista");
					Iterator<EmpleadoReporte> itera = lista.iterator();
					EmpleadoReporte obj = null;
					
					while(itera.hasNext()){
						obj = itera.next();
				    %>
			
					<tr>
						<td class="text-center"><%=obj.getCod_empleado()%></td>
						<td class="text-center"><%=obj.getNombre() %></td>
						<td class="text-center"><%=obj.getApellidos() %></td>
						<td class="text-center"><%=obj.getDni() %></td>
						<td class="text-center"><%=obj.getTelefono() %></td>
						<td class="text-center"><%=obj.getDistrito() %></td>
						<td class="text-center"><%=obj.getCargo() %></td>
						<td class="text-center"><%=obj.getEstado() %></td>
						
						
						<%-- AL PARECER EL VALOR DEL OBJETO CODIGO CALZADO LO OBTIENE PERO AL MANDARLO AL METODO EN AJAX NO LO PUEDE USAR, 
						     PIENSO QUE TALVEZ PODRIA SER POR EL TIPO DE DATO POR ESO LE AGREGE LAS COMILLAS SIMPLES Y FUNCIONO
						     ---> YA ENTENDIIIII--- LOS NUMERO NO NECESITAN COMILLAS POR LO QUE UN VALOR NUMERICO DENTRO DE LOS PARENTECIS
						     	 					SIEMPRE SABRAN QUE ES UN PARAMETRO CUYO VALOR ES NUMERICO, PERO UN VALOR DE TIPO STRING 
						     	 					DENTRO DE LOS PARENTESIS PUEDE HACER REFERENCIA A UNA VARIABLE DENTRO DE LA MISMA PAGINA 
						     	 					POR LO QUE SI QUIERES TOMAR EL VALOR COMO EL MISMO PARAMETRO QUE SE ENVIA DEBES 
						     	 					AGREGARLE LAS COMILLAS PARA AVISARLES QUE ESTE ES EL VALOR QUE QUIERES QUE SE ENVIE
						     	 					COMO EN MYSQL, TODO PARAMETRO DE CADENA DEBE IR DENTRO DE COMILLAS PERO LOS NUMEROS NO ES 
						     	 					OPCIONAL PORQUE LAS VARIABLES NO SE PUEDEN DEFINIR SOLO CON NUMEROS --%>
						<%-- ACA ABAJO HABIA UNA LINEA DE CODIGO A LA LINEA 73, PERO ESTABA COMENTADO, PERO LA PARTE DEL VALOR DEL OBJETO SE VEIA EN 
							 BLANCO COMO SI NO ESTUVIERA COMENTADO, ESTO EVITABA QUE SE EJECUTARA TODA LA VISTA, AL PARECER PORQUE EL METODO NO EXISTIA
							 PERO LO RARO ES QUE "PERO SI ESTABA COMENTADOOOOOOOOOOOOOOOOOOOOOOO" 
							 ---> YA LO ENTENDIII-- ES PORQUE LA PARTE BLANCA QUIERE DECIR QUE ESA PARTE NO ESTABA COMENTADO ENREALIZAD PORQUE ERA CODIGO
							 	                    JAVA DENTRO DEL COMENTARIO QUE SI ESTABA FUNCIONANDO PERO AL ESE CODIGO TENER UN METODO QUE NO EXISTE
							 	                    TODO ES JODIA--%>
						<td class="text-center">
						<a class="btn btn-outline-warning" href="javascript:;" onclick="mostrarEditarEmpleado('<%=obj.getCod_empleado()%>')">Editar</a>
							<a class="btn btn-outline-danger" href="javascript:;" onclick="eliminarEmpleado('<%=obj.getCod_empleado()%>');" >Eliminar</a>
						</td>
					</tr>
				
				    <%
					}
				%>
			
			</tbody>
		</table>