/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Cliente;
import model.ClienteDb;
import views.CadastroUsuario;

/**
 *
 * @author micae
 */
public class ClienteController {
    private CadastroUsuario cadastroUsuario;
    private ClienteDb clienteDb;
    
    public ClienteController(CadastroUsuario cadastrousuario, ClienteDb clienteDb){
        this.cadastroUsuario = cadastrousuario;
        this.clienteDb = clienteDb;
        this.cadastroUsuario.btnCadastrarUsuario.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
