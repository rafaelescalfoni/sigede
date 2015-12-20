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
	                <c:import url="../jspf/abas_suporte_usuarios.jsp"></c:import>
	                <div class="tab-content">
	                	<div class="tab-pane fade in active" id="tab1primary">
	                    	<div class="container-fluid">
	                            <div class="tab-content"> 
	                        		<br>
	                       			<div class="form-group">
	                           			<a href="<c:url value="/admin/suporte/usuario"/>" class="btn btn-warning btn-large">
	                           				<i class="glyphicon glyphicon-chevron-left"></i>
	                           				 CANCELAR
	                           			</a>
	                           			<br>
	                       			</div>
	                    		</div>
	                        	<div class="tab-content2">
	                    			<h4>CADASTRO DE USUÁRIOS</h4>
	                    		</div>
	                      		<form class="form-inline" role="form" 
	                      			action="<c:url value="/suporte/usuario"/>" 
	                      			method="post">
	                            	<!-- Select Basic -->
	                             	<div class="tab-content3">
	                        			<div class="form-group">
	                            			<div class="control-label">
	                                    		<label for="nome">Nome*</label>
	                            			</div> 
	                            			<div class="control-label">
	                                    		<input id="nome" type="text" name="usuario.nome" maxlength="60" 
	                                    			class="form-controlm" required="required" >
	                                  		</div>
	                        			</div>
	                                 	<div class="form-group">
	                            			<div class="control-label">
	                                    		<label for="email">E-mail*</label>
	                            			</div> 
	                            			<div class="control-label">
	                                    		<input id="email" type="email" required="required" 
	                                    			pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
	                                    			class="form-controlm" name="usuario.email">
	                                  		</div>
	                        			</div>
	                        			<div class="form-group">
	                            			<div class="control-label">
	                                    		<label for="senha">Senha*</label>
	                            			</div> 
	                            			<div class="control-label">
	                                    		<input id="senha" type="password" required="required"
	                                    			pattern="[a-zA-Z0-9]{5,20}" maxlength="20" 
	                                    			class="form-control" name="usuario.senha">
	                                  		</div>
	                        			</div>
	                                 	<div class="form-group">
	                            			<div class="control-label">
	                                    		<label for="telefone">Telefone*</label>
	                            			</div> 
	                            			<div class="control-label">
	                                    		<input id="telefone" type="text" required="required" 
	                                    			maxlength="15" class="form-control" name="usuario.telefone" />
	                                  		</div>
	                        			</div>
	                        			<div class="form-group">
	                            			<div class="control-label">
	                            				<label for="area">Área*</label> 
	                            			</div>
	                            			<div class="control-label">
	                              				<select id="area"  name="usuario.area" 
	                              					class="form-control" required="required">
	                              					<option value="">Selecione</option>
	                                				<c:forEach items="${areaList}" var="area">
	                                					<option value="${area}">${area}</option>
	                                				</c:forEach>
	                              				</select>
	                            			</div>
	                          			</div>
	                        			<div class="form-group">
	                            			<div class="control-label">
	                            				<label for="perfil">Perfil*</label>
	                            			</div>
	                            			<div class="control-label">
	                              				<select id="perfil" name="usuario.perfil" 
	                              					class="form-control" required="required">
	                              					<option value="">Selecione</option>
	                                				<c:forEach items="${perfilList}" var="perfil">
					                                	<option value="${perfil}">${perfil}</option>
	                              					</c:forEach>
	                              				</select>
	                            			</div>
	                          			</div>
	                             		<div class="form-group">
	                            			<div class="control-label">
	                            				<label for="status">Status*</label>
	                            			</div>
	                            			<div class="control-label">
	                              				<select id="status" name="usuario.status"
	                              					class="form-control" required="required">
	                              					<option value="">Selecione</option>
					                                <c:forEach items="${statusList}" var="status">
	                                					<option value="${status}">${status}</option>
	                                				</c:forEach>
	                              				</select>
	                            			</div>
	                          			</div>    
	                          			<br><br>
	                          			<div class="tab-content" align="right">
		                          			<div class="control-label">
			                            		<button type="submit" id="consulta-busca" name="consulta-busca" 
			                                		class="btn btn-success" value="Gravar">
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
		        $("#cal01").datepicker({
		            format: "dd/mm/yyyy",
		            language: "pt-BR",
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