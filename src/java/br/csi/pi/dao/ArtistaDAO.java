package br.csi.pi.dao;

import br.csi.pi.modelo.ArtistaFotografo;
import br.csi.pi.modelo.Obra;
import br.csi.pi.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class ArtistaDAO {
    public int create(ArtistaFotografo af) {
        int cod_usuario = new UsuarioDAO().create(af.getNome(),af.getSenha(),af.getEmail(),af.getIdade(),af.getPais(), af.getCidade(),af.getTipo());                        
        
        if(cod_usuario == 0){//Testa se já existe esse email
            return 0;
        }else if(cod_usuario == -1){//se não só continua 
                    return -1;
                  }else{
                        try(Connection conn = new ConectaPostgres().getConexao()){
                            String sql = "INSERT INTO artista_fotografo(cod_usuario, tag, contato, linguagem, descricao_artist_foto, imagem)"
                                          + "VALUES (?,?,?,?,?,?)";
                            PreparedStatement pre = conn.prepareStatement(sql);
                            pre.setInt(1, cod_usuario);
                            pre.setString(2, af.getTag());
                            pre.setString(3, af.getContato());
                            pre.setString(4, af.getLinguagem());
                            pre.setString(5, af.getDescricao_artist_foto());
                            pre.setString(6, af.getImagem());
                            if (pre.executeUpdate() > 0){
                                return 1;
                            };                        
                        }catch(SQLException e){
                            e.printStackTrace();
                        }      
        }
        return 0;        
    }
    
    public ArtistaFotografo read(int cod_usuario) {
        Usuario u = new UsuarioDAO().read(cod_usuario);
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "select * from artista_fotografo WHERE cod_usuario = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_usuario);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ArtistaFotografo af = new ArtistaFotografo(cod_usuario, 
                                                           rs.getInt("cod_artist_foto"),
                                                           rs.getString("tag"), 
                                                           rs.getString("contato"), 
                                                           rs.getString("linguagem"), 
                                                           u.getNome(), 
                                                           u.getSenha(), 
                                                           u.getEmail(), 
                                                           u.getIdade(),
                                                           u.getPais(),
                                                           u.getCidade(),
                                                           rs.getString("descricao_artist_foto"),
                                                           u.getTipo(),
                                                           rs.getString("imagem"));
                return af;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(ArtistaFotografo af){
        boolean retorno = new UsuarioDAO().update(af.getCod_usuario(),
                                                  af.getNome(),
                                                  af.getSenha(),
                                                  af.getEmail(),
                                                  af.getIdade(),
                                                  af.getPais(),
                                                  af.getCidade(),
                                                  af.getTipo());       
        if(retorno){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "UPDATE artista_fotografo SET tag = ?, contato = ?, linguagem = ?, descricao_artist_foto = ? "
                              +"WHERE cod_usuario = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setString(1, af.getTag());
                pre.setString(2, af.getContato());
                pre.setString(3, af.getLinguagem());
                pre.setString(4, af.getDescricao_artist_foto());
                pre.setInt(5, af.getCod_usuario());
                
                if (pre.executeUpdate() > 0) {
                    System.out.println("ArtistaFototgrafo atualizado com sucesso");
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Falha ao atualizar artistaFotografo");
            return false;
        }else{
             System.out.println("Falha ao atualizar usuario de artistaFotografo");
             return false;
             }
    }
    
    public boolean updateImagem(String imagem) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE artista_fotografo SET imagem = ? WHERE imagem = 'semImagem'";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, imagem);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(ArtistaFotografo af) {
        ArrayList<Obra> obras = new ObraDAO().getObras_contem_artista_foto(af.getCod_artistFoto());
        for(int i = 0; i < obras.size(); i++){
            Obra o = obras.get(i);
            boolean retorno = new ObraDAO().delete(o.getCod_obra());
            if(retorno){
                System.out.println("Obra excluida das tabela obra"); 
            }else{
                    System.out.println("Erro ao excluir obras da tabela obra");
                 }
        }
        System.out.println("Teste delete2");
        try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM artista_fotografo WHERE cod_usuario = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, af.getCod_usuario());
                if (pre.executeUpdate() > 0){
                    System.out.println("Teste delete2");
                    boolean retorno = new UsuarioDAO().delete(af.getCod_usuario());
                    System.out.println("Teste delete3");
                    if(retorno){
                        System.out.println("ArtistaFotografo deletado com sucesso");
                        return true;
                    }else{
                           System.out.println("Falha ao deletar artistaFotografo");
                           return false;
                         }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false; 
    }
}