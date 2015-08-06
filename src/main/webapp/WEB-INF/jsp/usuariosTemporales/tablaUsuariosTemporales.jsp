<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<!-- modal  -->

<link type='text/css' href='resources/modal/css/demo.css' rel='stylesheet' media='screen' />

<!-- Contact Form CSS files -->
<link type='text/css' href='resources/modal/css/basic.css' rel='stylesheet' media='screen' />

<!-- IE6 "fix" for the close png image -->
<!--[if lt IE 7]>
<link type='text/css' href='css/basic_ie.css' rel='stylesheet' media='screen' />
<![endif]-->

<!-- JS files are loaded at the bottom of the page -->
  <script type='text/javascript' src='resources/modal/js/jquery.js'></script>
<script type='text/javascript' src='resources/modal/js/jquery.simplemodal.js'></script>
<script type='text/javascript' src='resources/modal/js/basic.js'></script>

<!-- fin modal -->



<link rel="stylesheet" type="text/css" href="resources/DataTables/media/css/jquery.dataTables.min.css"  />


	<script src="resources/metrostyle/jquery/jquery.js"
	type="text/javascript"></script>
	<script type="text/javascript" src="resources/DataTables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#example').DataTable();
} );


function modal(){
	
	var nombreUsuario="maria";
	
	$.ajax({
		type : "POST",
		traditional : true,
		url : "crearMailConCodigo.htm",
		data : "nombreUsuario="+maria,
		success : function(response) {
			// we have the response
			alert(response);

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	
	
}

</script>
</head>
<body>
<body><table id="example" class="display" width="100%" cellspacing="0">
  <thead>
            <tr>
                <th>nombre de usuario</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Razon social</th>
                <th>Telefono</th>
                <th>ruc</th>
                <th>mail</th>
                <th>Autogenerar mail</th>
            </tr>
        </thead>
 
        <tbody>
        <c:forEach var="usuario" items="${usuarioDTO}">

        <tr>
                <td>${usuario.nombreUsuario}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.apellido}</td>
                <td>${usuario.razonSocial}</td>
                <td>${usuario.telefono}</td>
                <td>${usuario.ruc}</td>
                <td>${usuario.mail}</td>
                <td><input type="button" onclick="modal()" value="Crear Mail"></td>
            </tr>
						
					</c:forEach>
        
        </tbody>

</body>

</html>