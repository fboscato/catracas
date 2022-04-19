/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mauricio
 */
public class Catraca {

    private Integer id;
    private String nome;
    private String ip;
    private String statusConexao;
    private List<ParametroCatraca> parametros;
    private Integer tempo_bloqueio;

    public Catraca() {
        super();
    }

    public Catraca(Integer id, String nome, String ip, String statusConexao, Integer tempo_bloqueio) {
        super();
        this.id = id;
        this.nome = nome;
        this.ip = ip;
        this.statusConexao = statusConexao;
        this.tempo_bloqueio = tempo_bloqueio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatusConexao() {
        return statusConexao;
    }

    public void setStatusConexao(String statusConexao) {
        this.statusConexao = statusConexao;
    }

    public Integer getTempoBloqueio() {
        if (tempo_bloqueio == null) {
            return 1;
        } else {
            return tempo_bloqueio;
        }
    }

    public void setTempoBloqueio(Integer tempo_bloqueio) {
        this.tempo_bloqueio = tempo_bloqueio;
    }

    public List<ParametroCatraca> getParametros() {
        if (parametros == null) {
            parametros = new ArrayList<>();
        }
        return parametros;
    }

    public void setParametros(List<ParametroCatraca> parametros) {
        this.parametros = parametros;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Catraca)) {
            return false;
        }
        Catraca bean = (Catraca) obj;
        if (getId() != null && getIp() != null && getNome() != null) {
            return this.getId().equals(bean.getId()) && this.getIp().equals(bean.getIp())
                    && this.getNome().equals(bean.getNome());
        }
        return super.equals(obj);
    }

}
