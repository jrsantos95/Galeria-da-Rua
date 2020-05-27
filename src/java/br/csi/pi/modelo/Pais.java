package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class Pais {
    private int cod_pais;
    private String nome;   
    
    //-------------------------------||----------------------------------------
    public Pais(int cod_pais, String nome) {
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
    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
}