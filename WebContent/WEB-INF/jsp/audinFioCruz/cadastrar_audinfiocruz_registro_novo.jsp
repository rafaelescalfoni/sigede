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
					<c:import url="../jspf/abas_demandas_audin.jsp"></c:import>
					<div class="tab-content">
						<div class="tab-pane fade in active" id="tab1primary">
							<div class="container-fluid">
								<div class="tab-content"> 
		                        	<br>
				                    <div class="form-group">
				                    	<a href="<c:url value="/demandas/audinfiocruz"/>" class="btn btn-warning btn-large">
				                        	<i class="glyphicon glyphicon-chevron-left"></i>
				                           	 CANCELAR
				                        </a>
				                        <br>
				                    </div>
		                    	</div>
		                        <div class="tab-content2">
		                    		<h4>CADASTRO DE RELATÓRIOS EMITIDOS PELA AUDITORIA INTERNA (AUDIN)</h4>
		                    	</div>
		                      	<form class="form-inline" role="form" 
		                      		action="<c:url value="/demandas/audinfiocruz/registro/${demandaaudin.id}/add"/>" 
		                      		method="post">
		                            <div class="tab-content3">
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tiporelatorioaudin">Tipo de Relatório</label>
		                            		</div>
		                              		<select id="tiporelatorioaudin" name="demandaaudin.tiporelatorioaudin" 
		                              			class="form-control" disabled="disabled">
		                              			<option value="">Selecione</option>
	                                			<c:forEach items="${tiporelatorioaudinList}" var="tiporelatorioaudin">
	                                				<option value="${tiporelatorioaudin}"
	                                					<c:if test="${tiporelatorioaudin eq demandaaudin.tiporelatorioaudin}">selected="selected"</c:if>>
	                                					${tiporelatorioaudin}
	                                				</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_demanda">Número</label> 
		                            		</div>
		                              		<input id="num_demanda" type="text" name="demandaaudin.num_demanda" 
		                              			class="form-control" disabled="disabled" value="${demandaaudin.num_demanda}">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="ano">Ano</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="ano" name="demandaaudin.ano" 
		                              				class="form-control" disabled="disabled">
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano}"
		                                					<c:if test="${ano eq demandaaudin.ano}">selected="selected"</c:if>>
		                                					${ano}
		                                				</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_inicio">Data Inicio</label>
		                            		</div>
		                                	<input id="cal01" type="text" name="demandaaudin.data_inicio" 
		                                		class="form-control" disabled="disabled" value="${demandaaudin.data_inicio}">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_fim">Data Fim</label>
		                            		</div>   
		                            		<input id="cal02" type="text" name="demandaaudin.data_fim"
		                            			class="form-control" disabled="disabled" value="${demandaaudin.data_fim}">
		                          		</div>
		                          		<div class="form-group">
			                            	<div class="control-label">
			                                    <label for="processo_interno">Processo FIOCRUZ</label>
			                            	</div> 
			                            	<div class="control-label">
			                                    <input id="processo_interno" type="text" name="demandaaudin.processo_interno"
			                                    	class="form-control" disabled="disabled" value="${demandaaudin.processo_interno}">
			                                </div>
			                        	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="institucional">Institucional</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="institucional" name="demandaaudin.institucional" 
		                              				class="form-control" disabled="disabled">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${institucionalList}" var="institucional">
					                                	<option value="${institucional}" 
					                                		<c:if test="${institucional eq demandaaudin.institucional}">selected="selected"</c:if>>
					                                			${institucional}
					                                	</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
					                    <c:if test="${demandaaudin.foco ne null}">
						                    <div class="form-group">
						                       	<div class="control-label">
						                       		<label for="foco">Foco</label>
						                       	</div>
						                       	<div class="control-label">
						                       		<select id="foco" name="demandaaudin.foco" 
						                       			class="form-control" disabled="disabled">
						                       			<option value="">Selecione</option>
						                       			<c:forEach items="${focoList}" var="foco">
						                       				<option value="${foco}"
			                                					<c:if test="${foco eq demandaaudin.foco}">selected="selected"</c:if>>
			                                					${foco}
			                                				</option>
						                       			</c:forEach>
						                       		</select>
						                       	</div>
			                          		</div>
		                          		</c:if>
		                          		<c:if test="${demandaaudin.unidadeauditada ne null}">
			                          		<div class="form-group">
						                       	<div class="control-label">
						                       		<label for="unidadeauditada">Unidade Auditada</label>
						                       	</div>
						                       	<div class="control-label">
						                       		<select id="unidadeauditada" name="demandaaudin.unidadeauditada" 
						                       			class="form-control" disabled="disabled">
						                       			<option value="">Selecione</option>
						                       			<c:forEach items="${unidadeauditadaList}" var="unidadeauditada">
						                       				<option value="${unidadeauditada}"
			                                					<c:if test="${unidadeauditada eq demandaaudin.unidadeauditada}">selected="selected"</c:if>>
			                                					${unidadeauditada}
			                                				</option>
						                       			</c:forEach>
						                       		</select>
						                       	</div>
						                    </div>
					                    </c:if>
		                    		</div>
		                            <br><br>
		                        <%-- </form>    
								<form class="form-inline" role="form" action="<c:url value="/demandas/audinfiocruz/registro"/>" method="post"> --%>		
		                        	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="areatematica">Área Temática</label> 
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="areatematica" name="registrodemandaaudin.areatematica" 
		                              			<c:if test="${demandaaudin.institucional eq 'Sim'}">disabled="disabled"</c:if>
		                              			class="form-control" >
		                              			<option value="">Selecione</option>
		                                		<c:forEach items="${areatematicaList}" var="areatematica">
		                                			<option value="${areatematica}">${areatematica}</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
		                        	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="unidade">Unidade</label>
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="unidade" name="registrodemandaaudin.unidade" 
		                              			<c:if test="${demandaaudin.institucional eq 'Não'}">disabled="disabled"</c:if>
		                              			class="form-control">
		                              			<option value="">Selecione</option>
		                                		<c:forEach items="${unidadeList}" var="unidade">
		                                			<option value="${unidade}">${unidade}</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="data_atualizacao">Data da Atualização</label>
		                            	</div>
		                            	<div class="control-label">
		                            		<input type="text" id="cal03" name="registrodemandaaudin.data_atualizacao" 
		                            			class="form-control" >
		                          		</div>
		                        	</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="assunto">Assunto</label>
		                            </div>
		                            <textarea id="assunto" class="textarea" rows="3" name="registrodemandaaudin.assunto" ></textarea>		                           
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="desdobramento">Recomendação(ões)</label>
		                            </div>
									<textarea id="desdobramento" class="textarea" rows="3" name="registrodemandaaudin.desdobramento" ></textarea>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.providencia">Providência(s)</label>
		                            </div>
		                            <textarea class="textarea" rows="3" id="demanda.providencia" name="registrodemandaaudin.providencia"></textarea>
		                            <br><br>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="statusregistro">Status</label> 
		                            	</div>
		                              	<select id="statusregistro" name="registrodemandaaudin.statusregistro" 
		                              		class="form-control" >
		                              		<option value="">Selecione</option>
		                                	<c:forEach items="${statusregistroList}" var="statusregistro">
		                                		<option value="${statusregistro}">${statusregistro}</option>
		                                	</c:forEach>
		                              	</select>
		                          	</div>
		                            <br><br>
			                        <div class="tab-content" align="right">
			                        	<button type="submit" id="consulta-busca" name="consulta-busca" 
			                        		class="btn btn-success">
					                        <span class="glyphicon glyphicon-ok"></span>
					                         GRAVAR
					                	</button>
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
