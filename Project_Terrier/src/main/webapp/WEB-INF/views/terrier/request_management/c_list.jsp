<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<title>요청 관리</title>

<div id="content" class="col-md-10 nav_and_content">
	<div id="title">
		<span class="glyphicon glyphicon-send"></span>&nbsp;요청 완료 리스트
	</div>
	
	<div class="jumbotron" style="background-color: #3367D6; 
	padding-bottom:5px; padding-top: 5px;">
		
		<form id="search_form" role="form">
		<div class="form-group row">	
			<div class="col-md-1">
		        <label for="control" style="color:#ffffff;font-weight:bold;">제어</label>
		        <c:set var="title" value="${fn:split(vo.title,'%')}" />
		        <input class="form-control" id="title_s" name="title" type="text" placeholder="ex) 와이파이 ex) 차단 ex) 와이파이 차단" value="${title[0]}">
     		</div>     		 
			
			<div class="col-md-2">
		        <label for="employee_num" style="color:#ffffff;font-weight:bold;">사번</label>
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
				<label for="name" style="color:#ffffff;">이름</label>
				<input type="text" class="form-control" id="name" name="name" placeholder="ex) 홍길동" value="${vo.name}">
			</div>
			
			<div class="col-md-2">
				<label for="date" style="color:#ffffff;">날짜</label>
				<c:set var="date" value="${fn:split(vo.date,'%')}" />
				<input type="date" class="form-control" id="date" name="date" value="${date[0]}">
			</div>
						
			<div class="col-md-1">
				<br>
				<button id="search_button" type="submit" class="btn btn-default btn-lg" style=" margin-top:-7px; color:#3367D6;"><span class="glyphicon glyphicon-search"></span> 검색</button>
			</div>
		</div><!-- 그룹 -->
		</form>

	</div><!-- jumbotron search -->
	
	<table class="table table-hover table-striped table-bordered" style="margin-bottom:10px;">
		<thead>
			<tr>
				<td>요청 번호
				<td>제어
				<td>사번
				<td>부서명
				<td>직책
				<td>이름
				<td>등록일
				<td>승인/거부
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">${list.bno}
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">${list.title}
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">${list.employee_num}
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">${list.department}
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">${list.rank}
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">${list.name}
					<td style="cursor: pointer;" onclick="read_request(${list.bno});"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.date}"/></td>
					<td style="cursor: pointer;" onclick="read_request(${list.bno});">
						<c:choose>
							<c:when test="${list.admit == 1}">
								승인
							</c:when>
							<c:otherwise>
								거부
							</c:otherwise>
						</c:choose>
					</td>
			</c:forEach>
		</tbody>
	</table>
	
	<c:set var="uri" value="${fn:split(requestScope['javax.servlet.forward.request_uri'],'/')}" />
	<c:set var="send_data" value="&title=${title[0]}&employee_num=${vo.employee_num}&department=${vo.department}&rank=${vo.rank}&name=${vo.name}&date=${date[0]}"/>
	
	<div class="text-center">
		<ul class="pagination">
			<!-- 이전표시를 남기는것 조건문 -->
			<c:if test="${pageMaker.prev}">
				<c:choose>
				    <c:when test="${uri[2] eq 'c_list'}">
				    	<li><a href="c_list${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
				    </c:when>
					
					<c:otherwise>
						<li><a href="c_list_search${pageMaker.makeSearch(pageMaker.startPage -1)}${send_data}">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
			</c:if>
			
			<!-- 아래번호판을 선택했을때 액션들 -->
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<li
					<c:out value="${pageMaker.cri.page==idx?'class=active':''}"/>>
					<c:choose>
						<c:when test="${uri[2] eq 'c_list'}">
							<a href="c_list${pageMaker.makeSearch(idx)}">${idx}</a><!-- 페이지를 누를때마다 계속 uri요청을 하여 리바인딩하는형식 -->
						</c:when>
						
						<c:otherwise>
							<a href="c_list_search${pageMaker.makeSearch(idx)}${send_data}">${idx}</a><!-- 페이지를 누를때마다 계속 uri요청을 하여 리바인딩하는형식 -->
						</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
			
			<!-- 다음 표시를 남기는 조건문 -->
			<c:if test="${pageMaker.next && pageMaker.endPage>0}">
				<c:choose>
						<c:when test="${uri[2] eq 'c_list'}">
							<li><a href="c_list${pageMaker.makeSearch(pageMaker.endPage+1)}">&raquo;</a></li>
						</c:when>
						
						<c:otherwise>
							<li><a href="c_list_search${pageMaker.makeSearch(pageMaker.endPage+1)}${send_data}">&raquo;</a></li>
						</c:otherwise>
				</c:choose>
			</c:if>		
			
		</ul>
	</div><!-- ./center -->
	
	
	
	
	
	
</div>

<script>
var formObj=$("form[role='form']");
$("#search_button").on("click",function(){//검색 활성화	
	formObj.attr("action","c_list_search");
	formObj.attr("method","get");
	formObj.submit();
});

function read_request(bno) {
	location.href="c_read?bno="+bno;
}
</script>