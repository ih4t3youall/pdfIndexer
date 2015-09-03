<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/960.css">

<script src="resources/jquery-ui/js/jquery-1.9.1.js"></script>


<link rel="stylesheet"
	href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>

<style type="text/css">
#navegador ul {
	list-style-type: none;
	text-align: left;
	background-color: #208DFF;
	padding-left: 162px;
}

#navegador li {
	display: inline;
	text-align: center;
}

#navegador li a {
	padding: 2px 7px 2px 7px;
}

.menuN {
	height: 50px;
	!
	important
}

span {
	color: #208DFF;
}

#acomodaRegistro {
	height: 30px;
	padding-left: 29px;
}

P { text-indent: 15px }

</style>

<script>
	function porqueEtracking() {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "porqueEtracking.htm",
			datatype : "text/jason",
			success : function(response) {
				$('#contenedorSecundario').empty();
				$('#contenedorSecundario').append(response);

			},
			error : function(response) {
				console.log(response);
			}

		});

	}

	function bienvenido() {

		$.ajax({

			type : "POST",
			traditional : true,
			url : "bienvenido.htm",
			datatype : "text/jason",
			success : function(response) {

				$('#contenedorSecundario').empty();
				$('#contenedorSecundario').append(response);

			},
			error : function(e) {

				console.log(e);

			}

		});

	}

	function pruebe() {

		$.ajax({
			type : "POST",
			traditional : true,
			url : "pruebe.htm",
			datatype : "text/json",
			success : function(response) {

				$('#contenedorSecundario').empty();
				$('#contenedorSecundario').append(response);

			},
			error : function(e) {
				console.log(e);
			}
		});

		document.getElementById("derecha").style.padding = "50px 10px 20px 30px";

	}

	function compre() {

	}
</script>


</head>

<body>





	<!-- nuevo menu -->





	<jsp:include page="../fueraLogin/menu.jsp" flush="true" />
	<!-- fin nuevo menu  -->



	<div class="container_12">
		<div class="grid_10">
			<img width="1000px" src="resources/imagenes/login/head.png" />
		</div>
		<div class="grid_2"></div>

	</div>


	<div id="contenedorSecundario">

		<jsp:include page="../fueraLogin/bienvenido.jsp" flush="true" />

	</div>
	<div class="clear"></div>
	<div class="container_12">
		<div class="grid_12">
			<img src="resources/imagenes/login/footer.png" alt="Smiley face"></a>
		</div>

	</div>


</body>

</html>