package br.com.projetofinal.entidade;

public class Funcionario {

    private int idfuncionario;
    private String funcionario;
    private String emailfunc;
    private String telfunc;
    private String celfunc;
    private String cpffunc;
    private String funcaofunc;
    private String cepfunc;
    private String endfunc;
    private String numfunc;
    private String complfunc;
    private String bairrofunc;
    private String cidfunc;
    private String estfunc;
    private boolean ativo = true;
    
    public Funcionario(int idfuncionario, String funcionario, String emailfunc, String telfunc, String celfunc, String cpffunc, String funcaofunc, String cepfunc, String endfunc, String numfunc, String complfunc, String bairrofunc, String cidfunc, String estfunc){
        super();
        this.idfuncionario = idfuncionario;
        this.funcionario = funcionario;
        this.emailfunc = emailfunc;
        this.telfunc = telfunc;
        this.celfunc = celfunc;
        this.cpffunc = cpffunc;
        this.funcaofunc = funcaofunc;
        this.cepfunc = cepfunc;
        this.endfunc = endfunc;
        this.numfunc = numfunc;
        this.complfunc = complfunc;
        this.bairrofunc = bairrofunc;
        this.cidfunc = cidfunc;
        this.estfunc = estfunc;
    }

    public Funcionario() {}
    
    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public String getEmailfunc() {
        return emailfunc;
    }

    public void setEmailfunc(String emailfunc) {
        this.emailfunc = emailfunc;
    }

    public String getTelfunc() {
        return telfunc;
    }

    public void setTelfunc(String telfunc) {
        this.telfunc = telfunc;
    }

    public String getCelfunc() {
        return celfunc;
    }

    public void setCelfunc(String celfunc) {
        this.celfunc = celfunc;
    }

    public String getCpffunc() {
        return cpffunc;
    }

    public void setCpffunc(String cpffunc) {
        this.cpffunc = cpffunc;
    }

    public String getFuncaofunc() {
        return funcaofunc;
    }

    public void setFuncaofunc(String funcaofunc) {
        this.funcaofunc = funcaofunc;
    }

    public String getCepfunc() {
        return cepfunc;
    }

    public void setCepfunc(String cepfunc) {
        this.cepfunc = cepfunc;
    }

    public String getEndfunc() {
        return endfunc;
    }

    public void setEndfunc(String endfunc) {
        this.endfunc = endfunc;
    }

    public String getNumfunc() {
        return numfunc;
    }

    public void setNumfunc(String numfunc) {
        this.numfunc = numfunc;
    }

    public String getComplfunc() {
        return complfunc;
    }

    public void setComplfunc(String complfunc) {
        this.complfunc = complfunc;
    }

    public String getBairrofunc() {
        return bairrofunc;
    }

    public void setBairrofunc(String bairrofunc) {
        this.bairrofunc = bairrofunc;
    }

    public String getCidfunc() {
        return cidfunc;
    }

    public void setCidfunc(String cidfunc) {
        this.cidfunc = cidfunc;
    }

    public String getEstfunc() {
        return estfunc;
    }

    public void setEstfunc(String estfunc) {
        this.estfunc = estfunc;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
