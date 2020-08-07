package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Gerente extends Usuario{
    private int cod_gerente;
    
    //-------------------------------||----------------------------------------
    public Gerente(int cod_usuario,int cod_gerente, String nome, String senha, String email, String idade,String pais, String cidade, String tipo) {
        super(cod_usuario,nome, senha, email, idade,pais, cidade, tipo);
        this.setCod_gerente(cod_gerente);
    }
    
    public Gerente(int cod_usuario, String nome, String senha, String email, String idade, String pais, String cidade, String tipo) {
        super(cod_usuario,nome, senha, email, idade, pais, cidade,tipo);
    }
    
    public Gerente(String nome, String senha, String email, String idade, String tipo) {
        super(nome, senha, email, idade, tipo);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_gerente() {
        return cod_gerente;
    }

    private void setCod_gerente(int cod_gerente) {
        this.cod_gerente = cod_gerente;
    }
}