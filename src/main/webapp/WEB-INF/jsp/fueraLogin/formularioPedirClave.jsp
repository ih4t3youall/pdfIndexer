<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="resources/metrostyle/jquery/jquery.js"
	type="text/javascript"></script>


<!-- Metro-UI-CSS-master -->
<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>
<script src="resources/jquery/notify.min.js" type="text/javascript"></script>

<!--  calendar -->
<script
	src="resources/Metro-UI-CSS-master/docs/js/metro/metro-calendar.js"></script>
<script
	src="resources/Metro-UI-CSS-master/docs/js/metro/metro-datepicker.js"></script>
<!-- fin calendar -->
<!--  fin Metro-UI-CSS-master -->
<!--  calendar -->
<script
	src="resources/Metro-UI-CSS-master/docs/js/metro/metro-calendar.js"></script>
<script
	src="resources/Metro-UI-CSS-master/docs/js/metro/metro-datepicker.js"></script>
<!-- fin calendar -->

<script>
	
</script>


<title>eTracking</title>

<script>
	$(document).ready(function() {
		$('.input-control').inputControl();
	});

	
	function validarMail(){
		var textos = $('.ntext');
		if($(textos[6]).val().indexOf('@', 0) == -1 || $(textos[6]).val().indexOf('.', 0) == -1) {  
	        return false;  
	    }  else {
	    return true;  
	    }
		
	}
	
	function validar() {
		var passwd = $('.npasswd');
		var textos = $('.ntext');
		
		var existeUsuario= false;
		
		
		
		//existe usuario
		$.ajax({
			type : "POST",
			traditional : true,
			async: false,
			url : "existeUsuario.htm",
			data : "nombreUsuario=" +$(textos[0]).val() ,
			success : function(response) {
				
				existeUsuario=response;
				
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
		
		
		
		if(existeUsuario == 'false'){

		if (validarMail()) {

			if ($(passwd[0]).val() == $(passwd[1]).val()
					&& $(passwd[0]).val().trim() != ""
					&& $(passwd[1]).val().trim() != "") {

				$.ajax({
					type : "POST",
					traditional : true,
					url : "registroDePrueba.htm",
					data : "passwd=" + $(passwd[0]).val() + "&nombreUsuario="
							+ $(textos[0]).val() + "&nombre="
							+ $(textos[1]).val() + "&apellido="
							+ $(textos[2]).val() + "&razonSocial="
							+ $(textos[3]).val() + "&ruc=" + $(textos[4]).val()
							+ "&telefono=" + $(textos[5]).val()
							+ "&correoElectronico=" + $(textos[6]).val(),
							
					success : function(response) {
						$('.metro').empty();
						$('.metro').append(response);
						

					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});

			} else {
				
				$.notify(
						"Las contrase&ntilde;as no coinciden.", 
				  { position:"top-left" }
				);
			}
		} else {
			$.notify(
					"El mail que ingreso no es valido", 
			  { position:"top-left" }
			);

		}
		}else {
			$.notify(
					"Ya existe ese usuario, por favor seleccione otro.", 
			  { position:"top-left" }
			);
			
			
		}
	}
</script>
</head>
<body class="metro">
	<div class="grid">
		<div class="row">
			<div class="span6 offset4">
				<div class="example">
					<form>
						<fieldset>
							<legend>Agregar Usuario</legend>
							<label>Nombre usuario</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>
							<label>Password</label>
							<div data-role="input-control" class="input-control password">
								<input class="npasswd" type="password" autofocus=""
									placeholder="type">
								<button tabindex="-1" class="btn-reveal" type="button"></button>
							</div>
							<label>Repita Password</label>
							<div data-role="input-control" class="input-control password">
								<input class="npasswd" type="password" autofocus=""
									placeholder="type ">
								<button tabindex="-1" class="btn-reveal" type="button"></button>
							</div>


							<label>Nombre</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>
							<label>Apellido</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>
							<label>Razon social</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>
							<label>R.U.C.</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>
							<label>Telefono</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>
							<label>Correo electronico</label>
							<div data-role="input-control" class="input-control text">
								<input type="text" class="ntext" placeholder="type text">
								<button tabindex="-1" class="btn-clear" type="button"></button>
							</div>

						
				</div>

				<div>

					<input type="button" onclick="validar()" value="aceptar" )/>
					</fieldset>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>