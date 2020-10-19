<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>web-first</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8" />
    <meta name="author" content="polinadelaet" />
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="stylesheets/indexStyle.css">
    <script src="scripts/jquery-3.5.1.min.js"></script>
    <script src="scripts/script.js"></script>
</head>
<body>
<video src="resources/dank.mp4" id="jabaVideo" autoplay muted loop></video>

<div class="wrapper">
    <div id="header">
        <header>
            Прокушева Полина Андреевна, p3231, вариант 2735
        </header>
    </div>

    <form method="post" action="<%= request.getContextPath() %>/controller" id="checkForm">

        <div id="XRlocation">

            <div id="area_x" class="border">

                <p>Choose a parameter X:</p>
                <select name="coordinateX">
                    <option value="-3" selected>-3</option>
                    <option value="-2">-2</option>
                    <option value="-1">-1</option>
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>

            <div id="area_r" class="border">

                <p>Choose a parameter R:</p>
                <input name="coordinateR" type="radio" value="1"> 1
                <input name="coordinateR" type="radio" value="2"> 2
                <br><input name="coordinateR" type="radio" value="3"> 3
                <input name="coordinateR" type="radio" value="4"> 4
                <input name="coordinateR" type="radio" value="4"> 5

                <br class="coordinateRE">
            </div>
        </div>

        <div id="YSlocation">

            <div id="area_y" class="border">

                <p><label for="coordinateY">Choose a coordinate Y: </label></p>
                <input type="text" id="coordinateY" name="coordinateY" maxlength="5" placeholder="От -3 по 5">
            </div>

            <div id="area_submit">
                <p><input type="submit" id="formSubmit" value="Check">
            </div>
        </div>
    </form>

    <div id="diagram">
        <svg xmlns="http://www.w3.org/2000/svg" width="300" height="300">
            <line x1="0" y1="150" x2="300" y2="150" stroke="#ffffff"></line>
            <line x1="150" y1="0" x2="150" y2="300" stroke="#ffffff"></line>

            <line x1="250" y1="145" x2="250" y2="155" stroke="#ffffff"></line>
            <line x1="200" y1="145" x2="200" y2="155" stroke="#ffffff"></line>
            <line x1="100" y1="145" x2="100" y2="155" stroke="#ffffff"></line>
            <line x1="50" y1="145" x2="50" y2="155" stroke="#ffffff"></line>

            <line x1="145" y1="50" x2="155" y2="50" stroke="#ffffff"></line>
            <line x1="145" y1="100" x2="155" y2="100" stroke="#ffffff"></line>
            <line x1="145" y1="200" x2="155" y2="200" stroke="#ffffff"></line>
            <line x1="145" y1="250" x2="155" y2="250" stroke="#ffffff"></line>

            <text x="245" y="140" stroke="#ffffff">R</text>
            <text x="185" y="140" stroke="#ffffff">R/2</text>
            <text x="77" y="140" stroke="#ffffff">-R/2</text>
            <text x="37" y="140" stroke="#ffffff">-R</text>
            <text x="156" y="55" stroke="#ffffff">R</text>
            <text x="156" y="105" stroke="#ffffff">R/2</text>
            <text x="156" y="205" stroke="#ffffff">-R/2</text>
            <text x="156" y="255" stroke="#ffffff">-R</text>
            <polygon points="300,150 295,155 295, 145" fill="#000720" stroke="#ffffff"></polygon>
            <polygon points="150,0 145,5 155,5" fill="#000720" stroke="#ffffff"></polygon>

            <rect x="50" y="100" width="100" height="50" fill-opacity="0.4" stroke="navy" fill="blue"></rect>
            <polygon points="150,150 150,200 250,150" fill-opacity="0.4" stroke="navy" fill="blue"></polygon>
            <path d="M150 150 L 200 150 C 200 150 200 100 150 100 L Z" fill-opacity="0.4" stroke="navy" fill="blue"></path>

        </svg>
    </div>

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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <c:forEach items="${results}" var="d" >
                    <tr id="op">
                        <td id="${d.getX()}">${d.getX()}</td>
                        <td class="y" id="${d.getY()}">${d.getY()}</td>
                        <td class="r" id="${d.getR()}">${d.getR()}</td>
                        <td>${d.getHit()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>