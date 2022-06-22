/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import controller.ClienteController;
import controller.ServicoController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Cliente;
import model.ServicoDB;
import views.HomeCliente;
import views.CadastroServico;
import views.CadastroUsuario;
import views.ListaServicos;

/**
 *
 * @author micae
 */
public class HomeClienteController implements ActionListener{

    public ClienteController clienteController;
    public ServicoController servicoController;
    
    public HomeClienteController(ClienteController clienteController, ServicoController servicoController) {
        this.clienteController = clienteController;
        this.servicoController = servicoController;
        this.clienteController.cadastroUsuario.btnCadastrar.addActionListener(this);
        this.clienteController.homeCliente.btnAddServico.addActionListener(this);
        this.clienteController.homeCliente.btnShowList.addActionListener(this);
        
        this.servicoController.cadastroServico.btnCadastro.addActionListener(this);
        this.servicoController.listaServicos.btnReturnHome.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == this.clienteController.cadastroUsuario.btnCadastrar){
            this.clienteController.cadastroUsuario.dispose();
            this.servicoController.cadastroServico.setVisible(true);
        }
        if(e.getSource() == this.servicoController.cadastroServico.btnCadastro){
            this.servicoController.cadastroServico.dispose();
            this.clienteController.homeCliente.setVisible(true);
        }
        if(e.getSource() == this.clienteController.homeCliente.btnAddServico){
            this.clienteController.homeCliente.dispose();
            this.servicoController.cadastroServico.setVisible(true);
        }
        if(e.getSource() == this.clienteController.homeCliente.btnShowList){
            this.clienteController.homeCliente.dispose();
            this.servicoController.listaServicos.setVisible(true);
        }
        if(e.getSource() == this.servicoController.listaServicos.btnReturnHome){
            this.servicoController.listaServicos.dispose();
            this.clienteController.homeCliente.setVisible(true);
        }
    }
}
    

