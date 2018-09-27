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
        <%
            if(usuario == null){
                    %>
        <div class="esp50"></div>
        <div class="corpo">
            <div class="container">
                <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Cadastro de Funcionário</h3></center>
                        <hr>
                    </div>
                </div>
                <div class="esp15"></div>
                <form action="cadfuncionario.html" method="POST">
                    <div class="form-group row">
                        <label for="nfu" class="col-md-4 col-form-label">Nome do Funcionário:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="nfu" name="nfun" placeholder="Informe o nome do fornecedor"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="emailfu" class="col-md-4 col-form-label">E-mail do Funcionário:</label>
                        <div class="col-md-8">
                            <input type="email" class="form-control" id="emailfu" name="emailfun" placeholder="Ex.: exemplo@exemplo.com"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="telfu" class="col-md-4 col-form-label">Telefone do Funcionário:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="telfu" name="telfun" placeholder="Ex.: (xx) xxxx-xxxx"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="celfu" class="col-md-4 col-form-label">Celular do Funcionário:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="celfu" name="celfun" placeholder="Ex.: (xx) xxxx-xxxx"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="cpffu" class="col-md-4 col-form-label">CPF do Funcionário:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="cpffu" name="cpffun"/>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <hr/>
                        <!--    DADOS DO BUSCA CEP  -->
                    <div class="esp5"></div>
                    <div class="form-group row">
                        <label for="cep" class="col-md-4 col-form-label">Informe o CEP do Fornecedor:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" id="cep" name="cep" onblur="pesquisacep(this.value)"/>
                        </div>
                    </div>
                    <div class="esp5"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="end" class="col-md-4 col-form-label">Endereço:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="end" name="end" readonly/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="numfu" class="col-md-4 col-form-label">Número:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="numfu" name="numfu"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="complfun" class="col-md-4 col-form-label">Complemento:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="complfun" name="complfun"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group row">
                                <label for="bairro" class="col-md-4 col-form-label">Bairro:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="bairro" name="bairro" readonly/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cid" class="col-md-4 col-form-label">Cidade:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cid" name="cid" readonly/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="est" class="col-md-4 col-form-label">Estado:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="est" name="est" readonly/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="esp5"></div>
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
