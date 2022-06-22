/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;


/**
 *
 * @author micae
 */
public class ClienteDb {
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
    
    public boolean insertCliente(Cliente cliente){
        try{
            String sql = "insert into clientes"
                +"(nome, cpf, idade, endereco, telefone) "
                + "values ('"+cliente.getNome()
                + "', '" +cliente.getCpf() 
                + "', " +cliente.getIdade()
                +", '" +cliente.getEndereco()
                +"', '" +cliente.getTelefone()
                +"');";
            System.out.println(sql);
            this.statement.execute(sql);
            return true;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }
}
