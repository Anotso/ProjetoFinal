package br.com.projetofinal.entidade;

public class Produto {

    private int idproduto;
    private String produto;
    private String fornecedor;
    private int categoria;
    private String descricao;
    private float compra;
    private float venda;
    private int qtd;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;
    private String foto5;

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }
    private boolean destaque = false;

    public Produto(int idproduto, String produto, String fornecedor, int categoria, String descricao, float compra, float venda, int qtd, String foto1, String foto2, String foto3, String foto4, String foto5, boolean destaque) {
        super();
        this.idproduto = idproduto;
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.compra = compra;
        this.venda = venda;
        this.qtd = qtd;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
        this.destaque = destaque;
    }

    public Produto() {
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCompra() {
        return compra;
    }

    public void setCompra(float compra) {
        this.compra = compra;
    }

    public float getVenda() {
        return venda;
    }

    public void setVenda(float venda) {
        this.venda = venda;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
    }

    public String getFoto5() {
        return foto5;
    }

    public void setFoto5(String foto5) {
        this.foto5 = foto5;
    }

    //TRATAMENTO DE ERROS
    private String isDados() {
        String erros = "";

        if (produto.equals("")) {
            erros += "Produto em branco. \n";
        }
        if (fornecedor.equals("")) {
            erros += "Fornecedor em branco. \n";
        }
        if (categoria==0) {
            erros += "Categoria em branco. \n";
        }
        if (descricao.equals("")) {
            erros += "Descrição em branco. \n";
        }
        if (compra == 0) {
            erros += "Valor de compra em branco. \n";
        }
        if (venda == 0) {
            erros += "Valor de venda em branco. \n";
        }
        if (qtd == 0) {
            erros += "Quantidade em branco. \n";
        }
        if (foto1.equals("")) {
            erros += "Primeira foto em branco. \n";
        }
        if (foto2.equals("")) {
            erros += "Segunda foto em branco. \n";
        }
        if (foto3.equals("")) {
            erros += "Terceira foto em branco. \n";
        }
        return erros;
    }

    public void validar() throws Exception {
        String erros = isDados();
        if (!erros.equals("")) {
            throw new Exception(erros);
        }
    }

}
