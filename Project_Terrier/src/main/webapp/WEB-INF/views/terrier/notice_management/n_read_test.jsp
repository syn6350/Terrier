<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>

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

.reply_title {
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
						
						<div class="form-group">
								<button type="submit" class="btn btn-primary" id="1" >수정</button>
								<button type="submit" class="btn btn-danger" id="2" >삭제</button>
								<button type="submit" class="btn btn-default" id="3">목록</button>
						</div>
						
						
						<div class="col-md-2" style="float: right; padding:0px; margin-top: 0px;">
							<table style="float: right;">
								<tr>
									<td style="padding-right: 5px;"><a class="btn icon-btn btn-muted apply_butt" href="">목록</a>
									<td><a class="btn icon-btn btn-muted apply_butt" href="">수정</a>
							</table>
						</div>
						
						<div class="col-md-12" style="border-top:1px solid #cccccc; margin-top: 15px; padding: 15px 0px">
							댓글 작성<br>
							<div class="col-md-12" style="padding:0px;margin:0px;">
								<span class="col-md-11" style="padding:0px;margin:0px;"><input type="text" style="border:1px solid #cccccc;width:100%;padding-right:0px;padding-left:0px"></span>
								<span class="col-md-1" style="padding:0px;margin:0px;"><input type="button" class="btn icon-btn btn-muted apply_butt" value="등록" style="width:100%;height:30px;border:1px solid #cccccc;border-left:0px;border-radius: 0px;padding-bottom: 0px;padding-top:0px;"></span>
							</div>
							
							<div class="col-md-12" style="border-top:1px solid #cccccc; margin-top: 15px; padding: 15px 0px">
								<span class="col-md-2 reply_title">박종혁 인턴(park123)</span>
								<span class="col-md-8 reply_content">와 맛있겠다.... 감사합니다&nbsp;<a href="">[답글]</a></span>
								<span class="col-md-2 reply_date">2017-09-13 13:20</span>
							</div>
							
							<div class="col-md-12" style="border-top:1px solid #cccccc; margin-top: 15px; padding: 15px 0px">
								<span class="col-md-2 reply_title">박종혁 인턴(park123)</span>
								<span class="col-md-8 reply_content">아니 여고생 허벅지는 없습니까??&nbsp;<a href="">[답글]</a></span>
								<span class="col-md-2 reply_date">2017-09-13 13:20</span>
								<div class="col-md-12" style="margin-top: 8px; padding: 0px">
									<span class="col-md-1" style="text-align: right;">ㄴ</span>
									<span class="col-md-2 reply_title">이훈상 회장(hun123)</span>
									<span class="col-md-7 reply_content">적당히 해</span>
									<span class="col-md-2 reply_date">2017-09-13 13:20</span>
								</div>
								<div class="col-md-12" style="margin-top: 8px; padding: 0px">
									<span class="col-md-1" style="text-align: right;">ㄴ</span>
									<span class="col-md-2 reply_title">김성룡 부장(kim8745)</span>
									<span class="col-md-7 reply_content">집중좀하자 이것들아</span>
									<span class="col-md-2 reply_date">2017-09-13 13:20</span>
								</div>
							</div>
							
							<div class="col-md-12" style="border-top:1px solid #cccccc; margin-top: 15px; padding: 15px 0px">
								<span class="col-md-2 reply_title">홍석기 주임(ghdtjrrl111)</span>
								<span class="col-md-8 reply_content">...헿<a href="javascript:reply_reply(1);">&nbsp;[답글]</a></span>
								<span class="col-md-2 reply_date">2017-09-13 13:20</span>
								
								<!-- 댓글의 댓글 -->
								<div id="reply_reply" class="col-md-12" style="display:none; margin-top: 8px; padding: 0px"> 
									<span class="col-md-1"></span>
									<span class="col-md-10" style="padding:0px;margin:0px;"><input type="text" style="border:1px solid #cccccc;width:100%;padding-right:0px;padding-left:0px"></span>
									<span class="col-md-1" style="padding:0px;margin:0px;"><input type="button" class="btn icon-btn btn-muted apply_butt" value="등록" style="width:100%;height:30px;border:1px solid #cccccc;border-left:0px;border-radius: 0px;padding-bottom: 0px;padding-top:0px;"></span>
								</div>
							</div> 
							
						</div>
					</form>
	
	      	  	</div><!-- panel-body -->
	     	  </div>     
	   	 </div>
   	 
</div>

<script>
function reply_reply(rno) {
	$("#reply_reply").show();
}


$(document).ready(function(){
	var formObj=$("form[role='form']");
	var page=${page};
	var perPageNum=${perPageNum};
	
		$(".btn-primary").on("click",function(){
			formObj.attr("method","get");
			formObj.attr("action","/terrier/notice_management/n_modify");/* 페이지만들예정 */
			formObj.submit();
		});/* 수정 */
		
		$(".btn-danger").on("click",function(){
			formObj.attr("action","/terrier/notice_management/n_remove");
			formObj.submit();
		});/* 삭제 */
		
		$(".btn-default").on("click",function(){
			formObj.attr("method","get");
			formObj.attr("action","/terrier/notice_management/n_mgt");
			formObj.submit();
		});/* 목록 */
		
})/* document */

</script>
	