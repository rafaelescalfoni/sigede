<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="col-md-12">
				<div class="panel with-nav-tabs panel-primary">
					<c:import url="../jspf/abas_demandas_audin.jsp"></c:import>
					<div class="tab-content">
						<div class="tab-pane fade in active" id="tab1primary">
							<div class="container-fluid">
								<div class="tab-content">
									<br>
									<div class="form-group">
										<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
											<a href="<c:url value="/audinfiocruz/cadastrar_audinfiocruz"/>" class="btn btn-success">
												<i class="glyphicon glyphicon-plus"></i>
												 CADASTRAR DEMANDA
											</a>
										</c:if>
										<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
											<a href="<c:url value="/audinfiocruz/cadastrar_audinfiocruz"/>" class="btn btn-success">
												<i class="glyphicon glyphicon-plus"></i>
												 CADASTRAR DEMANDA
											</a>
										</c:if>
										<br>
									</div>
								</div>
								<div class="tab-content2">
									<h4>CONSULTA POR RELATÓRIOS EMITIDOS PELA AUDITORIA INTERNA (AUDIN)</h4>
								</div>
								<form action="<c:url value="/demandas/audin/pesquisa" />" method="get">
									<div class="input-group h2">
										<input name="palavraChave" class="form-control" id="search" type="text" placeholder="Pesquisar...">
											<span class="input-group-btn">
												<button class="btn btn-primary" type="submit" value="Pesquisar">
													<span class="glyphicon glyphicon-search"></span>
												</button>
											</span>
									</div>
								</form>
								<form class="form-inline" role="form">
									<br>
									<div class="container-fluid">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>DESCRIÇÃO</th>
													<th>UNIDADE AUDITADA</th>
													<th>FOCO</th>
													<th>ASSUNTO</th>
													<th>STATUS</th>
													<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
														<th>NOVO</th>
													</c:if>
													<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
														<th>NOVO</th>
													</c:if>
													<th>EDITAR</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${registrodemandaaudinList}" var="registrodemandaaudin" >
													<tr>
														<td>${registrodemandaaudin.demandaaudin.tipodemandaaudin} de ${registrodemandaaudin.demandaaudin.tiporelatorioaudin} nº ${registrodemandaaudin.demandaaudin.num_demanda}/${registrodemandaaudin.demandaaudin.ano}</td>
														<c:if test="${registrodemandaaudin.demandaaudin.unidadeauditada eq null}">
															<td>Institucional</td>
														</c:if>
														<c:if test="${registrodemandaaudin.demandaaudin.unidadeauditada ne null}">
															<td>${registrodemandaaudin.demandaaudin.unidadeauditada}</td>
														</c:if>
														<c:if test="${registrodemandaaudin.demandaaudin.foco eq null}">
															<td>Em todas as áreas da Unidade</td>
														</c:if>
														<c:if test="${registrodemandaaudin.demandaaudin.foco ne null}">
															<td>${registrodemandaaudin.demandaaudin.foco}</td>
														</c:if>
														<td>${registrodemandaaudin.assunto}</td>
														<td>${registrodemandaaudin.statusregistro}</td>
														<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
															<td>
																<a href="<c:url value="/demandas/audinfiocruz/registro/${registrodemandaaudin.demandaaudin.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
															<td>
																<a href="<c:url value="/demandas/audinfiocruz/registro/${registrodemandaaudin.demandaaudin.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<td>
															<a href="<c:url value="/demandas/audinfiocruz/registro/${registrodemandaaudin.id}/update"/>">
																<button type="button" class="btn btn-success">
																	<span class="glyphicon glyphicon-pencil"></span>
																</button>
															</a>
														</td>
													</tr>
												</c:forEach>
												<!-- PESQUISAR DEMANDAS -->
												<c:forEach items="${demandasEncontradas}" var="registrodemandaaudin">
													<tr>
														<td>${registrodemandaaudin.demandaaudin.tipodemandaaudin} de ${registrodemandaaudin.demandaaudin.tiporelatorioaudin} nº ${registrodemandaaudin.demandaaudin.num_demanda}/${registrodemandaaudin.demandaaudin.ano}</td>
														<c:if test="${registrodemandaaudin.demandaaudin.unidadeauditada eq null}">
															<td>Institucional</td>
														</c:if>
														<c:if test="${registrodemandaaudin.demandaaudin.unidadeauditada ne null}">
															<td>${registrodemandaaudin.demandaaudin.unidadeauditada}</td>
														</c:if>
														<c:if test="${registrodemandaaudin.demandaaudin.foco eq null}">
															<td>Em todas as áreas da Unidade</td>
														</c:if>
														<c:if test="${registrodemandaaudin.demandaaudin.foco ne null}">
															<td>${registrodemandaaudin.demandaaudin.foco}</td>
														</c:if>
														<td>${registrodemandaaudin.assunto}</td>
														<td>${registrodemandaaudin.statusregistro}</td>
														<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
															<td>
																<a href="<c:url value="/demandas/audinfiocruz/registro/${registrodemandaaudin.demandaaudin.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
															<td>
																<a href="<c:url value="/demandas/audinfiocruz/registro/${registrodemandaaudin.demandaaudin.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<td>
															<a href="<c:url value="/demandas/audinfiocruz/registro/${registrodemandaaudin.id}/update"/>">
																<button type="button" class="btn btn-success">
																	<span class="glyphicon glyphicon-pencil"></span>
																</button>
															</a>
														</td>
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
	</body>
</html>
