package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Apreciador extends Usuario{
    private int cod_apreciador;

    //-------------------------------||----------------------------------------
    public Apreciador(int cod_usuario,
                      int cod_apreciador, 
                      String nome, 
                      String senha, 
                      String email,
                      String idade, 
                      String tipo){
        super(cod_usuario,nome, senha, email, idade, tipo);
        this.setCod_apreciador(cod_apreciador);
    }
    
    public Apreciador(int cod_usuario, 
                      String nome, 
                      String senha, 
                      String email,
                      String idade, 
                      String tipo){
        super(cod_usuario,nome, senha, email, idade, tipo);
    }
    
    public Apreciador(
                      String nome, 
                      String senha, 
                      String email,
                      String idade, 
                      String tipo){
        super(nome, senha, email, idade, tipo);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_apreciador() {
        return cod_apreciador;
    }

    private void setCod_apreciador(int cod_apreciador) {
        this.cod_apreciador = cod_apreciador;
    }   
}