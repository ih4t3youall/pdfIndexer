
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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


<script>
	function validarContrasenia() {

		var passwd = $('.npasswd');

		var codigo = $('#codigoVerificador').val();
		
		var codigoAceptado = false;
		
		//verificar codigo 
		$.ajax({
			
			type : "POST",
			traditional : true,
			url : "verificarCodigo.htm",
			async: false,
			data : "codigo="+codigo,
			success : function (response){
				codigoAceptado = response;
				
			}
			
		});
		
		
		
		if (codigoAceptado){
		
		if ($(passwd[0]).val() == $(passwd[1]).val()) {

			$.ajax({
				type : "POST",
				traditional : true,
				async: false,
				url : "existeUsuario.htm",
				data : "nombreUsuario=" + $('#username').val(),
				success : function(response) {
					
					if(response =="false" ){
						
			$('#formulario').submit();
						
					}else {
						
						$('#divUsername').addClass('error-state');
						 $.Notify({style: {background: 'red', color: 'white'}, content: "El nombre de usuario ya existe."});
					}
					
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
		}
			

		}else{
			
			$.Notify({style: {background: 'red', color: 'white'}, content: "Error en el codigo de verificacion."});
			$('#codigoVerificador').css('color','red');
		}

	}
</script>
</head>

<body class="metro">


	<div class="grid">
		<div class="row">
			<div class="span6 offset4">
				<div class="example">
					<fieldset>
						<legend>Crear Cuenta</legend>
						<label>Nombre usuario</label>
						<form:form method="post" name="cargaUsuario" id="formulario"
							action="doAgregarUsuario.htm" modelAttribute="usuarioDTO">

							<div class="input-control text" id="divUsername" data-role="input-control">
								<form:input type="text" path="nombreUsuario" id="username" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Nombre</label>
							<div class="input-control text" data-role="input-control">
								<form:input type="text" path="nombre" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Apellido</label>
							<div class="input-control text" data-role="input-control">
								<form:input type="text" path="apellido" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Direccion</label>
							<div class="input-control text" data-role="input-control">
								<form:input type="text" path="direccion" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Telefono</label>
							<div class="input-control text" data-role="input-control">
								<form:input type="text" path="telefono" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Empresa</label>
							<div class="input-control text" data-role="input-control">
								<form:input type="text" path="empresa" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Mail</label>
							<div class="input-control text" data-role="input-control">
								<form:input type="text" path="mail" placeholder="type text"
									class="ntext"/>
								<button type="button" class="btn-clear" tabindex="-1"></button>
							</div>
							<label>Password</label>
							<div class="input-control password" data-role="input-control">
								<form:input type="password" path="passwd" placeholder="type"
									autofocus="" class="npasswd"/>
								<button type="button" class="btn-reveal" tabindex="-1"></button>
							</div>
							<label>Repita Password</label>
							<div class="input-control password" data-role="input-control">
								<form:input type="password" path="" placeholder="type " autofocus=""
									class="npasswd"/>
								<button type="button" class="btn-reveal" tabindex="-1"></button>
							</div>
							
							<label>Codigo Verificador</label>
							<div class="input-control password" data-role="input-control">
								<form:input id="codigoVerificador" type="text" path="codigoVerificador" placeholder="type " autofocus=""
									/>
								<button type="button" class="btn-reveal" tabindex="-1"></button>
							</div>
							
					</fieldset>
				</div>

				<div>

					<input type="button" onclick="validarContrasenia()" value="aceptar"
						onclick="validar()"/>
					</form:form>


				</div>

			</div>
		</div>
	</div>
	</div>
</body>
</html>