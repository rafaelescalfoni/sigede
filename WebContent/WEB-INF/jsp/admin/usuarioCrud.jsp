<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>SIGEDE</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet">
<script src="<c:url value="/js/.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/jquery.js"/>"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/js/bootstrap.js"/>"></script>
<script src="<c:url value="/js/bootstrap-confirmation.js"/>"
	type="text/javascript"></script>
</head>
<body>
	<c:import url="../jspf/cabecalho.jsp"></c:import>
	<div class="container">
		<div class="col-md-12">
			<div class="panel with-nav-tabs panel-primary">
				<c:import url="../jspf/abas_suporte_usuarios.jsp"></c:import>				
				<div class="tab-content">
					<div class="tab-pane fade in active" id="tab1primary">
						<div class="container-fluid">
							<div class="tab-content">
								<br>
								<div class="form-group">
									<a href="<c:url value="/admin/usuario/cadastrar_usuario"/>"
										class="btn btn-success"> <i
										class="glyphicon glyphicon-plus"></i> CADASTRAR USUÁRIO
									</a> <br>
								</div>
							</div>
							<div class="tab-content2">
								<h4>CONSULTA POR USUÁRIOS</h4>
							</div>
							<form class="form-inline" role="form">
								<!-- Select Basic -->
								<div class="tab-content3">
									<div class="form-group">
										<div class="control-label">
											<label>SELECIONE O USUÁRIO</label>
										</div>
										<select class="form-control">
											<option value=""></option>
											<option value="">Agnaldo Ferreira Moraes da Rocha</option>
											<option value="">Felipe da Silva Góis</option>
											<option value="">Diogo Finizola</option>
											<option value="">Diogo FinizolaDiogo FinizolaDiogo
												FinizolaDiogo FinizolaDiogo FinizolaDiogo Finizola</option>
										</select>
									</div>
									<button type="button" class="btn btn-info">
										<span class="glyphicon glyphicon-search"></span> BUSCAR
									</button>
									<br>
									<br>
								</div>
								<br>
								<div class="container-fluid">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>DATA DE CADASTRO</th>
												<th>NOME</th>
												<th>E-MAIL</th>
												<th>TELEFONE</th>
												<th>ÁREA</th>
												<th>PERFIL</th>
												<th>STATUS</th>
												<th>EDITAR</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${usuarioList}" var="usuario">
												<tr>
													<td>
														<fmt:formatDate pattern="dd/MM/yyyy hh:mm:ss" value="${usuario.data_cadastro}" />
													</td>
													<td>${usuario.nome}</td>
													<td>${usuario.email}</td>
													<td>${usuario.telefone}</td>
													<td>${usuario.area.nome}</td>
													<td>${usuario.perfil}</td>
													<td>${usuario.status.nome}</td>
													<td><a
														href="<c:url value="/admin/suporte/usuario/${usuario.id}/update"/>">
															<button type="button" class="btn btn-success">
																<span class="glyphicon glyphicon-pencil"></span>
															</button>
													</a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		</script>
</body>
</html>