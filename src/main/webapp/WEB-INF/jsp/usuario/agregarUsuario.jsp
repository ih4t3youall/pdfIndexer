<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	$(document).ready(function() {
		$('.input-control').inputControl();
	});

	function validar() {
		var passwd = $('.npasswd');
		var queseyo = $(passwd[0]).val();
		var textos = $('.ntext');

		if($('#combo').val() != 'Seleccione...'){
		
		if ($(passwd[0]).val() == $(passwd[1]).val()
				&& $(passwd[0]).val().trim() != ""
				&& $(passwd[1]).val().trim() != "") {

			$.ajax({
				type : "POST",
				traditional : true,
				url : "addUser.htm",
				data : "passwd=" + $(passwd[0]).val() + "&nombreUsuario="
						+ $(textos[0]).val() + "&nombre=" + $(textos[1]).val()
						+ "&apellido=" + $(textos[2]).val() + "&direccion="
						+ $(textos[3]).val() + "&telefono="
						+ $(textos[4]).val() + "&empresa=" + $(textos[5]).val()
						+ "&mail=" + $(textos[6]).val()
						+ "&tipo_usuario="+$('#combo').val(),
				success : function(response) {
					alert(response);
					window.location.href = "welcome.htm";

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

		} else {
			alert('las contrase&ntilde;as no coinciden.');
		}
		}else{
			alert('Debe seleccionar un tipo de usuario.');
			
			
		}
	}
</script>

<div class="grid">
	<div class="row">
		<div class="span6 offset4">
			<div class="example">
				<form>
					<fieldset>
						<legend>Agregar Usuario</legend>
						<label>Nombre usuario</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Nombre</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Apellido</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Direccion</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Telefono</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Empresa</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Mail</label>
						<div data-role="input-control" class="input-control text">
							<input type="text" class="ntext" placeholder="type text">
							<button tabindex="-1" class="btn-clear" type="button"></button>
						</div>
						<label>Password</label>
						<div data-role="input-control" class="input-control password">
							<input class="npasswd" type="password" autofocus=""
								placeholder="type">
							<button tabindex="-1" class="btn-reveal" type="button"></button>
						</div>
						<label>Repita Password</label>
						<div data-role="input-control" class="input-control password">
							<input class="npasswd" type="password" autofocus=""
								placeholder="type ">
							<button tabindex="-1" class="btn-reveal" type="button"></button>
						</div>


						<div data-role="input-control" class="input-control select">
							<select id="combo">
								<option >Seleccione...</option>

								<c:forEach items="${tipo_usuarios}" var="item">
									<option>${item}</option>
								</c:forEach>

							</select>
						</div>
						
						
			</div>

			<div>

				<input type="button" onclick="validar()" value="aceptar" )/>
				</fieldset>
				</form>
			</div>

		</div>
	</div>
</div>
