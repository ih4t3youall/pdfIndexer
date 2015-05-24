<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar en pagina</title>

	

</head>
<body>

	<form:form method="post" name="busqueda" id="busqueda"
		action="doBuscar.htm" modelAttribute="buscar">

		<p>Palabra a buscar:</p>
		<form:input path="texto" id="textoID" />


		<td colspan="2"><input type="submit" value="Cargar" /></td>

	</form:form>
</body>
</html>