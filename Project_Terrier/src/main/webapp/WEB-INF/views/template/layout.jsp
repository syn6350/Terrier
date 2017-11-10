<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" 	uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<link rel="stylesheet" href="/webjars/bootstrap/3.3.4/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<spring:url value="/resources/layout.css" var="layoutcss"></spring:url>
<link href="${layoutcss}" rel="stylesheet">
<script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.4/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<html>
<body>
<div id="container" class="container-fluid">
	<div class="row-fluid">
	<tiles:insertAttribute name="header"/><!-- 상단 -->
	</div>
	
	<div class="row-fluid">
	<tiles:insertAttribute name="nav"/><!-- 사이드 -->
	<tiles:insertAttribute name="content"/>
	</div>

	<div class="row-fluid">
	<tiles:insertAttribute name="footer"/><!-- 하단 -->
	</div>

</div><!-- 기본 컨테이너 -->

<script>
	var maxHeight;
	$('.nav_and_content').each(function() {
    	maxHeight = maxHeight > $(this).height() ? maxHeight : $(this).height();
  	});

	$('.nav_div').css('min-height', maxHeight+30);
</script>
</body>
</html>



