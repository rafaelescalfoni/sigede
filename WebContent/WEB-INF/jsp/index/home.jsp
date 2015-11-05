<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script src="<c:url value="/js/bootstrap-confirmation.js"/>" type="text/javascript"></script>
	</head>
	<body>
		
		<c:import url="../jspf/cabecalho.jsp"></c:import>
		
		<div class="container">
			<div class="col-md-8">
				<h2>Bem-vindo ao SIGEDE</h2>
				<p>
					Esta é a tela inicial do SIGEDE (Sistema de Geranciamento de
					Demandas). <br> Você pode cadastrar e consultar suas demandas
					através do ícone correspondente no menu do topo.
				</p>
				<br>
				<p>
					<b>Inicie cadastrando suas demandas.</b>
				</p>
				<br> <br>
				<div class="form-group">
					<a href="<c:url value="/audin/audinfiocruz"/>"
						class="btn btn-success btn-large"> <i
						class="glyphicon glyphicon-plus"></i> COMEÇAR A CADASTRAR DEMANDAS
					</a> <br>
				</div>
			</div>
		</div>
		<!-- div row conteudo -->
	</body>
</html>
