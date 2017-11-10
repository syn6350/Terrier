<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-stats"></span>&nbsp;&nbsp;제어 통계 관리
	</div>
	<div class="container-fluid" style="margin-top:20px; margin-bottom:20px;"><!-- 컨테니어 커스텀설정 -->
	
	
		<div class="row">
			<div class="col-md-12" style="margin-right: 4px;"> 
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #3367d6;">
						사원 출 퇴근 현황
					</div>
					
					<div class="panel-body" style="margin-bottom:5px; ">
						<div class="col-md-5">
							<div id=chart_div1 style="width: 100%; height: 300px;"></div>
						</div>
						
						<div class="col-md-5">
							<div id=chart_div2 style="width: 100%; height: 300px;"></div>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12" style="margin-right: 4px;"> 
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #3367d6;">
						날짜 별 사원 출퇴근 내역
					</div>
					
					<div class="panel-body" style="margin-bottom:5px; ">
						<div class="col-md-5 form-group">
							<label>날짜 선택 : </label> <input id="date" type="date" value="2017-10-31" style="height:25px"/> <button id="cummute_search">검색</button>
						</div>
						
						<div class="col-md-5">
							ㅎ2
						</div>
						
					</div>
				</div>
			</div>
		</div>	
					
				
	</div>
</div>

<script>
	//Load the Visualization API and the corechart package.	
	google.charts.load('current', {'packages':['corechart']});/* 일반적인 차트로드 */     
	google.charts.load('current', {'packages':['bar']}); /* 듀얼이나 트리플은 해당 차트를 로드해야함 */
	// Set a callback to run when the Google Visualization API is loaded.

	google.charts.setOnLoadCallback(drawChart1);
	google.charts.setOnLoadCallback(drawChart2);
	/*google.charts.setOnLoadCallback(drawChart3); */
	
	$("#load_dep_ctl").load("control_dep_ctl?department=인사");
	
	/* 파이그래프 */
	function drawChart1() {
        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'control');
        data.addColumn('number', 'status:on');
        data.addRows([
          ['출근', 5],
          ['미출근/퇴근', 5],
        ]);

        // Set chart options
        var options = {
        	'title':'전체사원 56명 중 21명 출근',
        	animation:{
    			startup: true,
    			duration: 1000,
    			easing: 'out'
    		}
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
        chart.draw(data, options);
        
	}
	

	/* 컬럼그래프 */
	function drawChart2() {
	    var data = google.visualization.arrayToDataTable([
	      ["Element", "출근", { role: "style" } ],
	      ["인사부", 2, "#4285f4"],
	      ["기술부", 3, "#4285f4"],
	      ["생산부", 5, "#4285f4"],
	      ["총무부", 4, "#4285f4"]
	    ]);
	    var view = new google.visualization.DataView(data);
	     
	    view.setColumns([0, 1,
	         { calc: "stringify",
	           sourceColumn: 1,
	           type: "string",
	           role: "annotation" },
	         2]);
	    
	    // Set chart options
	    var options = {
	      //title: "Density of Precious Metals, in g/cm^3",
	      //width: 800,
	      //height: 350,
	      //bar: {groupWidth: "95%"},
	      //legend: { position: "none" },
	    };
	
	    var chart = new google.visualization.ColumnChart(document.getElementById('chart_div2'));
	    chart.draw(view, options);
	}
	
	
	
	$("#cummute_search").click(function(){
		alert($("#date").val());
		
		var data={};
		data["date"]=$("#date").val();
		
		$.ajax({
			type:"GET",
			contentType:'application/json,charset=UTF-8',
			dataType:'text',
			data:data,
			url:'/terrier/statistics_management/cummute_date?data',
			success:function(data)
			{
				if(data=="SUCCESS"){
					
				}
			},
			error:function(jqXHR,exception)
			{
				alert("전송실패");
				alert(jqXHR.status);
				alert(exception);
				console.log(jqXHR);
				return false;
			}
		});/* ajax */
	});
</script>