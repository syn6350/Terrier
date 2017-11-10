<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<script src="/webjars/jquery-knob/1.2.13/dist/jquery.knob.min.js"></script>
<title>통계 디자인 테스트</title>

<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-stats"></span>&nbsp;통계 관리 - 통계 관리 테스트
	</div>
	
	
	

	<div class="col-md-3" style="padding-left: 5px;padding-right:0px;">
	    	<div class="panel panel-primary">
	      		<div class="panel-heading" style="background-color: #3367d6;">출퇴근 현황</div>
	      		<div class="panel-body">
	      			<table border="1">
	      				<tr>
							<td rowspan="2"><input type="text" class="knob" value="80" data-width="90" data-height="90" data-fgColor="#3367d6" data-readonly="true"><!-- <input type="text" class="knob" value="70" data-skin="tron" data-thickness="0.2" data-width="90" data-height="90" data-fgColor="#3367d6" data-readonly="true"> -->
							<td>전체 사원 수 : 14명
						<tr>
							<td>출근 사원 수 : 9명
					</table>
	      		</div>
	      	</div>
	</div>
</div>





<script>
$(".knob").knob({
      draw: function () {

        // "tron" case
        if (this.$.data('skin') == 'tron') {

          var a = this.angle(this.cv)  // Angle
              , sa = this.startAngle          // Previous start angle
              , sat = this.startAngle         // Start angle
              , ea                            // Previous end angle
              , eat = sat + a                 // End angle
              , r = true;

          this.g.lineWidth = this.lineWidth;

          this.o.cursor
          && (sat = eat - 0.3)
          && (eat = eat + 0.3);

          if (this.o.displayPrevious) {
            ea = this.startAngle + this.angle(this.value);
            this.o.cursor
            && (sa = ea - 0.3)
            && (ea = ea + 0.3);
            this.g.beginPath();
            this.g.strokeStyle = this.previousColor;
            this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, sa, ea, false);
            this.g.stroke();
          }

          this.g.beginPath();
          this.g.strokeStyle = r ? this.o.fgColor : this.fgColor;
          this.g.arc(this.xy, this.xy, this.radius - this.lineWidth, sat, eat, false);
          this.g.stroke();

          this.g.lineWidth = 2;
          this.g.beginPath();
          this.g.strokeStyle = this.o.fgColor;
          this.g.arc(this.xy, this.xy, this.radius - this.lineWidth + 1 + this.lineWidth * 2 / 3, 0, 2 * Math.PI, false);
          this.g.stroke();

          return false;
        }
      }
    });
</script>

