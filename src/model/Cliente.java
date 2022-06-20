/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author micae
 */
public class  Cliente extends Usuario{
    private ArrayList<Servico> servicos = new ArrayList<>();

    public ArrayList<Servico> getServicos() {
        return servicos;
    }
    
    public String verificarStatusServico(){
        for(Servico serv : servicos){
            if("pendente".equals(serv.getStatus())){
                return "pendente";
            }
             if("em andamento".equals(serv.getStatus())){
                return "em andamento";
            }
              if("concluido".equals(serv.getStatus())){
                return "concluido";
            }
        }
        return null;
    }
    
    public void removerServico(Servico servico){
	this.servicos.remove(servico);
    }
    
}
