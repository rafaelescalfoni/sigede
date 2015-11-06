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
		                    		<h4>CADASTRO DE DEMANDAS ORIGINADAS DA AUDITORIA INTERNA (AUDIN\FIOCRUZ)</h4>
		                    	</div>
		                      	<form class="form-inline" role="form" action="<c:url value="/demandas/audinfiocruz/{demanda.id}"/>" method="post">
		                        	<!-- Select Basic -->
		                            <div class="tab-content3">
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.tipodemanda.id">Tipo de Demanda</label>
		                            		</div>
		                              		<select id="demanda.tipodemanda.id"  name="demanda.tipodemanda.id" 
		                              			<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if> 
		                              			class="form-control">
		                              			<option value="">Selecione</option>
	                                			<c:forEach items="${tipodemandaList}" var="tipodemanda">
	                                				<option value="${tipodemanda.id}"
	                                					<c:if test="${tipodemanda.id eq demanda.tipodemanda.id}">selected="selected"</c:if>>
	                                					${tipodemanda.nome}
	                                				</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.tiporelatorioaudin.id">Tipo de Relatório</label>
		                            		</div>
		                              		<select id="demanda.tiporelatorioaudin.id"  name="demanda.tiporelatorioaudin.id" 
		                              			<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              			class="form-control">
	                                			<option value="">Selecione</option>
	                                			<c:forEach items="${tiporelatorioaudinList}" var="tiporelatorioaudin">
	                                				<option value="${tiporelatorioaudin.id}"
	                                					<c:if test="${tiporelatorioaudin.id eq demanda.tiporelatorioaudin.id}">selected="selected"</c:if>>
	                                					${tiporelatorioaudin.nome}
	                                				</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.num_demanda">Número</label> 
		                            		</div>
		                              		<input type="text" class="form-control" name="demanda.num_demanda" 
		                              			<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              			value="${demanda.num_demanda}">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.ano.id">Ano</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.ano.id"  name="demanda.ano.id" 
		                              				<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              				class="form-control">
		                                			<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano.id}"
		                                					<c:if test="${ano.id eq demanda.ano.id}">selected="selected"</c:if>>
		                                					${ano.ano}
		                                				</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.data_inicio">Data Inicio</label>
		                            		</div>
		                                	<input type="text" id="cal02" class="form-control" name="demanda.data_inicio" 
		                                		<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                                		value="${demanda.data_inicio}">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.data_fim">Data Fim</label>
		                            		</div>   
		                            		<input type="text" id="cal03" class="form-control" name="demanda.data_fim" value="${demanda.data_fim}">
		                          		</div>
		                          		<div class="form-group">
			                            	<div class="control-label">
			                                    <label for="demanda.processo_interno">Processo FIOCRUZ</label>
			                            	</div> 
			                            	<div class="control-label">
			                                    <input type="text" class="form-control" name="demanda.processo_interno" 
			                                    	<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
			                                    	value="${demanda.processo_interno}">
			                                </div>
			                        	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.institucional">Institucional</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.institucional" name="demanda.institucional" 
		                              				<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              				class="form-control">
					                                <option value="">Selecione</option>
					                                <option value="Sim">Sim</option>
					                                <option value="Nao">Não</option>
		                              			</select>
		                            		</div>
		                          		</div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.foco.id">Foco</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.foco.id"  name="demanda.foco.id" 
		                              				<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              				class="form-control">
		                                			<option value="">Selecione</option>
		                                			<c:forEach items="${focoList}" var="foco">
		                                				<option value="${foco.id}"
		                                					<c:if test="${foco.id eq demanda.foco.id}">selected="selected"</c:if>>
		                                					${foco.nome}
		                                				</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.unidadeauditada.id">Unidade Auditada</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.unidadeauditada.id"  name="demanda.unidadeauditada.id" 
		                              				<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              				class="form-control">
		                                			<option value="">Selecione</option>
		                                			<c:forEach items="${unidadeauditadaList}" var="unidadeauditada">
		                                				<option value="${unidadeauditada.id}"
		                                					<c:if test="${unidadeauditada.id eq demanda.unidadeauditada.id}">selected="selected"</c:if>>
		                                					${unidadeauditada.nome}
		                                				</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado' }">
			                                <button type="submit" id="consulta-busca-cab" name="consulta-busca" class="btn btn-success">
			                                	<span class="glyphicon glyphicon-ok"></span>
			                                	 SALVAR
			                               	</button>
			                                <button type="button" id="editar-cab" name="consulta-busca" class="btn btn-info">
			                                	<span class="glyphicon glyphicon-pencil"></span>
			                                	 EXCLUIR
			                                </button> 
		                                </c:if>
		                    		</div>
		                            <br><br>
		                        	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.areatematica.id">Área Temática</label> 
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="demanda.areatematica.id" name="demanda.areatematica.id" 
		                              			<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              			class="form-control">
		                                		<option value="">Selecione</option>
		                                		<c:forEach items="${areatematicaList}" var="areatematica">
		                                			<option value="${areatematica.id}"
		                                				<c:if test="${areatematica.id eq demanda.areatematica.id}">selected="selected"</c:if>>
		                                				${areatematica.nome}
		                                			</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
		                        	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.unidade.id">Unidade</label>
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="demanda.unidade.id" name="demanda.unidade.id" 
		                              			<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              			class="form-control">
		                                		<option value="">Selecione</option>
		                                		<c:forEach items="${unidadeList}" var="unidade">
		                                			<option value="${unidade.id}"
		                                				<c:if test="${unidade.id eq demanda.unidade.id}">selected="selected"</c:if>>
		                                				${unidade.nome}
		                                			</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
		                            <div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.data_atualizacao">Data da Atualização</label>
		                            	</div>
		                            	<div class="control-label">
		                            		<input type="text" id="cal01" class="form-control" name="demanda.data_atualizacao" 
		                            			<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                            			value="${demanda.data_atualizacao}">
		                          		</div>
		                        	</div>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.statusregistro.id">Status</label> 
		                            	</div>
		                              	<select id="demanda.statusregistro.id"  name="demanda.statusregistro.id" 
		                              		<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                              		class="form-control">
		                                	<option value="">Selecione</option>
		                                	<c:forEach items="${statusregistroList}" var="statusregistro">
		                                		<option value="${statusregistro.id}"
		                                			<c:if test="${statusregistro.id eq demanda.statusregistro.id}">selected="selected"</c:if>>
		                                			${statusregistro.nome}
		                                		</option>
		                                	</c:forEach>
		                              	</select>
		                          	</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.assunto">Assunto</label>
		                            </div>
		                            <textarea class="textarea" rows="3" id="demanda.assunto" 
		                            	<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                            	name="demanda.assunto">${demanda.assunto }</textarea>		                           
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.desdobramento">Recomendação(ões)</label>
		                            </div>
									<textarea class="textarea" rows="3" id="demanda.desdobramento" 
										<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
										name="demanda.desdobramento">${demanda.desdobramento }</textarea>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.providencia">Providência(s)</label>
		                            </div>
		                            <textarea class="textarea" rows="3" id="demanda.providencia" 
		                            	<c:if test="${userSession.usuario.perfil eq 'Usuário Básico'}">disabled="disabled"</c:if>
		                            	name="demanda.providencia">${demanda.providencia }</textarea>
		                            <br><br>
		                            <div class="form-group">
		                            	<div class="control-label">
		                            		<c:if test="${userSession.usuario.perfil eq 'Usuário Avançado' }">
			                                	<button type="submit" id="consulta-busca" name="consulta-busca" class="btn btn-success">
			                                		<span class="glyphicon glyphicon-ok"></span>
			                                		 GRAVAR
			                                	</button>
			                                	<button type="button" id="excluir" name="consulta-busca" class="btn btn-danger">
			                                		<span class="glyphicon glyphicon-remove"></span>
			                                		 EXCLUIR
			                                	</button>
		                                	</c:if>
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
