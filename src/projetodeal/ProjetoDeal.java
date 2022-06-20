/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodeal;


import controller.ClienteController;
import java.awt.event.ActionListener;
import model.ClienteDb;
import views.CadastroServico;
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
        CadastroServico cadastroServico = new CadastroServico();
        cadastroUsuario.setVisible(true);
        if(cadastroUsuario.btnCadastrar.isSelected()){
            cadastroUsuario.setVisible(false);
            cadastroServico.setVisible(true);
        }
        
        ClienteController clienteController = new ClienteController(cadastroUsuario, cdb);
    }
    
}
