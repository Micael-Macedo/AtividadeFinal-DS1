/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodeal;


import controller.ClienteController;
import controller.HomeClienteController;
import controller.ServicoController;
import java.awt.event.ActionListener;
import model.ClienteDb;
import model.ServicoDB;
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
        ServicoDB sdb = new ServicoDB();
        ClienteDb cdb = new ClienteDb();
        
        CadastroUsuario cadastroUsuario = new CadastroUsuario();
        CadastroServico cadastroServico = new CadastroServico();
        ListaServicos listaServicos = new ListaServicos();
        
        ClienteController clienteController = new ClienteController(cadastroUsuario, cdb);
        ServicoController servicoController = new ServicoController(cadastroServico, listaServicos, sdb);
        HomeClienteController homeClienteController = new HomeClienteController(clienteController, servicoController, listaServicos);
        homeClienteController.clienteController.cadastroUsuario.setVisible(true);
    }
    
}
