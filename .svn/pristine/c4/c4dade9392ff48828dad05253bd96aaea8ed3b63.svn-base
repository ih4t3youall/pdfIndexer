
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
	var array = new Array();

	$("input").change(function() {

		var resp = isAdded($(this).val());

		if (resp == -1) {
			var marca = new marcados($(this).val(), $(this).is(':checked'));
			array.push(marca);

		} else {

			array[resp].selector = $(this).is(':checked');

		}

	});

	function isAdded(nombre) {
		var flag = -1;
		for ( var i = 0; i < array.length; i++) {

			if (nombre == array[i].nombreUsuario)
				flag = i;

		}
		return flag;

	}

	function marcados(unNombreUsuario, unSelector) {

		this.nombreUsuario = unNombreUsuario;
		this.selector = unSelector;

	}

	function actualizar() {
var flag = true;
		for ( var i = 0; i < array.length; i++) {
		$.ajax({
			type :"POST",
			traditional : true,
			url :"actualizarEstadoUsuario.htm",
			"async": true,
			data : "nombreUsuario="+array[i].nombreUsuario+"&enabled="+array[i].selector,
			success : function(response){
				
				
			},
			error : function(e){
				flag= false;
			}
		});
			
			
		}
		if(flag)
	alert('Cambios realizados correctamente');		

	}
	
	function eliminarUsuario(usuario){
		
		
		$.ajax({
			type : "POST",
			traditional :true,
			url : "eliminarUsuario.htm",
			data : "nombreUsuario="+usuario,
			success : function(response){
				
			$('#'+usuario+'').remove();	
				
			},error : function(e){
				alert('error consulte a su administrador codigo 1');
			}
			
		});
		
		
	}
	
</script>
<div class="grid">
		<div class="row">
			<div class="span6 offset4">
${usuarios}
</div></div></div>
<input type="button" onClick="actualizar()" value="Confirmar Cambios" />