<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
			<div class="panel-heading" style="background-color: #3367d6;">요청 완료 내역</div>
			<div class="panel-body">	  	  		
				<div class="form-group">
					요청 완료일
					<div class="textview">
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${vo.date}"/>
					</div>
				</div>
				
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
					요청 여부
					<div class="textview">
						<c:choose>
							<c:when test="${vo.admit == 1}">
								승인
							</c:when>
							<c:otherwise>
								거부
							</c:otherwise>
						</c:choose>
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
								<td><button type="submit" class="btn icon-btn btn-muted apply_butt" id="1" >목록</button>
						</table>
				</div>	
						
			</div>
		</div>
	</div>
</div>

<script>
	$("#1").on("click",function(){
		window.history.back();
	});
</script>