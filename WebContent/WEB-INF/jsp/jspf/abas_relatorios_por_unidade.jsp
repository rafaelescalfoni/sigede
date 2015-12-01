<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="panel-heading">
	<ul class="nav nav-tabs">
		<li><a href="<c:url value="/relatorios/areatematica"/>">POR ÁREA TEMÁTICA</a></li>
		<li><a href="<c:url value="/relatorios/statusregistro"/>">POR STATUS</a></li>
		<li class="active"><a href="<c:url value="#"/>">POR UNIDADE</a></li>
	</ul>
</div>