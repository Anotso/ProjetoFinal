package br.com.projetofinal.entidade;

public class Categoria {
    
    private int idcategoria;
    private String categoria;
    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public Categoria(int idcategoria, String categoria, String setor){
        super();
        this.idcategoria = idcategoria;
        this.categoria = categoria;
        this.setor = setor;
    }
    public Categoria(){}

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    private String isDados() {
        String erros = "";

        if (categoria.equals("")) {
            erros += "Categoria em branco. \n";
        }
        if (setor.equals("")) {
            erros += "Setor em branco. \n";
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
