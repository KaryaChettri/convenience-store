<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page  language="java" import="java.util.*,java.text.*"%>
<%!
public int nullIntconv(String inv)
{   
	int conv=0;
		
	try{
		conv=Integer.parseInt(inv);
	}
	catch(Exception e)
	{}
	return conv;
}
%>
<%
 //int iYear=nullIntconv(request.getParameter("iYear"));
 int iMonth=nullIntconv(request.getParameter("iMonth"));

 Calendar ca = new GregorianCalendar();
 int iTDay=ca.get(Calendar.DATE);
 int iYear=ca.get(Calendar.YEAR);
 int iTMonth=ca.get(Calendar.MONTH);
 
 String myLink = "http://localhost:8080/ConvenienceStoreWeb/list";
 String color = "RED";//default to RED

  if(iYear==0)
 {
	  iMonth=iTMonth;
 } 

 GregorianCalendar cal = new GregorianCalendar (iYear, iMonth, 1); 

 int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
 int weekStartDay=cal.get(Calendar.DAY_OF_WEEK);
 
 cal = new GregorianCalendar (iYear, iMonth, days); 
 int iTotalweeks=cal.get(Calendar.WEEK_OF_MONTH);
  
%>
<html>
<head>
<title>Calendar For Schedule</title>
<script>
function goTo()
{
  document.frm.submit()
}
</script>
</head>

<body>
<form:form name="frm" method="post" modelattribute="schedulerModel">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="6%"></td>
        <td width="7%">
		</td>
        <td width="73%" align="center"><h3><%=new SimpleDateFormat("MMMM").format(new Date(2015,iMonth,01))%> <%=iYear%></h3></td>
        <td width="6%">Month</td>
        <td width="8%">
		<select name="iMonth" onchange="goTo()">
        <%
		// print month in combo box to change month in calendar
	    for(int im=0;im<=11;im++)
		{
		  if(im==iMonth)
		  {
	     %>
          <option value="<%=im%>" selected="selected"><%=new SimpleDateFormat("MMMM").format(new Date(2015,im,01))%></option>
          <%
		  }
		  else
		  {
		    %>
          <option value="<%=im%>"><%=new SimpleDateFormat("MMMM").format(new Date(2015,im,01))%></option>
          <%
		  }
		}
	   %>
        </select></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <table align="center" border="1" cellpadding="3" cellspacing="0" width="100%">
    <tr>

      <tbody>
        <tr>
          <th>Sun</th>
          <th>Mon</th>
          <th>Tue</th>
          <th>Wed</th>
          <th>Thu</th>
          <th>Fri</th>
          <th>Sat</th>
        </tr>
        <%
        int cnt =1;
        for(int i=1;i<=iTotalweeks;i++)
        {
		%>
        <tr>
          <% 
	        for(int j=1;j<=7;j++)
	        {
		        if(cnt<weekStartDay || (cnt-weekStartDay+1)>days)
		        {
		         %>
                <td align="center" height="35">&nbsp;</td>
               <% 
		        }
		        else
		        {
		         %>
		         <%
		         List model = (List)request.getAttribute("schedulerModel");
		         for (int k=0; k < model.size(); k++) {
		        	 //System.out.println(String.valueOf(cnt-weekStartDay+1));
		        	 Map dateMap = (Map)model.get(k);
		        	 String key = String.valueOf(iMonth+1) + ";" + String.valueOf(cnt-weekStartDay+1);
		        	 String str = (String)dateMap.get(key);
		        	 if (str != null) {
		        		 color = str;
		        		 break;
		        	 } 
		         }
		        %>
		         
                <td align="center" height="35" BGCOLOR=<%=color%>  
                id="day_<%=(cnt-weekStartDay+1)%>">
                	<%-- <span><a href="<%=myLink%>"><%=(cnt-weekStartDay+1)%></a></span> --%>
                	<span>
                		<a href="http://localhost:8080/ConvenienceStoreWeb/schedule?mm=<%=iMonth+1%>&yyyy=<%=iYear%>&dd=<%=(cnt-weekStartDay+1)%>">
                			<%=(cnt-weekStartDay+1)%>
                		</a>
                	</span>
                </td>
               <% 
		        }
		        cnt++;
		      }
	        %>
        </tr>
        <% 
	    }
	    %>
      </tbody>
    </table>
    </td>
  </tr>
</table>
</form:form>
</body>
</html>