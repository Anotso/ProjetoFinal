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
            <div class="col-md-6">
                <img style="max-width:100px;" src="../recursos/telaprod/gtx.png" /> 
                </div>
                    <div class="col-md-6" style="border: 1px solid gray;">
                    <!--Dados do produto-->
                    <h3>celular do praguay</h3>
                    <!--  <h5 style="color:#337ab7">vendido por <a href="#">Samsung</a>·<small style="color:#337ab7">(5054 ventas)</small></h5>--->
                    <!--- preços--->
                    <h6 class="title-price"><small>preço</small></h6>
                    <h3 style="margin-top:0px;">U$S 399</h3>
                    <!--    detalhe e especificaçao do produto--->
                    <!------>
                    <!-- Botao da compra -->
                    <div class="section" style="padding-bottom:20px;">
                        <button class="btn btn-success">Adicionar ao carrinho </button> 
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>