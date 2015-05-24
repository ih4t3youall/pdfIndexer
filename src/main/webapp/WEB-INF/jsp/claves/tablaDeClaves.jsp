<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
</head>
<body>

					<table class="table striped">
						<thead>
							<tr>
								<th class="text-left">Codigo</th>
								<th class="text-left">Dias</th>
								<th class="text-left">Usado</th>
								<th class="text-left">Tipo Usuario</th>
								<th class="text-left">Usado</th>

							</tr>
						</thead>

						<tbody>
									<c:forEach items="${listaCodigosDTO}" var="codigos">
							<tr>
								<td>${codigos.codigo}</td>
								<td class="right">${codigos.dias}</td>
								<td class="right">${codigos.usado}</td>
								<td class="right">${codigos.idTipoUsuario}</td>
								<td class="right">${codigos.usado}</td>
							</tr>
						</c:forEach>
							
						</tbody>

						<tfoot></tfoot>
					</table>
</body>
</html>