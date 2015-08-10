
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>

</head>
<body>
	<form:form method="post" modelAttribute="schedulerModel"
		action="saveSchedule">

		<a href="${pageContext.request.contextPath}/add">Click here to add
			new record </a>
		<h1>
			Schedule for date(dd/mm/yyyy):
			<form:label path="displayDate">${schedulerModel.displayDate}</form:label>
		</h1>
		<table>
			<tr>
				<td>
					<div>
						<c:choose>
							<c:when test="${fn:length(schedulerModel.schedulerDTOs)>0}">
								<table id="records" align="left" border="1">
									<thead>
										<tr>
											<th width="80">ID</th>
											<th width="120">Employee Name</th>
											<th width="320">Schedule Time</th>
										</tr>


										<c:forEach items="${schedulerModel.schedulerDTOs}"
											var="schedulerDTO" varStatus="loop">
											<tr>
												<td><form:label
														path="schedulerDTOs[${loop.index}].empId">
														<c:out value="${schedulerDTO.empId}"></c:out>
													</form:label></td>
												<td><c:out value="${schedulerDTO.employeeName}"></c:out></td>

												<td>Start Time: 
												<c:if test="${schedulerDTO.startTime != null || schedulerDTO.startTime != \"\"}">
												<form:label path="schedulerDTOs[${loop.index}].startTime"><c:out value="${schedulerDTO.startTime}"></c:out></form:label>
												</c:if>
												<form:select
														path="schedulerDTOs[${loop.index}].startTime">
														<option value="${schedulerDTO.startTime}">-</option>
														<option value="10:00">10:00</option>
														<option value="11:00">11:00</option>
														<option value="12:00">12:00</option>
														<option value="13:00">13:00</option>
														<option value="14:00">14:00</option>
														<option value="15:00">15:00</option>
														<option value="16:00">16:00</option>
														<option value="17:00">17:00</option>
														<option value="18:00">18:00</option>
														<option value="19:00">19:00</option>
														<option value="20:00">20:00</option>
														<option value="21:00">21:00</option>
														<option value="22:00">22:00</option>
													</form:select> 
													 <br> <br> End Time: 
													 <c:if test="${schedulerDTO.endTime != null || schedulerDTO.endTime != \"\"}">
												<form:label path="schedulerDTOs[${loop.index}].startTime"><c:out value="${schedulerDTO.endTime}"></c:out></form:label>
												</c:if>
													 <form:select
														path="schedulerDTOs[${loop.index}].endTime">
														<option value="-">-</option>
															<option value="10:00">10:00</option>
														<option value="11:00">11:00</option>
														<option value="12:00">12:00</option>
														<option value="13:00">13:00</option>
														<option value="14:00">14:00</option>
														<option value="15:00">15:00</option>
														<option value="16:00">16:00</option>
														<option value="17:00">17:00</option>
														<option value="18:00">18:00</option>
														<option value="19:00">19:00</option>
														<option value="20:00">20:00</option>
														<option value="21:00">21:00</option>
														<option value="22:00">22:00</option>
													</form:select> 
													 <br> <br>
												</td>
											</tr>
										</c:forEach>
									</thead>
								</table>
							</c:when>
						</c:choose>
					</div>
				</td>
			</tr>
			<tr>
				<td><form:input path="displayDate" type="hidden"
						name="myhiddenvalue" value="${schedulerModel.displayDate}" /></td>
			</tr>
			<tr>
				<td><input type="button" value="Cancel" onclick="window.location='scheduler'"></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>



