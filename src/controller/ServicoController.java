/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Servico;
import model.ServicoDB;
import views.CadastroServico;
import views.HomeCliente;
import views.ListaServicos;

/**
 *
 * @author francisleide
 */
public class ServicoController implements ActionListener{
    CadastroServico cadastroServico;
    private ServicoDB servicoDB;
    public ListaServicos listaServicos;
    public HomeCliente homeCliente;
    
    public ServicoController(CadastroServico cadastroServico,ListaServicos listaServicos,ServicoDB servicoDB){
        this.servicoDB = servicoDB;
        this.cadastroServico = cadastroServico;
        this.listaServicos = listaServicos;
        this.cadastroServico.btnCadastro.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.cadastroServico.btnCadastro){
            Servico servico = new Servico();
            servico.setNome(this.cadastroServico.nome.getText());
            servico.setCategoria(this.cadastroServico.categoria.getSelectedItem().toString()); ///////////////////////////////
            servico.setDescricao(this.cadastroServico.descricao.getText());
            System.out.println(servico.getStatus());
            servicoDB.connect();
           if(this.servicoDB.insertServico(servico)){
               JOptionPane.showMessageDialog(null, "Sucesso ao inserir o servico!");
               servicoDB.connect();
               fillTable(this.listaServicos.tabelaServico);
           }else{
               JOptionPane.showMessageDialog(null, "Erro ao inserir os dados", "", JOptionPane.ERROR_MESSAGE);
           }
           
        } 
   }
    public void fillTable(JTable table){
        //criar essa defaultTable para a gente conseguir manipular os dados que vão estar nela
        DefaultTableModel defaultTable = new DefaultTableModel();
        //apontar nossa tabela que estar na tela para a que a gente está montando localmente
        table.setModel(defaultTable);
        //adicionar as colunas com os nomes que a gente quer que seja exibido
        defaultTable.addColumn("Nome");
        defaultTable.addColumn("Categoria");
        defaultTable.addColumn("Descrição");
        defaultTable.addColumn("Status");
        // criar as colunas de cada linha
        Object [] colunas  = new Object[4];
        ArrayList<Servico> servicos = this.servicoDB.listServico();
        for (Servico servico : servicos) {
            colunas[0] = servico.getNome();
            colunas[1] = servico.getCategoria();
            colunas[2] = servico.getDescricao();
            colunas[3] = servico.getStatus();
            defaultTable.addRow(colunas);
        }
    }
    
}
