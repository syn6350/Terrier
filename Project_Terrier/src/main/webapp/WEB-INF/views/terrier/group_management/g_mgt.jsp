<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>
그룹 관리
</title>

<style>
#table tr{
	width:100%;
	display: inline-table;
}
#tbody{
	overflow-y: scroll;
	display: block;
	height: 200px;
}
.loc_butt{
	height:24px;
	padding:2px 7px;
	margin:0px;
	
	background-color: #ffffff;
	border:1px solid #dddddd;
	color:#333333;
}

.loc_butt:hover {
	background-color: #e6e6e6;
	border:1px solid #adadad;
}

.apply_butt{
	margin:0px;
	width:100px;
	background-color: #ffffff;
	border:1px solid #dddddd;
	color:#333333;
}

.apply_butt:hover{
	background-color: #e6e6e6;
	border:1px solid #adadad;
}

.click_g_list{
	background-color: #f5f5f5;
}

</style>

<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-th"></span>&nbsp;&nbsp;그룹 관리
	</div>
	
                                                
	<div class="container-fluid" style="margin-top:20px;">
		
  		<div class="row"><!-- 1번째줄 -->
    	
    	<div class="col-md-3" style="padding-left: 5px;">    
    	  <div class="panel panel-primary">
	  	  	<div class="panel-heading" style="background-color: #3367d6;">
	  	  		그룹 리스트
	  	  		<div style="float:right;">
	  	  			<a class="btn icon-btn btn-muted loc_butt" href="javascript:g_Create();">그룹 관리</a>
	  	  			<!-- <a class="btn icon-btn btn-muted loc_butt" href="#">수정</a>
	  	  			<a class="btn icon-btn btn-muted loc_butt" href="#">삭제</a> -->
	  	  		</div>
	  	  		
	  	  	</div>
	  	  	<div class="panel-body" style="padding: 0px;">	  	  		
				  <table id="table" class="table table-hover" style="margin:0px;">
				    <thead>             
				      <tr>
				        <th style="width:65%">그룹 이름</th>
				        <th style="width:35%">인원</th>
				      </tr>

				    </thead>
				    
				    <tbody id="tbody">
				    
				    <c:forEach items="${list}" var="list">
				      	<tr class="group_list" style="cursor:pointer;" onClick="Employee_list('${list.group_name}',this);">
				        	<td style="width:70%">${list.group_name}</td>
				        	<td style="width:30%">${list.group_rows}</td>
				      	</tr><!-- 객체불러와서 다뽑을 예정 -->
		      		</c:forEach>
		      		
				    </tbody>
				  </table>
      	  	</div><!-- panel-body -->
     	  </div>     
   	 	</div>
    
   	 	<div class="col-md-9" style="padding-left: 5px;padding-right:5px;">
    	   <div class="panel panel-primary">
		   	   <div class="panel-heading" style="background-color: #3367d6;">그룹 사원 리스트</div>
		   	   <div class="panel-body" id="emp_list" style="padding: 0px;">
	          	<table id="table" class="table table-hover" style="margin:0px;">
				    <thead>
				      <tr>
				        <th style="width:20%">사원번호</th>
				        <th style="width:20%">부서명</th>
				        <th style="width:20%">직책</th>
				        <th style="width:20%">번호</th>
				        <th style="width:20%">이름</th>
				      </tr>

				    </thead>
				    
				    <tbody id="tbody">
				      
		      
				    </tbody>
				  </table>
	      	   </div>
     	  </div> 
    	</div>	
 	 </div><!-- row1 -->
  
  
  		<div class="row"><!-- 2번째줄 --> 	
    	<div class="col-md-3" style="padding-left: 5px;padding-right:5px;">    
    	  <div class="panel panel-primary">
	  	  	<div class="panel-heading" style="background-color: #3367d6;">제어 관리</div>
	  	  	<div class="panel-body" style="padding-right: 0px"> 
	  	  	
	  	  	<table style="width:100%">
	  	  		<tr>
	  	  			<td><i class="fa fa-wifi" aria-hidden="true"></i>
	  	  			<td>Wifi
	  	  			<td>
	  	  			<div class=col-md-10>
		  	  			<select class="form-control" id="CW_sel"> 
							<option value="DE">Default</option> 
							<option value="ON">ON</option>
							<option value="OFF">OFF</option> 
					 	</select>
				 	</div>
	  	  		</tr> 
	  	  		
	  	  		<tr>
	  	  			<td><i class="fa fa-bluetooth" aria-hidden="true"></i>
	  	  			<td>BlueTooth
	  	  			<td>
	  	  			<div class=col-md-10>
		  	  			<select class="form-control" id="CB_sel"> 
							<option value="DE">Default</option> 
							<option value="ON">ON</option>
							<option value="OFF">OFF</option> 
					 	</select>
				 	</div>
	  	  		</tr>
	  	  		
	  	  		<tr>
	  	  			<td><i class="fa fa-android" aria-hidden="true"></i>
	  	  			<td>Tethering
	  	  			<td>
	  	  			<div class=col-md-10>
		  	  			<select class="form-control" id="CT_sel"> 
							<option value="DE">Default</option> 
							<option value="ON">ON</option>
							<option value="OFF">OFF</option> 
					 	</select>
				 	</div>
	  	  		</tr>
	  	  		
	  	  		<tr>
	  	  			<td><i class="fa fa-camera" aria-hidden="true"></i>
	  	  			<td>Camera
	  	  			<td>
	  	  			<div class=col-md-10>
		  	  			<select class="form-control" id="MC_sel"> 
							<option value="DE">Default</option> 
							<option value="ON">ON</option>
							<option value="OFF">OFF</option> 
					 	</select>
				 	</div>
	  	  		</tr>
	  	  		
	  	  		<tr>
	  	  			<td><i class="fa fa-microphone" aria-hidden="true"></i>
	  	  			<td>VoiceRecord
	  	  			<td>
	  	  			<div class=col-md-10>
		  	  			<select class="form-control"id="MR_sel"> 
							<option value="DE">Default</option> 
							<option value="ON">ON</option>
							<option value="OFF">OFF</option> 
					 	</select>
				 	</div>
	  	  		</tr>
	  	  		
	  	  		<tr>
	  	  			<td colspan="3" align="center" style="padding-top:10px; padding-left:0px;">
	  	  			     	 		<a class="btn icon-btn btn-muted apply_butt" href="javascript:apply();">적용</a>
	 
			</table>
      	  	</div>
     	  </div>     
   	 	</div>
    
   	 	<div class="col-md-9" style="padding-left: 5px;padding-right:5px;">
    	   <div class="panel panel-primary">
		   	   <div class="panel-heading" style="background-color: #3367d6;">그룹 로그</div>
		   	   <div class="panel-body" style="padding: 0px;">
	          	<table id="table" class="table table-hover" style="margin:0px;">
				    <thead>
				      <tr>
				        <th style="width:15%">그룹명</th>
				        <th style="width:35%">제어</th>
				        <th style="width:25%">ON/OFF</th>
				        <th style="width:25%">날짜</th>
				      </tr>

				    </thead>
				    
				    <tbody id="tbody" style="height:238px">
	
				      <c:forEach items="${log}" var="log">
				      	<tr>
				      		<td style="width:15%;">${log.group_name}</td>
				      		<c:choose>
				      			<c:when test="${log.group_con=='MC'}">
				      				<td style="width:35%">Camera</td>
				      			</c:when>
				      			<c:when test="${log.group_con=='CT'}">
				      				<td style="width:35%">Tethering</td>
				      			</c:when>
				      			<c:when test="${log.group_con=='CB'}">
				      				<td style="width:35%">BlueTooth</td>
				      			</c:when>
				      			<c:when test="${log.group_con=='CW'}">
				      				<td style="width:35%">Wifi</td>
				      			</c:when>
				      			<c:when test="${log.group_con=='MR'}">
				      				<td style="width:35%">VoiceRecord</td>
				      			</c:when>
							</c:choose>
				      		<td style="width:25%;">${log.group_active}</td>
				      		<td style="width:25%;">${log.reg}</td>
				      </c:forEach>

				    </tbody>
				  </table>
	      	   </div>
     	  </div> 
    	</div>	
 	 </div><!-- row2 -->
 	 
	</div><!-- container-fluid -->
