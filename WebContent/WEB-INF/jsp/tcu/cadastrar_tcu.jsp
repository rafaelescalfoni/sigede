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
			                   		action="<c:url value="/demandas/tcu"/>" 
		                      		method="post">
			                    	<!-- Select Basic -->
			                        <div class="tab-content3">
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tipodemanda">Tipo de Demanda*</label>
		                            		</div>
		                              		<select id="tipodemanda" name="demandatcu.tipodemanda" 
		                              			class="form-control" required="required">
		                              			<option value="">Selecione</option>
	                                			<c:forEach items="${tipodemandaList}" var="tipodemanda">
	                                				<option value="${tipodemanda}">${tipodemanda}</option>
	                                			</c:forEach>
	                              			</select>
		                            	</div>
			                            <div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_demanda">Número</label> 
		                            		</div>
		                              		<input id="num_demanda" type="text" name="demandatcu.num_demanda" 
		                              			class="form-control">
		                            	</div>
			                            <div class="form-group">
		                            		<div class="control-label">
		                            			<label for="ano">Ano</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="ano" name="demandatcu.ano.id" 
		                              				class="form-control">
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="ano">
		                                				<option value="${ano.id}">${ano.ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_demanda">Data*</label>
		                            		</div>
		                                	<input id="cal01" type="text" name="demandatcu.data_demanda" 
		                                		class="form-control" maxlength="10" required="required">
		                            	</div>
			                            <div class="form-group">
		                            		<div class="control-label">
		                            			<label for="remetente">Remetente*</label> 
		                            		</div>
		                              		<input id="remetente" type="text" name="demandatcu.remetente" 
		                              			class="form-control" required="required">
		                            	</div>
			                            <div class="form-group">
			                            	<div class="control-label">
			                            		<label for="processotcu">Processo TC</label> 
			                            	</div>
			                              	<input id="processotcu" type="text" name="demandatcu.processotcu" 
		                              			class="form-control">
			                            </div>
			                            <div class="form-group">
			                            	<div class="control-label">
			                            		<label for="interessado">Interessado*</label>
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="interessado" type="text" name="demandatcu.interessado" 
		                              				class="form-control" required="required">
			                            	</div>
			                          	</div>
			                          	<div class="form-group">
				                            <div class="control-label">
				                            	<label for="processo_interno">Processo FIOCRUZ</label>
				                            </div> 
				                            <div class="control-label">
				                                <input id="processo_interno" type="text" name="demandatcu.processo_interno" 
		                              				class="form-control">
				                            </div>
				                        </div>
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="naturezatcu">Natureza*</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="naturezatcu" name="demandatcu.naturezatcu" 
		                              				class="form-control" required="required">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${naturezatcuList}" var="naturezatcu">
					                                	<option value="${naturezatcu}">${naturezatcu}</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="num_acordao">Acórdão nº</label> 
		                            		</div>
		                              		<input id="num_acordao" type="text" name="demandatcu.num_acordao" 
		                              			class="form-control">
		                            	</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="anoacordao">Ano</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="anoacordao" name="demandatcu.anoacordao.id" 
		                              				class="form-control">
		                              				<option value="">Selecione</option>
		                                			<c:forEach items="${anoList}" var="anoacordao">
		                                				<option value="${ano.id}">${ano.ano}</option>
		                                			</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="colegiadoacordao">Colegiado</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="colegiadoacordao" name="demandatcu.colegiadoacordao" 
		                              				class="form-control">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${colegiadoacordaoList}" var="colegiadoacordao">
					                                	<option value="${colegiadoacordao}">${colegiadoacordao}</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                            	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_sessaoacordao">Data da Sessão</label>
		                            		</div>
		                                	<input id="cal02" type="text" name="demandatcu.data_sessaoacordao" 
		                                		class="form-control" maxlength="10">
		                            	</div>
			                            <button type="submit" id="consulta-busca" name="consulta-busca" class="btn btn-success">
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
