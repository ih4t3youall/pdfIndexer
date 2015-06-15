<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
	$(document).ready(function() {

		$('.datepicker').datepicker({
			format : "yyyy/mm/dd", // set output format
			effect : "fade", // none, slide, fade
			position : "bottom", // top or bottom,
			locale : 'en',
		});

		$('.datepicker').datepicker().init();

	});

	function agregarFechaHoy(doc) {

		$.ajax({
			url : "agregarFechaHoy.htm",
			data : "documento=" + doc,

		}).done(function(response) {
			respuesta = response;
		});

	}

// 	function agregarFechaModificada(doc, fecha) {
// 		$.ajax({
// 			url : "agregarFechaADocumento.htm",
// 			data : "documento=" + doc + "&fecha=" + fecha,

// 			success : function(response) {
// 				// 				$(".box").empty();
// 				// 				$(".box").html(response);
// 				alert('terminado');
// 			}
// 		});
// 	}
	
	//va con data
	function agregarFechaModificada(doc, fecha) {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "agregarFechaADocumento.htm",
			data : "documento=" + doc + "&fecha=" + fecha,
			
		});

	}
	
// 	va con data
	function doAjaxPost() {
		//TODO 
		var fechas = $('.calendario');
		$(fechas).each(function(index, item) {

			var fecha = $(item).find('input').val();
			var doc = $(item).find('.documento').text();

			agregarFechaModificada(doc, fecha);

		});
		
		agregadoConExito();

		

	}
	
	function agregadoConExito(){
		$.ajax({
			type : "POST",
			traditional : true,
			url : "agregarDocumentosExito.htm",
			success : function(response){
				
				$("#contenedor_secundario").empty();
				$("#contenedor_secundario").append(response);
				
			}
			
			
			
		});
		
		
	}
	
</script>



<div class="grid">
	<div class="row">
		<div class="span6 offset3 example box">

			<p>Si la fecha es la del dia, solo presione aceptar</p>
			<table class="table striped">
				<thead>
					<tr>
						<th class="text-left">fecha_inclusion</th>
						<th class="text-left">ubicacion</th>

					</tr>
				</thead>

				<tbody>
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="archivo" items="${buscar.archivos}">

						<tr class="calendario">
							<td>
								<div class="datepicker input-control text"
									data-role="datepicker"">
									<input type="text">
									<button class="btn-date"></button>
								</div>


							</td>
							<td class="right documento">${archivo}</td>
						</tr>
						<c:set var="count" value="${count + 1}" scope="page" />
					</c:forEach>
				</tbody>

				<tfoot></tfoot>
			</table>
			<input type="button" value="Aceptar" onClick="doAjaxPost()" />


		</div>
	</div>
</div>