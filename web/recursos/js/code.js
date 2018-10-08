//CADASTRO DE CLIENTE
//HABILITA A DIV RESPONSÁVEL PELOS CAMPOS DA PESSOA FÍSICA
function CarPesFisica() {
    document.getElementById("pesfisica").style.display = "block";
    document.getElementById("pesjuridica").style.display = "none";
}
//HABILITA A DIV RESPONSÁVEL PELOS CAMPOS DA PESSOA JURÍDICA
function CarPesJuridica() {
    document.getElementById("pesfisica").style.display = "none";
    document.getElementById("pesjuridica").style.display = "block";
}


//CHAMA CADFUNCIONARIO
function CarregaCadFuncionario() {
    /*loadfuncao.submit;
     alert("??");
     document.location.href = "loadfuncao.html";*/
    window.history.pushState('Object', 'Categoria JavaScript', "/ProjetoFinal/cadfuncionario.jsp");
}
//CHAMA CADCATEGORIA
function CarregaCadSetor() {
    window.history.pushState('Object', 'Categoria JavaScript', "/ProjetoFinal/cadcategoria.jsp");
}
//CHAMA MENUPROD
function ChamaSetor() {
    window.history.pushState('Object', 'Categoria JavaScript', "/ProjetoFinal/menuprod.html");
}
//CHAMA CADPRODUTO
function CarregaCadProd() {
    window.history.pushState('Object', 'Categoria JavaScript', "/ProjetoFinal/cadproduto.jsp");
}


//CADASTRO DE FORNECEDOR
function EnvioFornecedor() {
    cadfornecedor.submit();
}

//CADASTRO DE FUNÇÕES
function EnvioFuncao() {
    var fun = "";
    fun = document.getElementById("funcao").value;
    if ((fun == "") || (fun == null)) {
        alert("            Campo vazio ou inválido!\n\nVerifique os dados e tente novamente.")
    } else {
        cadfuncao.submit();
    }
}

//CADASTRO DE FUNCIONÁRIO
function EnviaFuncionario() {
    var comp = "";
    comp = document.getElementById("complfu").value;
    if ((comp == "") || (comp == null)) {
        document.getElementById("complfu").value = (" - ");
    }
    cadfuncionario.submit();
}

//CADASTRO DE SETOR
function EnviaSetor() {
    var set = "";
    set = document.getElementById("setor").value;
    if ((set == "") || (set == null)) {
        alert("Setor não informado! Informe o nome do setor antes de confirmar.")
    } else {
        cadcategoria.submit();
    }
}


//MENU CLIENTE - ÁREA RESTRITA

function Dados() {
    document.getElementById("edc1").style.display = "block";
    document.getElementById("edc2").style.display = "none";
    document.getElementById("excluir").style.display = "block";
    document.getElementById("cancelar").style.display = "none";
    document.getElementById("pedidos").style.display = "none";
}
function Pedidos() {
    document.getElementById("dados").style.display = "none";
    document.getElementById("pedidos").style.display = "block";
}
function EditarCliente() {
    document.getElementById("edc1").style.display = "block";
    document.getElementById("edc2").style.display = "none";
    document.getElementById("excluir").style.display = "block";
    document.getElementById("cancelar").style.display = "none";
    //PF
    //document.getElementById("nomecli").readOnly = false;
    //document.getElementById("sobrenome").readOnly = false;
    //document.getElementById("sexo").readOnly = false;
    //document.getElementById("cpf").readOnly = false;
    //document.getElementById("rg").readOnly = false;
    //document.getElementById("nasc").readOnly = false;
    //document.getElementById("tel").readOnly = false;
    //document.getElementById("cel").readOnly = false;
    //document.getElementById("cel").readOnly = false;
    //PF
    //document.getElementById("rsocial").readOnly = false;
    //document.getElementById("fantasia").readOnly = false;
    //document.getElementById("cnpj").readOnly = false;
    //document.getElementById("insest").readOnly = false;
    //document.getElementById("telpj").readOnly = false;
    //document.getElementById("celpj").readOnly = false;

    //DADOS COMUNS DO ENDEREÇO 
    document.getElementById("cep").readOnly = false;
    document.getElementById("numero").readOnly = false;
    document.getElementById("comp").readOnly = false;
    document.getElementById("ref").readOnly = false;
}
function CancelarEditar(){
    document.getElementById("edc1").style.display = "none";
    document.getElementById("edc2").style.display = "block";
    document.getElementById("excluir").style.display = "none";
    document.getElementById("cancelar").style.display = "block";
    //PF
    //document.getElementById("nomecli").readOnly = true;
    //document.getElementById("sobrenome").readOnly = true;
    //document.getElementById("sexo").readOnly = true;
    //document.getElementById("cpf").readOnly = true;
    //document.getElementById("rg").readOnly = true;
    //document.getElementById("nasc").readOnly = true;
    //document.getElementById("tel").readOnly = true;
    //document.getElementById("cel").readOnly = true;
    //document.getElementById("cel").readOnly = true;
    //PF
    //document.getElementById("rsocial").readOnly = true;
    //document.getElementById("fantasia").readOnly = true;
    //document.getElementById("cnpj").readOnly = true;
    //document.getElementById("insest").readOnly = true;
    //document.getElementById("telpj").readOnly = true;
    //document.getElementById("celpj").readOnly = true;

    //DADOS COMUNS DO ENDEREÇO 
    document.getElementById("cep").readOnly = true;
    document.getElementById("numero").readOnly = true;
    document.getElementById("comp").readOnly = true;
    document.getElementById("ref").readOnly = true;
}