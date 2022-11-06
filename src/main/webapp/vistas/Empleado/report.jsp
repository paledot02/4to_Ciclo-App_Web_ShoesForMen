<%@page import="net.sf.jasperreports.engine.data.JRBeanCollectionDataSource"%>
<%@page import="net.sf.jasperreports.engine.JREmptyDataSource"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>
<%@page import="entidad.EmpleadoReporte"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<EmpleadoReporte> lista = (ArrayList<EmpleadoReporte>)request.getAttribute("lista"); 

	File jasper = new File(application.getRealPath("reportes/reporte_empleado.jasper"));
	
	Map<String, Object> parametros = new HashMap<String,Object>();
	parametros.put("DATAEmpleado", new JRBeanCollectionDataSource(lista));
	String imagen = "logo_reporte.png"; // añadimos la imagen por su nombre completo
	parametros.put("imagen_logo","../img/" + imagen);
// 	parametros.put("imagen_logo","\\img\\" + imagen); // por alguna razon marca error cuando se coloca de la siguiente forma: "/img/cc.jpg"
	parametros.put("nombre_empresa","SHOES FOR MEN");
	parametros.put("direccion_empresa","AV. URUGUAY N 389 ");
	parametros.put("distrito_empresa","SAN ISIDRO");
	parametros.put("nombre_empleado","KEVIN BASILIO");
	parametros.put("ruc_empresa","12345678901");
	
	byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, new JREmptyDataSource());
	
	response.setContentType("application/pdf");
	response.setContentLength(bytes.length);
	
	ServletOutputStream output = response.getOutputStream();
	output.write(bytes,0,bytes.length);
	output.flush();
	output.close();

%>
</body>
</html>