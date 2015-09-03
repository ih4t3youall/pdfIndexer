

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





<title>eTracking</title>

<script type="text/javascript">
	function esconder() {

		$('#contenedor_principal').hide();

	}

	function camposEnter(funcion) {

		$(".camposEnter").keydown(function(event) {

			if (event.keyCode == 13) {
				event.preventDefault();
				window[funcion]();
			}

		});

	}

	function sinEspacios() {

		$(".sinEspacios").keydown(function(event) {

			if (event.keyCode == 32) {
				event.preventDefault();
			}

		});

	}

	function mostrar() {
		$('#contenedor_principal').show();

	}

	function home() {
		$('#contenedor_secundario').empty();
		mostrar();
	}

	function logout() {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "j_spring_security_logout",

			success : function(response) {
				// we have the response
				url = "welcome.htm";
				$(location).attr('href', url);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function altaUsuario() {

		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "altaUsuario.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function generarClaves() {

		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "generarClaves.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function resultadoHistorico() {

		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "historialBusquedas.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function cortaPagina() {

		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "cortaPagina.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function verClavesNoUtilizadas() {

		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "verClavesNoUtilizadas.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function eliminarArchivos() {

		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "listarArchivos.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function opciones() {
		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "opciones.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}

	function aceptarArchivos() {
		esconder();
		$.ajax({
			type : "POST",
			traditional : true,
			url : "aceptarArchivos.htm",

			success : function(response) {
				$("#contenedor_secundario").html(response);

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});

	}
	
	function aceptarUsuariosTemporales(){
		
		esconder();
		$('#contenedor_secundario').empty();
		$.ajax({

			url : "aceptarUsuariosTemporales.htm",
			context : document.body
		}).done(function(response) {
			$("#contenedor_secundario").html(response);
		});
		
		
	}
	
	function eliminarArchivos(){
		
		
		esconder();
		$('#contenedor_secundario').empty();
		$.ajax({

			url : "eliminarArchivos.htm",
			context : document.body
		}).done(function(response) {
			$("#contenedor_secundario").html(response);
		});
		
		
	}

	function agregarUsuario() {
		esconder();
		$('#contenedor_secundario').empty();
		$.ajax({

			url : "agregarUsuario.htm",
			context : document.body
		}).done(function(response) {
			$("#contenedor_secundario").html(response);
		});

	}

	function lupa() {

		esconder();
		$('#contenedor_secundario').empty();
		$.ajax({

			url : "buscador.htm",
			context : document.body
		}).done(function(response) {
			$("#contenedor_secundario").html(response);
		});

	}

	function upload() {

		esconder();
		$('#contenedor_secundario').empty();
		$.ajax({

			url : "upload.htm",
			context : document.body
		}).done(function(response) {
			$("#contenedor_secundario").html(response);
		});

	}

	function cambiarContrasenia() {

		esconder();
		$('#contenedor_secundario').empty();
		$.ajax({

			url : "cambiarContrasenia.htm",
			context : document.body
		}).done(function(response) {
			$("#contenedor_secundario").html(response);
		});

	}
</script>
</head>
<body class="metro">




	<div class="navigation-bar">
		<div class="navigation-bar-content container">
			<a class="element" href="welcome.htm"><span class="icon-grid-view"></span>
				eTraking <sup>1.0-beta</sup></a> <span class="element-divider"></span> <a
				href="welcome.htm" class="element1 pull-menu"></a>
			<ul class="element-menu">
				<li><a href="#" class="dropdown-toggle">Buscar</a>
					<ul data-role="dropdown" class="dropdown-menu ">
						<li><a onclick="lupa();">Buscar en diarios</a></li>
<!-- 						<li><a class="dropdown-toggle">Busquedas anteriores</a> -->
<!-- 							<ul data-role="dropdown" class="dropdown-menu "> -->
<!-- 								<li><a onClick="resultadoHistorico()">Historico</a></li> -->
<!-- 							</ul> -->
<!-- 							</li> -->
					</ul></li>

				<li><a href="#" class="dropdown-toggle">Usuario</a>
					<ul data-role="dropdown" class="dropdown-menu ">
						<li><a onclick="cambiarContrasenia()">Cambiar
								contrase&ntilde;a</a></li>
					</ul></li>



				<c:if test="${username eq 'root'}">

					<li><a href="#" class="dropdown-toggle">Administrar</a>
						<ul data-role="dropdown" class="dropdown-menu ">
							<li><a class="dropdown-toggle" href="#">Archivos</a>
								<ul data-role="dropdown" class="dropdown-menu ">
									<li><a onclick="upload()"> Subir archivos</a></li>
									<li><a onclick="eliminarArchivos()"> Eliminar Archivos</a></li>
									<li><a onclick="aceptarArchivos()">Aceptar Archivos</a></li>
<!-- 									<li><a onclick="eliminarArchivos()">Eliminar archivos</a></li> -->
									<li><a onclick="agregarUsuario();">Agregar Usuario</a></li>
									<li><a onclick="altaUsuario();">Dar Usuario de
											alta/baja</a></li>
											<li><a onclick="aceptarUsuariosTemporales();">Usuarios temporales</a></li>
									<li><a onclick="generarClaves();">Generar claves</a></li>
									<li><a onclick="verClavesNoUtilizadas();">Ver claves
											no utilizadas</a></li>
								</ul></li>
						</ul></li>

				</c:if>
			</ul>

			<div class="element no-display">
				<a class="fg-yellow" href="one-page-example.html">Big Example</a>
			</div>

			<div class="no-tablet-portrait no-phone">
				<span class="element-divider place-right"></span> <span
					class="element-divider place-right"></span> <span
					class="element-divider place-right"></span> <span
					class="element-divider place-right"></span>


				<ul class="element-menu place-right">



					<li><a href="#" class="dropdown-toggle"><span
							class="icon-share-2">&nbsp;&nbsp;</span>${username}</a>
						<ul data-role="dropdown" class="dropdown-menu ">
							<li><a onclick="logout();">Deslogearse</a></li>
						</ul></li>
					<li>
						<ul>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</ul>

					</li>

				</ul>




			</div>
		</div>
	</div>

	<div id="contenedor_principal"></div>

	<div id="contenedor_secundario">
		<%-- 	<jsp:include page="../resultados/resultadoHistorico2.jsp" flush="true" /> --%>
	</div>







</body>
</html>