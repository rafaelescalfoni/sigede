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
		        	<c:import url="../jspf/abas_demandas_tcu.jsp"></c:import>
		            <div class="tab-content">
		               	<div class="tab-pane fade in active" id="tab1primary">
		                   	<div class="container-fluid">
		                       	<div class="tab-content"> 
		                       		<br>
		                   			<div class="form-group">
		                   				<c:if test="${userSession.usuario.perfil eq 'Administrador' }">
					             			<a href="<c:url value="/tcu/cadastrar_tcu"/>" class="btn btn-success">
					               				<i class="glyphicon glyphicon-plus"></i>
					               				 CADASTRAR DEMANDA
					               			</a>
					               		</c:if>
					               		<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado' }">
					             			<a href="<c:url value="/tcu/cadastrar_tcu"/>" class="btn btn-success">
					               				<i class="glyphicon glyphicon-plus"></i>
					               				 CADASTRAR DEMANDA
					               			</a>
					               		</c:if>
		                       			<br>
	                   				</div>
	                  			</div>
	                       		<div class="tab-content2">
	                   				<h4>CONSULTA POR DEMANDAS ORIGINADAS DO TRIBUNAL DE CONTAS DA UNIÃO (TCU)</h4>
	                   			</div>
	                   			<form action="<c:url value="/demanda/tcu/pesquisa" />" method="get">
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
				                                	<th>EMISSOR</th>
				                                	<th>PROCESSO FIOCRUZ</th>
				                                    <th>NATUREZA</th>
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
			                                    <c:forEach items="${registrodemandatcuList}" var="registrodemandatcu">
													<tr>
														<td>
															${registrodemandatcu.demandatcu.tipodemanda}
															<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'E-Mail'}">
																<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Telefonema'}">
																	 nº ${registrodemandatcu.demandatcu.num_demanda}
																	 <c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Diário Oficial da União'}">
																	 	/
																	 </c:if>
																	 ${registrodemandatcu.demandatcu.ano}																
																</c:if>
															</c:if>
														  	de ${registrodemandatcu.demandatcu.data_demanda}
														</td>
														<td>${registrodemandatcu.demandatcu.remetente}</td>
														<td>${registrodemandatcu.demandatcu.processo_interno}</td>
														<td>${registrodemandatcu.demandatcu.naturezatcu}
															<c:if test="${registrodemandatcu.demandatcu.naturezatcu eq 'Acórdão'}">
																nº ${registrodemandatcu.demandatcu.num_acordao}/${registrodemandatcu.demandatcu.anoacordao}-${registrodemandatcu.demandatcu.colegiadoacordao}
															</c:if>
														</td>
														<td>${registrodemandatcu.assunto}</td>
														<td>${registrodemandatcu.statusregistro}</td>
														<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
															<td>
																<a href="<c:url value="/demandas/tcu/registro/${registrodemandatcu.demandatcu.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
															<td>
																<a href="<c:url value="/demandas/tcu/registro/${registrodemandatcu.demandatcu.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<td>
															<a href="<c:url value="/demandas/tcu/registro/${registrodemandatcu.id}/update"/>">
																<button type="button" class="btn btn-success">
																	<span class="glyphicon glyphicon-pencil"></span>
																</button>
															</a>
														</td>
													</tr>
												</c:forEach>
												<!-- PESQUISAR DEMANDAS -->
												<c:forEach items="${demandasEncontradas}" var="registrodemandatcu">
													<tr>
														<td>
															${registrodemandatcu.demandatcu.tipodemanda}
															<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'E-Mail'}">
																<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Telefonema'}">
																	 nº ${registrodemandatcu.demandatcu.num_demanda}
																	 <c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Diário Oficial da União'}">
																	 	/
																	 </c:if>
																	 ${registrodemandatcu.demandatcu.ano}																
																</c:if>
															</c:if>
														  	de ${registrodemandatcu.demandatcu.data_demanda}
														</td>
														<td>${registrodemandatcu.demandatcu.remetente}</td>
														<td>${registrodemandatcu.demandatcu.processo_interno}</td>
														<td>${registrodemandatcu.demandatcu.naturezatcu}
															<c:if test="${registrodemandatcu.demandatcu.naturezatcu eq 'Acórdão'}">
																nº ${registrodemandatcu.demandatcu.num_acordao}/${registrodemandatcu.demandatcu.anoacordao}-${registrodemandatcu.demandatcu.colegiadoacordao}
															</c:if>
														</td>
														<td>${registrodemandatcu.assunto}</td>
														<td>${registrodemandatcu.statusregistro}</td>
														<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
															<td>
																<a href="<c:url value="/demandas/tcu/registro/${registrodemandatcu.demandatcu.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
															<td>
																<a href="<c:url value="/demandas/tcu/registro/${registrodemandatcu.demandatcu.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<td>
															<a href="<c:url value="/demandas/tcu/registro/${registrodemandatcu.id}/update"/>">
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
		<script type="text/javascript">
		
		</script>
	</body>
</html>
