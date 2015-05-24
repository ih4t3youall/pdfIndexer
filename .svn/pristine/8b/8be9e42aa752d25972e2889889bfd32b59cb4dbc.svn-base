
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>



$( document ).ready(function() {
$('.password').inputControl();
	});

function validar(){
	
		var passwd = $('.nPasswd');

	
	if ($(passwd[0]).val() == $(passwd[1]).val() && $(passwd[0]).val().trim() != "" && $(passwd[1]).val().trim() != ""){
	
		$.ajax({
			type : "POST",
			traditional : true,
			url : "changePasswd.htm",
			data : "contrasenia="+$(passwd[0]).val(),
			success : function(response) {
				// we have the response
				

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
		
	}else {
	alert('las contrase&ntilde;as no coinciden.');
	}
}
	

</script>


<body class="metro">
	<div class="grid">
		<div class="row">
			<div class="span4 offset4">
	<div class="example">
                                 		<form:form method="post" name="busqueda" id="cambiarContrasenia" 
 			action="changePasswd.htm" modelAttribute="usuarioDTO"> 
                                    <fieldset>
                                        <legend>Cambio de contrase&ntilde;a.</legend>
                                        <label>Ingrese Contrase&ntilde;a actual</label>
                                        <div data-role="input-control" class="input-control password">
                                            <input type="password" autofocus="" placeholder="type password">
                                            <button tabindex="-1" class="btn-reveal" type="button"></button>
                                        </div>
                                        <label>Ingrese Contrase&ntilde;a nueva.</label>
                                        <div data-role="input-control" class="input-control password">
                                            <input  class="nPasswd" type="password" autofocus="" placeholder="type password">
                                            <button tabindex="-1" class="btn-reveal" type="button"></button>
                                        </div>
                                        <label>Repita la nueva Contrase&ntilde;a.</label>
                                        <div data-role="input-control" class="input-control password">
                                            <input path="usuarioDTO.passwd" class="nPasswd" type="password" autofocus="" placeholder="type password">
                                            <button tabindex="-1" class="btn-reveal" type="button"></button>
                                        </div>
                                        

                                        <input type="button" onClick="validar()" value="Cambiar Contrase&ntilde;a">
                                    </fieldset>
                                </form:form>
                            </div>
                            </div>
                            </div>
                            </div>

