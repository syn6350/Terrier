<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
</style>

<div id="content" class="col-md-10 nav_and_content">

	<div id="title">
		<span class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;공지사항
	</div>
	
	
		<div class="col-md-12" style="padding:0">    
	    	  <div class="panel panel-primary">
		  	  	<div class="panel-heading" style="background-color: #3367d6;">글작성</div>
		  	  	<div class="panel-body">	  	  		
	
					<form method="post" action="n_create">
					
						<div class="form-group">
							작성자<input class="form-control" type="text" name="writer"  value="${writer}" readonly>
						</div>
					
						<div class="form-group">
							제목<input class="form-control" type="text" name="title" size="11">
						</div>
						
						<div class="form-group">
							내용<textarea class="form-control" name="content" rows="12"></textarea>
						</div>
						
						<div class="form-group">
							<div class="input-group input-file" name="Fichier1">
								<span class="input-group-btn">
        							<button class="btn btn-default btn-choose" type="button">
        								<span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
        								선택
        							</button>
    							</span>
    							<input type="text" class="form-control" placeholder='Choose a file...' />
    							<span class="input-group-btn">
       			 					<button class="btn btn-warning btn-reset" type="button" style="background-color: #3367d6; border: 1px solid #cccccc">Reset</button>
    							</span>
							</div>
						</div>
						
						<div class="col-md-2" style="float: right; padding:0px; margin-top: 0px;">
							<table style="float: right;">
								<tr>
									<td style="padding-right: 5px;"><a class="btn icon-btn btn-muted apply_butt" href="">초기화</a>
									<td><button type="submit"class="btn icon-btn btn-muted apply_butt">글작성</button></td><!-- 글작성DB저장 -->

							</table>
						</div>
					</form>
	
	      	  	</div><!-- panel-body -->
	     	  </div>     
	   	 </div>
   	 
</div>

<script>
function bs_input_file() {
	$(".input-file").before(
		function() {
			if ( ! $(this).prev().hasClass('input-ghost') ) {
				var element = $("<input type='file' class='input-ghost' style='visibility:hidden; height:0'>");
				element.attr("name",$(this).attr("name"));
				element.change(function(){
					element.next(element).find('input').val((element.val()).split('\\').pop());
				});
				$(this).find("button.btn-choose").click(function(){
					element.click();
				});
				$(this).find("button.btn-reset").click(function(){
					element.val(null);
					$(this).parents(".input-file").find('input').val('');
				});
				$(this).find('input').css("cursor","pointer");
				$(this).find('input').mousedown(function() {
					$(this).parents('.input-file').prev().click();
					return false;
				});
				return element;
			}
		}
	);
}
$(function() {
	bs_input_file();
});
</script>
	