<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP Page</title>
</head>
<body>

    <% String name=(String)session.getAttribute("name"); %>
    <h1> failed <%=name%> </h1>
    </body>
</html>

