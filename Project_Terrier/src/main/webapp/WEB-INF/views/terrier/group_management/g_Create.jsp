<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<!-- 스프링url설정링크 -->
<spring:url value="/resources/list_dual/g_list.js" var="g_list_js"></spring:url>
<spring:url value="/resources/list_dual/g_list.css" var="g_list_css"></spring:url>
<!-- 부트스트랩 링크-->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<!-- 폰트아이콘 링크-->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 부트스트랩 토글 링크-->
<link href="${g_list_css}" rel="stylesheet">
<!-- 제이쿼리 스크립-->
<script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
<!-- 부트스트랩 스크랩-->
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
<!-- 부트스트랩 토글 스크랩 -->
<script src="${g_list_js}"></script>

<style>
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

.g_class td{
	padding-right: 10px;
}
</style>
</head>

<body onload="init();">
<div class="container" style="margin-top:20px; margin-left:0; margin-right:0;  padding-left:0; padding-right:0; width:100%">
	<div class="row-fluid-fluid" id="create_div">
		<div class="col-md-12" style="padding-left: 5px;padding-right:5px;">
			<div class="panel panel-primary">
				<div class="panel-heading" style="background-color: #3367d6;">그룹 생성</div>
				<div class="panel-body" id="emp_list">
					<table style="width:100%" class="g_class">
				 		<tr>
				 			<td><div class="input-group">
	      							<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
	      							<input id="msg" type="text" class="form-control" name="msg" placeholder="Group's Name">
    							</div>
							
				 			<td><a class="btn icon-btn btn-muted apply_butt" href="javascript:g_Create();">생성</a>
				 			
					</table>
				</div>
			</div> 
		</div>
	</div>
	
	
	
	<div class="row-fluid-fluid">


		<div class="col-md-12" style="padding-left: 5px;padding-right:5px;">
			<div class="panel panel-primary">
				<div class="panel-heading" style="background-color: #3367d6;padding-top:3px;padding-bottom:3px; height:40px">
					<div class="col-md-4" style="padding-left: 0px; height:100%;">
				  		<select class="form-control" name="department" id="group_list">
							<option>그룹생성</option>
							<c:forEach items="${list}" var="list">
				        		<option>${list.group_name}</option>
		      				</c:forEach>
				   		</select>
			  		</div>
			  		<div id="button_div" style="padding:0px; margin:0px; display:none;">
						<a class="btn icon-btn btn-muted apply_butt" href="javascript:g_Update();"><i class="fa fa-check" aria-hidden="true"></i> 적용</a>
						<a class="btn icon-btn btn-muted apply_butt" href="javascript:g_Delete();"><i class="fa fa-trash-o" aria-hidden="true"></i> 삭제</a>
					</div>
				</div>
					<div class="panel-body" id="emp_list" style="padding-left: 0px; padding-bottom: 0px;">
		<!--  -->
				        <div class="dual-list list-left col-md-6">
				            <div class="well text-right" style="background-color:#fff">
				                <div class="row">
				                    <div class="col-md-8">
				                        <div class="input-group">
				                            <span class="input-group-addon glyphicon glyphicon-search"></span>
				                            <input type="text" name="SearchDualList" class="form-control" placeholder="search" />
				                        </div>
				                    </div>
				                    <div class="col-md-4">
				                        <div class="btn-group">
				                            <a class="btn btn-default selector all_selector" title="select all"><i class="glyphicon glyphicon-unchecked"></i></a>
				                            <button class="btn btn-default btn-sm move-right" style="width:40px;height:28px">
				               					<span class="glyphicon glyphicon-chevron-right"></span>
				            				</button>
				                        </div>
				                    </div>
				                </div>
				                
				                <div id="all_emp" style="padding:0px;margin:0px;">
					                <ul class="list-group" style="height: 430px;overflow-y: scroll;margin:0px;">
					                </ul>
				                </div>
				            </div>
				        </div>
				        
				        
				        <div id ="list_k"class="dual-list list-right col-md-6" style="padding: 0px;">
				            <div class="well" style="background-color:#fff">
				                <div class="row">
				                    <div class="col-md-4">
				                        <div class="btn-group">
				                            <a class="btn btn-default selector all_selector" title="select all"><i class="glyphicon glyphicon-unchecked"></i></a>
				                            <button class="btn btn-default btn-sm move-left" style="width:40px;height:28px">
				                				<span class="glyphicon glyphicon-chevron-left"></span>
				            				</button>
				                        </div>
				                    </div>
				                    <div class="col-md-8">
				                        <div class="input-group">
				                            <input type="text" name="SearchDualList" class="form-control" placeholder="search" />
				                            <span class="input-group-addon glyphicon glyphicon-search"></span>
				                        </div>
				                    </div>
				                </div>
				                <div id="in_group_emp" style="padding:0px;margin:0px;">
				                	<ul id ="check" class="list-group" style="height: 430px;overflow-y: scroll;margin:0px;">
				                	</ul>
				                </div>
				            </div>
				        </div>
		<!--  -->
				</div>
			</div>
		</div>        
		
	</div>
