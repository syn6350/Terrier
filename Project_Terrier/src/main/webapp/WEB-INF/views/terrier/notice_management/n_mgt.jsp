<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
.board_num {
	min-width: 1px;
}

.apply_butt{
	margin:0px;
	width:100%;
	background-color: #ffffff;
	border:1px solid #dddddd;
	color:#333333;
}

.apply_butt:hover{
	background-color: #e6e6e6;
	border:1px solid #adadad;
}

</style>

<div id="content" class="col-md-10 nav_and_content">

	<div id="title">
		<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;공지사항
	</div>
		
	<div class="col-md-6" style="float: right; padding:0px 0px 10px 0px;">
		<div class="col-md-3" style="padding-right: 0">
			<select class="form-control" name="department">
				<option>제목</option>
				<option>제목 + 내용</option>					
			</select>
		</div>
		<div class="col-md-7" style="padding-right: 0">
			<input type="text" class="form-control">
		</div>
		<div class="col-md-2" style="padding-right: 0">
			<a class="btn icon-btn btn-muted apply_butt" href="#"><span class="glyphicon glyphicon-search"></span> 검색</a>
		</div>
	</div>
	
	<fmt:formatDate pattern="yyyy-MM-dd" value="${time}" var="nowtime"/>

	<table class="table table-hover table-striped table-bordered" style="margin-bottom:10px;">
		<thead>
			<tr>
				<td class="board_num">번호
				<td class="board_title">제목
				<td class="board_writer">작성자
				<td class="board_date">등록일
				<td class="board_hit">조회
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.bno}
					<td><a href="/terrier/notice_management/n_read${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${list.bno}">${list.title}<c:if test="${list.replycnt ne 0 }"> <font color="#3367d6">[${list.replycnt}]</font> </c:if> </a>					
					<fmt:formatDate pattern="yyyy-MM-dd" value="${list.regdate}" var="date"/>
						<c:if test="${nowtime eq date }">
							<span class="label label-default" style="background-color: #3367d6; padding:2px 4px;">New</span>
						</c:if>
					<td>${list.writer}
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.regdate}"/></td>
					<td>${list.viewcnt}
				</tr>
			</c:forEach>	
			
					
		<!-- 			
			<tr>
					<span class="label label-default" style="background-color: #759ddf; padding:2px 4px;">File</span>
			<tr> 
		-->
			
			
		</tbody>
	</table>
	
	
	<div class="col-md-1" style="float: right; padding:0px; margin-top: 0px; word-wrap: break-word;">
		<a class="btn icon-btn btn-muted apply_butt" href="n_create">글작성</a>
	</div><!-- container-fluid -->
	
<div class="text-center">
	<ul class="pagination">
		<!-- 이전표시를 남기는것 조건문 -->
		<c:if test="${pageMaker.prev}">
			<li><a href="n_mgt${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
		</c:if>
		
		<!-- 아래번호판을 선택했을때 액션들 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
			<li
				<c:out value="${pageMaker.cri.page==idx?'class=active':''}"/>>
				<a href="n_mgt${pageMaker.makeSearch(idx)}">${idx}</a><!-- 페이지를 누를때마다 계속 uri요청을 하여 리바인딩하는형식 -->
			</li>
		</c:forEach>
		
		<!-- 다음 표시를 남기는 조건문 -->
		<c:if test="${pageMaker.next && pageMaker.endPage>0}">
			<li><a href="n_mgt${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
		</c:if>		
		
	</ul>
</div><!-- ./center -->
	
	
	

	
	
	
	
	
	
	
<!-- 	
	<div class="col-md-12" style="padding:0px 0px 10px 0px; text-align: center;">
		<ul class="pagination" style="padding:0; margin:0;">
			<li><a href="#">«</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">»</a></li>
		</ul>
	</div> -->
</div><!-- col-md-10 -->


<script>
var ok='${msg}';
if(ok=="OK")
	{
		alert("작성성공");
	}
var r_ok='${r_msg}';
if(r_ok=="OK")
	{
		alert("삭제성공");
	}
else if(r_ok=="NO")
	{
		alert("작성자가 다릅니다");
	}

</script>