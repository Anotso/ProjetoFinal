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
        <!--    Codificação própria -->
        <script type="text/javascript" src="recursos/js/code.js"></script>
        <title>SenTec</title>
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
                    <div class="esp50"></div>
                    <div class="row">
                        <div class="col-md-12"><center><h3>Cadastro de Categoria</h3></center></div>
                    </div>
                    <div class="esp50"></div>
                    <form action="cadfuncao.html" method="POST" id="cadfuncao">
                        <div class="form-group row">
                            <label for="funcao" class="col-md-4 col-form-label">Nome do Função:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="funcao" name="funcao" placeholder="Informe o nome da função"/>
                            </div>
                        </div>
                        <div class="esp15"></div>
                        <hr/>
                        <div class="esp25"></div>
                        <div class="row">
                            <div class="col-md-5">
                                <button type="button" class="btn btn-danger btn-block">Cancelar</button>
                            </div>
                            <div class="col-md-2 esp5"></div>
                            <div class="col-md-5">
                                <button type="button" class="btn btn-danger btn-block" onclick="EnvioFuncao()">Cadastrar</button>
                            </div>
                        </div>
                        <div class="esp25"></div>
                    </form>
                </div>
            </div>
        </c:if>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
