<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>단말 관리</title>
<style>

.on_button{
  cursor:pointer;
  width:85px;
  height:30px;
  font-size:13px;
  
  border: 1px solid #cccccc;
  border-radius: 3px;
  border-spacing:0px;
}

.on_button td , .off_button td{
  text-align:center;
}

.on_button .on_button_on {
  border-right: 1px solid #cccccc;
  background-color:#3367d6;
  color:#ffffff;
  width:50%;
}
.on_button .on_button_off {
  background-color:#ffffff;
  width:50%;
}

.off_button{
  cursor:pointer;
  width:85px;
  height:30px;
  font-size:13px;
  
  border: 1px solid #cccccc;
  border-radius: 3px;
  border-spacing:0px;
}

.off_button .off_button_on {
  border-right: 1px solid #cccccc;
  background-color:#ffffff;
  width:50%;
}
.off_button .off_button_off {
  background-color:#e6e6e6;
  color:#3367d6;
  width:50%;
}

/* controll_view onoff style */
.on_view{
  border: 1px solid #cccccc;
  padding: 0px 3px;
  border-radius: 5px;
  border-spacing:0px;
  background-color:#3367d6;
  font-size:1px;
}

.off_view{
  border: 1px solid #cccccc;
  padding: 0px 3px;
  border-radius: 5px;
  border-spacing:0px;
  background-color:#e6e6e6;
  font-size:1px;
}
</style>


<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-phone"></span>&nbsp;단말 관리
	</div>
	
	<div class="jumbotron" style="background-color: #3367D6; 
	padding-bottom:5px; padding-top: 5px;">
		
		<form id="search_form" role="form">
		<div class="form-group row">	
			<div class="col-md-2">
		        <label for="employee_num" style="color:#ffffff;font-weight:bold;">사원번호</label>
		        <input class="form-control" id="employee_num" name="employee_num" type="text" placeholder="ex) 16011018" value="${vo.employee_num}">
     		 </div>     		 
			
			
			<div class="col-md-2">
				<label for="department" style="color:#ffffff;font-weight:bold;">부서명</label>
				  <select class="form-control" name="department" >
					  <option value="선택" <c:out value="${vo.department==null?'selected':'' }"/>>선택</option>
					  <option value="인사" <c:out value="${vo.department eq '인사'?'selected':''}"/>>인사</option>
					  <option value="기술"<c:out value="${vo.department eq '기술'?'selected':''}"/>>기술</option>
					  <option value="생산"<c:out value="${vo.department eq '생산'?'selected':''}"/>>생산</option>
					  <option value="총무"<c:out value="${vo.department eq '총무'?'selected':''}"/>>총무</option>
				   </select>
			  </div>
			  
			  <div class="col-md-2">
				<label for="rank" style="color:#ffffff;font-weight:bold;">직책</label>
				  <select class="form-control" name="rank">
					  <option value="선택" <c:out value="${vo.rank==null?'selected':'' }"/>>선택</option>
					  <option value="사원" <c:out value="${vo.rank eq '사원'?'selected':'' }"/>>사원</option>
					  <option value="주임" <c:out value="${vo.rank eq '주임'?'selected':'' }"/>>주임</option>
					  <option value="대리" <c:out value="${vo.rank eq '대리'?'selected':'' }"/>>대리</option>
					  <option value="과장" <c:out value="${vo.rank eq '과장'?'selected':'' }"/>>과장</option>
					  <option value="차장" <c:out value="${vo.rank eq '차장'?'selected':'' }"/>>차장</option>
					  <option value="부장" <c:out value="${vo.rank eq '부장'?'selected':'' }"/>>부장</option>
				   </select>
			  </div>
					  
			 <div class="col-md-2">
				<label for="phone" style="color:#ffffff;">번호</label>
				<input type="text" class="form-control" id ="phone" name="phone" placeholder="ex) 01000000000" value="${vo.phone}">
			</div>	
			<div class="col-md-2">
				<label for="name" style="color:#ffffff;">이름</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="ex) 홍길동" value="${vo.name}">
			</div>
						
			<div class="col-md-2">
				<br>
				<button id="search_button" type="submit" class="btn btn-default btn-lg" style=" margin-top:-7px; color:#3367D6;"><span class="glyphicon glyphicon-search"></span> 검색</button>
			</div>
		</div><!-- 그룹 -->
		</form>

	</div><!-- jumbotron search -->
		
	
		
	<!-- 테이블 -->
	<table class="table table-hover table-striped table-bordered">
			<thead><!-- 리스트목록 -->
		      <tr >
		        <th>사 번</th>
		        <th>부 서 명</th>
		        <th>직 책</th>
		        <th>번 호</th>
		        <th>이 름</th>  
		        <th style="text-align: center">출/퇴근</th>     
		      </tr>
		    </thead>
		    
		    
			<tbody><!-- 리스트 상세명단 -->
		      
		      <c:forEach items="${list}" var="list">
		      	
		      		<td style="cursor: help;" onclick="view_controll(${list.employee_num});">${list.employee_num}
		      		<td style="cursor: help;" onclick="view_controll(${list.employee_num});">${list.department}
					<td style="cursor: help;" onclick="view_controll(${list.employee_num});">${list.rank}
					<td style="cursor: help;" onclick="view_controll(${list.employee_num});">${list.phone}
					<td style="cursor: help;" onclick="view_controll(${list.employee_num});">${list.name}
					<td align="center">
						
						
						<div class="controll_info" id="${list.employee_num}">
							
							<c:choose>
								<c:when test="${list.active=='on'}">
									<table class="on_button" onclick="c_mdt(${list.employee_num});">
									<tr><td class="on_button_on">ON<td class="on_button_off">OFF</table>
								</c:when>
								
								<c:otherwise>
									<table class="off_button" onclick="c_mdt(${list.employee_num});">
									<tr><td class="off_button_on">ON   <td class="off_button_off">OFF</table>
								</c:otherwise>
							</c:choose>				
						
						</div>
						
					</td>			
		      	
		      	<tr class="controll_view" id="${list.employee_num}_controll_view" style="display: none; font-size: 13px">
		      		<td colspan="6">
		      				<div class="col-md-2" style="padding:0px;padding:0px;text-align: center;">
								제어 현황
							</div>
							
							<div id="wifi" class="col-md-2" style="padding:0px;padding:0px;">
								Wifi <span class="off_view">&nbsp;</span>
							</div>
							
							<div id="bluetooth" class="col-md-2" style="padding:0px;padding:0px;">
								Bluetooth <span class="off_view">&nbsp;</span>
							</div>
							
							<div id="tethering" class="col-md-2" style="padding:0px;padding:0px;">
								Tethering <span class="off_view">&nbsp;</span>
							</div>
							
							<div id="camera" class="col-md-2" style="padding:0px;padding:0px;">
								Camera <span class="off_view">&nbsp;</span>
							</div>
							
							<div id="voicerecord" class="col-md-2" style="padding:0px;padding:0px;">
								VoiceRecord <span class="off_view">&nbsp;</span>
							</div>
		      	</tr>
		      	
		      </c:forEach>
		      
		    </tbody>
	
		</table>
	</div><!-- container -->

