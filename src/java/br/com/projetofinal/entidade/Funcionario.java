package br.com.projetofinal.entidade;

public class Funcionario {

    private int idfuncionario;
    private String funcionario;
    private String emailfunc;
    private String senhafunc;
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

    public Funcionario(int idfuncionario, String funcionario, String emailfunc, String senhafunc, String telfunc, String celfunc, String cpffunc, String funcaofunc, String cepfunc, String endfunc, String numfunc, String bairrofunc, String cidfunc, String estfunc, String complfunc, boolean ativo) {
        super();
        this.idfuncionario = idfuncionario;
        this.funcionario = funcionario;
        this.emailfunc = emailfunc;
        this.senhafunc = senhafunc;
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
        this.ativo = ativo;
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
    
    public String getSenhafunc() {
        return senhafunc;
    }

    public void setSenhafunc(String senhafunc) {
        this.senhafunc = senhafunc;
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

    private String isDados() {
        String erros = "";
        if (funcionario.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (emailfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (senhafunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (telfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (celfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (cpffunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (funcaofunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (cepfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (endfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (numfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (complfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (bairrofunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (cidfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (estfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        return erros;
    }
    
    public void validar() throws Exception{
        String erros = isDados();
        if(!erros.equals("")){
            throw new Exception(erros);
        }
    }

    
    private String isDadosAtt() {
        String erros = "";
        if (funcionario.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (emailfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (telfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (celfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (cpffunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (funcaofunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (cepfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (endfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (numfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (complfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (bairrofunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (cidfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        if (estfunc.equals("")){
            erros += "Nome do funcionário em branco. \n";
        }
        return erros;
    }
    
    public void validarAtt() throws Exception{
        String erros = isDadosAtt();
        if(!erros.equals("")){
            throw new Exception(erros);
        }
    }

    public void setSenhafunc(byte[] messageDigest) {}
    
}
