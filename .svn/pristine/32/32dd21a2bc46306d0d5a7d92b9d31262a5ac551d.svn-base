
<script src="resources/Highlight/highlight.js"></script>
<script src="resources/Highlight/highthlight2.js"></script>

<script type="text/javascript">
<!--
$( document ).ready(function() {
	$('.accordion').accordion().init();
	$('.tab-control').tabcontrol().init();
	


	jQuery(function(){
		var options = {
			exact:"partial",
			keys:"Quanto"
		}
		jQuery(document).SearchHighlight(options);
	});
	


	$('.accordion-frame').each(function( index,item ) {
		var terminos = $(item).find('.terminos').text().split(',');
		var remarcar = $(item).find('.contenido');
		$(terminos).each(function(index,item){
		if(item != " "){
		$(remarcar).highlight($.trim(item));
		}
		});
		});

	
	
});



function generarPDF(contexto){
	var index =$(contexto).attr('index');
	var documento =$(contexto).attr('documento');
	var idBusqueda = $(contexto).attr('termino');
	var palabra = $(contexto).attr('palabra');
	
	$.ajax({
		type : "POST",
		traditional : true,
		async : false,
		url : "peticionPDF.htm",
		data : "index=" + index+"&documento="+documento+"&idBusqueda= "+idBusqueda+"&palabra="+palabra ,
		
	});
	
	
	var url = 'comodin.htm';
	var win=window.open(url, '_blank');
	

	
	
	
	
	}


//-->
</script>

<style>
.highlight {
background-color: #FFFF88;
}


</style>
<style type='text/css'>
 span.hilite {background:yellow}
</style>


${contenido}