<script>

function c_mdt(e_num)
{
	url = "c_mgt?e_num=" + e_num;
	specs = "width=1000,height=750,top=0";
	window.open(url,"", specs);
}

function view_controll(e_num)
{
	var maxHeight;
	
	if($("#"+e_num+"_controll_view").css("display") == "none")
	{
		$.ajax({
			url : "http://58.141.234.126:9405/terrier/device_management/controll_view",
	        type: "get",
	        data : { "e_num" : e_num },
	        success : function(responseData){
	            var data = responseData;
	            
	            if(data.wifi == "on")
	            	$("#"+e_num+"_controll_view").find("#wifi").find("span").attr('class','on_view');
	            if(data.bluetooth == "on")
	            	$("#"+e_num+"_controll_view").find("#bluetooth").find("span").attr('class','on_view');
	           	if(data.tethering == "on")
	           		$("#"+e_num+"_controll_view").find("#tethering").find("span").attr('class','on_view');
				if(data.camera == "on")
					$("#"+e_num+"_controll_view").find("#camera").find("span").attr('class','on_view');
				if(data.voiceRecord == "on")
					$("#"+e_num+"_controll_view").find("#voicerecord").find("span").attr('class','on_view');
				
	        },
		    error: function() {
		    	alert("에러");
		    }        
		});
		
		$("#"+e_num+"_controll_view").show("fest");
		
		//전체 높이 증가
		$('.nav_and_content').each(function() {
	    	maxHeight = maxHeight > $(this).height() ? maxHeight : $(this).height();
	  	});
		$('.nav_div').css('min-height', maxHeight+30);
	}
	else
	{
		$("#"+e_num+"_controll_view").hide("fest");
		
		
		//전체 높이 감소
		$('.nav_and_content').each(function() {
	    	maxHeight = maxHeight > $(this).height() ? maxHeight : $(this).height();
	  	});
		$('.nav_div').css('min-height', maxHeight-30);
	}
}

$(document).ready(function(){
	var formObj=$("form[role='form']");
	$("#search_button").on("click",function(){//검색 활성화	
		formObj.attr("action","d_mgt_search");
		formObj.attr("method","get");
		formObj.submit();
	});
	
		var wsUri = "ws://58.141.234.126:9405/terrier/device_management/";
		//192.168.219.105
		//58.141.234.126:8745
    
		websocket = new WebSocket(wsUri);
    	websocket.onopen = function(evt) { onOpen(evt) };
    	websocket.onmessage = function(event) { onMessage(event) };
    
    	function onOpen(evt) {
    		//alert("소켓연결성공");
    	}
   
    function onMessage(evt) {
    	/* alert(evt.data); */
    	var info = (evt.data).split(':');
    	var emp_num = info[0];
    	var active = info[1];
    	
    	if(active == "on")
    	{
    		$("#"+emp_num).html("<table class='on_button' onclick='c_mdt(" + emp_num + ");'><tr><td class='on_button_on'>ON<td class='on_button_off'>OFF</table>");    	    	
    	}
    	else
    	{
    		$("#"+emp_num).html("<table class='off_button' onclick='c_mdt(" + emp_num + ");'><tr><td class='off_button_on'>ON<td class='off_button_off'>OFF</table>");
    	}
    }
	
});//ready

</script>

