package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Autor {
    private int cod_autor;
    private String nome;
    private String tag;
    
    //-------------------------------||----------------------------------------
    public Autor(int cod_autor, String nome, String tag) {
        this.setCod_autor(cod_autor);
        this.setNome(nome);
        this.setTag(tag);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_autor() {
        return this.cod_autor;
    }

    private void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }
    
    //-------------------------------||----------------------------------------
    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
    
    //-------------------------------||----------------------------------------
    public String getTag() {
        return this.tag;
    }

    private void setTag(String tag) {
        this.tag = tag;
    }
}