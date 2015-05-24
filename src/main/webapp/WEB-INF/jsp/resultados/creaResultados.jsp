<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<a href="#"onclick="home()"><i class="icon-arrow-left-3 fg-lighter large"></i></a>


<c:forEach items="${lista.archivos}" var="archivoBusqueda">
<div class="panel panel-primary">


 <div class="panel-heading">
                <h3 class="panel-title">Nombre archivo: ${archivoBusqueda.nombre}</h3>
              </div>

<c:forEach items="${archivoBusqueda.resultados}" var="listaresultados">
 <div class="panel-body">

<p>la palabra se encontro en la pagina ${listaresultados.pagina}, ${listaresultados.vecesEncontrado} veces 

<c:forEach items="${listaresultados.resultado}" var="textoResultados">
${textoResultados} 

</c:forEach>  
</div>

  

</c:forEach>  
</div>
</c:forEach>

              

              