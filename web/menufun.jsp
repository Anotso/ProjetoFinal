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
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <!--	Font Awesome -->
        <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
        <nav>
            <c:if test="${not empty f}">
                <c:import url="include/navlogout.jsp"/>
            </c:if>
            <c:if test="${empty f}">
                <% response.sendRedirect("index.jsp");%>
            </c:if>
            <c:if test="${not empty f}">
                <c:import url="include/navfun.jsp"/>
            </c:if>
        </nav>
        <c:if test="${not empty f}">

            <div class="esp50"></div>
            <div class="corpo">
                <div class="container">
                    <c:import url="include/painel.jsp"/>
                </div>
            </div>
        </c:if>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
