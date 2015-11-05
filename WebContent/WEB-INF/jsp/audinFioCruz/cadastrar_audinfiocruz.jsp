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
		                      	<form class="form-inline" role="form" action="<c:url value="/demandas/audinfiocruz"/>" method="post">
		                        	<!-- Select Basic -->
		                            <div class="tab-content3">
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.tipodemanda.id">Tipo de Demanda</label>
		                            		</div>
		                              		<select id="demanda.tipodemanda.id"  name="demanda.tipodemanda.id" class="form-control">
	                                			<c:forEach items="${tipodemandaList}" var="tipodemanda">
	                                				<option value="${tipodemanda.id}">${tipodemanda.nome}</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.tiporelatorioaudin.id">Tipo de Relatório</label>
		                            		</div>
		                              		<select id="demanda.tiporelatorioaudin.id"  name="demanda.tiporelatorioaudin.id" class="form-control">
	                                			<c:forEach items="${tiporelatorioaudinList}" var="tiporelatorioaudin">
	                                				<option value="${tiporelatorioaudin.id}">${tiporelatorioaudin.nome}</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.num_demanda">Número</label> 
		                            		</div>
		                              		<input type="text" class="form-control" name="demanda.num_demanda">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.ano.id">Ano</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.ano.id"  name="demanda.ano.id" class="form-control">
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano.id}">${ano.ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.data_inicio">Data Inicio</label>
		                            		</div>
		                                	<input type="text" id="cal02" class="form-control" name="demanda.data_inicio">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.data_fim">Data Fim</label>
		                            		</div>   
		                            		<input type="text" id="cal03" class="form-control" name="demanda.data_fim">
		                          		</div>
		                          		<div class="form-group">
			                            	<div class="control-label">
			                                    <label for="demanda.processo_interno">Processo FIOCRUZ</label>
			                            	</div> 
			                            	<div class="control-label">
			                                    <input type="text" class="form-control" name="demanda.processo_interno">
			                                </div>
			                        	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.institucional">Institucional</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.institucional" name="demanda.institucional" class="form-control">
					                                <option value=""></option>
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
		                              			<select id="demanda.foco.id"  name="demanda.foco.id" class="form-control">
		                                			<c:forEach items="${focoList}" var="foco">
		                                				<option value="${foco.id}">${foco.nome}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="demanda.unidadeauditada.id">Unidade Auditada</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="demanda.unidadeauditada.id"  name="demanda.unidadeauditada.id" class="form-control">
		                                			<c:forEach items="${unidadeauditadaList}" var="unidadeauditada">
		                                				<option value="${unidadeauditada.id}">${unidadeauditada.nome}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                                <button type="submit" id="consulta-busca-cab" name="consulta-busca" class="btn btn-success">
		                                	<span class="glyphicon glyphicon-ok"></span>
		                                	 SALVAR
		                               	</button>
		                    		</div>
		                            <br><br>
		                        	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.areatematica.id">Área Temática</label> 
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="demanda.areatematica.id"  name="demanda.areatematica.id" class="form-control">
		                                			<c:forEach items="${areatematicaList}" var="areatematica">
		                                				<option value="${areatematica.id}">${areatematica.nome}</option>
		                                			</c:forEach>
		                              			</select>
		                            	</div>
		                          	</div>
		                        	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.unidade.id">Unidade</label>
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="demanda.unidade.id"  name="demanda.unidade.id" class="form-control">
		                                		<c:forEach items="${unidadeList}" var="unidade">
		                                			<option value="${unidade.id}">${unidade.nome}</option>
		                                		</c:forEach>
		                              		</select>
		                            	</div>
		                          	</div>
		                            <div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.data_atualizacao">Data da Atualização</label>
		                            	</div>
		                            	<div class="control-label">
		                            		<input type="text" id="cal01" class="form-control" name="demanda.data_atualizacao">
		                          		</div>
		                        	</div>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="demanda.statusregistro.id">Status</label> 
		                            	</div>
		                              	<select id="demanda.statusregistro.id"  name="demanda.statusregistro.id" class="form-control">
		                                	<c:forEach items="${statusregistroList}" var="statusregistro">
		                                		<option value="${statusregistro.id}">${statusregistro.nome}</option>
		                                	</c:forEach>
		                              	</select>
		                          	</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.assunto">Assunto</label>
		                            </div>
		                            <textarea class="textarea" rows="3" id="demanda.assunto" name="demanda.assunto"></textarea>		                           
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.desdobramento">Recomendação(ões)</label>
		                            </div>
									<textarea class="textarea" rows="3" id="demanda.desdobramento" name="demanda.desdobramento"></textarea>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="demanda.providencia">Providência(s)</label>
		                            </div>
		                            <textarea class="textarea" rows="3" id="demanda.providencia" name="demanda.providencia"></textarea>
		                            <br><br>
		                            <div class="form-group">
		                            	<div class="control-label">
		                                	<button type="submit" id="consulta-busca" name="consulta-busca" class="btn btn-success">
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
