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
<title>Test</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/add">Click here to add new record </a>
         <h1>Employees List</h1>
         <div>
             <c:choose>
                 <c:when test="${fn:length(employeelist)>0}">
                     <table id="records" align="left" border="1" >
                         <thead>
                         <tr>
                         		<th width="80"> ID</th>
                                 <th width="120">First Name</th>
                                 <th width="120">Last Name</th>
                                 <th width="120">Job Title</th>
                                 <th width="120">Address</th>
                                 <th width="180">Phone</th>
                                 <th width="80">Edit</th>
                                 <th width="80">Delete</th>
                             </tr>
 
 
                             <c:forEach items="${employeelist}" var="e">
                                 <tr>
                                     <td><c:out value="${e.id}"></c:out></td>
                                     <td><c:out value="${e.firstName}"></c:out></td>
                                     <td><c:out value="${e.lastName}"></c:out></td>
                                     <td><c:out value="${e.title}"></c:out></td>
                                     <td><c:out value="${e.address}"></c:out></td>
                                     <td><c:out value="${e.phoneNumber}"></c:out></td>
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



 