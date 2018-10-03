package br.com.projetofinal.entidade;

public class Pf {

    private int idpf;
    private String pf;
    private String snome;
    private String dtnasc;
    private String sexo;
    private String cpfpf;
    private String rgpf;
    private String emailpf;
    private String senhapf;
    private String telpf;
    private String celpf;
    private String ceppf;
    private String endpf;
    private String numpf;
    private String complpf;
    private String refpf;
    private String bairropf;
    private String cidpf;
    private String estpf;
    private boolean ativo = true;

    public Pf(int idpf, String pf, String snome, String dtnasc, String sexo, String cpfpf, String rgpf, String emailpf, String senhapf, String telpf, String celpf, String ceppf, String endpf, String numpf, String complpf, String refpf, String bairropf, String cidpf, String estpf, boolean ativo) {
        super();
        this.idpf = idpf;
        this.pf = pf;
        this.snome = snome;
        this.dtnasc = dtnasc;
        this.sexo = sexo;
        this.cpfpf = cpfpf;
        this.rgpf = rgpf;
        this.emailpf = emailpf;
        this.senhapf = senhapf;
        this.telpf = telpf;
        this.celpf = celpf;
        this.ceppf = ceppf;
        this.endpf = endpf;
        this.numpf = numpf;
        this.complpf = complpf;
        this.refpf = refpf;
        this.bairropf = bairropf;
        this.cidpf = cidpf;
        this.estpf = estpf;
        this.ativo = ativo;
    }
    
    public Pf(){}

    public int getIdpf() {
        return idpf;
    }

    public void setIdpf(int idpf) {
        this.idpf = idpf;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
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

    public String getCpfpf() {
        return cpfpf;
    }

    public void setCpfpf(String cpfpf) {
        this.cpfpf = cpfpf;
    }

    public String getRgpf() {
        return rgpf;
    }

    public void setRgpf(String rgpf) {
        this.rgpf = rgpf;
    }

    public String getEmailpf() {
        return emailpf;
    }

    public void setEmailpf(String emailpf) {
        this.emailpf = emailpf;
    }

    public String getSenhapf() {
        return senhapf;
    }

    public void setSenhapf(String senhapf) {
        this.senhapf = senhapf;
    }

    public String getTelpf() {
        return telpf;
    }

    public void setTelpf(String telpf) {
        this.telpf = telpf;
    }

    public String getCelpf() {
        return celpf;
    }

    public void setCelpf(String celpf) {
        this.celpf = celpf;
    }

    public String getCeppf() {
        return ceppf;
    }

    public void setCeppf(String ceppf) {
        this.ceppf = ceppf;
    }

    public String getEndpf() {
        return endpf;
    }

    public void setEndpf(String endpf) {
        this.endpf = endpf;
    }

    public String getNumpf() {
        return numpf;
    }

    public void setNumpf(String numpf) {
        this.numpf = numpf;
    }

    public String getComplpf() {
        return complpf;
    }

    public void setComplpf(String complpf) {
        this.complpf = complpf;
    }

    public String getRefpf() {
        return refpf;
    }

    public void setRefpf(String refpf) {
        this.refpf = refpf;
    }

    public String getBairropf() {
        return bairropf;
    }

    public void setBairropf(String bairropf) {
        this.bairropf = bairropf;
    }

    public String getCidpf() {
        return cidpf;
    }

    public void setCidpf(String cidpf) {
        this.cidpf = cidpf;
    }

    public String getEstpf() {
        return estpf;
    }

    public void setEstpf(String estpf) {
        this.estpf = estpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    private String isDados() {
        String erros = "";
        if (pf.equals("")) {
            erros += "Nome em branco. \n";
        }
        if (snome.equals("")) {
            erros += "Sobrenome em branco. \n";
        }
        if (dtnasc.equals("")) {
            erros += "Data de nascimento em branco. \n";
        }
        if (cpfpf.equals("")) {
            erros += "CPF em branco. \n";
        }
        if (rgpf.equals("")) {
            erros += "Identidade em branco. \n";
        }
        if (emailpf.equals("")) {
            erros += "E-mail em branco. \n";
        }
        if (senhapf.equals("")) {
            erros += "Senha em branco. \n";
        }
        if (telpf.equals("")) {
            erros += "Número de telefone em branco. \n";
        }
        if (celpf.equals("")) {
            erros += "Número de celular em branco. \n";
        }
        if (ceppf.equals("")) {
            erros += "CEP em branco. \n";
        }
        if (endpf.equals("")) {
            erros += "Endereço em branco. \n";
        }
        if (numpf.equals("")) {
            erros += "Número da residência em branco. \n";
        }
        if (complpf.equals("")) {
            erros += "Complemento em branco. \n";
        }
        if (refpf.equals("")) {
            erros += "Referência em branco. \n";
        }
        if (bairropf.equals("")) {
            erros += "Bairro em branco. \n";
        }
        if (cidpf.equals("")) {
            erros += "Cidade em branco. \n";
        }
        if (estpf.equals("")) {
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
