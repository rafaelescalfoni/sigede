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
					<c:import url="../jspf/abas_demandas_tcu.jsp"></c:import>
		            <div class="tab-content">
		               	<div class="tab-pane fade in active" id="tab1primary">
		                   	<div class="container-fluid">
		                       	<div class="tab-content"> 
		                       		<br>
		                   			<div class="form-group">
		                       			<a href="<c:url value="/demandas/tcu"/>" class="btn btn-warning btn-large">
		                       				<i class="glyphicon glyphicon-chevron-left"></i>
		                       				 CANCELAR
		                       			</a>
		                       			<br>
		                   			</div>
		                  		</div>
		                       	<div class="tab-content2">
		                   			<h4>CADASTRO DE DEMANDAS ORIGINADAS DO TRIBUNAL DE CONTAS DA UNIÃO (TCU)</h4>
		                   		</div>
			                   	<form class="form-inline" role="form" 
			                   		action="<c:url value="/demandas/tcu"/>" method="post">
			                        <div class="tab-content3">
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tipodemanda">Tipo de Demanda*</label>
		                            		</div>
		                            		<div class="control-label">
			                              		<select id="tipodemandaSelecionada" name="demandatcu.tipodemanda" 
			                              			class="form-control" required="required" onchange="desabilitarBox1(this.value, 'comboTipoDemanda')">
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tipodemandaList}" var="tipodemanda">
		                                				<option value="${tipodemanda}">${tipodemanda}</option>
		                                			</c:forEach>
		                              			</select>
	                              			</div>
		                            	</div>
			                            <div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_demanda">Número*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="num_demandaSelecionado" type="text" class="form-control" name="demandatcu.num_demanda" 
			                              			onchange="desabilitarBox1(this.value, 'comboNumDemanda')" required="required">
		                              		</div>
		                            	</div>
			                            <div class="form-group">
		                            		<div class="control-label">
		                            			<label for="ano">Ano*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="anoSelecionado" name="demandatcu.ano" 
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
			                                	<input id="cal01" type="text" name="demandatcu.data_demanda" 
			                                		class="form-control" maxlength="10" required="required">
		                                	</div>
		                            	</div>
			                            <div class="form-group">
		                            		<div class="control-label">
		                            			<label for="remetente">Remetente*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="remetenteSelecionado" type="text" name="demandatcu.remetente" class="form-controln"  
			                              			onchange="desabilitarBox1(this.value, 'comboRemetente')" required="required">
		                              		</div>
		                            	</div>
			                            <div class="form-group">
			                            	<div class="control-label">
			                            		<label for="processotcu">Processo TC</label> 
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="processotcu" type="text" name="demandatcu.processotcu" 
			                              			class="form-control">
		                              		</div>
			                            </div>
			                            <div class="form-group">
			                            	<div class="control-label">
			                            		<label for="interessado">Interessado*</label>
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="interessado" type="text" name="demandatcu.interessado" 
		                              				class="form-controln" required="required">
			                            	</div>
			                          	</div>
			                          	<div class="form-group">
				                            <div class="control-label">
				                            	<label for="processo_interno">Processo FIOCRUZ</label>
				                            </div> 
				                            <div class="control-label">
				                                <input id="processo_interno" type="text" name="demandatcu.processo_interno" 
		                              				class="form-controlm">
				                            </div>
				                        </div>
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="naturezatcu">Natureza*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="naturezatcuSelecionado" name="demandatcu.naturezatcu" required="required"
		                              				class="form-control" onchange="desabilitarBox2(this.value, 'comboNatureza')">
		                              				<option value="">Selecione</option>
					                                <c:forEach items="${naturezatcuList}" var="naturezatcu">
					                                	<option value="${naturezatcu}">${naturezatcu}</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_acordao">Acórdão nº*</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="num_acordaoSelecionado" type="text" name="demandatcu.num_acordao" class="form-control" 
			                              			onchange="desabilitarBox2(this.value, 'comboNumAcordao')" required="required">
		                              		</div>
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="anoacordao">Ano*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="anoacordaoSelecionado" name="demandatcu.anoacordao" class="form-control" 
		                              				onchange="desabilitarBox2(this.value, 'comboAnoAcordao')" required="required">
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano}">${ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="colegiadoacordao">Colegiado*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="colegiadoacordaoSelecionado" name="demandatcu.colegiadoacordao" class="form-control" 
		                              				onchange="desabilitarBox2(this.value, 'comboColegiado')" required="required">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${colegiadoacordaoList}" var="colegiadoacordao">
					                                	<option value="${colegiadoacordao}">${colegiadoacordao}</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_sessaoacordao">Data da Sessão*</label>
		                            		</div>
		                            		<div class="control-label">
			                                	<input id="cal02" type="text" name="demandatcu.data_sessaoacordao" class="form-control" 
			                                		maxlength="10" onchange="desabilitarBox2(this.value, 'comboDataSessao')" required="required">
		                                	</div>
		                            	</div>
		                            	<div class="tab-content" align="right">
		                            		<div class="control-label">
					                            <button type="submit" id="gravarSelecionado" name="consulta-busca" class="btn btn-success">
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
				if(comboBox == "comboTipoDemanda"){
					document.getElementById("num_demandaSelecionado").disabled = false;
					document.getElementById("anoSelecionado").disabled = false;
					document.getElementById("remetenteSelecionado").disabled = false;
					if(comboBoxValue == "Diário Oficial da União"){
						document.getElementById("num_demandaSelecionado").disabled = false;
						document.getElementById("anoSelecionado").disabled = true;
						document.getElementById("remetenteSelecionado").disabled = true;
					} else {
						if(comboBoxValue == "E-Mail"){
							document.getElementById("num_demandaSelecionado").disabled = true;
							document.getElementById("anoSelecionado").disabled = true;
							document.getElementById("remetenteSelecionado").disabled = false;
						} else {
							if(comboBoxValue == "Ofício"){
								document.getElementById("num_demandaSelecionado").disabled = false;
								document.getElementById("anoSelecionado").disabled = false;
								document.getElementById("remetenteSelecionado").disabled = false;
							} else {
								if(comboBoxValue == "Telefonema"){
									document.getElementById("num_demandaSelecionado").disabled = true;
									document.getElementById("anoSelecionado").disabled = true;
									document.getElementById("remetenteSelecionado").disabled = false;
								}
							}
						}
					}
				} 
			}
			function desabilitarBox2(comboBoxValue, comboBox){  
				if(comboBox == "comboNatureza"){
					document.getElementById("num_acordaoSelecionado").disabled = false;
					document.getElementById("anoacordaoSelecionado").disabled = false;
					document.getElementById("colegiadoacordaoSelecionado").disabled = false;
					document.getElementById("cal02").disabled = false;
					if(comboBoxValue == "Acórdão"){
						document.getElementById("num_acordaoSelecionado").disabled = false;
						document.getElementById("anoacordaoSelecionado").disabled = false;
						document.getElementById("colegiadoacordaoSelecionado").disabled = false;
						document.getElementById("cal02").disabled = false;
					} else {
						if(comboBoxValue == "Audiência"){
							document.getElementById("num_acordaoSelecionado").disabled = true;
							document.getElementById("anoacordaoSelecionado").disabled = true;
							document.getElementById("colegiadoacordaoSelecionado").disabled = true;
							document.getElementById("cal02").disabled = true;
						} else {
							if(comboBoxValue == "Comunicação"){
								document.getElementById("num_acordaoSelecionado").disabled = true;
								document.getElementById("anoacordaoSelecionado").disabled = true;
								document.getElementById("colegiadoacordaoSelecionado").disabled = true;
								document.getElementById("cal02").disabled = true;
							} else {
								if(comboBoxValue == "Diligência"){
									document.getElementById("num_acordaoSelecionado").disabled = true;
									document.getElementById("anoacordaoSelecionado").disabled = true;
									document.getElementById("colegiadoacordaoSelecionado").disabled = true;
									document.getElementById("cal02").disabled = true;
								} else {
									if(comboBoxValue == "Oitiva"){
										document.getElementById("num_acordaoSelecionado").disabled = true;
										document.getElementById("anoacordaoSelecionado").disabled = true;
										document.getElementById("colegiadoacordaoSelecionado").disabled = true;
										document.getElementById("cal02").disabled = true;
									}
								}
							}
						}
					}
				} 
			}
		</script>
	</body>
</html>
