<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page</title>
</head>
<body>
    <%!
    int age=34;
    %>

    <%
        String name=request.getParameter("uname");
        String city=request.getParameter("ucity");
        Date date =new Date();
        out.println("hello this is in JSP");
    %>
    <h1> Current date:<%=date%> </h1>
    <h1>Hello, <%= name %>! Welcome to the JSP page.</h1>
    <h3>your city is <%=city%> </h3>


    </body>
</html>