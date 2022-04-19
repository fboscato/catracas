/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.model;

/**
 *
 * @author mauri
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class ParametroCatraca {
    
    private Integer id;
    private String descricao;
    private Integer dias;
    
    public ParametroCatraca() {
        super();
    }
    
    public ParametroCatraca(Integer id,String descricao, Integer dias) {
	super();
        this.id = id;
	this.descricao = descricao;
        this.dias = dias;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }
    
    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
	this.dias = dias;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof ParametroCatraca)) {
            return false;
	}
	ParametroCatraca bean = (ParametroCatraca) obj;
        if (getId() != null) {
            return this.getId().equals(bean.getId());
	}
        return super.equals(obj);
    }
    
    
}