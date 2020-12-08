<%@ page import="com.example.Client.dto.DoubleResponse" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="form" class="com.example.Client.dto.DoubleResponse" scope="session"/>
<html>
<%if (form == null) {%>
<meta http-equiv="refresh" content="5; URL=/index.jsp"/>
<%
    }
%>
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №3</title>
    <link rel="stylesheet" href="html/style.css">
</head>
<body>
<h1>Лабораторная работа №3</h1>
<p>
    Сложение чиселок
</p>
<form action="html/result.html">
    <fieldset>
        <legend>Сложение чиселок</legend>
        <p>
            <label for="numberChar">Число:</label>
        <p id="numberChar" name="numberChar"><jsp:getProperty name="form" property="value"/></p>
        </p>
    </fieldset>
    <p><a href="result.xml" download="">Скачать результат</a></p>
   <p><a href="${pageContext.request.contextPath}/html/index.html">Возврат на исходную страницу</a></p> <%--возвращается на исходную страницу--%>
</form>
</body>
</html>

