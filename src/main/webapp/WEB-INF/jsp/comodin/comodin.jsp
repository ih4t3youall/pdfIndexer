
<html>
<head>
<script src="resources/metrostyle/jquery/jquery.js"
	type="text/javascript"></script>
	
	<script src="resources/pdfObject/pdfobject.js"
	type="text/javascript"></script>
	<script src="resources/Highlight/highlight.js"></script>

<!-- <META HTTP-EQUIV="REFRESH" CONTENT="5;URL=cargarPDF.htm">  -->
<script>
$(document).ready(function() {

	
	var pdf = new PDFObject({
		  url: "visualizarPdf.htm",
		  id: "pdfRendered",
		  pdfOpenParams: {
		    view: "FitH"
		  }
		}).embed("pdfRenderer");
	
	$('#formulario').submit();
	
});




</script>

<style>
.highlight {
background-color: #FFFF88;
}
</style>
</head>

<body>


<form action="visualizarPdf.htm" id ="formulario"></form>
<div id="pdfRenderer"></div>

</body>

</html>