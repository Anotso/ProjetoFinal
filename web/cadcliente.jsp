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
                <script type="text/javascript" src="recursos/js/code.js"></script>
        <title>JSP Page</title>
    </head>
    <body onload="CarPesFisica()">
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
        <div class="container">
            <div class="esp15"></div>
                <div class="row">
                    <div class="col-md-12">
                        <center><h3>Cadastro de Cliente</h3></center>
                        <hr>
                    </div>
                </div>
                <div class="esp15"></div>
            <form action="" method="POST">
                <div class="form-group row">
                        <label for="email" class="col-md-4 col-form-label">E-mail:</label>
                        <div class="col-md-8">
                                <input type="text" class="form-control" id="email" name="email" placeholder="Ex.: exemplo@exemplo.com"/>
                        </div>
                </div>
                <div class="form-group row">
                    <label for="senha" class="col-md-4 col-form-label">Senha:</label>
                    <div class="col-md-8">
                        <input type="senha" class="form-control" id="senha" name="senha" placeholder="Digite a senha"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="reptsenha" class="col-md-4 col-form-label">Repetir senha:</label>
                    <div class="col-md-8">
                        <input type="url" class="form-control" id="reptsenha" name="reptsenha" placeholder="Repetir senha"/>
                    </div>
                </div>
                <div class="esp5"></div>
                <hr/>
                <div class="esp5"></div>
                <div class="form-row">
                    <div class=" col-md-6">
                        <div class="form-check form-check-inline" onclick="CarPesFisica()">
                            <input class="form-check-input" type="radio" id="pf" value="pf" name="pessoa">
                            <label class="form-check-label" for="pf">Pessoa Física</label>
                        </div>
                    </div>
                    <div class=" col-md-6">
                        <div class="form-check form-check-inline" onclick="CarPesJuridica()">
                            <input class="form-check-input" type="radio" id="pj" value="pj" name="pessoa">
                            <label class="form-check-label" for="pj">Pessoa Jurídica</label>
                        </div>
                    </div>
                </div>
                <div class="esp5"></div>
                <hr/>
                <div class="esp5"></div>
                <div class="form-row">
                    
                    <div class="col-md-6">
                        <!-- PESSOA FÍSICA -->
                        <div id="pesfisica">
                            <div class="row">
                                <div class="col-md-12"><center><h4>Dados cadastrais</h4></center></div>
                            </div>
                            <div class="row"><div class="col-md-12 esp5"></div></div>
                            <div class="form-group row">
                                <label for="nomecli" class="col-md-4 col-form-label">Nome:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="nomecli" name="nomecli"/>
                                </div>
                            </div>	
                            <div class="form-group row">
                                <label for="sobrenome" class="col-md-4 col-form-label">Sobrenome:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="sobrenome" name="sobrenome"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label" for="sexo">Sexo</label>
                                <div class="col-md-8">
                                    <select class="custom-select form-control" id="sexo">
                                        <option selected>Selecione</option>
                                        <option value="M">Masculino</option>
                                        <option value="F">Feminino</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cpf" class="col-md-4 col-form-label">CPF:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cpf" name="cpf"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="rg" class="col-md-4 col-form-label">Identidade:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="rg" name="rg"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="nasc" class="col-md-4 col-form-label">Data de Nascimento:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="nasc" name="nasc"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="tel" class="col-md-4 col-form-label">Telefone:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="tel" name="tel"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cel" class="col-md-4 col-form-label">Celular:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cel" name="cel"/>
                                </div>
                            </div>
                        </div>
                        <div id="pesjuridica">
                            <div class="row">
                                <div class="col-md-12"><center><h4>Dados cadastrais</h4></center></div>
                            </div>
                            <div class="row"><div class="col-md-12 esp5"></div></div>
                            <div class="form-group row">
                                <label for="nomecli" class="col-md-4 col-form-label">Razão Social:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="nomecli" name="nomecli"/>
                                </div>
                            </div>	
                            <div class="form-group row">
                                <label for="sobrenome" class="col-md-4 col-form-label">Nome Fantasia:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="sobrenome" name="sobrenome"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cnpj" class="col-md-4 col-form-label">CNPJ:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cnpj" name="cnpj"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="insest" class="col-md-4 col-form-label">Inscrição Estadual:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="insest" name="insest"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="tel" class="col-md-4 col-form-label">Telefone:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="tel" name="tel"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cel" class="col-md-4 col-form-label">Celular:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cel" name="cel"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="row">
                            <div class="col-md-12"><center><h4>Endereço de entrega</h4></center></div>
                        </div>
                        <div class="row"><div class="col-md-12 esp5"></div></div>
                        <div class="form-group row">
                        <label for="cep" class="col-md-4 col-form-label">CEP:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="cep" name="cep"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="rua" class="col-md-4 col-form-label">Rua:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="rua" name="rua" readonly/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="numero" class="col-md-4 col-form-label">Número:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="numero" name="numero"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="comp" class="col-md-4 col-form-label">Complemento:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="comp" name="comp"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="ref" class="col-md-4 col-form-label">Referência:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="ref" name="ref"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="bairro" class="col-md-4 col-form-label">Bairro:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="bairro" name="bairro" readonly/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="cidade" class="col-md-4 col-form-label">Cidade:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="cidade" name="cidade" readonly/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="estado" class="col-md-4 col-form-label">Estado:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="estado" name="estado" readonly/>
                            </div>
                        </div>
                    </div>
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
            </form>
        </div>
        <div class="esp50"></div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
    </body>
</html>
