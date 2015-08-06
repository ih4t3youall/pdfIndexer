<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">

<script src="resources/jquery-ui/js/jquery-1.9.1.js"></script>


<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-accordion.js"></script>
<script src="resources/jquery/notify.min.js" type="text/javascript"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('.input-control').inputControl();
});

function validarMail() {
	var textos = $('.ntext');
	if ($(textos[6]).val().indexOf('@', 0) == -1
			|| $(textos[6]).val().indexOf('.', 0) == -1) {
		return false;
	} else {
		return true;
	}

}

function validar() {
	var passwd = $('.npasswd');
	var textos = $('.ntext');

	var existeUsuario = false;

	//existe usuario
	$.ajax({
		type : "POST",
		traditional : true,
		async : false,
		url : "existeUsuario.htm",
		data : "nombreUsuario=" + $(textos[0]).val(),
		success : function(response) {

			existeUsuario = response;

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});

	if (existeUsuario == 'false') {

		if (validarMail()) {

			if ($(passwd[0]).val() == $(passwd[1]).val()
					&& $(passwd[0]).val().trim() != ""
					&& $(passwd[1]).val().trim() != "") {

				$.ajax({
					type : "POST",
					traditional : true,
					url : "regristoConBcp.htm",
					data : "passwd=" + $(passwd[0]).val()
							+ "&nombreUsuario=" + $(textos[0]).val()
							+ "&nombre=" + $(textos[1]).val()
							+ "&apellido=" + $(textos[2]).val()
							+ "&razonSocial=" + $(textos[3]).val()
							+ "&ruc=" + $(textos[4]).val() + "&telefono="
							+ $(textos[5]).val() + "&correoElectronico="
							+ $(textos[6]).val()+ "&bcp="
							+ $(textos[7]).val(),

					success : function(response) {
						$('.metro').empty();
						$('.metro').append(response);

					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});

			} else {

				$.notify("Las contrase&ntilde;as no coinciden.", {
					position : "top-left"
				});
			}
		} else {
			$.notify("El mail que ingreso no es valido", {
				position : "top-left"
			});

		}
	} else {
		$.notify("Ya existe ese usuario, por favor seleccione otro.", {
			position : "top-left"
		});

	}
}


</script>
</head>

<body class="metro">
	<div class="grid">
		<div class="row">
			<div class="span6 offset4">
				<div class="example">
					<div class="cell">
							<div data-closeany="false" data-role="accordion"
								class="accordion span3 place-left margin10">
								<div class="accordion-frame">
									<a href="#" class="heading  collapsed">Ya tengo cuenta!</a>
									<div class="content" style="display: none;">

										<form:form commandName="usuarioDTO"
											action="crearCuentaConClave.htm">
											<br>
											<label>Usuario</label>
											<form:input type="text" path="nombreUsuario" />
											<br>
											<label>Password</label>
											<form:input type="password" path="passwd" />
											<br>
											<br>
											<input type="submit" value="Submit" />
										</form:form>




									</div>
								</div>
								<div class="accordion-frame">
									<a href="#" class="heading  collapsed">No tengo cuenta.</a>
									<div class="content" style="display: none;">

										<jsp:include page="../fueraLogin/formularioCrearCuentaConBcp.jsp" flush="true" />
							
							


									</div>
								</div>
							</div>



					</div>
				</div>
				<input type="button" value="volver" onClick="location.href = 'welcome.htm'"/>
			</div>
		</div>
</body>

</html>