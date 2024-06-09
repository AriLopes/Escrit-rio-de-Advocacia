package dados;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import dados.Advocacia;
	import jdbc.conexao;

	public class AdvocaciaDao {
	    
	    public void cadastrar(Advocacia advocacia) {
	        Connection con = conexao.obterConexao();
	        
	        String sql = "INSERT INTO Advocacia(nome_escritorio, num_casos_ativos, taxa_hora_media) VALUES (?, ?, ?)";
	        
	        try {
	            PreparedStatement preparador = con.prepareStatement(sql);
	            preparador.setString(1, advocacia.getNomeEscritorio());
	            preparador.setInt(2, advocacia.getNumCasosAtivos());
	            preparador.setDouble(3, advocacia.getTaxaHoraMedia());
	            
	            preparador.executeUpdate();
	            preparador.close();
	            
	            System.out.println("Escritório de advocacia cadastrado com sucesso!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public Advocacia consultar() {
	        Connection con = conexao.obterConexao();
	        Advocacia advocacia = null;
	        
	        String sql = "SELECT * FROM Advocacia";
	        
	        try {
	            PreparedStatement preparador = con.prepareStatement(sql);
	            ResultSet resultado = preparador.executeQuery();
	            
	            if (resultado.next()) {
	                advocacia = new Advocacia(
	                    resultado.getString("nome_escritorio"),
	                    resultado.getInt("num_casos_ativos"),
	                    resultado.getDouble("taxa_hora_media")
	                );
	            }
	            
	            resultado.close();
	            preparador.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return advocacia;
	    }
	    
	    public void alterar(Advocacia advocacia) {
	        Connection con = conexao.obterConexao();
	        
	        String sql = "UPDATE Advocacia SET nome_escritorio=?, num_casos_ativos=?, taxa_hora_media=? WHERE id=?";
	        
	        try {
	            PreparedStatement preparador = con.prepareStatement(sql);
	            preparador.setString(1, advocacia.getNomeEscritorio());
	            preparador.setInt(2, advocacia.getNumCasosAtivos());
	            preparador.setDouble(3, advocacia.getTaxaHoraMedia());
	            // Supondo que exista um ID no banco para cada registro da advocacia
	            preparador.setInt(4, 1); // Substituir 1 pelo ID correto
	            
	            preparador.executeUpdate();
	            preparador.close();
	            
	            System.out.println("Dados do escritório de advocacia atualizados com sucesso!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void excluir() {
	        Connection con = conexao.obterConexao();
	        
	        String sql = "DELETE FROM Advocacia WHERE id=?";
	        
	        try {
	            PreparedStatement preparador = con.prepareStatement(sql);
	            // Supondo que exista um ID no banco para cada registro da advocacia
	            preparador.setInt(1, 1); // Substituir 1 pelo ID correto
	            
	            preparador.executeUpdate();
	            preparador.close();
	            
	            System.out.println("Escritório de advocacia excluído com sucesso!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


