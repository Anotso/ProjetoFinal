<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="recursos/estilo/reset.css"/>
        <link rel="stylesheet" type="text/css" href="recursos/estilo/estilo.css"/>
        <!--	Bootstrap	-->
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>

        <!--	Font Awesome -->
        <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
        <!--        CODIFICAÇÃO PRÓPRIA -->
        <script type="text/javascript" src="recursos/js/code.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <c:if test="${not empty f or not empty c}">
                <c:import url="include/navlogout.jsp"/>
            </c:if>
            <c:if test="${empty f and empty c}">
                <c:import url="include/navlogin.jsp"/>
            </c:if>
            <c:if test="${not empty f}">
                <c:import url="include/navfun.jsp"/>
            </c:if>
            <c:if test="${empty f}">
                <c:import url="include/menuprod.jsp"/>
            </c:if>
        </nav>
        <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <c:import url="include/destaque.jsp"/>
            </div>
        </div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
        <!--	Bootstrap	-->
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
