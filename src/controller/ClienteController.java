/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.Cliente;
import model.ClienteDb;
import views.CadastroUsuario;

/**
 *
 * @author micae
 */
public class ClienteController implements ActionListener{
    private CadastroUsuario cadastroUsuario;
    private ClienteDb clienteDb;
    
    public ClienteController(CadastroUsuario cadastroUsuario, ClienteDb clienteDb){
        this.cadastroUsuario = cadastroUsuario;
        this.clienteDb = clienteDb;
        this.cadastroUsuario.btnCadastrar.addActionListener(this);
        
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
            
            if(this.clienteDb.insertCliente(cliente)){
                JOptionPane.showMessageDialog(null, "Sucesso ao inserir o cliente ao banco");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao inserir ao banco de dados");
            }
        
        }
    }
      
    
}
