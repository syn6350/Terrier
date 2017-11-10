<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.apply_butt{
		margin:0px;
		width:100%;
		background-color: #ffffff;
		border:1px solid #dddddd;
		color:#333333;
		white-space:nowrap;
	}
	
	.apply_butt:hover{
		background-color: #e6e6e6;
		border:1px solid #adadad;
	}
	
	.textview {
		border:1px solid #cccccc;
		padding:4px 12px 1px 12px;
		border-radius: 5px;
	}
</style>


<title>요청 관리</title>

<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-send"></span>&nbsp;요청
	</div>
	
	<div class="col-md-12" style="padding:0">    
		<div class="panel panel-primary">
			<div class="panel-heading" style="background-color: #3367d6;">요청 대기 내역</div>
			<div class="panel-body">	  	  		
				<div class="form-group">
					요청 사원
					<div class="textview">
						${vo.employee_num}
					</div>
				</div>
								
				<div class="form-group">
					요청 제어
					<div class="textview">
						${vo.title}
					</div>
				</div>
				
				<div class="form-group">
					첨부 파일
					<div class="textview">
						<a href="#">없음</a>
					</div>
				</div>
				
				<div class="form-group">
					세부 내용
					<div class="textview" style="height: 20%; overflow-y:scroll; ">
						${vo.contents}
					</div>
				</div>
				
				<div class="form-group col-md-3" style="float: right; padding:0px; margin-top: 0px;">
						<table style="float: right;">
							<tr>
								<td style="padding-right: 5px;"><button type="submit" class="btn icon-btn btn-muted apply_butt" id="1" >승인</button>
								<td style="padding-right: 5px;"><button type="submit" class="btn icon-btn btn-muted apply_butt" id="2" >거부</button>
								<td><button type="submit" class="btn icon-btn btn-muted apply_butt" id="3" >목록</button>
						</table>
				</div>			
			</div>
		</div>
	</div>
</div>

<script>
	$("#1").on("click",function(){
		
		var control = "${vo.title}";
		var controller = control.split(" ");
		
		if(controller[0] == "와이파이")
			controller[0] = "CW";
		else if(controller[0] == "블루투스")
			controller[0] = "CB";
		else if(controller[0] == "테더링")
			controller[0] = "CT";
		else if(controller[0] == "카메라")
			controller[0] = "MC";
		else if(controller[0] == "음성녹음")
			controller[0] = "MR";
			
		if(controller[1] == "허용")
			controller[1] = "ON";
		else
			controller[1] = "OFF";
		
		
		var data={}
		data["controller"]=controller[0];
		data["emp"]="${vo.employee_num}";
		data["onoff"]=controller[1];
		
		$.ajax({
			type:"GET",
			contentType:'application/json,charset=UTF-8',
			dataType:'jsonp',
			data:data,
			crossDomain:true,
			url:'http://58.141.234.126:55376/process/devicepush?data',
			jsonp:'callback',
			success:function(data)
			{
				
				alert("크로스 도메인 전송 성공");
				if(data.check=="true")
				{
					alert("check : " + data.check);
					$.ajax({
						type:"POST",
						dataType:'text',
						data: {bno:'${bno}'},
						url:'/terrier/request_management/grant',
						success:function(data)
						{
							if(data=="SUCCESS"){
								alert("승인하였습니다.");
								location.href = "/terrier/request_management/w_list";
							}
						},
						error:function(jqXHR,exception)
						{
							alert("전송실패");
							return false;
						}
					});
				}
				else
				{
					alert("check : " + data.check);
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
					
		});
	});
	
	$("#2").on("click",function(){
		$.ajax({
			type:"POST",
			dataType:'text',
			data: {bno:'${bno}'},
			url:'/terrier/request_management/deny',
			success:function(data)
			{
				if(data=="SUCCESS"){
					alert("거부하였습니다.");
					location.href = "/terrier/request_management/w_list";
				}
			},
			error:function(jqXHR,exception)
			{
				alert("전송실패");
				return false;
			}
		});
	});
	
	$("#3").on("click",function(){
		window.history.back();
	});
</script>