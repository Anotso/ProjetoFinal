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
            <%
                String usuario = (String) session.getAttribute("usuario");
                if(usuario == null){
                        %><c:import url="include/navlogin.jsp"/>
            <%
                }else{
                        %><c:import url="include/navlogout.jsp"/>
            <%
                }
            %>
            <c:import url="include/menuprod.jsp"/>
        </nav>
        <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><center>TESTE 01</center></div>
                    <div class="col-md-3"><center>TESTE 02</center></div>
                    <div class="col-md-3"><center>TESTE 03</center></div>
                </div>
                <c:import url="include/teste.jsp"/>
            </div>
        </div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
