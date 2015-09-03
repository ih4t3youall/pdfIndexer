<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script>
	
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
				alert('Error: ' + e);
			}
		});
		
		
	}
	
	function eliminarDiaCompleto(dia){
		
		
		$.ajax({
			type : "POST",
			traditional : true,
			url : "eliminarDirectorio.htm",
			data : "path="+dia,

			success : function(response) {
				$('.box').empty();
				$('.box').append(response);

			},
			error : function(e) {
				alert('Error: ' + e);
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