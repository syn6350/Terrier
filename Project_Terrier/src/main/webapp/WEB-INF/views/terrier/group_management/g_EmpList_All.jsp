<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul class="list-group" style="height: 570px;overflow-y: scroll;margin:0px;">
	<c:forEach items="${all_list}" var="all_list">
		
		<li class="list-group-item">
			<table id="list_table">
				<tr style="width: 100%;">
					<th id="emp_num" style="width:10%;">${all_list.employee_num }
					<td style="width:10%;">${all_list.department}
					<td style="width:10%;">${all_list.rank}
					<td style="width:10%;">${all_list.phone}
					<td style="width:10%;">${all_list.name}                   		
				</tr>
			</table>
		</li>
					                    
	</c:forEach>
</ul>