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
		                      		action="<c:url value="/demandas/audinfiocruz"/>" method="post">
		                        	<!-- Select Basic -->
		                            <div class="tab-content3">
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tiporelatorioaudin">Tipo de Relatório*</label>
		                            		</div>
		                            		<div class="control-label">
			                              		<select id="tiporelatorioaudin"  name="demandaaudin.tiporelatorioaudin" 
			                              			class="form-control" required="required" >
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tiporelatorioaudinList}" var="tiporelatorioaudin">
		                                				<option value="${tiporelatorioaudin}">${tiporelatorioaudin}</option>
		                                			</c:forEach>
		                              			</select>
	                              			</div>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_demanda">Número*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="num_demanda" type="text" name="demandaaudin.num_demanda" 
			                              			class="form-control" required="required">
		                              		</div>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="ano">Ano*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="ano" name="demandaaudin.ano" 
		                              				class="form-control" required="required" >
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano}">${ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_inicio">Data Início*</label>
		                            		</div>
		                            		<div class="control-label">
			                                	<input id="cal01" type="text" name="demandaaudin.data_inicio" 
			                                		class="form-control" maxlength="10" required="required" >
		                                	</div>	
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_fim">Data Fim*</label>
		                            		</div>  
		                            		<div class="control-label"> 
			                            		<input id="cal02" type="text" name="demandaaudin.data_fim"
			                            			class="form-control" maxlength="10" required="required" >
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
			                            	<div class="control-label">
			                                    <label for="processo_interno">Processo FIOCRUZ</label>
			                            	</div> 
			                            	<div class="control-label">
			                                    <input id="processo_interno" type="text" name="demandaaudin.processo_interno" 
			                                    	class="form-controlm" >
			                                </div>
			                        	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="institucional">Institucional*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="institucionalSelecionado" name="demandaaudin.institucional" required="required"
		                              				class="form-control" onchange="desabilitarBox(this.value, 'comboInstitucional')">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${institucionalList}" var="institucional">
					                                	<option value="${institucional}">${institucional}</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
					                    <div class="form-group">
					                       	<div class="control-label">
					                       		<label for="foco">Foco*</label>
					                       	</div>
					                       	<div class="control-label">
					                       		<select id="focoSelecionado" name="demandaaudin.foco" 
					                       			class="form-control" onchange="desabilitarBox(this.value, 'comboFoco')" required="required">
					                       			<option value="">Selecione</option>
					                       			<c:forEach items="${areatematicaList}" var="areatematica">
					                       				<option value="${areatematica}">${areatematica}</option>
					                       			</c:forEach>
					                       		</select>
					                       	</div>
		                          		</div>
		                          		<div class="form-group">
					                       	<div class="control-label">
					                       		<label for="unidadeauditada">Unidade Auditada*</label>
					                       	</div>
					                       	<div class="control-label">
					                       		<select id="unidadeauditadaSelecionada" name="demandaaudin.unidadeauditada" 
					                       			class="form-control" onchange="desabilitarBox(this.value, 'comboUnidadeAuditada')" required="required">
					                       			<option value="">Selecione</option>
					                       			<c:forEach items="${unidadeList}" var="unidade">
					                       				<option value="${unidade}">${unidade}</option>
					                       			</c:forEach>
					                       		</select>
					                       	</div>
					                    </div>
					                    <br><br>
					                    <div class="tab-content" align="right">
						                    <div class="control-label">
				                                <button type="submit" id="consulta-busca-cab" name="consulta-busca" class="btn btn-success">
				                                	<span class="glyphicon glyphicon-ok"></span>
				                                	 SALVAR
				                               	</button>
			                               	</div>
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
		<script>
			function desabilitarBox(comboBoxValue, comboBox){  
				if(comboBox == "comboInstitucional"){
					document.getElementById("focoSelecionado").disabled = false;
					document.getElementById("unidadeauditadaSelecionada").disabled = false;
					if(comboBoxValue == "Sim"){
						document.getElementById("institucionalSelecionado").disabled = false;
						document.getElementById("focoSelecionado").disabled = false;
						document.getElementById("unidadeauditadaSelecionada").disabled = true;
					} else {
						if(comboBoxValue == "Não"){
							document.getElementById("institucionalSelecionado").disabled = false;
							document.getElementById("focoSelecionado").disabled = true;
							document.getElementById("unidadeauditadaSelecionada").disabled = false;
						}	
					}
				} 
			}
		</script>
	</body>
</html>
