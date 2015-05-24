
<div class="grid">
	<div class="row">



		<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		<script>
			$(document).ready(function() {

			});

			$(document)
					.ready(
							function() {
								//add more file components if Add is clicked
								$('#addFile')
										.click(
												function() {
													var fileIndex = $('#archivos')
															.children().length;
													$('#archivos')
															.append(
																	'<tr><td>'
																			+ '   <input  type="file" name="files['+ fileIndex +']" />'
																			+ '</td></tr>');
													actualizar();
												});

								$('#removeFile').click(
										function() {
											$("#archivos").find("input")
													.last().remove();
											actualizar();
										});

							});

			function actualizar() {
				$("#numero").text($("#archivos").find("input").length);
			}
		</script>

		<div class="grid">
			<div class="row">
				<div class="span6 offset3 example">
					<form:form id="form" method="post" action="save.htm"
						modelAttribute="uploadForm" enctype="multipart/form-data">
						<fieldset>
							<legend>Subiar archivos</legend>
							<label>Seleccione los archivos a subir, si desea precione
								el "+" para agregar otro.</label> <input type="button" value="+"
								class="button default" id="addFile"> <input
								type="button" value="-" class="button default" id="removeFile">
								<div id="archivos"></div>


							<br>
							<button onclick="$('#form').submit();" class="shortcut"
								style="margin-top: 10; height: 65px; width: 70px;">
								<i class="icon-upload-2"></i> Upload <small id="numero"
									class="bg-cobalt fg-white">0</small>
							</button>
						</fieldset>
					</form:form>

				</div>
			</div>
		</div>




	</div>

</div>

