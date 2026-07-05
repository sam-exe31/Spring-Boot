<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My First JSP</title>
</head>
<body>

    <h1>Welcome to my page</h1>

    <%
        String name = "Sam";
        out.println("Hello, " + name + "!");
    %>

    <p>Current time is: <%= new java.util.Date() %></p>

</body>
</html>