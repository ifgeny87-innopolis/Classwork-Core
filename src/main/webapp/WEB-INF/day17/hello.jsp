<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("PATH", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Message: ${message}</h1>
<h2>Model: ${model}</h2>
<h3>PATH: ${PATH}</h3>
<ul>
    <li><a href="${PATH}/">Go back</a></li>
    <li><a href="${PATH}/day17/test">Hello test</a></li>
    <li><a href="${PATH}/day17/my/Kitty">Hello my Kitty</a></li>
    <li><a href="${PATH}/day17/body">Show request body</a></li>
    <li><a href="${PATH}/day17/string">Response String, not Json!</a></li>
    <li><a href="${PATH}/day17/json">Response Json</a></li>
</ul>
</body>
</html>
