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
        <!--	Font Awesome -->
        <link href="recursos/fontawesome/css/all.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body onload="CarPesFisica()">
        <nav>
            <c:if test="${not empty f or not empty c}">
                <c:import url="include/navlogout.jsp"/>
            </c:if>
            <c:if test="${empty f and empty c}">
                <c:import url="include/navlogin.jsp"/>
            </c:if>
            <c:if test="${not empty f}">
                <c:import url="include/navfun.jsp"/>
            </c:if>
            <c:if test="${not empty c}">
                <c:import url="include/menuprod.jsp"/>
            </c:if>
        </nav>
        <div class="container">
            <div class="esp15"></div>
            <div class="row">
                <div class="col-md-12">
                    <center><h3>Cadastro de Cliente</h3></center>
                    <hr>
                </div>
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
            <div class="esp15"></div>
            <form action="cadcliente.html" method="POST">
                <div class="form-group row">
                    <label for="email" class="col-md-4 col-form-label">E-mail:</label>
                    <div class="col-md-8">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Ex.: exemplo@exemplo.com"
                            value="<c:if test="${pf.emailpf}">${pf.emailpf}</c:if><c:if test="${pj.emailpj}">${pj.emailpj}</c:if>"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="senha" class="col-md-4 col-form-label">Senha:</label>
                    <div class="col-md-8">
                        <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite a senha"
                            value="<c:if test="${pf.senhapf}"></c:if><c:if test="${pj.senhapj}"></c:if>"/>
                    </div>
                </div>
                <div class="esp5"></div>
                <hr/>
                <div class="esp5"></div>
                <div class="form-row">
                    <div class=" col-md-6">
                        <div class="form-check form-check-inline" onclick="CarPesFisica()">
                                <input class="form-check-input" type="radio" id="pf" value="pf" name="pessoa"
                                <c:if test="${not empty pf.cpfpf}"></c:if>/>
                            <label class="form-check-label" for="pf">Pessoa Física</label>
                        </div>
                    </div>
                    <div class=" col-md-6">
                        <div class="form-check form-check-inline" onclick="CarPesJuridica()">
                            <input class="form-check-input" type="radio" id="pj" value="pj" name="pessoa"
                            <c:if test="${not empty pf.cpfpf}"></c:if>/>
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
                                    <input type="text" class="form-control" id="nomecli" name="nomecli"
                                    <c:if test="pf.pf"></c:if>/>
                                </div>
                            </div>	
                            <div class="form-group row">
                                <label for="sobrenome" class="col-md-4 col-form-label">Sobrenome:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="sobrenome" name="sobrenome"
                                        <c:if test="pf.snomepf"></c:if>/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-md-4 col-form-label" for="sexo">Sexo</label>
                                <div class="col-md-8">
                                    <select class="custom-select form-control" id="sexo" name="sexo"<c:if test="pf.sexo"></c:if>>
                                        <option value="M">Masculino</option>
                                        <option value="F">Feminino</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cpf" class="col-md-4 col-form-label">CPF:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cpf" name="cpf"<c:if test="pf.cpfpf"></c:if>/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="rg" class="col-md-4 col-form-label">Identidade:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="rg" name="rg"<c:if test="pf.rgpf"></c:if>/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="nasc" class="col-md-4 col-form-label">Data de Nascimento:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="nasc" name="nasc"<c:if test="pf.dtnasc"></c:if>/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="tel" class="col-md-4 col-form-label">Telefone:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="tel" name="tel"<c:if test="pf.telpf"></c:if>/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="cel" class="col-md-4 col-form-label">Celular:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="cel" name="cel"<c:if test="pf.celpf"></c:if>/>
                                </div>
                            </div>
                        </div>
                        <div id="pesjuridica">
                            <div class="row">
                                <div class="col-md-12"><center><h4>Dados cadastrais</h4></center></div>
                            </div>
                            <div class="row"><div class="col-md-12 esp5"></div></div>
                            <div class="form-group row">
                                <label for="rsocial" class="col-md-4 col-form-label">Razão Social:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="rsocial" name="rsocial"<c:if test="pj.razao"></c:if>/>
                                </div>
                            </div>	
                            <div class="form-group row">
                                <label for="fantasia" class="col-md-4 col-form-label">Nome Fantasia:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="fantasia" name="fantasia"<c:if test="pj.nomepj"></c:if>/>
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
                                <label for="telpj" class="col-md-4 col-form-label">Telefone:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="telpj" name="telpj"/>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="celpj" class="col-md-4 col-form-label">Celular:</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="celpj" name="celpj"/>
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
                                <input type="text" class="form-control" id="cep" name="cep" onblur="pesquisacep(this.value)"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="end" class="col-md-4 col-form-label">Rua:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" id="end" name="end" readonly/>
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
            </form>
        </div>
        <div class="esp50"></div>
        <footer>
            <c:import url="include/rodape.jsp"/>
        </footer>
        <!--	JS Bootstrap	-->
        <script type="text/javascript" src="bootstrap/jquery/jquery-3.3.1.slim.min.js"></script>
        <script type="text/javascript" src="bootstrap/popper/popper.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <!--    Codificação própria -->
        <script type="text/javascript" src="recursos/js/cep.js"></script>
        <script type="text/javascript" src="recursos/js/code.js"></script>
    </body>
</html>
