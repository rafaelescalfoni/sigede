<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	    <link href="<c:url value="/css/datepicker.css"/>" rel="stylesheet">
	    <script src="<c:url value="/js/bootstrap-datepicker.js"/>"></script>
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
		                           		<a href="<c:url value="/demandas/do"/>" class="btn btn-warning btn-large">
		                           			<i class="glyphicon glyphicon-chevron-left"></i>
		                           			 CANCELAR
		                           		</a>
		                           		<br>
		                       		</div>
		                    	</div>
		                        <div class="tab-content2">
		                    		<h4>CADASTRO DE DEMANDAS ORIGINADAS DOS DEMAIS ÓRGÃOS DE CONTROLE (DO)</h4>
		                    	</div>
		                      	<form class="form-inline" role="form" 
		                      		action="<c:url value="/demandas/do/registro/${demandado.id}/add"/>" method="post">
		                            <div class="tab-content3">
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tipodemandado">Tipo de Demanda</label>
		                            		</div>
		                            		<div class="control-label">
			                              		<select id="tipodemandado" name="demandado.tipodemandado" 
			                              			class="form-control" disabled="disabled">
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tipodemandadoList}" var="tipodemandado">
		                                				<option value="${tipodemandado}"
		                                					<c:if test="${tipodemandado eq demandado.tipodemandado}">selected="selected"</c:if>>
		                                					${tipodemandado}
		                                				</option>
		                                			</c:forEach>
		                              			</select>
	                              			</div>
		                            	</div>
		                            	<c:if test="${demandado.tipodemandado ne 'E-Mail'}">
				                            <c:if test="${demandado.tipodemandado ne 'Telefonema'}">
				                            	<div class="form-group">
				                            		<div class="control-label">
				                            			<label for="num_demanda">Número</label> 
				                            		</div>
				                            		<div class="control-label">
					                              		<input id="num_demanda" type="text" name="demandado.num_demanda" disabled="disabled"
					                              			class="form-control" value="${demandado.num_demanda}">
				                              		</div>
				                            	</div>
					                         	<div class="form-group">
					                            	<div class="control-label">
					                            		<label for="ano">Ano</label>
					                            	</div>
					                            	<div class="control-label">
					                            		<select id="ano" name="demandado.ano" 
					                            			class="form-control" disabled="disabled">
					                            			<option value="">Selecione</option>
					                               			<c:forEach items="${anoList}" var="ano">
					                               				<option value="${ano}"
					                               					<c:if test="${ano eq demandado.ano}">selected="selected"</c:if>>
					                               					${ano}
					                               				</option>
					                               			</c:forEach>
					                            		</select>
					                            	</div>
					                          	</div>
		                          			</c:if>
				                       	</c:if>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_demanda">Data</label>
		                            		</div>
		                            		<div class="control-label">
			                                	<input id="cal01" type="text" name="demandado.data_demanda" disabled="disabled"
			                                		class="form-control" maxlength="10" value="${demandado.data_demanda}">
		                                	</div>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="remetente">Remetente</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="remetente" type="text" name="demandado.remetente" disabled="disabled"
			                              			class="form-controln" value="${demandado.remetente}">
		                              		</div>
		                            	</div>
		                           		<div class="form-group">
			                            	<div class="control-label">
			                            		<label for="interessado">Interessado</label>
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="interessado" type="text" name="demandado.interessado" disabled="disabled"
		                              				class="form-controln" value="${demandado.interessado}">
			                            	</div>
			                          	</div>
		                             	<div class="form-group">
				                            <div class="control-label">
				                            	<label for="processo_interno">Processo FIOCRUZ</label>
				                            </div> 
				                            <div class="control-label">
				                                <input id="processo_interno" type="text" name="demandado.processo_interno" disabled="disabled"
		                              				class="form-controlm" value="${demandado.processo_interno}">
				                            </div>
				                        </div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="naturezado">Natureza</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="naturezado" name="demandado.naturezado" 
		                              				class="form-control" disabled="disabled">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${naturezadoList}" var="naturezado">
					                                	<option value="${naturezado}"
		                                					<c:if test="${naturezado eq demandado.naturezado}">selected="selected"</c:if>>
		                                					${naturezado}
		                                				</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<c:if test="${demandado.naturezado eq 'Relatório'}">
			                          		<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="tiporelatoriodo">Tipo de Relatório</label>
			                            		</div>
			                            		<div class="control-label">
				                              		<select id="tiporelatoriodo" name="demandado.tiporelatoriodo" 
				                              			class="form-control" disabled="disabled">
				                              			<option value="">Selecione</option>
			                                			<c:forEach items="${tiporelatoriodoList}" var="tiporelatoriodo">
			                                				<option value="${tiporelatoriodo}"
			                                					<c:if test="${tiporelatoriodo eq demandado.tiporelatoriodo}">selected="selected"</c:if>>
			                                					${tiporelatoriodo}
			                                				</option>
			                                			</c:forEach>
			                              			</select>
		                              			</div>
			                            	</div>
			                           		<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="num_relatorio">Número</label> 
			                            		</div>
			                            		<div class="control-label">
				                              		<input id="num_relatorio" type="text" name="demandado.num_relatorio" disabled="disabled"
				                              			class="form-controlm" value="${demandado.num_relatorio}">
			                              		</div>
			                            	</div>
			                     			<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="data_relatorio">Data do Relatório</label>
			                            		</div>
			                            		<div class="control-label">
				                                	<input id="cal02" type="text" name="demandado.data_relatorio" disabled="disabled"
				                                		class="form-control" maxlength="10" value="${demandado.data_relatorio}">
			                                	</div>
			                            	</div>
			                        		<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="exerciciorelatorio">Exercício Avaliado</label>
			                            		</div>
			                            		<div class="control-label">
			                              			<select id="exerciciorelatorio" name="demandado.exerciciorelatorio" disabled="disabled"
			                              				class="form-control">
			                              				<option value="">Selecione</option>
			                                			<c:forEach items="${anoList}" var="ano">
			                                				<option value="${ano}"
					                                			<c:if test="${ano eq demandado.exerciciorelatorio}">selected="selected"</c:if>>
					                                			${ano}
					                                		</option>
			                                			</c:forEach>
			                              			</select>
			                            		</div>
			                          		</div>
		                          		</c:if>
					                </div>    
		                            <br><br>
		                            <div class="form-group">
		                            	<div class="control-label">
		                            		<label for="areatematica">Área Temática*</label> 
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="areatematica" name="registrodemandado.areatematica" 
		                              			class="form-control" required="required">
		                              			<option value="">Selecione</option>
		                                		<c:forEach items="${areatematicaList}" var="areatematica">
		                                			<option value="${areatematica}">${areatematica}</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
			                        <div class="form-group">
		                            	<div class="control-label">
		                            		<label for="unidade">Unidade*</label>
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="unidade" name="registrodemandado.unidade" 
		                              			class="form-control" required="required">
		                              			<option value="">Selecione</option>
		                                		<c:forEach items="${unidadeList}" var="unidade">
		                                			<option value="${unidade}">${unidade}</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="data_atualizacao">Data da Atualização*</label>
		                            	</div>
		                            	<div class="control-label">
		                            		<input type="text" id="cal03" name="registrodemandado.data_atualizacao" 
		                            			class="form-control" required="required">
		                          		</div>
		                        	</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="assunto">Assunto*</label>
		                            </div>
		                            <div class="control-label">
			                            <textarea id="assunto" class="textarea" rows="3" name="registrodemandado.assunto" 
			                            	required="required"></textarea>
		                            </div>		                           
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="desdobramento">Recomendação(ões)*</label>
		                            </div>
		                            <div class="control-label">
										<textarea id="desdobramento" class="textarea" rows="3" name="registrodemandado.desdobramento" 
											required="required"></textarea>
									</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="providencia">Providência(s)</label>
		                            </div>
		                            <div class="control-label">
		                            	<textarea class="textarea" rows="3" id="providencia" name="registrodemandado.providencia"></textarea>
		                            </div>
		                            <br>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="statusregistro">Status*</label> 
		                            	</div>
		                            	<div class="control-label">
			                              	<select id="statusregistro" name="registrodemandado.statusregistro" 
			                              		class="form-control" required="required">
			                              		<option value="">Selecione</option>
			                                	<c:forEach items="${statusregistroList}" var="statusregistro">
			                                		<option value="${statusregistro}">${statusregistro}</option>
			                                	</c:forEach>
			                              	</select>
		                              	</div>
		                          	</div>
		                          	<br><br>
		                          	<div class="tab-content" align="right">
		                          		<div class="control-label">
				                        	<button type="submit" id="consulta-busca" name="consulta-busca" 
				                        		class="btn btn-success">
						                        <span class="glyphicon glyphicon-ok"></span>
						                         GRAVAR
						                	</button>
					                	</div>
									</div>
			                        <br><br>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
		    $(document).ready(function () {
		        $('#cal01').datepicker({
		            format: "dd/mm/yyyy",
		            language: "pt-BR"
		        });
		      });
		        $(document).ready(function () {
		        $('#cal02').datepicker({
		            format: "dd/mm/yyyy",
		            language: "pt-BR"
		        });
		      });
		        $(document).ready(function () {
		        $('#cal03').datepicker({
		            format: "dd/mm/yyyy",
		            language: "pt-BR"
		        });
		      });
		</script>
	</body>
</html>