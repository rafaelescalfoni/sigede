<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<c:import url="../jspf/abas_suporte_status.jsp"></c:import>
					<div class="tab-content">
						<div class="tab-pane fade in active" id="tab1primary">
							<div class="container-fluid">
								<div class="tab-content">
									<br>
									<div class="form-group">
										<a href="<c:url value="/admin/status/cadastrar_status"/>"
											class="btn btn-success"> <i
											class="glyphicon glyphicon-plus"></i> CADASTRAR STATUS DO USUÁRIO
										</a> <br>
									</div>
								</div>
								<div class="tab-content2">
									<h4>CONSULTA POR STATUS DO USUÁRIO</h4>
								</div>
								<form class="form-inline" role="form">
									<!-- Select Basic -->
									<div class="tab-content3">
										<div class="form-group">
											<div class="control-label">
												<label>SELECIONE O STATUS</label>
											</div>
											<select class="form-control">
												<option value=""></option>
												<option value="">Ativo</option>
												<option value="">Inativo</option>
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
													<th>NOME</th>
													<th>EDITAR</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${statusList}" var="status">
													<tr>
														<td>${status.nome}</td>
														<td><a href="<c:url value="/admin/suporte/status/${status.id}/update"/>">
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