</div>

<script>
function init()
{
	$("#all_emp").load("all_emp_empty?id=${user_info.id}&group_name="+$("#group_list option:selected").val());
}

function g_Create()
{
	var g_emp_list = new Array();
	
	$('.list-right ul li').find('th').each(function(){
		g_emp_list.push($(this).text().trim());
		//alert($(this).text().trim());
	});
	
	if ($('#msg').val().length == 0) {
		alert("그룹 이름을 설정하십시오.")
	}
	else if ( g_emp_list.length == 0 ) {
		alert("사원이 최소 한명이상 있어야 합니다.")
	} else {
		$.ajax({
			type:"POST",
			url:"/terrier/group_management/group_Check",
			data: {"group_name" : $('#msg').val()},
			success: function(data){
				if(data != 0)
				{
					alert("이미 존재하는 그룹명 입니다.");
				}
				else
				{	
					$.ajax({
						type:"POST",
						url:"g_Update",
						data: {"g_emp_list":g_emp_list,
								"g_name":$('#msg').val()},
						success:function(data){
							//alert("ok생성");
							$('#group_list').append("<option>" + $('#msg').val() +"</option>");
							$('#msg').val('');
							location.reload();
							window.opener.Refresh();
						}
					});
				}
			}
		});
	}
}

$("#group_list").change(function()//그룹리스트에 변화가일어나면..
{

	$(".all_selector").removeClass('selected').closest('.well').find('ul li.active_list').removeClass('active_list');
	$(".all_selector").children('i').removeClass('glyphicon-check').addClass('glyphicon-unchecked');
	
	
	
	if($("#group_list option:selected").val() == "그룹생성")
	{
		$("#all_emp").load("all_emp_empty?id=${user_info.id}&group_name="+$("#group_list option:selected").val());
		$("#in_group_emp").load("in_group_emp_empty");
		
		$("#create_div").show("slow");
		$("#button_div").hide("slow");
	}
	else
	{
		$("#all_emp").load("all_emp?id=${user_info.id}&group_name="+$("#group_list option:selected").val());//all_emp는 NOT IN 맵퍼
		$("#in_group_emp").load("in_group_emp?id=${user_info.id}&group_name="+$("#group_list option:selected").val());//in_group_emp는 IN맵퍼
		
		$("#create_div").hide("slow");
		$("#button_div").show("slow");
	}
});

function g_Delete(){
	var query = {group_name : $("#group_list option:selected").val()};
	
	$.ajax({
		type:"POST",
		url:"/terrier/group_management/group_Delete",
		data: query,
		success: function(data){
			location.reload();
			window.opener.Refresh();
		}
	});
}

/*적용,생성 버튼눌렀을댸*/
function g_Update(){
	var g_emp_list = new Array();
	
	$('.list-right ul li').find('th').each(function(){
		g_emp_list.push($(this).text().trim());
		//alert($(this).text().trim());
	});
	
	if ( g_emp_list.length == 0 ) {
		alert("사원이 최소 한명이상 있어야 합니다.")
	} else {
		$.ajax({
			type:"POST",
			url:"g_Update",
			data: {"g_emp_list":g_emp_list,
					"g_name":$("#group_list option:selected").val()},
			success:function(data){
				//alert("ok");
				location.reload();
				window.opener.Refresh();
			}
		});
	}
	
}
</script>
</body>
</html>
