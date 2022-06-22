/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ClienteDb;
import views.CadastroUsuario;
import views.ListaServicos;
import views.HomeCliente;

/**
 *
 * @author micae
 */
public class ClienteController implements ActionListener{
    public CadastroUsuario cadastroUsuario;
    public ClienteDb clienteDb;
    public HomeCliente homeCliente;
    
    public ClienteController(CadastroUsuario cadastroUsuario, ClienteDb clienteDb, HomeCliente homeCliente){
        this.cadastroUsuario = cadastroUsuario;
        this.clienteDb = clienteDb;
        this.homeCliente = homeCliente;
        this.cadastroUsuario.btnCadastrar.addActionListener(this);
        this.homeCliente.btnAddServico.addActionListener(this);
        this.homeCliente.btnShowList.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.cadastroUsuario.btnCadastrar){
            Cliente cliente = new Cliente();
            cliente.setNome(this.cadastroUsuario.txtNome.getText());
            cliente.setCpf(this.cadastroUsuario.txtCpf.getText());
            cliente.setEndereco(this.cadastroUsuario.txtEndereco.getText());
            cliente.setTelefone(this.cadastroUsuario.txtTelefone.getText());
            cliente.setIdade(Integer.parseInt(this.cadastroUsuario.txtIdade.getText()));
            JOptionPane.showMessageDialog(null, "Seja Bem vindo(a) " + cliente.getNome());
            if(this.clienteDb.insertCliente(cliente)){
                JOptionPane.showMessageDialog(null, "Sucesso ao inserir o cliente ao banco");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao inserir ao banco de dados");
            }
        
        }
    }
      
    
}
