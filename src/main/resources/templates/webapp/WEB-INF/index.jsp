<%@ page import="com.example.Client.dto.DoubleResponse" %>
<%@ page import="lombok.val" %>

<jsp:useBean id="form" class="com.example.Client.dto.DoubleResponse" scope="session"/>
<jsp:setProperty name="form" property="*"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Лабораторная работа №3</title>
    <link rel="stylesheet" href="html/style.css">
</head>
<body>
<%@page import="com.example.Client.Service.MathService"
        import="com.example.Client.dto.DoubleResponse " %>
<%@ page import="java.util.Scanner" %>
<%if (form != null) {%>
<jsp:forward page="html/result.html"/>
<%
    }
%>
<%
    class PageDouble {
        public String val1;
        public String val2;

        void checkInputData() {
            if (val1.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                if (val2.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                    Double val = Double.parseDouble(val1) + Double.parseDouble(val2);
                    MathService mathService = new MathService();
                    DoubleResponse doubleResponse = new DoubleResponse(val);
                    mathService.objectToXmlJsp(doubleResponse);
                    form = doubleResponse;
                } else {
                    System.out.println("хрень ввели");
                }

            } else {
                System.out.println("хрень ввели");
            }
        }
    }%>
<%
    PageDouble pageDouble = new PageDouble();
%>
<h1>Лабораторная работа №3</h1>
<p>
    Сложение чиселок
</p>
<form action="index.jsp" id="myForm" method="post">
    <fieldset>
        <legend>Сложение чиселок</legend>
        <p>
            <label for="numberChar">Число</label>
            <input type="text" id="numberChar" name="val1" value="<%=pageDouble.val1%>" placeholder="Введите число"/>
        </p>
        <p>
            <label for="numberChar2">Число</label>
            <input type="text" id="numberChar2" name="val2" value="<%=pageDouble.val2%>" placeholder="Введите число"/>
        </p>
    </fieldset>
    <p>
        <button class="submit" type="submit" onclick="<%=(new PageDouble()).checkInputData()%>">Подтвердить</button>
    </p>
</form>
</body>
</html>