package br.csi.pi.modelo;

/**
 *
 * @author Juan
 */
public class LocalizaObra {
    private int cod_localiza_obra;
    private Obra obra;
    private Cidade cidade;
    
    //-------------------------------||----------------------------------------
    public LocalizaObra(int cod_localiza_obra, Obra obra, Cidade cidade){
        this.setCod_localiza_obra(cod_localiza_obra);
        this.setCidade(cidade);
        this.setObra(obra);
    }
    
    public LocalizaObra(Obra obra, Cidade cidade){
        this.setCidade(cidade);
        this.setObra(obra);
    }
    
    //-------------------------------||----------------------------------------
    public int getCod_localiza_obra() {
        return this.cod_localiza_obra;
    }

    private void setCod_localiza_obra(int cod_localiza_obra) {
        this.cod_localiza_obra = cod_localiza_obra;
    }
    
    //------------------------t-------||---------------------------------------- 
    public Obra getObra() {
        return this.obra;
    }

    private void setObra(Obra obra) {
        this.obra = obra;
    }
    
    //-------------------------------||----------------------------------------
    public Cidade getCidade() {
        return this.cidade;
    }

    private void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}