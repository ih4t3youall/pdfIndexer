<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script src="resources/jquery.confirm-master/jquery.confirm.js" type="text/javascript"></script>
<script src="resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>

<link rel="stylesheet" href="resources/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script>
$( document ).ready(function() {
    
	
	
	
});

	function seleccioneDia(dia){
		
	

		$.ajax({
			type : "POST",
			traditional : true,
			url : "listarArchivosEndirectorio.htm",
			data : "path="+dia,

			success : function(response) {
				$('.box').empty();
				$('.box').append(response);

			},
			error : function(e) {
				alert('Error: ' + e);s
			}
		});
		
		
	}
	
	function eliminarDiaCompleto(dia){
		
		$.confirm({
		    text: "Seguro que desea eliminar el dia completo?",
		    confirm: function() {
		    	$.ajax({
					type : "POST",
					traditional : true,
					url : "eliminarDirectorio.htm",
					data : "path="+dia,

					success : function(response) {
						$('.box').empty();
						$('.box').append(response);
						$('.box').append('</br>');
						$('.box').append('<input  type="button" onClick="eliminarArchivos()" value="volver" />');

					},
					error : function(e) {
						alert('Error: ' + e);
					}
				});
		        
		    },
		    cancel: function() {
		        
		    }
		});
		
		
	}
	
	
</script>



<div class="grid">
	<div class="row">
		<div class="span6 offset3 example box">

			<p>Seleeccione dia</p>

<c:forEach items="${files}" var="item">
<input type="button" onClick="seleccioneDia('${item.getName()}')" value="${item.getName()}" />
   

</c:forEach>

<p>Borrar dia completo</p>
<c:forEach items="${files}" var="item">
<input type="button" onclick="eliminarDiaCompleto('${item.getName()}')"value="${item.getName()}" />
   

</c:forEach>  

		</div>
	</div>
</div>