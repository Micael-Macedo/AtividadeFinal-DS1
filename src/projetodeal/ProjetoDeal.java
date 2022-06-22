/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodeal;


import controller.ClienteController;
import model.ClienteDb;
import views.CadastroUsuario;
/**
 *
 * @author micae
 */
public class ProjetoDeal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClienteDb cdb = new ClienteDb();
        
        if(cdb.connect()){
            System.out.println("Conexão ok");
        }else{
            System.out.println("algo de errado n esta certo");
        }
        
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        
        cadastroUsuario.setVisible(true);

       
       
        ClienteController clienteController = new ClienteController(cadastroUsuario, cdb);
       
    }
    
}
