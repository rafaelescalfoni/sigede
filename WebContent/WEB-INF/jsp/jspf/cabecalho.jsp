<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#myNavbar">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/home"/>"> <img
								src="<c:url value="/img/SIGEDE.png" />" alt="">
						</a></li>
						<li><a href="<c:url value="/demandas/audinfiocruz"/>">DEMANDAS </a></li>
						<li><a href="<c:url value="/relatorios/areatematica"/>">RELATÓRIOS </a></li>
						<li><c:if test="${userSession.usuario.perfil eq 'Administrador' }">
								<a href="<c:url value="/admin/suporte/usuario"/>">SUPORTE </a>
							</c:if></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" 
								role="button" aria-haspopup="true" aria-expanded="false">
								<span class="glyphicon glyphicon-user"></span>
								${userSession.usuario.nome}
							</a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="<c:url value="#"/>">Perfil</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="<c:url value="/logout"/>">Sair</a></li>
							</ul>
						</li>
						<li><a href="<c:url value="/logout"/>"> <span class="glyphicon glyphicon-log-out"></span>
								Sair
						</a></li>
					</ul>
				
			</div>
		</nav>