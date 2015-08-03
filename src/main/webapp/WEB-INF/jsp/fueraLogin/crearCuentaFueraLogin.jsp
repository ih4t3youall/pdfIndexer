<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">

<script src="resources/jquery-ui/js/jquery-1.9.1.js"></script>


<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>



</head>

<body class="metro">
	<div class="grid">
		<div class="row">
			<div class="span6 offset4">
				<div class="example">


					<form:form commandName="usuarioDTO" action="crearCuentaConClave.htm">
						<br>
						<label>Usuario</label>
						<form:input type="text" path="nombreUsuario" />
						<br>
						<label>Password</label>
						<form:input type="password" path="passwd" />
						<br>
						<Label>Codigo Verificador</Label>
						<form:input type="text" path="codigoVerificador" />
						<br>
						<input type="submit" value="Submit"/>
					</form:form>
					<input type="button" value="volver"onClick="location.href = 'welcome.htm' "/>



				</div>
			</div>
		</div>
	</div>
</body>

</html>