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
		                      		action="<c:url value="/demandas/do"/>" method="post">
		                            <div class="tab-content3">
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tipodemandado">Tipo de Demanda*</label>
		                            		</div>
		                            		<div class="control-label">
			                              		<select id="tipodemandadoSelecionado" name="demandado.tipodemandado" 
			                              			class="form-control" required="required" onchange="desabilitarBox1(this.value, 'comboTipoDemandaDo')">
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tipodemandadoList}" var="tipodemandado">
		                                				<option value="${tipodemandado}">${tipodemandado}</option>
		                                			</c:forEach>
		                              			</select>
	                              			</div>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_demanda">Número*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="num_demandaSelecionado" type="text" name="demandado.num_demanda" 
			                              			class="form-control" onchange="desabilitarBox1(this.value, 'comboNumDemanda')" required="required">
		                              		</div>
		                            	</div>
		                         		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="ano">Ano*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="anoSelecionado" name="demandado.ano" 
		                              				class="form-control" onchange="desabilitarBox1(this.value, 'comboAno')" required="required">
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano}">${ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_demanda">Data*</label>
		                            		</div>
		                            		<div class="control-label">
			                                	<input id="cal01" type="text" name="demandado.data_demanda" 
			                                		class="form-control" maxlength="10" required="required">
		                                	</div>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="remetente">Remetente*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="demandado.remetente" type="text" name="demandado.remetente" 
			                              			class="form-controln" required="required">
		                              		</div>
		                            	</div>
		                           		<div class="form-group">
			                            	<div class="control-label">
			                            		<label for="interessado">Interessado*</label>
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="interessado" type="text" name="demandado.interessado" 
		                              				class="form-controln" required="required">
			                            	</div>
			                          	</div>
		                             	<div class="form-group">
				                            <div class="control-label">
				                            	<label for="processo_interno">Processo FIOCRUZ</label>
				                            </div> 
				                            <div class="control-label">
				                                <input id="processo_interno" type="text" name="demandado.processo_interno" 
		                              				class="form-controlm">
				                            </div>
				                        </div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="naturezado">Natureza*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="naturezadoSelecionado" name="demandado.naturezado" required="required" 
		                              				class="form-control" onchange="desabilitarBox2(this.value, 'comboNatureza')">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${naturezadoList}" var="naturezado">
					                                	<option value="${naturezado}">${naturezado}</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tiporelatoriodo">Tipo de Relatório*</label>
		                            		</div>
		                            		<div class="control-label">
			                              		<select id="tiporelatoriodoSelecionado" name="demandado.tiporelatoriodo" class="form-control" 
			                              			onchange="desabilitarBox2(this.value, 'comboTipoRelatorio')" required="required">
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tiporelatoriodoList}" var="tiporelatoriodo">
		                                				<option value="${tiporelatoriodo}">${tiporelatoriodo}</option>
		                                			</c:forEach>
		                              			</select>
	                              			</div>
		                            	</div>
		                           		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_relatorio">Número*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="num_relatorioSelecionado" type="text" name="demandado.num_relatorio" class="form-controlm" 
			                              			onchange="desabilitarBox2(this.value, 'comboNumRelatorio')" required="required">
		                              		</div>
		                            	</div>
		                     			<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_relatorio">Data do Relatório*</label>
		                            		</div>
		                            		<div class="control-label">
			                                	<input id="cal02" type="text" name="demandado.data_relatorio" maxlength="10" class="form-control" 
			                                		onchange="desabilitarBox2(this.value, 'comboDataRelatorio')" required="required">
		                                	</div>
		                            	</div>
		                        		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="exerciciorelatorio">Exercício Avaliado*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="exerciciorelatorioSelecionado" name="demandado.exerciciorelatorio" class="form-control" 
		                              				onchange="desabilitarBox2(this.value, 'comboExercicio')" required="required">
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano}">${ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="tab-content" align="right">
			                          		<div class="control-label">
				                               	<button type="submit" id="consulta-busca" name="consulta-busca" class="btn btn-success">
							                       	<span class="glyphicon glyphicon-ok"></span>
							                       	 GRAVAR
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
			function desabilitarBox1(comboBoxValue, comboBox){  
				if(comboBox == "comboTipoDemandaDo"){
					document.getElementById("num_demandaSelecionado").disabled = false;
					document.getElementById("anoSelecionado").disabled = false;
					if(comboBoxValue == "E-Mail"){
						document.getElementById("num_demandaSelecionado").disabled = true;
						document.getElementById("anoSelecionado").disabled = true;
					} else {
						if(comboBoxValue == "Ofício"){
							document.getElementById("num_demandaSelecionado").disabled = false;
							document.getElementById("anoSelecionado").disabled = false;
						} else {
							if(comboBoxValue == "Memorando"){
								document.getElementById("num_demandaSelecionado").disabled = false;
								document.getElementById("anoSelecionado").disabled = false;
							} else {
								if(comboBoxValue == "Memorando-Circular"){
									document.getElementById("num_demandaSelecionado").disabled = false;
									document.getElementById("anoSelecionado").disabled = false;
								} else {
									if(comboBoxValue == "Telefonema"){
										document.getElementById("num_demandaSelecionado").disabled = true;
										document.getElementById("anoSelecionado").disabled = true;
									}
								}
							}
						}
					}
				} 
			}
			function desabilitarBox2(comboBoxValue, comboBox){  
				if(comboBox == "comboNatureza"){
					document.getElementById("tiporelatoriodoSelecionado").disabled = false;
					document.getElementById("num_relatorioSelecionado").disabled = false;
					document.getElementById("cal02").disabled = false;
					document.getElementById("exerciciorelatorioSelecionado").disabled = false;
					if(comboBoxValue == "Comunicação"){
						document.getElementById("tiporelatoriodoSelecionado").disabled = true;
						document.getElementById("num_relatorioSelecionado").disabled = true;
						document.getElementById("cal02").disabled = true;
						document.getElementById("exerciciorelatorioSelecionado").disabled = true;
					} else {
						if(comboBoxValue == "Diligência"){
							document.getElementById("tiporelatoriodoSelecionado").disabled = true;
							document.getElementById("num_relatorioSelecionado").disabled = true;
							document.getElementById("cal02").disabled = true;
							document.getElementById("exerciciorelatorioSelecionado").disabled = true;
						} else {
							if(comboBoxValue == "Relatório"){
								document.getElementById("tiporelatoriodoSelecionado").disabled = false;
								document.getElementById("num_relatorioSelecionado").disabled = false;
								document.getElementById("cal02").disabled = false;
								document.getElementById("exerciciorelatorioSelecionado").disabled = false;
							} 
						}
					}
				} 
			}
		</script>
	</body>
</html>