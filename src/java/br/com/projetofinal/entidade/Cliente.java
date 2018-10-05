package br.com.projetofinal.entidade;

public class Cliente {
    
    private int idcli;
    private String cliente;
    private String snome;
    private String dtnasc;
    private String sexo;
    private String tipocli;
    private String cadfed;
    private String cadest;
    private String emailcli;
    private String senhacli;
    private String telcli;
    private String celcli;
    private String cepcli;
    private String endcli;
    private String numcli;
    private String complcli;
    private String refcli;
    private String bairrocli;
    private String cidcli;
    private String estcli;
    private boolean ativo = true;
    
    public Cliente(int idcli, String cliente, String snome, String dtnasc, String sexo, String tipocli, String cadfed, String cadest,
            String emailcli, String senhacli, String telcli, String celcli, String cepcli, String endcli, String numcli,
            String complcli, String refcli, String bairrocli, String cidcli, String estcli, boolean ativo) {
        super();
        this.idcli = idcli;
        this.cliente = cliente;
        this.snome = snome;
        this.dtnasc = dtnasc;
        this.sexo = sexo;
        this.tipocli = tipocli;
        this.cadfed = cadfed;
        this.cadest = cadest;
        this.emailcli = emailcli;
        this.senhacli = senhacli;
        this.telcli = telcli;
        this.celcli = celcli;
        this.cepcli = cepcli;
        this.endcli = endcli;
        this.numcli = numcli;
        this.complcli = complcli;
        this.refcli = refcli;
        this.bairrocli = bairrocli;
        this.cidcli = cidcli;
        this.estcli = estcli;
        this.ativo = ativo;
    }

    public Cliente() {}

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSnome() {
        return snome;
    }

    public void setSnome(String snome) {
        this.snome = snome;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipocli() {
        return tipocli;
    }

    public void setTipocli(String tipocli) {
        this.tipocli = tipocli;
    }

    public String getCadfed() {
        return cadfed;
    }

    public void setCadfed(String cadfed) {
        this.cadfed = cadfed;
    }

    public String getCadest() {
        return cadest;
    }

    public void setCadest(String cadest) {
        this.cadest = cadest;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }

    public String getSenhacli() {
        return senhacli;
    }

    public void setSenhacli(String senhacli) {
        this.senhacli = senhacli;
    }

    public String getTelcli() {
        return telcli;
    }

    public void setTelcli(String telcli) {
        this.telcli = telcli;
    }

    public String getCelcli() {
        return celcli;
    }

    public void setCelcli(String celcli) {
        this.celcli = celcli;
    }

    public String getCepcli() {
        return cepcli;
    }

    public void setCepcli(String cepcli) {
        this.cepcli = cepcli;
    }

    public String getEndcli() {
        return endcli;
    }

    public void setEndcli(String endcli) {
        this.endcli = endcli;
    }

    public String getNumcli() {
        return numcli;
    }

    public void setNumcli(String numcli) {
        this.numcli = numcli;
    }

    public String getComplcli() {
        return complcli;
    }

    public void setComplcli(String complcli) {
        this.complcli = complcli;
    }

    public String getRefcli() {
        return refcli;
    }

    public void setRefcli(String refcli) {
        this.refcli = refcli;
    }

    public String getBairrocli() {
        return bairrocli;
    }

    public void setBairrocli(String bairrocli) {
        this.bairrocli = bairrocli;
    }

    public String getCidcli() {
        return cidcli;
    }

    public void setCidcli(String cidcli) {
        this.cidcli = cidcli;
    }

    public String getEstcli() {
        return estcli;
    }

    public void setEstcli(String estcli) {
        this.estcli = estcli;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    private String isDados() {
        String erros = "";
        if (cliente.equals("")) {
            erros += "Nome em branco. \n";
        }
        if (snome.equals("")) {
            erros += "Sobrenome em branco. \n";
        }
        if (dtnasc.equals("")) {
            erros += "Data de nascimento em branco. \n";
        }
        if (cadfed.equals("")) {
            erros += "CPF em branco. \n";
        }
        if (cadest.equals("")) {
            erros += "Identidade em branco. \n";
        }
        if (emailcli.equals("")) {
            erros += "E-mail em branco. \n";
        }
        if (senhacli.equals("")) {
            erros += "Senha em branco. \n";
        }
        if (telcli.equals("")) {
            erros += "Número de telefone em branco. \n";
        }
        if (celcli.equals("")) {
            erros += "Número de celular em branco. \n";
        }
        if (cepcli.equals("")) {
            erros += "CEP em branco. \n";
        }
        if (endcli.equals("")) {
            erros += "Endereço em branco. \n";
        }
        if (numcli.equals("")) {
            erros += "Número da residência em branco. \n";
        }
        if (complcli.equals("")) {
            erros += "Complemento em branco. \n";
        }
        if (refcli.equals("")) {
            erros += "Referência em branco. \n";
        }
        if (bairrocli.equals("")) {
            erros += "Bairro em branco. \n";
        }
        if (cidcli.equals("")) {
            erros += "Cidade em branco. \n";
        }
        if (estcli.equals("")) {
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

    public void setSenhacli(byte[] messageDigest) {}
    
}
