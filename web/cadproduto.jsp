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
        <!--    Codificação própria -->
        <link href="recursos/estilo/estilo.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body onload="CarregaCadProd()">
        <nav>
            <%
                String usuario = (String) session.getAttribute("usuario");
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
                <div class="esp25"></div>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Cadastro de Produtos</h3></center>
                    </div>
                </div>
                <hr/>
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
                <div class="esp15"></div>
                <form action="cadproduto.html" method="POST">
                    <div class="form-group row">
                        <label for="nprod" class="col-md-4 col-form-label">Nome:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="nprod" name="nprod" placeholder="Informe o nome do produto" value="${produto.produto}"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="forprod" class="form-group col-md-4">Fornecedor:</label>
                        <div class="form-group col-md-8">
                            <select type="text" class="form-control" id="forprod" name="forprod" value="${produto.fornecedor}">
                                <c:forEach var="fornecedor" items="${listaFornecedor}">
                                    <option value="${fornecedor.idfornecedor}">${fornecedor.fornecedor}</option>
                                </c:forEach>
                            </select> 
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="catprod" class="form-group col-md-4">Categoria:</label>
                        <div class="form-group col-md-8">
                            <select type="text" class="form-control" id="catprod" name="catprod" value="${produto.categoria}">
                                <c:forEach var="categoria" items="${listaCategoria}">
                                    <option value="${categoria.idcategoria}">${categoria.categoria}</option>
                                </c:forEach>
                            </select> 
                        </div>
                    </div>

                    <!-- COLOCAR A DESCRIÇÃO AQUI -->
                    <div class="form-row">
                        <label class="form-group col-md-4" for="descricao">Descrição do produto:</label>
                        <div class="col-md-7">
                            <textarea class="form-control" id="descricao" rows="4" value="${produto.descricao}"></textarea>
                        </div>
                        <label class="form-group col-md-1">Exemplo de textarea</label>
                    </div>
                    <div class="esp15"></div>
                    <div class="row">
                        <div class="form-group row"> 
                            <label class="col-md-6 col-form-label text-center" for="vcompprod">Valor de compra:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="vcompprod" name="vcompprod" value="${produto.compra}"/>
                            </div>
                        </div>
                        <div class="form-group row"> 
                            <label class="col-md-6 col-form-label text-center" for="vvendprod">Valor de venda:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="vvendprod" name="vvendprod" value="${produto.venda}"/>
                            </div>
                        </div>
                        <div class="form-group row"> 
                            <label class="col-md-6 col-form-label text-center" for="qtdprod">Quantidade:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="qtdprod" name="qtdprod" value="${produto.qtd}"/>
                            </div>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <hr/>
                    ​<div class="custom-file">
                        <input type="file" class="custom-file-input" name="foto01" id="foto01" value="${produto.foto1}" placeholder="Foto 01" required/>
                        <label class="custom-file-label" for="foto01"></label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="foto02" id="foto02" value="${produto.foto2}" placeholder="Foto 02" required/>
                        <label class="custom-file-label" for="foto02"></label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="foto03" id="foto03" value="${produto.foto3}" placeholder="Foto 03" required/>
                        <label class="custom-file-label" for="foto03"></label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="foto04" id="foto04" value="${produto.foto4}" placeholder="Foto 04" required/>
                        <label class="custom-file-label" for="foto04"></label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" name="foto05" id="foto05" value="${produto.foto5}" placeholder="Foto 05" required/>
                        <label class="custom-file-label" for="foto05"></label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <hr/>
                    <div class="esp15"></div>
                    <div class="row">
                        <div class="col-md-5">
                            <button type="button" class="btn btn-danger btn-block">Cancelar</button>
                        </div>
                        <div class="col-md-2 esp5"></div>
                        <div class="col-md-5">
                            <button type="submit" class="btn btn-danger btn-block">Cadastrar</button>
                        </div>
                    </div>
                    <div class="esp50"></div>
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
        <!--    JS BOOTSTRAP    -->
            <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
            <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
            <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <!--    JS PRÓPRIO     -->
            <script type="text/javascript" src="recursos/js/code.js"></script>
    </body>
</html>
