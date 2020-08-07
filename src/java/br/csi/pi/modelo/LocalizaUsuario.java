package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class LocalizaUsuario {
    private int cod_localiza_obra;
    private Usuario usuario;
    private Cidade cidade;
    
    //-------------------------------||----------------------------------------
    public LocalizaUsuario(int cod_localiza_obra, Usuario usuario, Cidade cidade){
        this.setCod_localiza_obra(cod_localiza_obra);
        this.setCidade(cidade);
        this.setUsuario(usuario);
    }
    
    public LocalizaUsuario(Usuario usuario, Cidade cidade){
        this.setCidade(cidade);
        this.setUsuario(usuario);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_localiza_obra() {
        return this.cod_localiza_obra;
    }

    private void setCod_localiza_obra(int cod_localiza_obra) {
        this.cod_localiza_obra = cod_localiza_obra;
    }
    
    //------------------------t-------||---------------------------------------- 
    public Usuario getUsuario() {
        return this.usuario;
    }

    private void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //-------------------------------||----------------------------------------
    public Cidade getCidade() {
        return this.cidade;
    }

    private void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }   
}