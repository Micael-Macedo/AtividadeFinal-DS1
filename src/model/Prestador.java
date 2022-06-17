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
public class Prestador extends Usuario{
    private String competencia;
    private Portifolio portifolio;
    private String locaisDeAtuacao;
    private String historico;
    private ArrayList<Servico> servicos;

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public Portifolio getPortifolio() {
        return portifolio;
    }

    public void setPortifolio(Portifolio portifolio) {
        this.portifolio = portifolio;
    }

    public String getLocaisDeAtuacao() {
        return locaisDeAtuacao;
    }

    public void setLocaisDeAtuacao(String locaisDeAtuacao) {
        this.locaisDeAtuacao = locaisDeAtuacao;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }
    
    
}
