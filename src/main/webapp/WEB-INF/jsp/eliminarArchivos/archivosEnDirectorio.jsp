<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script>
	function eliminarArchivo(nombreArchivo,carpeta){
		console.log(nombreArchivo);
		console.log(carpeta);
		
		
		$.ajax({
			type : "POST",
			traditional : true,
			url : "eliminarArchivo.htm",
			data : "nombreArchivo="+nombreArchivo+"&carpeta="+carpeta,
			success : function(response){
			alert(response);	
			},
			error : function(e){
				alert('Error: ' + e);
			}
			
			
		});
		
		
	}
	
</script>




			<p>Seleeccione archivo a borrar</p>

<c:forEach items="${files}" var="item">
<input type="button" onClick="eliminarArchivo('${item}','${path}')" value="${item}" />
   

</c:forEach>

<input  type="button" onClick="eliminarArchivos()" value="volver" />