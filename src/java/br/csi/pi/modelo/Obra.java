package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Obra {
    private int cod_obra;
    private int cod_artist_foto;
    private String nome;
    private String imagem;
    private String cor_predominante;
    private String descricao_obra;
    private String linguagem;
    private String autor;
    private String pais;
    
    //-------------------------------||----------------------------------------
    public Obra(int cod_obra, 
                int cod_artist_foto, 
                String nome, 
                String cor_predominante, 
                String descricao_obra, 
                String linguagem,
                String imagem,
                String autor,
                String pais) {
        this.setCod_obra(cod_obra);
        this.setCod_artist_foto(cod_artist_foto);
        this.setCor_predominante(cor_predominante);
        this.setDescricao_obra(descricao_obra);
        this.setLinguagem(linguagem);
        this.setNome(nome);
        this.setImagem(imagem);
        this.setAutor(autor);
        this.setPais(pais);
    }
    
    public Obra(
                int cod_artist_foto, 
                String nome, 
                String cor_predominante, 
                String descricao_obra, 
                String linguagem,
                String imagem,
                String autor,
                String pais) {
        this.setCod_artist_foto(cod_artist_foto);
        this.setCor_predominante(cor_predominante);
        this.setDescricao_obra(descricao_obra);
        this.setLinguagem(linguagem);
        this.setNome(nome);
        this.setImagem(imagem);
        this.setAutor(autor);
        this.setPais(pais);
    }
    
    public Obra(
                int cod_artist_foto, 
                String nome, 
                String cor_predominante, 
                String descricao_obra, 
                String linguagem,
                String autor,
                String pais) {
        this.setCod_artist_foto(cod_artist_foto);
        this.setCor_predominante(cor_predominante);
        this.setDescricao_obra(descricao_obra);
        this.setLinguagem(linguagem);
        this.setNome(nome);
        this.setAutor(autor);
        this.setPais(pais);
    }
    
    //-------------------------------||----------------------------------------
    public String getAutor() {
        return autor;
    }
    private void setAutor(String autor) {
        this.autor = autor;
    }
    
    //-------------------------------||----------------------------------------
    public String getPais() {
        return pais;
    }
    private void setPais(String pais) {
        this.pais = pais;
    }

    //-------------------------------||----------------------------------------
    public int getCod_artist_foto() {
        return this.cod_artist_foto;
    }

    private void setCod_artist_foto(int cod_artist_foto) {
        this.cod_artist_foto = cod_artist_foto;
    } 
    
    //-------------------------------||----------------------------------------

    public String getImagem() {
        return imagem;
    }

    private void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_obra() {
        return cod_obra;
    }

    private void setCod_obra(int cod_obra) {
        this.cod_obra = cod_obra;
    }
    
    //-------------------------------||----------------------------------------
    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    //-------------------------------||----------------------------------------
    public String getCor_predominante() {
        return cor_predominante;
    }

    private void setCor_predominante(String cor_predominante) {
        this.cor_predominante = cor_predominante;
    }
    
    //-------------------------------||----------------------------------------
    public String getDescricao_obra() {
        return descricao_obra;
    }

    private void setDescricao_obra(String descricao_obra) {
        this.descricao_obra = descricao_obra;
    }
    
    //-------------------------------||----------------------------------------
    public String getLinguagem() {
        return linguagem;
    }

    private void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }   
}