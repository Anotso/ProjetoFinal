<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <title>Insert title here</title>
    </head>
    <body>
        <nav>
            <%
                String usuario = (String) session.getAttribute("usuario");
                if(usuario == null){
                        %><%@include file="include/navlogin.html"%>
            <%
                }else{
                        %><%@include file="include/navlogout.html"%>
            <%
                }
            %>
            <%@include file="include/menuprod.html"%>
        </nav>
        <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"><center>TESTE 01</center></div>
                    <div class="col-md-3"><center>TESTE 02</center></div>
                    <div class="col-md-3"><center>TESTE 03</center></div>
                </div>
                <%@include file="include/teste.html"%>
            </div>
        </div>
        <footer>
            <%@include file="include/rodape.html"%>
        </footer>
    </body>
</html>