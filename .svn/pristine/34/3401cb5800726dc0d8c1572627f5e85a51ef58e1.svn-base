<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>


<meta http-equiv="Refresh" content="10;welcome.htm">

<script src="resources/metrostyle/jquery/jquery.js" type="text/javascript"></script>
<link rel="stylesheet" href="resources/Metro-UI-CSS-master/css/metro-bootstrap.css">

<script src="resources/Metro-UI-CSS-master/jquery.widget.min.js"></script>
<script src="resources/Metro-UI-CSS-master/min/metro.min.js"></script>
<script src="resources/Metro-UI-CSS-master/js/metro-dropdown.js"></script>

    <title>Spring MVC Multiple File Upload</title>
</head>
<body class="metro">
    
    <legend>Los siguientes archivos se subieron correctamente al servidor.</legend>
    <legend>Se redireccionara automaticamente.</legend>
    
    <div class="listview small">
    <ol>
        <c:forEach items="${files}" var="file">
<%--             <li>${file}</li> --%>
                   <a class="list" href="#">
                                        <div class="list-content">
                                            <img class="icon" src="resources/imagenes/iconos/pdf.png">
                                            <div class="data">
                                                <span class="list-title">${file}</span>
                                               
                                            </div>
                                        </div>
                                    </a>
        </c:forEach>
    </ol>
    </div>
<a href="welcome.htm"><button class="button inverse">Volver</button></a>

    
    
</body>
</html>