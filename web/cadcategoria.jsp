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
        <title>JSP Page</title>
    </head>
    <body onload="CarregaCadSetor()">
        <nav>
            <%
                Object usuario = session.getAttribute("funcionario");
                if (usuario == null) {
            %><c:import url="include/navlogin.jsp"/>
            <%
            } else {
            %><c:import url="include/navlogout.jsp"/>
            <%
                }
            %>
            <c:import url="include/menuprod.jsp"/>
        </nav>
        <%
            if (usuario == null) {
        %>
        <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <div class="esp50"></div>
                <div class="row">
                    <div class="col-md-12"><center><h3>Cadastro de Categoria</h3></center></div>
                </div>
                <c:if test="${not empty avisos}">
                    <div class="alert alert-success">
                        <p>${avisos}</p>
                    </div>
                </c:if>
                <c:if test="${not empty erros}">
                    <div class="alert alert-danger">
                        <p>${erros}</p>
                    </div>
                </c:if>
                <c:if test="${not empty alertas}">
                    <div class="alert alert-warning">
                        <p>${alertas}</p>
                    </div>
                </c:if>
                <div class="esp50"></div>
                <form action="cadcategoria.html" method="POST" id="cadcategoria">
                    <div class="form-group row">
                        <label for="categoria" class="col-md-4 col-form-label">Nome do Função:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="categoria" name="categoria" placeholder="Informe o nome da categoria" value="${categoria.nome}"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="setorcat" class="col-md-4 col-form-label">Selecione a função</label>
                        <div class="col-md-8">
                            <select name="setor" class="form-control" id="setor" value="${categoria.setor}">
                                <c:forEach var="setor" items="${listaSetor}">
                                    <option id="setor" value="${setor.idsetor}">${setor.setor}</option>
                                </c:forEach>
                            </select>
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
                            <button type="submit" class="btn btn-danger btn-block">Cadastrar</button>
                        </div>
                    </div>
                    <div class="esp25"></div>
                </form>
            </div>
        </div>
        <%
            } else {
                response.sendRedirect("index.jsp");
            }
        %>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
