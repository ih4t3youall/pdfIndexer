<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>

$(document).ready(function(){
	$('.input-control').inputControl();
	
	$("#dias").keydown(function(event) {
		   if(event.shiftKey)
		   {
		        event.preventDefault();
		   }
		 
		   if (event.keyCode == 46 || event.keyCode == 8)    {
		   }
		   else {
		        if (event.keyCode < 95) {
		          if (event.keyCode < 48 || event.keyCode > 57) {
		                event.preventDefault();
		          }
		        }
		        else {
		              if (event.keyCode < 96 || event.keyCode > 105) {
		                  event.preventDefault();
		              }
		        }
		      }
		   });
	
	
});

function generarLote(){
	
	
	if($('#cantidadClaves').length == 0){
	
	$('.example').append(' <div id="divCantidadClaves" data-role="input-control" class="input-control text">   <input id="cantidadClaves" type="text" placeholder="Cantidad de claves">    <button tabindex="-1" class="btn-clear" type="button"></button></div>');
	
	$("#cantidadClaves").keydown(function(event) {
		   if(event.shiftKey)
		   {
		        event.preventDefault();
		   }
		 
		   if (event.keyCode == 46 || event.keyCode == 8)    {
		   }
		   else {
		        if (event.keyCode < 95) {
		          if (event.keyCode < 48 || event.keyCode > 57) {
		                event.preventDefault();
		          }
		        }
		        else {
		              if (event.keyCode < 96 || event.keyCode > 105) {
		                  event.preventDefault();
		              }
		        }
		      }
		   });
	
	$('.input-control').inputControl();
	
	}else {
		
		$('#divCantidadClaves').remove();	
		
	}
	
}


function generar(){
	
	var dias = $('#dias').val();
	var tipo = $('#combo').val();
	
	if (dias != '' && tipo != 'Seleccione...'){
		var flag =$('#generarLote').is(":checked");
	if(!flag){
	
	$.ajax({
		
		type : "POST",
		traditional : true,
		url : "generadorClave.htm",
		data : "dias="+dias+"&tipo="+tipo,
		success : function (response){
			
			$('#claveGenerada').val(response);
			$.Notify({style: {background: 'white', color: 'black'}, content: "La clave se genero con exito."});	
		},
		error : function (e){
			alert('Error: ' + e);
			
			$.Notify({style: {background: 'red', color: 'white'}, content: 'Se produjo un error, contacte un Administrador: ' + e});
		}
	});
	
	}else {
		
		var cantidadClaves =$('#cantidadClaves').val();
		
		$.ajax({
			
			type : "POST",
			traditional : true,
			url : "generadorClavesPorLote.htm",
			data : "dias="+dias+"&tipo="+tipo+"&cantidad="+cantidadClaves,
			success : function (response){
				
				$('.example').empty();
				$('.example').append(response);
				
				$.Notify({style: {background: 'white', color: 'black'}, content: "La clave se genero con exito."});	
			},
			error : function (e){
				alert('Error: ' + e);
				
				$.Notify({style: {background: 'red', color: 'white'}, content: 'Se produjo un error, contacte un Administrador: ' + e});
			}
		});
		
	}
	
	
	}else {
		$.Notify({style: {background: 'red', color: 'white'}, content: "Debe completar todos los campos."});
		
	}
	
}

</script>

<div class="grid">
	<div class="row">
		<div class="span6 offset4">
			<div class="example">

<label>Dias de prueba</label>
				<div data-role="input-control" class="input-control text">
				
					<input id="dias" type="text" placeholder="Solo numeros">
					<button tabindex="-1" class="btn-clear" type="button"></button>
				</div>
				<br/>
				<div data-role="input-control" class="input-control select">
					<select id="combo">
						<option>Seleccione...</option>

						<c:forEach items="${tipo_usuarios}" var="item">
							<option>${item}</option>
						</c:forEach>

					</select>
				</div>

				<div data-role="input-control"
					class="input-control checkbox margin10">
					<label> <input id="generarLote" onchange="generarLote()" type="checkbox">
						<span class="check"></span> Generar lote
					</label>
				</div>


				<input type="submit" value="generar" onclick="generar()">
				<div id="cantDias" data-role="input-control" class="input-control text">
					<input id="claveGenerada" type="text" readonly value="Aqui aparecera la calve generada.">

				</div>





			</div>

		</div>
	</div>
</div>