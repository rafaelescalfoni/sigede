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
		        	<c:import url="../jspf/abas_demandas_do.jsp"></c:import>
					<div class="tab-content">
		            	<div class="tab-pane fade in active" id="tab1primary">
		                    <div class="container-fluid">
		                    	<div class="tab-content"> 
		                        	<br>
			                       	<div class="form-group">
			                       		<c:if test="${userSession.usuario.perfil eq 'Administrador' }">
			                           		<a href="<c:url value="/do/cadastrar_do"/>" class="btn btn-success">
			                           			<i class="glyphicon glyphicon-plus"></i>
			                           			 CADASTRAR DEMANDA
			                           		</a>
			                           	</c:if>
			                           	<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado' }">
			                           		<a href="<c:url value="/do/cadastrar_do"/>" class="btn btn-success">
			                           			<i class="glyphicon glyphicon-plus"></i>
			                           			 CADASTRAR DEMANDA
			                           		</a>
			                           	</c:if>
			                           	<br>
			                       	</div>
		                    	</div>
		                        <div class="tab-content2">
		                    		<h4>CONSULTA POR DEMANDAS ORIGINADAS DOS DEMAIS ÓRGÃOS DE CONTROLE</h4>		                
		                    	</div>
		                    	<form action="<c:url value="/demanda/do/pesquisa" />" method="get">
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
			                                    <c:forEach items="${registrodemandadoList}" var="registrodemandado">
													<tr>
														<td>
															${registrodemandado.demandado.tipodemandado}
															<c:if test="${registrodemandado.demandado.tipodemandado ne 'E-Mail'}">
																<c:if test="${registrodemandado.demandado.tipodemandado ne 'Telefonema'}">
																	 nº ${registrodemandado.demandado.num_demanda}/${registrodemandado.demandado.ano}																
																</c:if>
															</c:if>
														  	de ${registrodemandado.demandado.data_demanda}
														</td>
														<td>${registrodemandado.demandado.remetente}</td>
														<td>${registrodemandado.demandado.processo_interno}</td>
														<td>${registrodemandado.demandado.naturezado}
															<c:if test="${registrodemandado.demandado.naturezado eq 'Relatório'}">
																de ${registrodemandado.demandado.tiporelatoriodo} nº ${registrodemandado.demandado.num_relatorio} - Exercício ${registrodemandado.demandado.exerciciorelatorio}
															</c:if>
														</td>
														<td>${registrodemandado.assunto}</td>
														<td>${registrodemandado.statusregistro}</td>
														<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
															<td>
																<a href="<c:url value="/demandas/do/registro/${registrodemandado.demandado.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
															<td>
																<a href="<c:url value="/demandas/do/registro/novo/${registrodemandado.demandado.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<td>
															<a href="<c:url value="/demandas/do/registro/${registrodemandado.id}/update"/>">
																<button type="button" class="btn btn-success">
																	<span class="glyphicon glyphicon-pencil"></span>
																</button>
															</a>
														</td>
													</tr>
												</c:forEach>
												<!-- PESQUISAR DEMANDAS -->
												<c:forEach items="${demandasEncontradas}" var="registrodemandado">
													<tr>
														<td>
															${registrodemandado.demandado.tipodemandado}
															<c:if test="${registrodemandado.demandado.tipodemandado ne 'E-Mail'}">
																<c:if test="${registrodemandado.demandado.tipodemandado ne 'Telefonema'}">
																	 nº ${registrodemandado.demandado.num_demanda}/${registrodemandado.demandado.ano}																
																</c:if>
															</c:if>
														  	de ${registrodemandado.demandado.data_demanda}
														</td>
														<td>${registrodemandado.demandado.remetente}</td>
														<td>${registrodemandado.demandado.processo_interno}</td>
														<td>${registrodemandado.demandado.naturezado}
															<c:if test="${registrodemandado.demandado.naturezado eq 'Relatório'}">
																de ${registrodemandado.demandado.tiporelatoriodo} nº ${registrodemandado.demandado.num_relatorio} - Exercício ${registrodemandado.demandado.exerciciorelatorio}
															</c:if>
														</td>
														<td>${registrodemandado.assunto}</td>
														<td>${registrodemandado.statusregistro}</td>
														<c:if test="${userSession.usuario.perfil eq 'Administrador'}">
															<td>
																<a href="<c:url value="/demandas/do/registro/${registrodemandado.demandado.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado'}">
															<td>
																<a href="<c:url value="/demandas/do/registro/${registrodemandado.demandado.id}/add"/>">
																	<button type="button" class="btn btn-success">
																		<span class="glyphicon glyphicon-plus"></span>
																	</button>
																</a>
															</td>
														</c:if>
														<td>
															<a href="<c:url value="/demandas/do/registro/${registrodemandado.id}/update"/>">
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
