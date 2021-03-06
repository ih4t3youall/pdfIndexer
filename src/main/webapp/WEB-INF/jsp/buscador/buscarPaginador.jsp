<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>




 <script src="resources/jquery/notify.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var cantidadMaxima = 0;
	
	
	
	function cuandoCambia(){
		
		
		$('#archivos').empty();
		
		

		var dia = $("#combo :selected").text();

		$.ajax({
			type : "POST",
			traditional : true,
			url : "buscarArchivosEnCarpeta.htm",
		       data : "carpeta="+dia,
		        datatype : "text/json",


			success : function(response) {

		            $('#archivos').append(response);


			},
			error : function(e) {
		console.log(e);
			}
		});
		 
		
	}
	

	function acomodarAltura() {
		var altura = $('.texto').length * 40;

		$('#select').css('margin-top', altura + 'px');
	}

	$(document)
			.ready(
					function() {

						$('#combo').attr('data-hint-position', 'right');
						$('#combo')
								.attr(
										'data-hint',
										'Seleccion personalizada | Presione ctrl+click (mantenga ctrl) para seleccionar solamente los archivos que usted desee.');
						$("#combo").hint();
						
						
						
					});

	function eliminarCampo() {
		$('.texto').last().remove();
		$('#textos label').last().remove();

		acomodarAltura()
	}

	function agregarCampo() {

		var cant = $('.texto').length;

		if (cant < cantidadMaxima) {

			$('#textos')
					.append(
							'<label></label><input placeholder="tipear palabra" type="text" style="width:200px" class="camposEnter sinEspacios form-control input-sm texto" /> ');

			camposEnter('doAjaxPost');
		} else {

			alert('no puede ingresar mas de ' + cantidadMaxima
					+ ' nombres a buscar');

		}

		acomodarAltura();
		sinEspacios();

	}

	function cambio(contexto) {
		if ($('#tipo').val() == "Seleccione...") {

			$("#esconder").hide();

		} else {
			$("#esconder").show();
			$('.texto').remove();
			$('#textos label').remove();
			cantidadMaxima = $(contexto).find('option:selected').attr('numero');
			

			$("#cuadroBusqueda").notify(
					"Restan : " + cantidadMaxima + " Busquedas.", 
			  { position:"top-left" }
			);
			
// 			$.Notify({
// 				style : {
// 					background : 'blue',
// 					color : 'white',
// 					position:"left"
// 				},
// 				content : "Restan : " + cantidadMaxima + " Busquedas."
// 			});

		}

		cuandoCambia();
		
	}

	function doAjaxPost() {
		var terminos = [];
		var documentoSeleccionado = $('#combo option:selected').val();
		var archivos = [];

		$("#combo").each(function() {
			archivos.push($(this).val());
		});

		var aux = $('.texto');

		var combo = $('#tipo').val();

		for ( var i = 0; i < aux.length; i++) {
			if ($(aux[i]).val() != "") {
				terminos.push($(aux[i]).val());
			}
		}

		if (combo != 'Seleccione...' && terminos.length > 0) {
			//A�adimos la imagen de carga en el contenedor
			$('#contenedor_secundario').empty();
			$('#contenedor_secundario').append(
					'<div align="center"><img  src="resources/imagenes/loading.gif"/></div>');

			$.ajax({
				type : "POST",
				traditional : true,
				url : "buscarPaginasCortadas.htm",
				data : "tipoBusqueda=" + combo + "&terminos=" + terminos
						+ "&archivos=" + archivos,
				success : function(response) {
					// we have the response
					$('#contenedor_secundario').empty();
					$('#contenedor_secundario').append(response);

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

		} else {

			$.Notify({
				style : {
					background : 'red',
					color : 'white'
				},
				content : "Debe completar todos los campos.Presione + para agregar palabras."
			});

		}

	}
	
	
	

	

	
</script>

<div class="grid">


	<div class="row">
		<div id="cuadroBusqueda" class="span6 offset3 example">
			<!-- <div id="contenedor"> -->

			<form:form method="post" name="busqueda" id="busqueda"
				action="buscarPaginasCortadas.htm" modelAttribute="buscar">

				<legend>Tipo busqueda:</legend>
				<div data-role="input-control" class="input-control select">
					<select id="tipo" onchange="cambio(this)">
						<option>Seleccione...</option>
						<option numero="${restantes.diarias}">Diaria</option>
						<option numero="${restantes.semanales}">Semanal</option>
						<option numero="${restantes.mensuales}">Mensual</option>
					</select>
				</div>

				<div id="esconder" style="display: none">
					<legend>Palabra(s) a buscar:</legend>

					<input class="default danger" type="button" value="+"
						onclick="agregarCampo()"> <input class="default primary"
						type="button" value="-" onclick="eliminarCampo()">
					<div id="textos" class="input-control text"
						data-role="input-control"></div>



					<div id="select">
						<legend>Medios:</legend>
						
						
						<div class="grid">
						<div class="row">
						
						<div class="span1">
						
						<form:select path="archivos" onchange="cuandoCambia()" id="combo">
							<c:forEach var="equipo" items="${buscar.archivos}">

								<br />
       			${equipo}
						<form:option value="${equipo}" label="${equipo}" />
							</c:forEach>
						</form:select>
						
						</div>
						<div id="archivos" class="span1 offset1">
						
						
						
						</div>
						
						
						
						</div>
						</div>
						
					</div>
					<br /> <input type="button" class="default btn btn-primary"
						value="Buscar Palabra" onclick="doAjaxPost()">
				</div>







			</form:form>



		</div>
	</div>
</div>

