package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author micae
 */
public class ServicoDB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public boolean connect(){
        String server = "jdbc:mysql://localhost:3306/projetodeal";
        String user = "root";
        String pwd = "1234";
        String driver = "com.mysql.cj.jdbc.Driver";
        
        try{
            Class.forName(driver);
            this.connection = (Connection)DriverManager.getConnection(server, user, pwd);
            this.statement = (Statement)this.connection.createStatement();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao banco: "+e);
        }
        
        if(this.connection !=  null){
            System.out.println("Funcionou");
            return true;
        }
        return false;
    }
    
     public boolean insertServico(Servico servico){
        try{
            String sql = "insert into servicos "
                    +"(nome, descricao, categoria, status) "
                    +"values ('"+servico.getNome()
                    +"', '"+servico.getDescricao()
                    +"', '"+servico.getCategoria()
                    +"', '"+servico.getStatus()
                    +"');";
            //mostrar se o script do banco está sendo montado corretamente
            System.out.println(sql);
            this.statement.execute(sql);
            return true;
        }catch(Exception e){
            System.out.println("Erro1: "+e.getMessage());
            return false;
        }
    }
     
    public ArrayList<Servico> listServico(){
        ArrayList<Servico> servicos = new ArrayList<>();
        try{
            String sql = "select * from servicos";
            this.resultSet = statement.executeQuery(sql);
            Servico servico;
            while (this.resultSet.next()) {
                servico = new Servico();
                String nome = resultSet.getString("nome");
                servico.setNome(nome);
                String descricao = resultSet.getString("descricao");
                servico.setNome(descricao);
                String categoria = resultSet.getString("categoria");
                servico.setNome(categoria);
                String status = resultSet.getString("status");
                servico.setNome(status);
                servicos.add(servico);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return servicos;
    }
     
}
