package maven.demo;

import java.sql.*;

public class DAO {
    private Connection conexao;
    
    public DAO() {
        conexao = null;
    }
    
    public boolean conectar() {
        String driverName = "org.postgresql.Driver";
        String serverName = "localhost";
        String mydatabase = "Veiculo";
        int porta = 5432;
        String url = "jdbc:postgresql://" + serverName + ":" + porta + "/" + mydatabase;
        String username = "gcs";
        String password = "ga230505";
        boolean status = false;
        
        try {
            Class.forName(driverName);
            conexao = DriverManager.getConnection(url, username, password);
            status = true;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return status;
    }
    
    public boolean inserirVeiculo(Veiculo veiculo) {
        boolean status = false;
        
        try {
            Statement st = conexao.createStatement();
            String query = "INSERT INTO \"Veiculos\" (id, nome, preco, ano) VALUES (" +
                            veiculo.get_Id() + ", '" + veiculo.get_Name() + "', " +
                            veiculo.get_Preco() + ", " + veiculo.get_Ano() + ")";
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException v) {
            throw new RuntimeException(v);
        }
        
        return status;
    }
    
    public boolean atualizarVeiculo(Veiculo veiculo) {
        boolean status = false;
        
        try {
            Statement st = conexao.createStatement();
            String query = "UPDATE \"Veiculos\" SET nome = '" + veiculo.get_Name() + "', preco = " + veiculo.get_Preco() + ", ano = " + veiculo.get_Ano() + " WHERE id = " + veiculo.get_Id();
            st.executeUpdate(query);
            st.close();
            status = true;
        } catch (SQLException v) {
            throw new RuntimeException(v);
        }
        
        return status;
    }
    
    public boolean deletarVeiculo(int id) {
        boolean status = false;
        
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM \"Veiculos\" WHERE id = " + id);
            st.close();
            status = true;
        } catch (SQLException v) {
            throw new RuntimeException(v);
        }
        
        return status;
    }
    
    public Veiculo[] getVeiculos() {
        Veiculo[] veiculos = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM \"Veiculos\"");        
            if(rs.next()) {
                rs.last();
                veiculos = new Veiculo[rs.getRow()];
                rs.beforeFirst(); 

                for (int i = 0; rs.next(); i++) {
                    veiculos[i] = new Veiculo(rs.getInt("id"), rs.getString("nome"), 
                                              rs.getDouble("preco"), rs.getInt("ano"));
                }
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return veiculos;
    }
}

