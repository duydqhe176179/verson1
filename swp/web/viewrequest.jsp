<%-- 
    Document   : form
    Created on : Jan 13, 2024, 7:53:20 PM
    Author     : trang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style_re.css">

        <!----===== Iconscout CSS ===== -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    </head>
    <!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Happy Programming</title>
    <link rel="stylesheet" href="css/style_re.css">

    <!-- Iconscout CSS -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
</head>
<body>

    <div class="container"> 
        <i style="margin-left: 95%" class="uil uil-times" id="closeButton"></i>
        <header>View request</header>

        <div class="form first">
            <div class="details personal">
                <span class="title">Details</span>

                <c:forEach var="listR" items="${listR}">

                    <div class="fields">
                        <div class="input-field">
                            <label>Title (subject): ${listR.title} </label>
                        </div>

                        <div class="input-field">
                            <label>Content of request: ${listR.content}</label>
                        </div>

                        <div class="input-field">
                            <label>Deadline date: ${listR.deadline} </label>
                        </div>

                        <div class="input-field">
                            <label>Deadline hour: ${listR.hour} h</label>
                        </div>

                        <div class="input-field">
                            <label>Skill: ${listR.skill}</label>
                        </div>

                        <div class="input-field">
                            <label>Status: ${listR.status}</label>
                        </div>
                    </div>

                    <button onclick="return confirmReject();">
                        <a style="text-decoration: none;" href="reject?idRequest=${listR.getIdRequest()}&action=reject">Reject</a>
                    </button>
                </div>
                <br>
                <br>
            </c:forEach>
        </div> 
    </div>

    <!-- Script for the close button -->
    <script>
        // Lắng nghe sự kiện click trên biểu tượng "close"
        document.getElementById("closeButton").addEventListener("click", function() {
            // Chuyển hướng về trang home.jsp
            window.location.href = "home.jsp";
        });
    </script>
</body>
</html>



</body>
</html>
