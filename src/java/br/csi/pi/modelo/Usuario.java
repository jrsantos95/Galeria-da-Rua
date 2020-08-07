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
    private String pais;
    private String cidade;
    private String tipo;//g = gerente , ap = apreciador, af = artista_fotografo;
    
    //-------------------------------||----------------------------------------
    public Usuario(String nome, String senha, String email, String idade,String pais, String cidade, String tipo){
        this.setTipo(tipo);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setIdade(idade);
        this.setPais(pais);
        this.setCidade(cidade);
    }
    
    public Usuario(int cod_usuario,
                   String nome, 
                   String senha, 
                   String email, 
                   String idade,
                   String pais,
                   String cidade, 
                   String tipo ){
        this.setCod_usuario(cod_usuario);
        this.setTipo(tipo);
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setIdade(idade);
        this.setPais(pais);
        this.setCidade(cidade);
    }
    
    public Usuario(String nome, String senha, String email,String pais, String cidade){
        this.setNome(nome);
        this.setSenha(senha);
        this.setEmail(email);
        this.setPais(pais);
        this.setCidade(cidade);
    }
    
    public Usuario(){   
    } 
    
    //-------------------------------||----------------------------------------
    public String getPais() {
        return pais;
    }
    
    private void setPais(String pais) {
        this.pais = pais;
    }
    
    //-------------------------------||----------------------------------------
    public String getCidade() {
        return cidade;
    }
    
    private void setCidade(String cidade) {
        this.cidade = cidade;
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