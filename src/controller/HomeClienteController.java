/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.CadastroServico;
import views.CadastroUsuario;
import views.ListaServicos;
import controller.ClienteController;
import controller.ServicoController;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Servico;
import model.ServicoDB;

/**
 *
 * @author micae
 */

public class HomeClienteController implements ActionListener{
    public ServicoController servicoController;
    public ClienteController clienteController;
    
    public HomeClienteController(ClienteController clienteController, ServicoController servicoController, ListaServicos listaServicos) {
        this.clienteController = clienteController;
        this.servicoController = servicoController;
        this.servicoController.cadastroServico.btnCadastro.addActionListener(this);
        this.clienteController.cadastroUsuario.btnCadastrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.clienteController.cadastroUsuario.btnCadastrar){
            Cliente cliente = new Cliente();
            cliente.setNome(this.clienteController.cadastroUsuario.txtNome.getText());
            cliente.setCpf(this.clienteController.cadastroUsuario.txtCpf.getText());
            cliente.setIdade(Integer.parseInt(this.clienteController.cadastroUsuario.txtIdade.getText()));
            cliente.setEndereco(this.clienteController.cadastroUsuario.txtEndereco.getText());///////////////////////////////
            cliente.setTelefone(this.clienteController.cadastroUsuario.txtTelefone.getText());
            if(this.clienteController.clienteDb.insertCliente(cliente)){
                JOptionPane.showMessageDialog(null, "Sucesso ao inserir o cliente ao banco");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao inserir ao banco de dados");
            }
            JOptionPane.showMessageDialog(null, "Cadastro Concluido, seja bem vindo "+ cliente.getNome());
            this.clienteController.cadastroUsuario.setVisible(false);
            this.servicoController.cadastroServico.setVisible(true);
        }
        if(e.getSource() == this.servicoController.cadastroServico.btnCadastro){
            Servico servico = new Servico();
            servico.setNome(this.servicoController.cadastroServico.nome.getText());
            servico.setCategoria(this.servicoController.cadastroServico.categoria.getSelectedItem().toString()); ///////////////////////////////
            servico.setDescricao(this.servicoController.cadastroServico.descricao.getText());
            System.out.println(servico.getStatus());
            this.servicoController.servicoDB.insertServico(servico);
            this.servicoController.listaServicos.setVisible(true);
            this.servicoController.cadastroServico.setVisible(false);
//            if(this.servicoController.servicoDB.insertServico(servico)){
//               JOptionPane.showMessageDialog(null, "Sucesso ao inserir o café!");
//               this.servicoController.fillTable(this.servicoController.listaServicos.tabelaServico);
//               
//            }else{
//               JOptionPane.showMessageDialog(null, "Erro ao inserir os dados", "", JOptionPane.ERROR_MESSAGE);
//            }
        }
        
    }
    
}

