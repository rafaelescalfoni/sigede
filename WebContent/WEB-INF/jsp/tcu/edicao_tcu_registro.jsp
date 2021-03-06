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
			                   		action="<c:url value="/demandas/tcu/registro/${registrodemandatcu.id}"/>" method="post">
			                        <div class="tab-content3">
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="id">ID</label> 
		                            		</div>
		                            		<div class="control-label">
			                              		<input id="id" type="text" readonly="readonly" name="registrodemandatcu.demandatcu.id" 
			                              			class="form-control" value="${registrodemandatcu.demandatcu.id}">
		                              		</div>
		                            	</div>
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="tipodemanda">Tipo de Demanda</label>
		                            		</div>
		                            		<div class="control-label">
			                              		<select id="tipodemanda" name="demandatcu.tipodemanda" 
			                              			class="form-control" disabled="disabled">
			                              			<option value="">Selecione</option>
		                                			<c:forEach items="${tipodemandaList}" var="tipodemanda">
		                                				<option value="${tipodemanda}"
		                                					<c:if test="${tipodemanda eq registrodemandatcu.demandatcu.tipodemanda}">selected="selected"</c:if>>
			                                				${tipodemanda}
			                                			</option>
		                                			</c:forEach>
		                              			</select>
	                              			</div>
		                            	</div>
				                       	<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'E-Mail'}">
				                            <c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Telefonema'}">
					                            <div class="form-group">
				                            		<div class="control-label">
				                            			<label for="num_demanda">Número</label> 
				                            		</div>
				                            		<div class="control-label">
					                              		<input id="num_demanda" type="text" name="demandatcu.num_demanda" disabled="disabled"
					                              			class="form-control" value="${registrodemandatcu.demandatcu.num_demanda}">
				                              		</div>
				                            	</div>
				                         	</c:if>
										</c:if>
				                        <c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Diário Oficial da União'}">
				                        	<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'E-Mail'}">
				                            	<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Telefonema'}">
						                            <div class="form-group">
					                            		<div class="control-label">
					                            			<label for="ano">Ano</label>
					                            		</div>
					                            		<div class="control-label">
					                              			<select id="ano" name="demandatcu.ano" 
					                              				class="form-control" disabled="disabled">
					                              				<option value="">Selecione</option>
					                                			<c:forEach items="${anoList}" var="ano">
					                                				<option value="${ano}"
					                                					<c:if test="${ano eq registrodemandatcu.demandatcu.ano}">selected="selected"</c:if>>
					                                					${ano}
					                                				</option>
					                                			</c:forEach>
					                              			</select>
					                            		</div>
					                          		</div>
				                          		</c:if>
				                          	</c:if>
				                        </c:if>
		                          		<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="data_demanda">Data</label>
		                            		</div>
		                            		<div class="control-label">
			                                	<input id="cal01" type="text" name="demandatcu.data_demanda" disabled="disabled"
			                                		class="form-control" maxlength="10" value="${registrodemandatcu.demandatcu.data_demanda}">
		                                	</div>
		                            	</div>
		                            	<c:if test="${registrodemandatcu.demandatcu.tipodemanda ne 'Diário Oficial da União'}">
				                            <div class="form-group">
			                            		<div class="control-label">
			                            			<label for="remetente">Remetente</label> 
			                            		</div>
			                            		<div class="control-label">
				                              		<input id="remetente" type="text" name="demandatcu.remetente" disabled="disabled"
				                              			class="form-controln" value="${registrodemandatcu.demandatcu.remetente}">
			                              		</div>
			                            	</div>
		                            	</c:if>
			                            <div class="form-group">
			                            	<div class="control-label">
			                            		<label for="processotcu">Processo TC</label> 
			                            	</div>
			                            	<div class="control-label">
				                              	<input id="processotcu" type="text" name="demandatcu.processotcu" disabled="disabled"
			                              			class="form-control" value="${registrodemandatcu.demandatcu.processotcu}">
		                              		</div>
			                            </div>
				                        <div class="form-group">
				                           	<div class="control-label">
				                           		<label for="interessado">Interessado</label>
				                           	</div>
				                           	<div class="control-label">
					                           	<input id="interessado" type="text" name="demandatcu.interessado" disabled="disabled"
			                            			class="form-controln" value="${registrodemandatcu.demandatcu.interessado}">
				                           	</div>
				                        </div>
			                          	<div class="form-group">
				                            <div class="control-label">
				                            	<label for="processo_interno">Processo FIOCRUZ</label>
				                            </div> 
				                            <div class="control-label">
				                                <input id="processo_interno" type="text" name="demandatcu.processo_interno" disabled="disabled"
		                              				class="form-controlm" value="${registrodemandatcu.demandatcu.processo_interno}">
				                            </div>
				                        </div>
			                        	<div class="form-group">
		                            		<div class="control-label">
		                            			<label for="naturezatcu">Natureza</label>
		                            		</div>
		                            		<div class="control-label">
		                              			<select id="naturezatcu" name="demandaaudin.naturezatcu" 
		                              				class="form-control" disabled="disabled">
					                                <option value="">Selecione</option>
					                                <c:forEach items="${naturezatcuList}" var="naturezatcu">
					                                	<option value="${naturezatcu}"
		                                					<c:if test="${naturezatcu eq registrodemandatcu.demandatcu.naturezatcu}">selected="selected"</c:if>>
		                                					${naturezatcu}
		                                				</option>
	                              					</c:forEach>
		                              			</select>
		                            		</div>
		                          		</div>
		                          		<c:if test="${registrodemandatcu.demandatcu.naturezatcu eq 'Acórdão'}">
			                          		<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="num_acordao">Acórdão nº</label> 
			                            		</div>
			                            		<div class="control-label">
				                              		<input id="num_acordao" type="text" name="demandatcu.num_acordao" disabled="disabled"
				                              			class="form-control" value="${registrodemandatcu.demandatcu.num_acordao}">
			                              		</div>
			                            	</div>
			                            	<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="anoacordao">Ano</label>
			                            		</div>
			                            		<div class="control-label">
			                              			<select id="anoacordao" name="demandatcu.anoacordao" 
			                              				class="form-control" disabled="disabled">
			                              				<option value="">Selecione</option>
			                                			<c:forEach items="${anoList}" var="ano">
			                                				<option value="${ano}"
			                                					<c:if test="${ano eq registrodemandatcu.demandatcu.anoacordao}">selected="selected"</c:if>>
			                                					${ano}
			                                				</option>
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
			                              				class="form-control" disabled="disabled">
						                                <option value="">Selecione</option>
						                                <c:forEach items="${colegiadoacordaoList}" var="colegiadoacordao">
						                                	<option value="${colegiadoacordao}"
			                                					<c:if test="${colegiadoacordao eq registrodemandatcu.demandatcu.colegiadoacordao}">selected="selected"</c:if>>
			                                					${colegiadoacordao}
			                                				</option>
		                              					</c:forEach>
			                              			</select>
			                            		</div>
			                          		</div>
			                            	<div class="form-group">
			                            		<div class="control-label">
			                            			<label for="data_sessaoacordao">Data da Sessão</label>
			                            		</div>
			                            		<div class="control-label">
				                                	<input id="cal02" type="text" name="demandatcu.data_sessaoacordao" disabled="disabled"
				                                		class="form-control" maxlength="10" value="${registrodemandatcu.demandatcu.data_sessaoacordao}">
			                                	</div>
			                            	</div>
		                            	</c:if>
			                    	</div>
			                        <br><br>
			                        <div class="form-group">
		                            	<div class="control-label">
		                            		<label for="areatematica">Área Temática*</label> 
		                            	</div>
		                            	<div class="control-label">
		                              		<select id="areatematica" name="registrodemandatcu.areatematica" 
		                              			class="form-control" required="required">
		                              			<option value="">Selecione</option>
		                                		<c:forEach items="${areatematicaList}" var="areatematica">
		                                			<option value="${areatematica}"
		                                				<c:if test="${areatematica eq registrodemandatcu.areatematica}">selected="selected"</c:if>>
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
		                              		<select id="unidade" name="registrodemandatcu.unidade" 
		                              			class="form-control" required="required">
		                              			<option value="">Selecione</option>
		                                		<c:forEach items="${unidadeList}" var="unidade">
		                                			<option value="${unidade}"
		                                				<c:if test="${unidade eq registrodemandatcu.unidade}">selected="selected"</c:if>>
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
		                            		<input type="text" id="cal03" name="registrodemandatcu.data_atualizacao" 
		                            			class="form-control" required="required" value="${registrodemandatcu.data_atualizacao}">
		                          		</div>
		                        	</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="assunto">Assunto*</label>
		                            </div>
		                            <div class="control-label">
			                            <textarea id="assunto" class="textarea" rows="3" required="required" 
			                            	name="registrodemandatcu.assunto">${registrodemandatcu.assunto}</textarea>
		                            </div>		                           
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="desdobramento">Recomendação(ões)*</label>
		                            </div>
		                            <div class="control-label">
										<textarea id="desdobramento" class="textarea" rows="3" required="required"
											name="registrodemandatcu.desdobramento">${registrodemandatcu.desdobramento}</textarea>
									</div>
		                            <br><br>
		                            <div class="control-label">
		                            	<label for="providencia">Providência(s)</label>
		                            </div>
		                            <div class="control-label">
			                            <textarea id="providencia" class="textarea" rows="3"   
			                            	name="registrodemandatcu.providencia">${registrodemandatcu.providencia}</textarea>
		                            </div>
		                            <br><br>
		                          	<div class="form-group">
		                            	<div class="control-label">
		                            		<label for="statusregistro">Status*</label> 
		                            	</div>
		                            	<div class="control-label">
			                              	<select id="statusregistro" class="form-control" 
			                              		name="registrodemandatcu.statusregistro" required="required">
			                              		<option value="">Selecione</option>
			                                	<c:forEach items="${statusregistroList}" var="statusregistro">
			                                		<option value="${statusregistro}"
			                                			<c:if test="${statusregistro eq registrodemandatcu.statusregistro}">selected="selected"</c:if>>
			                                			${statusregistro}
			                                		</option>
			                                	</c:forEach>
			                              	</select>
		                              	</div>
		                          	</div>
			                        <br><br>
			                        <c:if test="${userSession.usuario.perfil eq 'Administrador' }">
			                            <div class="tab-content" align="right">
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
			                            <div class="tab-content" align="right">
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
