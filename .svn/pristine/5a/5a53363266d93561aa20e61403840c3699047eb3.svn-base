<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">

<script src="resources/jquery-ui/js/jquery-1.9.1.js"></script>


<link rel="stylesheet" href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>


</head>

<body  onload='document.f.j_username.focus();'>



<c:if test="${not empty error}">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>


	<div class="container_12">

		<img src="resources/imagenes/login/head.png" />


	</div>
	<div class="clear"></div>

	<div class="container_12">


		<div class="grid_6">
			<div id="parrafo" style="padding-top: 75px;">
				<p>        Diariamente periódicos y revistas proporcionan información sobre hechos, personas, temas, empresas,
				 marcas o instituciones, cuya presencia en medios impacta en su imagen y reputación.</p>
				 
				 
				<p>Periodistas de radio, televisión y sitios web, consultan los medios  impresos por la credibilidad que 
				éstos tienen y porque su formato  sigue siendo el más adecuado para tratar con holgura todo tipo de temas. 
				Por ello, estar oportunamente informado de lo que dicen los principales medios impresos de su país es fundamental. </p>
				<p>      Sin embargo, la inmediatez, rigurosidad y la enorme cantidad de  páginas a leer que exige la revisión de 
				TODO lo que publican, hace que este trabajo sea imposible de realizar para el ojo humano sin errores y cuando se necesita.</p>
				
				<p>  Por ello, eTraking® le ofrece un motor de búsqueda que lee en segundos y palabra por palabra todo el
				 contenido de diarios y revistas de su interés.</p>
				 
				 
				 <p>Todos los días a partir de las ocho de la mañana con eTraking® usted podrá encontrar en
				  cuestión de segundos, todo lo que periódicos y revistas digan sobre su marca, competencia, empresa, 
				  tema o persona de su interés. </p>
			</div>
		</div>

		<div class="grid_2">

			<img src="resources/imagenes/login/barra.png"
				style="padding-left: 100px; height: 500px; padding-top: 77px;" />

		</div>

		<div class="grid_4">

			<br /> <br /> <br /> <br />
			
			<form class="metro" name='f' action="<c:url value='j_spring_security_check' />"
			method='POST'>
			
			 <img style="width: 310px"
				src="resources/imagenes/login/semanagratis.png" />
			<p>usuario</p>
			<div data-role="input-control" class="input-control text"><input style="width: 200px"
						class="form-control input-sm texto" type='text'  placeholder="type text" name='j_username'
						value=''>
						  <button tabindex="-1" class="btn-clear" type="button"></button>
						  </div>
			<p>contrase&ntilde;a</p>
			<div data-role="input-control" class="input-control password"><input autofocus="" placeholder="type password" style="width: 200px"
						class="form-control input-sm texto" type='password'
						name='j_password' />  <button tabindex="-1" class="btn-reveal" type="button"></button></div>
			
			
			
			 <br />
			 <input class="btn btn-primary btn-sm"
						name="submit" type="submit" value="submit" />
						<label><a href="crearCuenta.htm">Crear cuenta</a></label>

		</div>
</form>
	</div>
	<div class="clear"></div>

	<div class="container_12">


		<img src="resources/imagenes/login/footer.png">



	</div>

</body>

</html>