package br.com.projetofinal.entidade;


public class Pj {
    
    private int idpj;
    private String razao;
    private String nomepj;
    private String cnpjpj;
    private String insestpj;
    private String emailpj;
    private String senhapj;
    private String telpj;
    private String celpj;
    private String ceppj;
    private String endpj;
    private String numpj;
    private String complpj;
    private String refpj;
    private String bairropj;
    private String cidpj;
    private String estpj;
    private boolean ativo = true;
    
    public Pj(int idpj, String razao, String nomepj, String cnpjpj, String insestpj, String emailpj, String senhapj, String telpj, String celpj, String ceppj, String endpj, String numpj, String complpj, String refpj, String bairropj, String cidpj, String estpj, boolean ativo) {
        super();
        this.idpj = idpj;
        this.razao = razao;
        this.nomepj = nomepj;
        this.cnpjpj = cnpjpj;
        this.insestpj = insestpj;
        this.emailpj = emailpj;
        this.senhapj = senhapj;
        this.telpj = telpj;
        this.celpj = celpj;
        this.ceppj = ceppj;
        this.endpj = endpj;
        this.numpj = numpj;
        this.complpj = complpj;
        this.refpj = refpj;
        this.bairropj = bairropj;
        this.cidpj = cidpj;
        this.estpj = estpj;
        this.ativo = ativo;
    }
    
    public Pj(){}

    public int getIdpj() {
        return idpj;
    }

    public void setIdpj(int idpj) {
        this.idpj = idpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getNomepj() {
        return nomepj;
    }

    public void setNomepj(String nomepj) {
        this.nomepj = nomepj;
    }

    public String getCnpjpj() {
        return cnpjpj;
    }

    public void setCnpjpj(String cnpjpj) {
        this.cnpjpj = cnpjpj;
    }

    public String getInsestpj() {
        return insestpj;
    }

    public void setInsestpj(String insestpj) {
        this.insestpj = insestpj;
    }

    public String getEmailpj() {
        return emailpj;
    }

    public void setEmailpj(String emailpj) {
        this.emailpj = emailpj;
    }

    public String getSenhapj() {
        return senhapj;
    }

    public void setSenhapj(String senhapj) {
        this.senhapj = senhapj;
    }

    public String getTelpj() {
        return telpj;
    }

    public void setTelpj(String telpj) {
        this.telpj = telpj;
    }

    public String getCelpj() {
        return celpj;
    }

    public void setCelpj(String celpj) {
        this.celpj = celpj;
    }

    public String getCeppj() {
        return ceppj;
    }

    public void setCeppj(String ceppj) {
        this.ceppj = ceppj;
    }

    public String getEndpj() {
        return endpj;
    }

    public void setEndpj(String endpj) {
        this.endpj = endpj;
    }

    public String getNumpj() {
        return numpj;
    }

    public void setNumpj(String numpj) {
        this.numpj = numpj;
    }

    public String getComplpj() {
        return complpj;
    }

    public void setComplpj(String complpj) {
        this.complpj = complpj;
    }

    public String getRefpj() {
        return refpj;
    }

    public void setRefpj(String refpj) {
        this.refpj = refpj;
    }

    public String getBairropj() {
        return bairropj;
    }

    public void setBairropj(String bairropj) {
        this.bairropj = bairropj;
    }

    public String getCidpj() {
        return cidpj;
    }

    public void setCidpj(String cidpj) {
        this.cidpj = cidpj;
    }

    public String getEstpj() {
        return estpj;
    }

    public void setEstpj(String estpj) {
        this.estpj = estpj;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    private String isDados() {
        String erros = "";
        if (razao.equals("")) {
            erros += "Nome em branco. \n";
        }
        if (nomepj.equals("")) {
            erros += "Sobrenome em branco. \n";
        }
        if (cnpjpj.equals("")) {
            erros += "CNPJ em branco. \n";
        }
        if (insestpj.equals("")) {
            erros += "Identidade em branco. \n";
        }
        if (emailpj.equals("")) {
            erros += "E-mail em branco. \n";
        }
        if (senhapj.equals("")) {
            erros += "Senha em branco. \n";
        }
        if (telpj.equals("")) {
            erros += "Número de telefone em branco. \n";
        }
        if (celpj.equals("")) {
            erros += "Número de celular em branco. \n";
        }
        if (ceppj.equals("")) {
            erros += "CEP em branco. \n";
        }
        if (endpj.equals("")) {
            erros += "Endereço em branco. \n";
        }
        if (numpj.equals("")) {
            erros += "Número da residência em branco. \n";
        }
        if (complpj.equals("")) {
            erros += "Complemento em branco. \n";
        }
        if (refpj.equals("")) {
            erros += "Referência em branco. \n";
        }
        if (bairropj.equals("")) {
            erros += "Bairro em branco. \n";
        }
        if (cidpj.equals("")) {
            erros += "Cidade em branco. \n";
        }
        if (estpj.equals("")) {
            erros += "Estado em branco. \n";
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
