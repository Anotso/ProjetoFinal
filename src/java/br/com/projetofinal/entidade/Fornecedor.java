package br.com.projetofinal.entidade;

public class Fornecedor {
    
    private int idfornecedor;
    private String fornecedor;
    private String emailfor;
    private String sitefor;
    private String telfor;
    private String cnpj;
    private String cepfor;
    private String endfor;
    private String numfor;
    private String complfor;
    private String bairrofor;
    private String cidfor;
    private String estfor;
    
    public Fornecedor(int idfornecedor, String fornecedor, String emailfor, String sitefor, String telfor, String cnpj, String cepfor, String endfor, String numfor, String complfor, String bairrofor, String cidfor, String estfor){
        super();
        this.idfornecedor = idfornecedor;
        this.fornecedor = fornecedor;
        this.emailfor = emailfor;
        this.sitefor = sitefor;
        this.telfor = telfor;
        this.cnpj = cnpj;
        this.cepfor = cepfor;
        this.endfor = endfor;
        this.numfor = numfor;
        this.complfor = complfor;
        this.bairrofor = bairrofor;
        this.cidfor = cidfor;
        this.estfor = estfor;
        
    }

    public Fornecedor() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getEmailfor() {
        return emailfor;
    }

    public void setEmailfor(String emailfor) {
        this.emailfor = emailfor;
    }

    public String getSitefor() {
        return sitefor;
    }

    public void setSitefor(String sitefor) {
        this.sitefor = sitefor;
    }

    public String getTelfor() {
        return telfor;
    }

    public void setTelfor(String telfor) {
        this.telfor = telfor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCepfor() {
        return cepfor;
    }

    public void setCepfor(String cepfor) {
        this.cepfor = cepfor;
    }

    public String getEndfor() {
        return endfor;
    }

    public void setEndfor(String endfor) {
        this.endfor = endfor;
    }

    public String getNumfor() {
        return numfor;
    }

    public void setNumfor(String numfor) {
        this.numfor = numfor;
    }

    public String getComplfor() {
        return complfor;
    }

    public void setComplfor(String complfor) {
        this.complfor = complfor;
    }

    public String getBairrofor() {
        return bairrofor;
    }

    public void setBairrofor(String bairrofor) {
        this.bairrofor = bairrofor;
    }

    public String getCidfor() {
        return cidfor;
    }

    public void setCidfor(String cidfor) {
        this.cidfor = cidfor;
    }

    public String getEstfor() {
        return estfor;
    }

    public void setEstfor(String estfor) {
        this.estfor = estfor;
    }
    
}