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
                <link href="recursos/estilo/estilo.css" rel="stylesheet"/>
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
        <%
            if(usuario == null){
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
                <div class="esp15"></div>
                <form action="cadproduto.html" method="POST">
                    <div class="form-group  row">
                        <label for="nprod" class="col-md-4 col-form-label">Nome:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="nprod" name="nprod" placeholder="Informe o nome do produto"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="forprod" class="form-group col-md-4">Fornecedor:</label>
                        <div class="form-group col-md-8">
                            <select type="text" class="form-control" id="forprod" name="forprod">
                                <option selected>Selecione o Fornecedor</option>
                                <option value="1">Um</option>
                                <option value="2">Dois</option>
                                <option value="3">Três</option>
                            </select> 
                        </div>
                    </div>
                    <div class="form-row">
                        <label for="catprod" class="form-group col-md-4">Categoria:</label>
                        <div class="form-group col-md-8">
                            <select type="text" class="form-control" id="catprod" name="catprod">
                                <option selected>Abra este menu select</option>
                                <option value="1">Um</option>
                                <option value="2">Dois</option>
                                <option value="3">Três</option>
                            </select> 
                        </div>
                    </div>
                    <div class="esp15"></div>
                    <div class="row">
                        <div class="form-group row"> 
                            <label class="col-md-6 col-form-label text-center" for="vcompprod">Valor de compra:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="vcompprod" name="vcompprod"/>
                            </div>
                        </div>
                        <div class="form-group row"> 
                            <label class="col-md-6 col-form-label text-center" for="vvendprod">Valor de venda:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="vvendprod" name="vvendprod"/>
                            </div>
                        </div>
                        <div class="form-group row"> 
                            <label class="col-md-6 col-form-label text-center" for="qtdprod">Quantidade:</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" id="qtdprod" name="qtdprod"/>
                            </div>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <hr/>
                    ​<div class="custom-file">
                        <input type="file" class="custom-file-input" id="foto01" required>
                        <label class="custom-file-label" for="foto01">Foto 01</label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="foto02" required>
                        <label class="custom-file-label" for="foto02">Foto 02</label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="foto03" required>
                        <label class="custom-file-label" for="foto03">Foto 03</label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="foto04" required>
                        <label class="custom-file-label" for="foto04">Foto 04</label>
                        <div class="invalid-feedback">Example invalid custom file feedback</div>
                    </div>
                    <div class="esp15"></div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="foto05" required>
                        <label class="custom-file-label" for="foto05">Foto 05</label>
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
                            <button type="button" class="btn btn-danger btn-block">Cadastrar</button>
                        </div>
                    </div>
                    <div class="esp50"></div>
                </form>
            </div>
        </div>
        <%
            }else{
                response.sendRedirect("index.jsp");
            }
        %>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
