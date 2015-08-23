<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">

<script src="resources/jquery-ui/js/jquery-1.9.1.js"></script>


<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>

<style type="text/css">
#navegador ul {
	list-style-type: none;
	text-align: left;
	background-color: #208DFF;
	padding-left: 162px;
}

#navegador li {
	display: inline;
	text-align: center;
}

#navegador li a {
	padding: 2px 7px 2px 7px;
}

.menuN {
	height: 50px;
	!
	important
}

span {
	color: #208DFF;
}

#acomodaRegistro {
	height: 30px;
	padding-left: 29px;
}

#left {
	float: left;
	padding-left: 354px;
	width: 825px;
}

#right {
	float: right;
	padding-top: 80px;
}
</style>

<script>
	function porqueEtracking() {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "porqueEtracking.htm",
			datatype : "text/jason",
			success : function(response) {
				$('#contenedorSecundario').empty();
				$('#contenedorSecundario').append(response);

			},
			error : function(response) {
				console.log(response);
			}

		});

	}

	function bienvenido() {

		$.ajax({

			type : "POST",
			traditional : true,
			url : "bienvenido.htm",
			datatype : "text/jason",
			success : function(response) {

				$('#contenedorSecundario').empty();
				$('#contenedorSecundario').append(response);

			},
			error : function(e) {

				console.log(e);

			}

		});

	}

	function pruebe() {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "pruebe.htm",
			datatype : "text/json",
			success : function(response) {

				$('#contenedorSecundario').empty();
				$('#contenedorSecundario').append(response);

			},
			error : function(e) {
				console.log(e);
			}
		});

		document.getElementById("derecha").style.padding = "50px 10px 20px 30px";

	}

	function compre() {

	}
</script>


</head>

<body onload='document.f.j_username.focus();'>



	<c:if test="${not empty error}">
		<div class="errorblock">
			Error de usuario y contraseña por favor intente nuevamente.<br />
			Causado por:
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>

	<!-- nuevo menu -->


	<jsp:include page="../fueraLogin/menu.jsp" flush="true" />



	<!-- fin nuevo menu  -->



	<div class="container_12">
		<div class="grid_10">
			<img width="1000px" src="resources/imagenes/login/head.png" />
		</div>
		<div class="grid_2"></div>

	</div>
	<div class="clear"></div>


	<div id="contenedorSecundario">




		<div class="clear"></div>
		<%-- <jsp:include page="../fueraLogin/login.jsp" flush="true" /> --%>


		<div id="contenedorSecundario">
	<div id="left">
		<form class="metro" name='f'
						action="<c:url value='j_spring_security_check' />" method='POST'>

						<a href="pedirClave.htm"><img style="width: 310px"
							src="resources/imagenes/login/semanagratis.png" /></a>
						<p>usuario</p>
						<div data-role="input-control" class="input-control text">
							<input style="width: 200px" class="form-control input-sm texto"
								type='text' placeholder="type text" name='j_username' value=''>
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<p>contrase&ntilde;a</p>
						<div data-role="input-control" class="input-control password">
							<input autofocus="" placeholder="type password"
								style="width: 200px" class="form-control input-sm texto"
								type='password' name='j_password' />
							<button tabindex="-1" class="btn-reveal" type="button"></button>
						</div>



						<br /> <input class="btn btn-primary btn-sm" name="submit"
							type="submit" value="Ingresar" /> <label><a
							href="crearCuenta.htm">Crear cuenta</a></label>
				</div>
				</form>
	</div>
	<div id="right">
		<img src="resources/imagenes/pantallasNuevoMenu/diarioConBarra.png" />
	</div>
</div>

	</div>

</body>

</html>