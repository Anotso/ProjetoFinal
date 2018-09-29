        //CADASTRO DE CLIENTE
//HABILITA A DIV RESPONSÁVEL PELOS CAMPOS DA PESSOA FÍSICA
function CarPesFisica(){
    document.getElementById("pesfisica").style.display="block";
    document.getElementById("pesjuridica").style.display="none";
}
//HABILITA A DIV RESPONSÁVEL PELOS CAMPOS DA PESSOA JURÍDICA
function CarPesJuridica(){
    document.getElementById("pesfisica").style.display="none";
    document.getElementById("pesjuridica").style.display="block";
}


        //CHAMA CADFUNCIONARIO
function CarregaCadFuncionario(){
    /*loadfuncao.submit;
    alert("??");
    document.location.href = "loadfuncao.html";*/
    window.history.pushState('Object', 'Categoria JavaScript', "/ProjetoFinal/cadfuncionario.jsp");
}

        //CADASTRO DE FORNECEDOR
function EnvioFornecedor(){
    cadfornecedor.submit();
}

        //CADASTRO DE FUNÇÕES
function EnvioFuncao(){
    var fun = "";
    fun = document.getElementById("funcao").value;
    if ((fun == "")||(fun == null)){
        alert("            Campo vazio ou inválido!\n\nVerifique os dados e tente novamente.")
    }else{
        cadfuncao.submit();
    }
}

        //CADASTRO DE FUNCIONÁRIO
function EnviaFuncionario(){
    var comp = "";
    comp = document.getElementById("complfu").value;
    if((comp == "")||(comp == null)){
        document.getElementById("complfu").value = (" - ");
    }
    cadfuncionario.submit();
}
