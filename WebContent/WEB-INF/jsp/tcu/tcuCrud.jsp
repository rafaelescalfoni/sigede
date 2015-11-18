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
			                   	<form class="form-inline" role="form">
			                       	<!-- Select Basic -->
			                       	<div class="tab-content3">
			                           	<div class="control-label">
			                            	<label>Assunto</label>
		                                </div>
		                            	<textarea class="textarea" rows="1" ></textarea>
		                            	<div class="form-group">
			                                <div class="control-label">
			                                    <label>Tipo</label>
			                                </div>
			                              	<select class="form-control">
				                                <option value=""></option>
				                                <option value="Conformidade em Recursos Humanos">Conformidade em Recursos Humanos</option>
				                                <option value="Conformidade">Conformidade</option>
				                                <option value="Especial">Especial</option>
				                                <option value="Monitoramento">Monitoramento</option>
			                              	</select>
		                        		</div>
		                            	<div class="form-group">
		                                	<div class="control-label">
		                            			<label>Número</label> 
		                                	</div>
			                              	<select class="form-control">
				                                <option value=""></option>
				                                <option value="000">000</option>
				                                <option value="001">001</option>
				                                <option value="002">002</option>
				                                <option value="003">003</option>
			                             	</select>
		                            	</div>
		                           		<div class="form-group">
		                                	<div class="control-label">
		                                    	<label>Ano</label> 
		                                	</div>
			                              	<select class="form-control">
				                                <option value=""></option>
				                                <option value="2014">2014</option>
				                                <option value="2015">2015</option>
			                              	</select>
		                            	</div>
		                             	<div class="form-group">
			                                <div class="control-label">
			                                    <label>Unidade Auditada</label> 
			                                </div>    
			                              	<select  class="form-control">
				                                <option value=""></option>
				                                <option value="Bio-Manguinhos">Bio-Manguinhos</option>
				                                <option value="Farmanguinhos">Farmanguinhos</option>
				                                <option value="DIRAD">DIRAD</option>
				                                <option value="DIREH">DIREH</option>
				                                <option value="DIRAC">DIRAC</option>
			                              	</select>
		                            	</div>
		                        		<div class="form-group">
			                                <div class="control-label">
			                                    <label>Foco</label>
			                                </div>    
			                              	<select class="form-control">
			                                	<option value=""></option>
			                                	<option value="Aposentadoria e Pensão"> Aposentadoria e Pensão</option>
			                                	<option value="Admissão">Admissão</option>
			                                	<option value="Afastamentos">Afastamentos</option>
			                                	<option value="Contratos">Contratos</option>
			                              	</select>
		                            	</div>
		                            	<button type="button" class="btn btn-info">
		                            		<span class="glyphicon glyphicon-search"></span>
		                            		 BUSCAR
		                            	</button>
		                            	<br><br>
		                        	</div>
		                            <br>
		                            <div class="container-fluid">       
		                                <table class="table table-striped">
			                            	<thead>
			                                	<tr>
				                                	<th>DESCRIÇÃO</th>
				                                	<th>EMISSOR</th>
				                                	<th>PROCESSO TC</th>
				                                    <th>ACÓRDÃO</th>
				                                    <th>ASSUNTO</th>
				                                    <th>STATUS</th>
				                                    <th>EDITAR</th>
			                                    </tr>
											</thead>
			                                <tbody>
			                                    <c:forEach items="${demandatcuList}" var="demandatcu">
													<tr>
														<td>
															${demandatcu.tipodemanda}
															<c:if test="${demandatcu.tipodemanda ne 'E-Mail'}">
																<c:if test="${demandatcu.tipodemanda ne 'Telefonema'}">
																	 nº ${demandatcu.num_demanda}/${demandatcu.ano.ano}																
																</c:if>
															</c:if>
														  	de ${demandatcu.data_demanda}
														</td>
														<td>${demandatcu.remetente}</td>
														<td>${demandatcu.processotcu}</td>
														<td>${demandatcu.num_acordao}/${demandatcu.anoacordao.ano}-${demandatcu.colegiadoacordao}</td>
														<td>${demandatcu.assunto}</td>
														<td>${demandatcu.statusregistro}</td>
														<td>
															<a href="<c:url value="/demandas/tcu/${demandatcu.id}/update"/>">
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
