<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-stats"></span>&nbsp;&nbsp;사용률 통계관리
	</div>
	<div class="container-fluid" style="margin-top:20px; margin-bottom:20px;"><!-- 컨테니어 커스텀설정 -->
	
	
	
	<!-- 첫번째줄시작 -->
	<div class="row">
		<div class="col-md-4" style="padding-left: 0px;margin-right: 4px;"> 
			<div class="panel panel-primary">
				<div class="panel-heading" style="background-color: #3367d6;">
					<!--판넬머리-->
					[파이그래프]
				</div>
				
				<div class="panel-body" style="padding: 0px;">
					<!--판넬몸통 -->
					<div id=chart_div></div>
				</div>
			</div>
		</div>
		<div class="col-md-7" style="padding-left: 0px; margin-right: 0px;"> 
			<div class="panel panel-primary">
				<div class="panel-heading" style="background-color: #3367d6;">
					<!--판넬머리-->
					[컬럼그래프]
				</div>
				
				<div class="panel-body" style="padding:0px;">
					<!--판넬몸통 -->
					<div id=chart_div1></div>
				</div>
			</div>
		</div>
	</div>
		<!-- row1번재줄끝------------------------------------------------ -->
		
		
		<div class="row">
			<div class="col-md-12"style="padding-left: 0px;margin-right: 4px;"> 
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #3367d6;">
						[듀얼컬럼그래프]
					</div>
					
					<div class="panel-body" style="padding:0px; margin-bottom:5px; ">
						<div id=chart_div2 style="width: 900px; height: 300px;">
						</div>
					</div>
				</div>
			</div>
		
		</div><!-- row2번재줄끝------------------------------------------------ -->	
				
		
		<div class="row">
			<div class="col-md-12"style="padding-left: 0px;margin-right: 4px;"> 
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #3367d6;">
						[바그래프]
					</div>
					
					<div class="panel-body" style="padding:0px;">
						<div id=chart_div3 style="width: 900px; height: 300px;">
					</div>
				</div>
			</div>
		</div>
		</div><!-- row3번재줄끝------------------------------------------------ -->	
		
		<div class="row">
			<div class="col-md-12"style="padding-left: 0px;margin-right: 4px;"> 
				<div class="panel panel-primary">
					<div class="panel-heading" style="background-color: #3367d6;">
						[듀얼바그래프]
					</div>
					
					<div class="panel-body" style="padding:0px; margin-bottom:5px; ">
						<div id=chart_div4 style="width: 900px; height: 300px;">
						</div>
					</div>
				</div>
			</div>		
		</div><!-- row4번재줄끝------------------------------------------------ -->	
		

	
	
	
	
	
	</div><!-- <container-fluid"> -->	
</div><!-- <content> -->





<script type="text/javascript">
      // Load the Visualization API and the corechart package.
            
      google.charts.load('current', {'packages':['corechart']});/* 일반적인 차트로드 */     
      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawChart1);      
      google.charts.setOnLoadCallback(drawChart3);
      
      google.charts.load('current', {'packages':['bar']}); /* 듀얼이나 트리플은 해당 차트를 로드해야함 */
      google.charts.setOnLoadCallback(drawChart2);
      google.charts.setOnLoadCallback(drawChart4);



      
      function drawChart() {/* ---------------------------------------------------파이그래프 */
        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', '토핑');
        data.addColumn('number', '시리얼');
        data.addRows([
          ['Mushrooms', 2],
          ['Onions', 2],
          ['Olives', 1],
          ['Zucchini', 1],
          ['Pepperoni', 4]
        ]);

        // Set chart options
        var options = {'title':'사용자 통계관리',
                       'width':400,
                       'height':350};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
        
      }
      
      function drawChart1() {/* ---------------------------------------------------컬럼그래프 */
      // Create the data table.
      var data = google.visualization.arrayToDataTable([
        ["Element", "Density", { role: "style" } ],
        ["Copper", 8.94, "#b87333"],
        ["Silver", 10.49, "silver"],
        ["Gold", 19.30, "gold"],
        ["Platinum", 21.45, "color: #e5e4e2"]
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
        title: "Density of Precious Metals, in g/cm^3",
        width: 800,
        height: 350,
        bar: {groupWidth: "95%"},
        legend: { position: "none" },
      };

          // Instantiate and draw our chart, passing in some options.
          var chart1 = new google.visualization.ColumnChart(document.getElementById('chart_div1'));
          chart1.draw(view, options);
        }
      function drawChart2(){/* ---------------------------------------------------듀얼컬럼그래프 div에 크기정해줘야함 */
    	  var data = google.visualization.arrayToDataTable([
              ['Year', 'Sales', 'Expenses', 'Profit'],
              ['2014', 1000, 400, 200],
              ['2015', 1170, 460, 250],
              ['2016', 660, 1120, 300],
              ['2017', 1030, 540, 350]
            ]);

            var options = {
              chart: {
                title: 'Company Performance',
                subtitle: 'Sales, Expenses, and Profit: 2014-2017',
              }
            };

            var chart = new google.charts.Bar(document.getElementById('chart_div2'));

            chart.draw(data, google.charts.Bar.convertOptions(options));
    	  
      }

      function drawChart3(){/* ---------------------------------------------------바그래프 */
    	 var data = google.visualization.arrayToDataTable([
    	        ["Element", "Density", { role: "style" } ],
    	        ["Copper", 8.94, "#b87333"],
    	        ["Silver", 10.49, "silver"],
    	        ["Gold", 84.30, "gold"],
    	        ["Platinum", 30.45, "color: #e5e4e2"]
    	      ]);
    	      var view = new google.visualization.DataView(data);
    	      view.setColumns([0, 1,
    	                       { calc: "stringify",
    	                         sourceColumn: 1,
    	                         type: "string",
    	                         role: "annotation" },
    	                       2]);
    	      var options = {
    	        title: "Density of Precious Metals, in g/cm^3",
    	        width: 1300,
    	        height: 300,
    	        bar: {groupWidth: "95%"},
    	        legend: { position: "none" },
    	      };
    	      var chart = new google.visualization.BarChart(document.getElementById("chart_div3"));
    	      chart.draw(view, options);    	  
      }
      function drawChart4(){/* ---------------------------------------------------듀얼바그래프는 div에 크기정해줘야함 */
    	  var data = new google.visualization.arrayToDataTable([
              ['Galaxy', 'Distance', 'Brightness'],
              ['Canis Major Dwarf', 8000, 23.3],
              ['Sagittarius Dwarf', 24000, 4.5],
              ['Ursa Major II Dwarf', 30000, 14.3],
              ['Lg. Magellanic Cloud', 50000, 0.9],
              ['Bootes I', 60000, 13.1]
            ]);

            var options = {
              width: 800,
              chart: {
                title: 'Nearby galaxies',
                subtitle: 'distance on the left, brightness on the right'
              },
              bars: 'horizontal', // Required for Material Bar Charts.
              series: {
                0: { axis: 'distance' }, // Bind series 0 to an axis named 'distance'.
                1: { axis: 'brightness' } // Bind series 1 to an axis named 'brightness'.
              },
              axes: {
                x: {
                  distance: {label: 'parsecs'}, // Bottom x-axis.
                  brightness: {side: 'top', label: 'apparent magnitude'} // Top x-axis.
                }
              }
            };

          var chart = new google.charts.Bar(document.getElementById('chart_div4'));
          chart.draw(data, options);
      };
      
      
      
</script>


