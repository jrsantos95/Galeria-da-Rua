package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Cidade {
    private int cod_cidade;
    private int cod_pais;
    private String nome;   
    
    //-------------------------------||----------------------------------------
    public Cidade(int cod_cidade, int cod_pais, String nome) {
        this.setCod_cidade(cod_cidade);
        this.setCod_pais(cod_pais);
        this.setNome(nome);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_pais() {
        return this.cod_pais;
    }

    private void setCod_pais(int cod_pais) {
        this.cod_pais = cod_pais;
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_cidade() {
        return this.cod_cidade;
    }

    private void setCod_cidade(int cod_cidade) {
        this.cod_cidade = cod_cidade;
    }
    
    //-------------------------------||----------------------------------------
    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
}