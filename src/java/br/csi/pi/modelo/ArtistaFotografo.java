package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class ArtistaFotografo extends Usuario{
    private int cod_artistFoto;
    private String tag;
    private String contato;
    private String linguagem;
    private String descricao_artist_foto;
    private String imagem;
    
    //-------------------------------||----------------------------------------
    public ArtistaFotografo(int cod_usuario, 
                            int cod_artistFoto, 
                            String tag, 
                            String contato, 
                            String linguagem, 
                            String nome, 
                            String senha, 
                            String email, 
                            String idade, 
                            String pais,
                            String cidade,
                            String descricao_artist_foto,
                            String tipo,
                            String imagem) {
        super(cod_usuario, nome, senha, email, idade,pais, cidade, tipo);
        this.setCod_artistFoto(cod_artistFoto);
        this.setContato(contato);
        this.setLinguagem(linguagem);
        this.setTag(tag);
        this.setDescricao_artist_foto(descricao_artist_foto);
        this.setImagem(imagem);
    }
    
    public ArtistaFotografo(int cod_usuario, 
                            String tag, 
                            String contato, 
                            String linguagem, 
                            String nome, 
                            String senha, 
                            String email, 
                            String idade, 
                            String pais,
                            String cidade,
                            String descricao_artist_foto,
                            String tipo) {
        super(cod_usuario, nome, senha, email, idade, pais, cidade, tipo);
        this.setContato(contato);
        this.setLinguagem(linguagem);
        this.setTag(tag);
        this.setDescricao_artist_foto(descricao_artist_foto);
    }
    
        public ArtistaFotografo( 
                            String tag, 
                            String contato, 
                            String linguagem, 
                            String nome, 
                            String senha, 
                            String email, 
                            String idade, 
                            String pais,
                            String cidade,
                            String descricao_artist_foto,
                            String tipo,
                            String imagem){    
        super(nome, senha, email, idade, pais, cidade, tipo);
        this.setContato(contato);
        this.setLinguagem(linguagem);
        this.setTag(tag);
        this.setDescricao_artist_foto(descricao_artist_foto);
        this.setImagem(imagem);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_artistFoto() {
        return cod_artistFoto;
    }

    private void setCod_artistFoto(int cod_artistFoto) {
        this.cod_artistFoto = cod_artistFoto;
    }
    
    //-------------------------------||----------------------------------------
    public String getTag() {
        return tag;
    }
    
    private void setTag(String tag) {
        this.tag = tag;
    }
    
    //-------------------------------||----------------------------------------
    public String getContato() {
        return contato;
    }

    private void setContato(String contato) {
        this.contato = contato;
    }
    
    //-------------------------------||----------------------------------------
    public String getLinguagem() {
        return linguagem;
    }

    private void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
    
    //-------------------------------||----------------------------------------
    public String getDescricao_artist_foto() {
        return this.descricao_artist_foto;
    }

    private void setDescricao_artist_foto(String descricao_artist_foto) {
        this.descricao_artist_foto = descricao_artist_foto;
    }
    
    //-------------------------------||----------------------------------------
    public String getImagem() {
        return imagem;
    }

    private void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
}