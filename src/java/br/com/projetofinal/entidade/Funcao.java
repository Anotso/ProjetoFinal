package br.com.projetofinal.entidade;

public class Funcao {

    private int idfuncao;
    private String funcao;
    
    public Funcao(int idfuncao, String funcao){
        super();
        this.idfuncao = idfuncao;
        this.funcao = funcao;
    }

    public Funcao() {
    }
    
    public int getIdfuncao() {
        return idfuncao;
    }

    public void setIdfuncao(int idfuncao) {
        this.idfuncao = idfuncao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    
}
