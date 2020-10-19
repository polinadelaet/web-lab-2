<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="stylesheets/indexStyle.css">
</head>
    <body>
        <h1>
        </h1>

        <div id="table-wrapper">
            <div id="table-scroll">
                <table id="tableWithResults">
                    <tr>
                        <th>X</th>
                        <th>Y</th>
                        <th>R</th>
                        <th>RESULT</th>
                    </tr>
                        <tr>
                            <td>${results.get(results.size()-1).getX()}</td>
                            <td>${results.get(results.size()-1).getY()}</td>
                            <td>${results.get(results.size()-1).getR()}</td>
                            <td>${results.get(results.size()-1).getHit()}</td>
                        </tr>
                </table>
            </div>>
        </div>
        <p><a href="index.jsp">Как сделать такое же фото?</a></p>
    </body>
</html>
