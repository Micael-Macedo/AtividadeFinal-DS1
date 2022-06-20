/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
            return true;
        }
        return false;
    }
    
     public boolean insertServico(Servico servico){
        try{
            String sql = "insert into coffee "
                    + "(cliente, prestador, nome,descricao,localizacao,categoria,status) "
                    + "values ('"+servico.getCliente()
                    +"', "+servico.getPrestador()
                    +", "+servico.getNome()
                    +", "+servico.getDescricao()
                    +", "+servico.getLocalizacao()
                    +", "+servico.getCategoria()
                    +", "+servico.getStatus()
                    +");";
            //mostrar se o script do banco está sendo montado corretamente
            System.out.println(sql);
            this.statement.execute(sql);
            return true;
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return false;
        }
    }
     
      public ArrayList<Servico> listServico(){
        ArrayList<Servico> coffees = new ArrayList<>();
        try{
            String sql = "select * from servicos";
            this.resultSet = statement.executeQuery(sql);
            Servico servico;
            while (this.resultSet.next()) {
                servico = new Servico();
                String brand = resultSet.getString("brand");
                coffee.setBrand(brand);
                coffee.setPrice(resultSet.getFloat("price"));
                coffee.setPrice(resultSet.getFloat("weight"));
                coffees.add(coffee);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return coffees;
    }
     
}
