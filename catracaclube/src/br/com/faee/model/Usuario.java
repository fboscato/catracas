/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.model;

/**
 *
 * @author mauricio
 */
public class Usuario {
    
    private Integer id;
    private Integer pessoa_id;
    private String tipo_usuario;
    
    public Usuario() {
        super();
    }
    
    public Usuario(Integer id,Integer pessoa_id, String tipo_usuario) {
	super();
        this.id = id;
	this.pessoa_id = pessoa_id;
	this.tipo_usuario = tipo_usuario;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
    
    public Integer getPessoaId() {
        return pessoa_id;
    }

    public void setPessoaId(Integer pessoa_id) {
	this.pessoa_id = pessoa_id;
    }
    
    public String getTipoUsuario() {
        return tipo_usuario;
    }

    public void setTipoUsuario(String tipo_usuario) {
	this.tipo_usuario = tipo_usuario;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof Usuario)) {
            return false;
	}
	Usuario bean = (Usuario) obj;
        if (getId() != null && getPessoaId()!= null && getTipoUsuario()!= null) {
            return this.getId().equals(bean.getId()) && this.getPessoaId().equals(bean.getPessoaId()) &&
                    this.getTipoUsuario().equals(bean.getTipoUsuario());
	}
        return super.equals(obj);
    }
}
