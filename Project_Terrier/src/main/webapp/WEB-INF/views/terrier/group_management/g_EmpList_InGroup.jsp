<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul id ="check" class="list-group" style="height: 570px;overflow-y: scroll;margin:0px;">
	<c:forEach items="${group_list}" var="group_list">
		
		<li class="list-group-item">
			<table id="list_table">
				<tr style="width: 100%;">
					<th id="emp_num" style="width:10%;">${group_list.employee_num}
					<td style="width:10%;">${group_list.department}
					<td style="width:10%;">${group_list.rank}
					<td style="width:10%;">${group_list.phone}
					<td style="width:10%;">${group_list.name}                   		
				</tr>
			</table>
		</li> 
					                    
	</c:forEach>
</ul>