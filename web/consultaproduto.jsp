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
            <!--        CODIFICAÇÃO PRÓPRIA -->
                <script type="text/javascript" src="recursos/js/code.js"></script>
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
                <div class="col-md-12">
                    <center><h3>Pesquisar produto</h3></center>
                </div>
            </div>
            <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
            <form action="" method="">
                <div class="form-group row">
                    <!---Sobre nome-->
                    <label for="bcli" class="col-md-4 col-form-label">Informe o codigo do produto</label>
                    <div class="col-md-8">
                    <input type="text" class="form-control" id="bcli" name="bcli"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-danger btn-block">Sign in</button>
            </form>
            </div>
            <div class="col-md-3"></div>
            </div>
        </div>
    </div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
