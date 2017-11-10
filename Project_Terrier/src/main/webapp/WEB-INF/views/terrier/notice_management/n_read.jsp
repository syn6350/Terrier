<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE>
<title>
	공지
</title>
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

.reply_writer {
	padding-left: 0px;
	padding-right: 0px;
	font-weight: bold;
}

.reply_content {
	padding-left: 0px;
	padding-right: 0px;
}

.reply_date {
	padding-left: 0px;
	padding-right: 0px;
	text-align: right;
	color: #999999;
}

</style>

<div id="content" class="col-md-10 nav_and_content">

	<div id="title">
		<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;공지사항
	</div>
	
	
		<div class="col-md-12" style="padding:0">    
	    	  <div class="panel panel-primary">
		  	  	<div class="panel-heading" style="background-color: #3367d6;">글보기</div>
		  	  	<div class="panel-body">	  	  		
	
					<form role="form" method="post">
							<input type='hidden' name='bno' value="${vo.bno}"> 
							<input type='hidden' name='page' value="${page}"> 
							<input type='hidden' name='perPageNum' value="${perPageNum}">
							<input type='hidden' name='writer' value="${vo.writer}">
<!-- 						private Integer bno;//페이지번호
							private String title;//제목
							private String content;//내용
							private String writer;//작성자
							private Date regdate; //작성시간
							private Integer viewcnt;//조회수 -->
						<div class="form-group">
							작성자
							<div class="textview">
								${vo.writer}
							</div>
						</div>
										
						<div class="form-group">
							제목
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
							내용
							<div class="textview" style="height: 40%; overflow-y:scroll; ">
								${vo.content}
							</div>
						</div>
						
						<div class="form-group col-md-3" style="float: right; padding:0px; margin-top: 0px;">
								<table style="float: right;">
									<tr>
										<td style="padding-right: 5px;"><button type="submit" class="btn icon-btn btn-muted apply_butt" id="1" >수정</button>
										<td style="padding-right: 5px;"><button type="submit" class="btn icon-btn btn-muted apply_butt" id="2" >삭제</button>
										<td><button type="submit" class="btn icon-btn btn-muted apply_butt" id="3">목록</button>
								</table>
						</div>
						
						
						
												
						<!-- 댓글 -->
						
						<div class="col-md-12" style="border-top:1px solid #cccccc; margin-top: 15px; padding: 15px 0px">
							댓글 작성<br>
							<div class="col-md-12" style="padding:0px;margin:0px;">
								<span class="col-md-11" style="padding:0px;margin:0px;"><input id="reply_content" type="text" style="border:1px solid #cccccc;width:100%;padding-right:0px;padding-left:0px"></span>
								<span class="col-md-1" style="padding:0px;margin:0px;"><input id="reply_regist" type="button" class="btn icon-btn btn-muted apply_butt" value="등록" style="width:100%;height:30px;border:1px solid #cccccc;border-left:0px;border-radius: 0px;padding-bottom: 0px;padding-top:0px;"></span>
							</div>
							
							<c:forEach items="${re_vo}" var="re_vo">
								<div class="col-md-12" style="border-top:1px solid #cccccc; margin-top: 15px; padding: 15px 0px">
									<span class="col-md-2 reply_writer">${re_vo.writer}</span>
									<span class="col-md-8 reply_content">${re_vo.content}&nbsp;<a href="javascript:reply_reply(${re_vo.rno});">[답글]</a></span>
									<span class="col-md-2 reply_date"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${re_vo.regdate}"/></span>
									
									<!-- 댓글의 댓글 -->
									<c:forEach items="${re_re_vo}" var="re_re_vo">
										<c:if test="${re_re_vo.paren_re_no eq re_vo.rno }">
											<div class="col-md-12" style="margin-top: 8px; padding: 0px">
												<span class="col-md-1" style="text-align: right;">ㄴ</span>
												<span class="col-md-2 reply_writer">${re_re_vo.writer}</span>
												<span class="col-md-7 reply_content">${re_re_vo.content}</span>
												<span class="col-md-2 reply_date"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${re_re_vo.regdate}"/></span>
											</div>
										</c:if>
									</c:forEach>
									
									<!-- 댓글의 댓글 작성란-->
									<div id="${re_vo.rno}_div" class="col-md-12" style="display:none; margin-top: 8px; padding: 0px"> 
										<span class="col-md-1"></span>
										<span class="col-md-10" style="padding:0px;margin:0px;"><input id="${re_vo.rno}_re_content" type="text" style="border:1px solid #cccccc;width:100%;padding-right:0px;padding-left:0px"></span>
										<span class="col-md-1" style="padding:0px;margin:0px;"><input type="button" onclick="re_reply_regist(${re_vo.rno});" class="btn icon-btn btn-muted apply_butt" value="등록" style="width:100%;height:30px;border:1px solid #cccccc;border-left:0px;border-radius: 0px;padding-bottom: 0px;padding-top:0px;"></span>
									</div>
								</div>
							</c:forEach>
							
						</div>
						
					</form>
	
	      	  	</div><!-- panel-body -->
	     	  </div>     
	   	 </div>
   	 
</div>

<script>
function Refresh() // 새로고침 함수
{
	location.reload();
}

function reply_reply(rno) {
	$("#"+rno+"_div").toggle(); // 숨겨 놓았던 댓글의 댓글을 다는 창 show , 토글 함수는 show라면 hide시키고 hide라면 show시킴
}

function re_reply_regist(rno) {
	var bno = "${vo.bno}";
	var content = $("#"+rno+"_re_content").val()

	var data={}/* 보내는 데이터 */
	data["bno"]=bno; // 자신의 게시글 num
	data["rno"]=rno; // 부모 댓글의 num
	data["content"]=content; // 댓글 내용
	
	$.ajax({
		type:"GET",
		contentType:'application/json,charset=UTF-8',
		dataType:'text',
		data:data,
		url:'/terrier/notice_management/reply_reply?data',
		success:function(data)
		{
			if(data=="SUCCESS"){
				Refresh();
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
				
	});/* ajax */
}

$(document).ready(function(){
	var formObj=$("form[role='form']");
	var page=${page};
	var perPageNum=${perPageNum};
	
		$("#1").on("click",function(){
			formObj.attr("method","get");
			formObj.attr("action","/terrier/notice_management/n_modify");/* 페이지만들예정 */
			formObj.submit();
		});/* 수정 */
		
		$("#2").on("click",function(){
			formObj.attr("action","/terrier/notice_management/n_remove");
			formObj.submit();
		});/* 삭제 */
		
		$("#3").on("click",function(){
			formObj.attr("method","get");
			formObj.attr("action","/terrier/notice_management/n_mgt");
			formObj.submit();
		});/* 목록 */
		
		
		$("#reply_regist").on("click",function(){
			var bno = "${vo.bno}";
			var content = $("#reply_content").val();

			var data={}/* 보내는 데이터 */
			data["bno"]=bno; // 자신의 게시글 num
			data["content"]=content; // 댓글 내용
			
			$.ajax({
				type:"GET",
				contentType:'application/json,charset=UTF-8',
				dataType:'text',
				data:data,
				url:'/terrier/notice_management/reply?data',
				success:function(data)
				{
					if(data=="SUCCESS"){
						Refresh();
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
						
			});/* ajax */
			
			
		})
})/* document */

</script>
	