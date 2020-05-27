package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Usuario{
    private int cod_usuario;
    private String nome;
    private String senha;
    private String email;
    private String idade;
    private String tipo;//g = gerente , ap = apreciador, af = artista_fotografo;
    
    //-------------------------------||----------------------------------------
    public Usuario(String nome, String senha, String email, String idade, String tipo){
        this.setTipo(tipo);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setIdade(idade);
    }
    
    public Usuario(int cod_usuario,String nome, String senha, String email, String idade, String tipo ){
        this.setCod_usuario(cod_usuario);
        this.setTipo(tipo);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setIdade(idade);
    }
    
    public Usuario(String nome, String senha, String email){
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
    }
    
    public Usuario(){   
    } 
    
    //-------------------------------||----------------------------------------
    public String getIdade() {
        return this.idade;
    }
    private void setIdade(String idade) {
        this.idade = idade;
    }

    //-------------------------------||----------------------------------------
    public int getCod_usuario() {
        return this.cod_usuario;
    }
    
    private void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    //-------------------------------||----------------------------------------
    public String getNome() {
        return this.nome;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    //-------------------------------||----------------------------------------
    public String getEmail() {
        return this.email;
    }
    private void setEmail(String email) {
        this.email = email;
    }
    
    //-------------------------------||----------------------------------------
    public String getSenha() {
        return this.senha;
    }
    private void setSenha(String senha) {
        this.senha = senha;
    }
    
    //--------------------||--------------------
    public String getTipo(){
        return tipo;
    }
    private void setTipo(String tipo) {
        this.tipo = tipo;
    }
}   