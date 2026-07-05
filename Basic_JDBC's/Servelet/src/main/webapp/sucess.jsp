<%@ page contentType="text/html;charset=UTF-8" language="java" %>
       <html>
       <head>
           <title> JSP page </title>
       </head>
       <body>
           <div style="text-align: center; margin-top: 50px;">
               <h1>Enter Well!</h1>
               <h2>Welcome, <%= request.getAttribute("username") %>!</h2>
               <h3>password is <%= request.getAttribute("password") %> </h3>
               <p>You successfully entered the thing.</p>
           </div>
       </body>
       </html>