package br.com.projetofinal.entidade;

public class Setor {

    private int idsetor;
    private String setor;
    
    public Setor(int idsetor, String setor){
        super();
        this.idsetor = idsetor;
        this.setor = setor;
    }
    
    public Setor(){}
    
    public int getIdsetor() {
        return idsetor;
    }

    public void setIdsetor(int idsetor) {
        this.idsetor = idsetor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
}
