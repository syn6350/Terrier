<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
    
<div id=chart_div4 style="width: 100%; height: 300px;"></div>
    
    
<script>
	//Load the Visualization API and the corechart package.	
	google.charts.load('current', {'packages':['corechart']});/* �Ϲ����� ��Ʈ�ε� */     
	google.charts.load('current', {'packages':['bar']}); /* ����̳� Ʈ������ �ش� ��Ʈ�� �ε��ؾ��� */
	// Set a callback to run when the Google Visualization API is loaded.
	
	google.charts.setOnLoadCallback(drawChart4);
	
	function drawChart4() {
		var dep = "${department}" + "��";
		var data = google.visualization.arrayToDataTable([
	            [dep+' ���� ��Ȳ', 'ON', 'OFF'],
	            ['Wifi', ${d_count_on.wifi}, ${d_count_off.wifi}],
	            ['Bluetooth', ${d_count_on.bluetooth}, ${d_count_off.bluetooth}],
	            ['Tethering', ${d_count_on.tethering}, ${d_count_off.tethering}],
	            ['Camera', ${d_count_on.camera}, ${d_count_off.camera}],
	            ['VoiceRecord', ${d_count_on.voiceRecord}, ${d_count_off.voiceRecord}]
	          ]);

	          var options = {
		              animation:{
		      			startup: true,
		      			duration: 1000,
		      			easing: 'out'
		      		  }
	          };

	          var chart = new google.charts.Bar(document.getElementById('chart_div4'));
	          chart.draw(data, google.charts.Bar.convertOptions(options));

	}
</script>