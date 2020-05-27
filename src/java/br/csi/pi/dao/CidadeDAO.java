package br.csi.pi.dao;

import br.csi.pi.modelo.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class CidadeDAO {    
    public int create(int cod_pais, String nome_cidade){
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "INSERT INTO cidade(cod_pais, nome_cidade) VALUES(?,?)";
            PreparedStatement pre = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1, nome_cidade);
            pre.executeUpdate();
            ResultSet rs = pre.getGeneratedKeys();
            rs.next();            
            
            if(rs.getInt(1) > 0){
               return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Cidade read(int cod_cidade) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM cidade WHERE cod_cidade = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_cidade);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cidade c = new Cidade(cod_cidade, rs.getInt("cod_pais"), rs.getString("nome_cidade"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean update(int cod_cidade, int cod_pais, String nome) {
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "UPDATE cidade SET cod_pais = ?, nome_cidade = ? WHERE cod_cidade = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_cidade);
            pre.setString(1, nome);
            if (pre.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int cod, String tipo) {
        if(tipo == "c"){
            boolean retorno = new LocalizaObraDAO().delete(cod, "c");
            boolean retorno2 = new LocalizaUsuarioDAO().delete(cod, "c");
            if(retorno == true && retorno2 == true ){
                try (Connection conn = new ConectaPostgres().getConexao()) {
                    String sql = "DELETE FROM cidade WHERE cod_cidade = ?";
                    PreparedStatement pre = conn.prepareStatement(sql);
                    pre.setInt(1, cod);
                    if (pre.executeUpdate() > 0) {
                        return true;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                    System.out.println("Falha ao excluir cidade da tabela localiza_obra e/ou localiza_usuario");
                 }
            return false;
        }else if(tipo == "p"){
                boolean certeza_exclui_cidade = true;           
                ArrayList<Cidade> cidades = new CidadeDAO().getCidades_contem_pais(cod);
                for(int i = 0; i < cidades.size(); i++){
                    Cidade c = cidades.get(i);
                    boolean retorno = new LocalizaObraDAO().delete(c.getCod_cidade(), "c");
                    boolean retorno2 = new LocalizaUsuarioDAO().delete(c.getCod_cidade(), "c");
                    if(retorno == true && retorno2 == true){
                        System.out.println("Cidade excluida das tabelas localiza"); 
                    }else{
                            System.out.println("Erro ao excluir cidades das tabelas localiza");
                            certeza_exclui_cidade = false;
                            break;
                         }
                }
                if(certeza_exclui_cidade == true){
                    try (Connection conn = new ConectaPostgres().getConexao()) {
                        String sql = "DELETE FROM cidade WHERE cod_pais = ?";
                        PreparedStatement pre = conn.prepareStatement(sql);
                        pre.setInt(1, cod);
                        if (pre.executeUpdate() > 0) {
                            return true;
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                        System.out.println("Algo deu errado, cidade não foi excluida");
                     }
        }
        return false;
    }
    
    public ArrayList<Cidade> getCidades_contem_pais(int cod_pais) {
    //Envio um codigo do pais e me devolve todas as cidades que aquele pais tem 
        ArrayList<Cidade> cidade_contem_pais = new ArrayList<>();
        try (Connection conn = new ConectaPostgres().getConexao()) {
            String sql = "SELECT * FROM cidade WHERE cod_pais = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, cod_pais);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Cidade c = new Cidade(rs.getInt("cod_cidade"),rs.getInt("cod_pais"),rs.getString("nome"));
                cidade_contem_pais.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cidade_contem_pais;
    }
}