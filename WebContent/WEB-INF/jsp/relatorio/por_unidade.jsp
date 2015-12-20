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
                	<c:import url="../jspf/abas_relatorios_por_areatematica.jsp"></c:import>
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
                    		<div class="container-fluid">
                            	<div class="tab-content"> 
                        			<br>
                    			</div>
                        		<div class="tab-content2">
                    				<h4>RELATÓRIO GERENCIAL POR UNIDADE</h4>
                    			</div>
                    			<form class="form-inline" role="form" 
		                      		action="<c:url value="/relatorios/unidade"/>" method="post">
								<script type="text/javascript">
									$(function () {
									    $('#container').highcharts({
									        chart: {
									            type: 'column'
									        },
									        title: {
									            text: 'PERCENTUAL DE REGISTROS POR UIDADE'
									        },
									        subtitle: {
									            text: ''
									        },
									        xAxis: {
									            categories: [
													'Bio-Manguinhos',
									                'CECAL',
									                'CPqAM',
									                'CPqRR',
									                'CPqLMD',
									                'DIRAC',
									                'DIREH',
									                'TI',
									                'Todas as Unidades',
									            ],
									            crosshair: true
									        },
									        yAxis: {
									            min: 0,
									            title: {
									                text: 'Quantidade de Registros'
									            }
									        },
									        tooltip: {
									            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
									            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
									                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
									            footerFormat: '</table>',
									            shared: true,
									            useHTML: true
									        },
									        plotOptions: {
									            column: {
									                pointPadding: 0.2,
									                borderWidth: 0
									            }
									        },
									        series: [{
									            name: '2012',
									            data: [0, 0, 0, 0, 0, 0, 0, 0, 0]
	
									        }, {
									            name: '2013',
									            data: [6, 0, 0, 0, 0, 0, 0, 0, 0]
	
									        }, {
									            name: '2014',
									            data: [0, 0, 0, 0, 4, 0, 5, 1, 0]
	
									        }, {
									            name: '2015',
									            data: [0, 1, 1, 1, 0, 1, 0, 0, 2]
	
									        }]
									    });
									});
							</script>
							</form>
							<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
							                    
							</div>
						</div>
					</div>
                </div>
            </div>
        </div>
	</body>
</html>