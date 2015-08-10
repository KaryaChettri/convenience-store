<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schedule Test</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/add">Click here to add new Schedule</a>
         <h1>Schedule List</h1>
         <div>
             <c:choose>
                 <c:when test="${fn:length(schedulelist)>0}">
                     <table id="records" align="left" border="1" >
                         <thead>
                         <tr>
                         		<th width="80"> ID</th>
                                 <th width="120">Day of Week</th>
                                 <th width="120">Start Time</th>
                                 <th width="120">End Time</th>
                                 <th width="120">Total Hours</th>
                                 <th width="80">Edit</th>
                                 <th width="80">Delete</th>
                             </tr>
 
 
                             <c:forEach items="${schedulelist}" var="e">
                                 <tr>
                                     <td><c:out value="${e.id}"></c:out></td>
                                     <td><c:out value="${e.dayOfWeek}"></c:out></td>
                                     <td><c:out value="${e.startTime}"></c:out></td>
                                     <td><c:out value="${e.endTime}"></c:out></td>
                                     <td><c:out value="${e.totalHours}"></c:out></td>
                                     <td><a href="<c:url value="/edit/${e.id}"/>">EDIT</a></td>
                                     <td><a href="<c:url value="/delete/${e.id}"/>">DELETE</a></td>
                                     </tr>
                             </c:forEach>
                         </thead>
                     </table>
                 </c:when>
                 <c:otherwise>
                     <label>Sorry! No Record To Display</label>
                 </c:otherwise>
             </c:choose>
         </div>
</body>
</html>
