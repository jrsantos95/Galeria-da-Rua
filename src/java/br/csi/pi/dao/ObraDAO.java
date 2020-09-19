package br.csi.pi.dao;

import br.csi.pi.modelo.Obra;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class ObraDAO {
    public boolean create(Obra o) throws FileNotFoundException, IOException {
        try (Connection conn = new ConectaPostgres().getConexao()){
            String sql ="INSERT INTO obra(cod_artist_foto, nome, imagem, cor_predominante, descricao_obra, linguagem)"
                          +"VALUES(?,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, o.getCod_artist_foto());
            pre.setString(2, o.getNome());
            pre.setString(3, "semImagem");
            pre.setString(4, o.getCor_predominante());
            pre.setString(5, o.getDescricao_obra());
            pre.setString(6, o.getLinguagem());
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Obra read(int cod_obra) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra WHERE cod_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_obra);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Obra o = new Obra(cod_obra, 
                                  rs.getInt("cod_artist_foto"), 
                                  rs.getString("nome"),     
                                  rs.getString("cor_predominante"),     
                                  rs.getString("descricao_obra"), 
                                  rs.getString("linguagem"), 
                                  rs.getString("imagem")); 
                return o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Obra read2(int cod_artist_foto,String nome) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra WHERE cod_artist_foto = ? and nome = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_artist_foto);
            pre.setString(2, nome);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Obra o = new Obra(rs.getInt("cod_obra"), 
                                  cod_artist_foto, 
                                  nome,     
                                  rs.getString("cor_predominante"),     
                                  rs.getString("descricao_obra"), 
                                  rs.getString("linguagem"), 
                                  rs.getString("imagem")); 
                return o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_autor, 
                          String nome, 
                          String cor_predominante, 
                          String descricao_obra, 
                          String linguagem, 
                          String imagem) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE obra SET nome = ?, cor_predominante = ?, descricao_obra = ?, linguagem = ?, imagem = ? "
                         + "WHERE cod_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, nome);
            pre.setString(2, cor_predominante);
            pre.setString(3, descricao_obra);
            pre.setString(4, linguagem);
            pre.setString(5, imagem);
            pre.setInt(6, cod_autor);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateImagem(String imagem) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE obra SET imagem = ? WHERE imagem = 'semImagem'";
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
    
    public boolean delete(int cod_obra) {
        //boolean retorno = new CriaObraDAO().delete(cod_obra, "o");
        //boolean retorno2 = new LocalizaObraDAO().delete(cod_obra, "o");
        //if(retorno == true && retorno2 == true){
            try (Connection conn = new ConectaPostgres().getConexao()) {
                String sql = "DELETE FROM obra WHERE cod_obra = ?";
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, cod_obra);
                if (pre.executeUpdate() > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        //}else{
                //System.out.println("Falha ao excluir obra da tabela criaObra e/ou localizaObra");
            // }
        return false;
    }
    
    public ArrayList<Obra> getObras_contem_artista_foto(int cod_artist_foto) {
    //Envio um codigo do artista_foto e me devolve todas as obras que aquele artista_foto tem 
        ArrayList<Obra> obra_contem_artista_fotografo = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra WHERE cod_artist_foto = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_artist_foto);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Obra o = new Obra(rs.getInt("cod_obra"), 
                                  rs.getInt("cod_artist_foto"), 
                                  rs.getString("nome"),     
                                  rs.getString("cor_predominante"),     
                                  rs.getString("descricao_obra"), 
                                  rs.getString("linguagem"), 
                                  rs.getString("imagem"));
                obra_contem_artista_fotografo.add(o);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return obra_contem_artista_fotografo;
    }
    
    public ArrayList<Obra> getObras(int cod_obra) {
        ArrayList<Obra> obra_contem_artista_fotografo = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra WHERE cod_obra = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_obra);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Obra o = new Obra(rs.getInt("cod_obra"), 
                                  rs.getInt("cod_artist_foto"), 
                                  rs.getString("nome"),     
                                  rs.getString("cor_predominante"),     
                                  rs.getString("descricao_obra"), 
                                  rs.getString("linguagem"), 
                                  rs.getString("imagem"));
                obra_contem_artista_fotografo.add(o);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return obra_contem_artista_fotografo;
    }
    
    public boolean getObras_teste_nome(int cod_artist_foto, String nome) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra WHERE cod_artist_foto = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_artist_foto);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                if(rs.getString("nome").equals(nome)){
                    System.out.println("Tem obra com esse nome!");
                    return false;
                }            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    public ArrayList<Obra> getObrasTotal() {
        ArrayList<Obra> obra_contem_artista_fotografo = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Obra o = new Obra(rs.getInt("cod_obra"), 
                                  rs.getInt("cod_artist_foto"), 
                                  rs.getString("nome"),     
                                  rs.getString("cor_predominante"),     
                                  rs.getString("descricao_obra"), 
                                  rs.getString("linguagem"), 
                                  rs.getString("imagem"));
                obra_contem_artista_fotografo.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return obra_contem_artista_fotografo;
    }
    
    public ArrayList<Obra> getObras_linguagem(String linguagem) {
        ArrayList<Obra> obra_contem_linguagem = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM obra WHERE linguagem = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, linguagem);
            ResultSet rs = pre.executeQuery();
            while(rs.next()) {
                Obra o = new Obra(rs.getInt("cod_obra"), 
                                  rs.getInt("cod_artist_foto"), 
                                  rs.getString("nome"),     
                                  rs.getString("cor_predominante"),     
                                  rs.getString("descricao_obra"), 
                                  rs.getString("linguagem"), 
                                  rs.getString("imagem"));
                obra_contem_linguagem.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return obra_contem_linguagem;
    }
}    