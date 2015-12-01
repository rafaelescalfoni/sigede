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
		                      		action="<c:url value="/demandas/do/registro/${registrodemandado.id}/update"/>" method="post">
		                            <div class="tab-content3">
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tipodemandado">Tipo de Demanda</label>
		                            		</div>
		                              		<select id="tipodemandado" name="demandado.tipodemandado" 
		                              			class="form-control" disabled="disabled">
		                              			<option value="">Selecione</option>
	                                			<c:forEach items="${tipodemandadoList}" var="tipodemandado">
	                                				<option value="${tipodemandado}"
	                                					<c:if test="${tipodemandado eq registrodemandado.demandado.tipodemandado}">selected="selected"</c:if>>
	                                					${tipodemandado}
	                                				</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
		                            	<c:if test="${demandado.tipodemandado ne 'E-Mail'}">
				                            <c:if test="${demandado.tipodemandado ne 'Telefonema'}">
				                            	<div class="form-group">
				                            		<div class="control-label">
				                            			<label for="num_demanda">Número</label> 
				                            		</div>
				                              		<input id="num_demanda" type="text" name="demandado.num_demanda" disabled="disabled"
				                              			class="form-control" value="${registrodemandado.demandado.num_demanda}">
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
					                               					<c:if test="${ano eq registrodemandado.demandado.ano}">selected="selected"</c:if>>
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
		                                	<input id="cal01" type="text" name="demandado.data_demanda" disabled="disabled"
		                                		class="form-control" maxlength="10" value="${registrodemandado.demandado.data_demanda}">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="remetente">Remetente</label> 
		                            		</div>
		                              		<input id="remetente" type="text" name="demandado.remetente" disabled="disabled"
		                              			class="form-control" value="${registrodemandado.demandado.remetente}">
		                            	</div>
		                           		<div class="form-group">
			                            	<div class="control-label">
			                            		<label for="interessado">Interessado</label>
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="interessado" type="text" name="demandado.interessado" disabled="disabled"
		                              				class="form-control" value="${registrodemandado.demandado.interessado}">
			                            	</div>
			                          	</div>
		                             	<div class="form-group">
				                            <div class="control-label">
				                            	<label for="processo_interno">Processo FIOCRUZ</label>
				                            </div> 
				                            <div class="control-label">
				                                <input id="processo_interno" type="text" name="demandado.processo_interno" disabled="disabled"
		                              				class="form-control" value="${registrodemandado.demandado.processo_interno}">
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
		                                					<c:if test="${naturezado eq registrodemandado.demandado.naturezado}">selected="selected"</c:if>>
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
			                              		<select id="tiporelatoriodo" name="demandado.tiporelatoriodo" 
			                              			class="form-control" disabled="disabled">
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tiporelatoriodoList}" var="tiporelatoriodo">
		                                				<option value="${tiporelatoriodo}"
		                                					<c:if test="${tiporelatoriodo eq registrodemandado.demandado.tiporelatoriodo}">selected="selected"</c:if>>
		                                					${tiporelatoriodo}
		                                				</option>
		                                			</c:forEach>
		                              			</select>
			                            	</div>
			                           		<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="num_relatorio">Número</label> 
			                            		</div>
			                              		<input id="num_relatorio" type="text" name="demandado.num_relatorio" disabled="disabled"
			                              			class="form-control" value="${registrodemandado.demandado.num_relatorio}">
			                            	</div>
			                     			<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="data_relatorio">Data do Relatório</label>
			                            		</div>
			                                	<input id="cal02" type="text" name="demandado.data_relatorio" disabled="disabled"
			                                		class="form-control" maxlength="10" value="${registrodemandado.demandado.data_relatorio}">
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
					                                			<c:if test="${ano eq registrodemandado.demandado.exerciciorelatorio}">selected="selected"</c:if>>
					                                			${ano}
					                                		</option>
			                                			</c:forEach>
			                              			</select>
			                            		</div>
			                          		</div>
		                          		</c:if>
		                          		<c:if test="${userSession.usuario.perfil eq 'Administrador' }">
			                                <button type="button" class="btn btn-info">
				                            	<span class="glyphicon glyphicon-pencil"></span>
				                            	 EDITAR
				                            </button> 
		                                </c:if>
		                          		<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado' }">
			                                <button type="button" class="btn btn-info">
				                            	<span class="glyphicon glyphicon-pencil"></span>
				                            	 EDITAR
				                            </button> 
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
		                                			<option value="${areatematica}"
		                                				<c:if test="${areatematica eq registrodemandado.areatematica}">selected="selected"</c:if>>
		                                				${areatematica}
		                                			</option>
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
		                                			<option value="${unidade}"
		                                				<c:if test="${unidade eq registrodemandado.unidade}">selected="selected"</c:if>>
		                                				${unidade}
		                                			</option>
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
		                            			class="form-control" required="required" value="${registrodemandado.data_atualizacao}">
		                          		</div>
		                        	</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="assunto">Assunto*</label>
		                            </div>
		                            <textarea id="assunto" class="textarea" rows="3" 
		                            	name="registrodemandado.assunto" required="required">${registrodemandado.assunto}</textarea>		                           
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="desdobramento">Recomendação(ões)*</label>
		                            </div>
									<textarea id="desdobramento" class="textarea" rows="3" 
										name="registrodemandado.desdobramento" required="required">${registrodemandado.desdobramento}</textarea>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="providencia">Providência(s)</label>
		                            </div>
		                            <textarea id="providencia" class="textarea" rows="3" 
		                            	name="registrodemandado.providencia">${registrodemandado.providencia}</textarea>
		                            <br><br>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="statusregistro">Status*</label> 
		                            	</div>
		                              	<select id="statusregistro" class="form-control"   
		                              		name="registrodemandado.statusregistro" required="required">
		                              		<option value="">Selecione</option>
		                                	<c:forEach items="${statusregistroList}" var="statusregistro">
		                                		<option value="${statusregistro}"
		                                			<c:if test="${statusregistro eq registrodemandado.statusregistro}">selected="selected"</c:if>>
		                                			${statusregistro}
		                                		</option>
		                                	</c:forEach>
		                              	</select>
		                          	</div>
			                        <br><br>
			                        <c:if test="${userSession.usuario.perfil eq 'Administrador' }">
			                            <div class="form-group">
			                            	<div class="control-label">
				                                	<button type="submit" id="editar" name="_method" class="btn btn-success" value="PUT">
				                                		<span class="glyphicon glyphicon-ok"></span>
				                                		 GRAVAR
				                                	</button>
				                                	<button type="submit" id="excluir" name="_method" class="btn btn-danger" value="DELETE">
				                                		<span class="glyphicon glyphicon-remove"></span>
				                                		 EXCLUIR
				                                	</button>
			                            	</div>
			                            </div>
		                            </c:if>
		                            <c:if test="${userSession.usuario.perfil eq 'Usuário Avançado' }">
			                            <div class="form-group">
			                            	<div class="control-label">
				                                	<button type="submit" id="editar" name="_method" class="btn btn-success" value="PUT">
				                                		<span class="glyphicon glyphicon-ok"></span>
				                                		 GRAVAR
				                                	</button>
				                                	<button type="submit" id="excluir" name="_method" class="btn btn-danger" value="DELETE">
				                                		<span class="glyphicon glyphicon-remove"></span>
				                                		 EXCLUIR
				                                	</button>
			                            	</div>
			                            </div>
		                            </c:if>
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