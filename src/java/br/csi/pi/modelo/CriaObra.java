package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class CriaObra {
    private int cod_cria_obra;
    private Obra obra;
    private Autor autor;

    //-------------------------------||-----------------------------------------
    public CriaObra(int cod_cria_obra, Obra obra, Autor autor) {
        this.setCod_cria_obra(cod_cria_obra);
        this.setAutor(autor);
        this.setObra(obra);
    }
    
    public CriaObra(Obra obra, Autor autor) {
        this.setAutor(autor);
        this.setObra(obra);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_cria_obra() {
        return this.cod_cria_obra;
    }

    private void setCod_cria_obra(int cod_cria_obra) {
        this.cod_cria_obra = cod_cria_obra;
    }
    
    //-------------------------------||----------------------------------------
    public Obra getObra() {
        return this.obra;
    }

    private void setObra(Obra obra) {
        this.obra = obra;
    }
    
    //-------------------------------||----------------------------------------
    public Autor getAutor() {
        return this.autor;
    }

    private void setAutor(Autor autor) {
        this.autor = autor;
    }
}