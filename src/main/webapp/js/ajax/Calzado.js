

// Funcion listar

function listarCalzado(){
	$.ajax({
		url:'./calzado',
		type: 'GET',
		data: 'accion=listar', 
		success:function(data){ 
			$('#divContenedor').html(data); 
		}, 									
		error:function(data,xml){}
		
	});
}


// Funcion buscar

function buscarCalzado(){
		
		var formData = {
			accion: 'buscar',
			valor: $("#valor").val()
		};
		$.ajax({
			url:'./calzado',
			type: 'GET',
			data: formData,
			success:function(data){
				$('#divContenedor').html(data);
			},
			error:function(data,xml){}
			
		});

}


// Funcion Mostrar pagina para agregar producto

function mostrarAddCalzado(){
	$.ajax({
		url:'./calzado',
		type: 'GET',
		data: 'accion=add',
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
		
	});
}

function agregarCalzado(){
		var formData = {
			accion: 'agregar',
			txt_codigo_calzado : $("#txt_codigo_calzado").val(),
			cbo_modelo : $("#cbo_modelo").val(),
			txt_talla : $("#txt_talla").val(),
			txt_color : $("#txt_color").val(),
			txt_stock : $("#txt_stock").val(),
		};
		$.ajax({
			url:'./calzado',
			type: 'GET',
			data: formData,
			success:function(data){
				$('#divContenedor').html(data);
			},
			error:function(data,xml){}
			
		});

}

//function mostrarEditarCalzado(cod_calzado){
function mostrarEditarCalzado(cod_calzado){
	$.ajax({
		url:'./calzado',
		type: 'GET',
		data: 'accion=editar&cod_calzado='+cod_calzado,
		success:function(data){
			$('#divContenedor').html(data);
		},
		error:function(data,xml){}
		
	});
}


function actualizarCalzado(){
		var formData = {
			accion: 'actualizar',
			
			txt_codigo_calzado : $("#txt_codigo_calzado").val(),
			cbo_modelo : $("#cbo_modelo").val(),
			txt_talla : $("#txt_talla").val(),
			txt_color : $("#txt_color").val(),
			txt_stock : $("#txt_stock").val(),
		};
		$.ajax({
			url:'./calzado',
			type: 'GET',
			data: formData,
			success:function(data){
				$('#divContenedor').html(data);
			},
			error:function(data,xml){}
			
		});

}







