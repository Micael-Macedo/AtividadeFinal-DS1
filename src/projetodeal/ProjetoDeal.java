/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodeal;


import controller.ClienteController;
import controller.ServicoController;
import controller.HomeClienteController;
import java.awt.event.ActionListener;
import model.ClienteDb;
import model.ServicoDB;
import views.HomeCliente;
import views.CadastroServico;
import views.CadastroUsuario;
import views.ListaServicos;
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
        ServicoDB sdb = new ServicoDB();
        if(cdb.connect()){
            System.out.println("Conexão ok");
        }else{
            System.out.println("algo de errado n esta certo");
        }
        HomeCliente homeCliente = new  HomeCliente();
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        CadastroServico cadastroServico = new CadastroServico();
        ListaServicos listaServicos = new ListaServicos();
        
        
        ClienteController clienteController = new ClienteController(cadastroUsuario, cdb, homeCliente);
        ServicoController servicoController = new ServicoController(cadastroServico,listaServicos, sdb);
        HomeClienteController homeClienteController = new HomeClienteController(clienteController, servicoController);
        homeClienteController.clienteController.cadastroUsuario.setVisible(true);
    }
    
}
