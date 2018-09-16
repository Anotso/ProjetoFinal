function limpa_formulário_cep() {
        //Limpa valores do formulário de cep.
        document.getElementById('endfor').value=("");
        document.getElementById('barfor').value=("");
        document.getElementById('cidfor').value=("");
        document.getElementById('estfor').value=("");
}
function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        r = document.getElementById('endfor').value=(conteudo.logradouro);
        b = document.getElementById('barfor').value=(conteudo.bairro);
        document.getElementById('cidfor').value=(conteudo.localidade);
        document.getElementById('estfor').value=(conteudo.uf);
        if((r=="")&&(b=="")){
            document.getElementById('endfor').readOnly = false;
            document.getElementById('barfor').readOnly = false;
        }else{
            if(r==""){
                document.getElementById('endfor').readOnly = false;
            }else{
                if(b==""){
                    document.getElementById('barfor').readOnly = false;
                }
            }
        }
        if((r!="")&&(b!="")){
            document.getElementById('endfor').readOnly = true;
            document.getElementById('barfor').readOnly = true;
        }
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep();
        alert("CEP não encontrado.");
    }
}
    
function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if(validacep.test(cep)) {

            //Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('endfor').value="...";
            document.getElementById('barfor').value="...";
            document.getElementById('cidfor').value="...";
            document.getElementById('estfor').value="...";

            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep();
    }
};