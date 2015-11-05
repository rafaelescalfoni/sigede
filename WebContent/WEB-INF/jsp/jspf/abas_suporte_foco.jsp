<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<div class="panel-heading">
		<ul class="nav nav-tabs">
			<li><a href="<c:url value="/admin/suporte/usuario"/>">USUÁRIOS</a></li>
			<li><a href="<c:url value="/admin/suporte/area"/>">ÁREA</a></li>
			<li><a href="<c:url value="/admin/suporte/status"/>">STATUS USUÁRIO</a></li>
			<li><a href="<c:url value="/admin/suporte/tipodemanda"/>">TIPO DEMANDA</a></li>
			<li><a href="<c:url value="/admin/suporte/tiporelatorioaudin"/>">RELATÓRIO AUDIN</a></li>
			<li><a href="<c:url value="/admin/suporte/tiporelatoriodo"/>">RELATÓRIO DEMAIS ÓRGÃOS</a></li>
			<li><a href="<c:url value="/admin/suporte/ano"/>">ANO</a></li>
			<li class="active"><a href="<c:url value="#"/>">FOCO</a></li>
			<li><a href="<c:url value="/admin/suporte/unidadeauditada"/>">UNIDADE AUDITADA</a></li>
			<li><a href="<c:url value="/admin/suporte/natureza"/>">NATUREZA</a></li>
			<li><a href="<c:url value="/admin/suporte/colegiado"/>">COLEGIADO</a></li>
			<li><a href="<c:url value="/admin/suporte/areatematica"/>">ÁREA TEMÁTICA</a></li>
			<li><a href="<c:url value="/admin/suporte/unidade"/>">UNIDADE</a></li>
			<li><a href="<c:url value="/admin/suporte/statusregistro"/>">STATUS REGISTRO</a></li>
		</ul>
	</div>