</div><!-- content -->

<script>
var group_name='';
var group_owner="${user_info.id}";

function apply()/* 적용버튼눌렀을때 */
{
		if(group_name=='')
		{
			alert("그룹을 선택해주세요");
		}
		else/* 그룹선택 정상적으로 선택했을때 */
		{			
			var jobj=new Object();/*JSON보내기 오브젝트용*/
			jobj.group_name=group_name;
			jobj.group_owner=group_owner;		
			var array=new Array();/* 제어와 on,off표시 */
			
			var cw=$("#CW_sel option:selected").val();
			var cb=$("#CB_sel option:selected").val();
			var ct=$("#CT_sel option:selected").val();
			var mc=$("#MC_sel option:selected").val();
			var mr=$("#MR_sel option:selected").val();
			
			if(cw=='ON'){array.push("CW:ON");}
			else if(cw=='OFF'){array.push("CW:OFF");}
			
			if(cb=='ON'){array.push("CB:ON");}
			else if(cb=='OFF'){array.push("CB:OFF");}
			
			if(ct=='ON'){array.push("CT:ON");}
			else if(ct=='OFF'){array.push("CT:OFF");}
		
			if(mc=='ON'){array.push("MC:ON");}
			else if(mc=='OFF'){array.push("MC:OFF");}
			
			if(mr=='ON'){array.push("MR:ON");}
			else if(mr=='OFF'){array.push("MR:OFF");}
			
			jobj.group_con=array;		
 			$.ajax({
				type:"GET",
				contentType:'application/json,charset=UTF-8',
				dataType:'jsonp',
				data:jobj,
				crossDomain:true,
				url:'http://58.141.234.126:55376/process/devicepushgroup?data',
				jsonp:'callback',
				success:function(data)
				{				
					alert("전송 성공");
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
			
 			if(array.length>0)/*선택한게 아무것도없으면 0임.*/
			{ 	
				for(var i=0;i<array.length;i++)
					{
						var sp=array[i];
						var arrtest=sp.split(':');
						var group_con=arrtest[0];
						var group_active=arrtest[1];
		 				$.ajax({
							type:'post',
							url:'/mdmservice/g_mgt_log',
							headers:{
								"Content-Type":"application/json",
								"X-HTTP-Method-Override":"POST"},
							dataType:'text',
							data:JSON.stringify({group_name:group_name, group_owner:group_owner, group_con:group_con, group_active:group_active}),
							success:function(result)
							{
								if(result=="SUCCESS"){}
							}				
						});
					}
			}
			alert("적용완료")
			Refresh();
		}
}

function Refresh()
{
	location.reload();
}

function Employee_list(group,obj){
	var test="${user_info.id}";
	$(obj).addClass('click_g_list');
	$(".group_list").not(obj).each(function(){
		$(this).removeClass('click_g_list');
	});
	$("#emp_list").load("emp_list?id=${user_info.id}&group_name="+group);
	group_name=group;/* 선택된 그룹이름 전역변수 값입력 */
}

function g_Create()
{
	url = "g_Create";
	specs = "width=1000,height=750,top=0";
	window.open(url,"", specs);
}
</script>