<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script src="resources/jquery.confirm-master/jquery.confirm.js" type="text/javascript"></script>
<script src="resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="resources/bootstrap-3.3.5-dist/css/bootstrap.min.css">

<script>
	function eliminarArchivo(nombreArchivo,carpeta){
		console.log(nombreArchivo);
		console.log(carpeta);
		
		$.confirm({
		    text: "Seguro que desea eliminar el archivo?",
		    confirm: function() {
		    	$.ajax({
					type : "POST",
					traditional : true,
					url : "eliminarArchivo.htm",
					data : "nombreArchivo="+nombreArchivo+"&carpeta="+carpeta,
					success : function(response){
						$('.box').empty();
						$('.box').append(response);
						$('.box').append('</br>');
						$('.box').append('<input  type="button" onClick="eliminarArchivos()" value="volver" />');	
					},
					error : function(e){
						alert('Error: ' + e);
					}
					
					
				});
		        
		    },
		    cancel: function() {
		        
		    }
		});
		
		
		
		
	}
	
</script>




			<p>Seleeccione archivo a borrar</p>

<c:forEach items="${files}" var="item">
<input type="button" onClick="eliminarArchivo('${item}','${path}')" value="${item}" />
   

</c:forEach>

<input  type="button" onClick="eliminarArchivos()" value="volver" />