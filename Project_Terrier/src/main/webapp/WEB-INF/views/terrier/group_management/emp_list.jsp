<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<table id="table" class="table table-hover" style="margin:0px;">
				    <thead>
				      <tr>
				        <th style="width:20%">사원번호</th>
				        <th style="width:20%">부서명</th>
				        <th style="width:20%">직책</th>
				        <th style="width:20%">번호</th>
				        <th style="width:20%">이름</th>
				      </tr>

				    </thead>
				    
				    <tbody id="tbody">
				      <c:forEach items="${list}" var="list">
						<tr>
		      				<td id="emp_num" style="width:20%">${list.employee_num}
		      				<td style="width:20%">${list.department}
							<td style="width:20%">${list.rank}
							<td style="width:20%">${list.phone}
							<td style="width:20%">${list.name}
				      </c:forEach>
		      
				    </tbody>
				  </table>		