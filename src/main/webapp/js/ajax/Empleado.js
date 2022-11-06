

// Funcion listar


function listarEmpleado(){
	$.ajax({
		url:'./empleado',
		type: 'GET',
		data: 'accion=listar', 
		success:function(data){ 
			$('#divContenedor').html(data); 
		}, 									
		error:function(data,xml){}
		
	});
}


// Funcion buscar

function buscarEmpleado(){
		
		var formData = {
			accion: 'buscar',
			valor: $("#valor").val()
		};
		$.ajax({
			url:'./empleado',
			type: 'GET',
			data: formData,
			success:function(data){
				$('#divContenedor').html(data);
			},
			error:function(data,xml){}
			
		});

}

// Funcion Mostrar pagina para agregar producto

function mostrarAddEmpleado(){
	$.ajax({
		url:'./empleado',
		type: 'GET',
		data: 'accion=add',
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
		
	});
}

// 		alert($('#txt_estado').is(":checked"));  --> para testear prueba con checked
// si al cheched pones "val()" te devuelve on-off segun sea el caso
// si al cheched pones "is(":checked")" te devuelve true-false segun sea el caso
function agregarEmpleado(){
		var formData = {
			accion: 'agregar',
			txt_codigo_empleado: $("#txt_codigo_empleado").val(),
			txt_nombre: $("#txt_nombre").val(),
			txt_apellidos: $("#txt_apellidos").val(),
			txt_dni: $("#txt_dni").val(),
			txt_direccion: $("#txt_direccion").val(),
			txt_telefono: $("#txt_telefono").val(),
			txt_email: $("#txt_email").val(),
			cbo_distrito: $("#cbo_distrito").val(),
			cbo_cargo: $("#cbo_cargo").val(),
			txt_estado: $("#txt_estado").is(":checked"),
		};
		$.ajax({
			url:'./empleado',
			type: 'GET',
			data: formData,
			success:function(data){
				$('#divContenedor').html(data);
			},
			error:function(data,xml){}
			
		});

}


//function mostrarEditarCalzado(cod_calzado){
function mostrarEditarEmpleado(cod_empleado){
	$.ajax({
		url:'./empleado',
		type: 'GET',
		data: 'accion=editar&cod_empleado='+cod_empleado,
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
		
	});
}

function actualizarEmpleado(){
		var formData = {
			accion: 'actualizar',
			txt_codigo_empleado: $("#txt_codigo_empleado").val(),
			txt_nombre: $("#txt_nombre").val(),
			txt_apellidos: $("#txt_apellidos").val(),
			txt_dni: $("#txt_dni").val(),
			txt_direccion: $("#txt_direccion").val(),
			txt_telefono: $("#txt_telefono").val(),
			txt_email: $("#txt_email").val(),
			cbo_distrito: $("#cbo_distrito").val(),
			cbo_cargo: $("#cbo_cargo").val(),
			txt_estado: $("#txt_estado").is(":checked"),
		};
		$.ajax({
			url:'./empleado',
			type: 'GET',
			data: formData,
			success:function(data){
				$('#divContenedor').html(data);
			},
			error:function(data,xml){}
			
		});

}












