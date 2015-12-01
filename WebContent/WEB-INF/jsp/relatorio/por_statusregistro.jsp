<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<script src="<c:url value="/js/highcharts.js"/>"></script>
		<script src="<c:url value="/js/modules/exporting.js"/>"></script>
	</head>
	<body>
		<c:import url="../jspf/cabecalho.jsp"></c:import>
		<div class="container"> 
        	<div class="col-md-12">
            	<div class="panel with-nav-tabs panel-primary">
                	<c:import url="../jspf/abas_relatorios_por_statusregistro.jsp"></c:import>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
                    		<div class="container-fluid">
                            	<div class="tab-content"> 
                        			<br>
                    			</div>
                        		<div class="tab-content2">
                    				<h4>RELATÓRIO GERENCIAL POR STATUS</h4>
                    			</div>
                      			<form class="form-inline" role="form">
                             		<!-- Select Basic -->
                             		<div class="tab-content3">
                         				<div class="form-group">
				                        	<div class="control-label">
				                            	<label>Status</label> 
				                            </div>
											<select id="selectbasicust" name="selectbasic" class="form-control">
				                                <option value=""></option>
				                                <option value="Atendido">Atendido</option>
				                                <option value="Atendido Parcialmente">Atendido Parcialmente</option>
				                                <option value="Não atendido">Não atendido</option>
											</select>
										</div>
                            			<div class="form-group">
                            				<div class="control-label">
                            					<label for="selectbasic">Ano</label>
                            				</div>
                            				<div class="control-label">
                              					<select id="selectbasic3" name="selectbasic" class="form-control">
					                                <option value=""></option>
					                                <option value="2014">2014</option>
					                                <option value="2015">2015</option>
					                                <option value="2016">2016</option>
					                                <option value="2017">2017</option>
					                                <option value="2018">2018</option>
					                                <option value="2019">2019</option>
					                                <option value="2020">2020</option>
					                                <option value="2021">2021</option>
					                                <option value="2022">2022</option>
					                                <option value="2023">2023</option>
					                                <option value="2024">2024</option>
					                                <option value="2025">2025</option>
                              					</select>
                            				</div>
                          				</div>
                          				<div class="form-group">
				                      		<div class="control-label">
				                            	<label>Origem</label> 
				                            </div>
				                            <select id="selectbasicust" name="selectbasic" class="form-control">
				                            	<option value=""></option>
				                                <option value="ORIGEM 1">ORIGEM 1</option>
				                                <option value="ORIGEM 2">ORIGEM 2</option>
				                                <option value="ORIGEM 3">ORIGEM 3</option>
				                            </select>
			                          	</div>
                             		</div>
                            		<br><br>
                            	</form>
								<script type="text/javascript">
									$(function () {
									    $('#container').highcharts({
									        chart: {
									            type: 'areaspline'
									        },
									        title: {
									            text: 'Average fruit consumption during one week'
									        },
									        legend: {
									            layout: 'vertical',
									            align: 'left',
									            verticalAlign: 'top',
									            x: 150,
									            y: 100,
									            floating: true,
									            borderWidth: 1,
									            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
									        },
									        xAxis: {
									            categories: [
									                'Monday',
									                'Tuesday',
									                'Wednesday',
									                'Thursday',
									                'Friday',
									                'Saturday',
									                'Sunday'
									            ],
									            plotBands: [{ // visualize the weekend
									                from: 4.5,
									                to: 6.5,
									                color: 'rgba(68, 170, 213, .2)'
									            }]
									        },
									        yAxis: {
									            title: {
									                text: 'Fruit units'
									            }
									        },
									        tooltip: {
									            shared: true,
									            valueSuffix: ' units'
									        },
									        credits: {
									            enabled: false
									        },
									        plotOptions: {
									            areaspline: {
									                fillOpacity: 0.5
									            }
									        },
									        series: [{
									            name: 'John',
									            data: [3, 4, 3, 5, 4, 10, 12]
									        }, {
									            name: 'Jane',
									            data: [1, 3, 4, 3, 3, 5, 4]
									        }]
									    });
									});
							</script>
							<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
							                    
							</div>
						</div>
					</div>
                </div>
            </div>
        </div>
	</body>
</html>