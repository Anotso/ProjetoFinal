<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <script type="text/javascript" src="recursos/js/cep.js"></script>
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
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Cadastro de Fornecedores</h3></center>
                        <hr>
                    </div>
                </div>
                <div class="esp15"></div>
                <form action="" method="POST">
                    <div class="form-group row">
                        <label for="nfor" class="col-md-4 col-form-label">Nome do Fornecedor:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="nfor" name="nfor" placeholder="Informe o nome do fornecedor"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="emailfor" class="col-md-4 col-form-label">E-mail do Fornecedor:</label>
                        <div class="col-md-8">
                            <input type="email" class="form-control" id="emailfor" name="emailfor" placeholder="Ex.: exemplo@exemplo.com"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="sitefor" class="col-md-4 col-form-label">Site do Fornecedor:</label>
                        <div class="col-md-8">
                            <input type="url" class="form-control" id="sitefor" name="sitefor" placeholder="Ex.: http://www.exemplo.com"/>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <hr/>
                        <!--    DADOS DO BUSCA CEP  -->
                    <div class="esp5"></div>
                    <div class="form-group row">
                        <label for="cepfor" class="col-md-4 col-form-label">Informe o CEP do Fornecedor:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="cepfor" name="cepfor" onblur="pesquisacep(this.value)"/>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="endfor" class="col-md-4 col-form-label">Endereço:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="endfor" name="endfor" readonly/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="numfor" class="col-md-4 col-form-label">Número:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="numfor" name="numfor"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="compfor" class="col-md-4 col-form-label">Complemento:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="compfor" name="compfor"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="barfor" class="col-md-4 col-form-label">Bairro:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="barfor" name="barfor" readonly/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cidfor" class="col-md-4 col-form-label">Cidade:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cidfor" name="cidfor" readonly/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="estfor" class="col-md-4 col-form-label">Estado:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="estfor" name="estfor" readonly/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <hr/>
                    <div class="esp5"></div>
                </form>
            </div>
        </div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
