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
	                <c:import url="../jspf/abas_suporte_tiporelatoriodo.jsp"></c:import>
	                <div class="tab-content">
	                	<div class="tab-pane fade in active" id="tab1primary">
	                    	<div class="container-fluid">
	                            <div class="tab-content"> 
	                        		<br>
	                       			<div class="form-group">
	                           			<a href="<c:url value="/admin/suporte/tiporelatoriodo"/>" class="btn btn-warning btn-large">
	                           				<i class="glyphicon glyphicon-chevron-left"></i>
	                           				 CANCELAR
	                           			</a>
	                           			<br>
	                       			</div>
	                    		</div>
	                        	<div class="tab-content2">
	                    			<h4>CADASTRO DO TIPO DE RELATÓRIO DOS DEMAIS ÓRGÃOS DE CONTROLE</h4>
	                    		</div>
	                      		<form class="form-inline" role="form" 
	                      			action="<c:url value="/suporte/tiporelatoriodo"/>" 
	                      			method="post">
	                            	<!-- Select Basic -->
	                             	<div class="tab-content3">
	                        			<div class="form-group">
	                            			<div class="control-label">
	                                    		<label for="tiporelatoriodo.nome">Nome</label>
	                            			</div> 
	                            			<div class="control-label">
	                                    		<input type="text" class="form-controln" name="tiporelatoriodo.nome">
	                                  		</div>
	                        			</div>
	                                 	<br><br>
	                                 	<div class="form-group">
	                                		<div class="control-label">
	                                			<button type="submit" id="consulta-busca" name="consulta-busca" class="btn btn-success" value="Gravar">
	                                				<span class="glyphicon glyphicon-ok"></span>
	                                				GRAVAR
	                                			</button>
	                            			</div>
	                             		</div>
	                            		<br><br>
	                            	</div>	
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