<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">

<script src="resources/jquery-ui/js/jquery-1.9.1.js"></script>


<link rel="stylesheet" href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>

<style type="text/css">
#navegador ul{
   list-style-type: none;
   text-align: left;
   background-color:#208DFF;
   padding-left: 162px;
}
#navegador li{
   display: inline;
   text-align: center;
  
}
#navegador li a {
   padding: 2px 7px 2px 7px;
   
}
.menuN{
height:50px;!important

}
span{
	color:#208DFF;
	}
#acomodaRegistro{
	
	 height: 30px;
    padding-left: 29px;
	}	


   </style>

<script>


function pruebe(){
	
	$.ajax({
		type : "POST",
		traditional : true,
		url : "pruebe.htm",
	        datatype : "text/json",
		success : function(response) {
	
			$('#parrafo').empty();
			$('#parrafo').append(response);
			
		},
		error : function(e) {
	console.log(e);
		}
	});
	
	$.ajax({
		type : "POST",
		traditional : true,
		url : "pruebeDerecha.htm",
	        datatype : "text/json",
		success : function(response) {
	
			$('#derecha').empty();
			$('#derecha').append(response);
			
		},
		error : function(e) {
	console.log(e);
		}
	});
	document.getElementById("derecha").style.padding = "50px 10px 20px 30px";
	
	
	
}

function compre(){
	
	
	
}

</script>


</head>

<body  onload='document.f.j_username.focus();'>



<c:if test="${not empty error}">
			<div class="errorblock">
				Error de usuario y contraseña por favor intente nuevamente.<br /> Causado por:
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>

<!-- nuevo menu -->





<div  id="navegador">
<ul>
<li><a href="#"><img class="menuN" src="resources/imagenes/imagenesMenu/bienvenido.png" alt="bienvenido" /></a></li>
<li><a href="#"><img class="menuN" src="resources/imagenes/imagenesMenu/porque.png" alt="porque nosotros" /></a></li>
<li><a href="#"><img class="menuN" src="resources/imagenes/imagenesMenu/comofunciona.png" alt="como funciona" /></a></li>
<li><a onclick="pruebe()" ><img class="menuN" src="resources/imagenes/imagenesMenu/pruebe.png" alt="pruebe" /></a></li>
<li><a onclick="compre()"><img class="menuN" src="resources/imagenes/imagenesMenu/compre.png" alt="compre" /></a></li>
<li><a href="#"><img class="menuN" src="resources/imagenes/imagenesMenu/conectese.png" alt="conectese" /></a></li>

</ul>
</div>
<!-- fin nuevo menu  -->



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

		<div id="derecha" class="grid_4">

			<br /> <br /> <br /> <br />
			
			<form class="metro" name='f' action="<c:url value='j_spring_security_check' />"
			method='POST'>
			
			 <a href="pedirClave.htm"><img style="width: 310px"
				src="resources/imagenes/login/semanagratis.png" /></a>
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
						name="submit" type="submit" value="Ingresar" />
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