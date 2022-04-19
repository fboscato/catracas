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
public class CatracaParametros {
    
    private Integer id;
    private Integer catraca_id;
    private Integer parametro_catraca_id;
    
    
    public CatracaParametros() {
        super();
    }
    
    public CatracaParametros(Integer id,Integer catraca_id, Integer parametro_catraca_id) {
	super();
        this.id = id;
	this.catraca_id = catraca_id;
	this.parametro_catraca_id = parametro_catraca_id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
    
    public Integer getCatracaId() {
        return catraca_id;
    }

    public void setCatracaId(Integer catraca_id) {
	this.catraca_id = catraca_id;
    }
    
    public Integer getParametroCatracaId() {
        return parametro_catraca_id;
    }

    public void setParametroCatracaId(Integer parametro_catraca_id) {
	this.parametro_catraca_id = parametro_catraca_id;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof CatracaParametros)) {
            return false;
	}
	CatracaParametros bean = (CatracaParametros) obj;
        if (getId() != null && getCatracaId() != null && getParametroCatracaId() != null) {
            return this.getId().equals(bean.getId()) && this.getCatracaId().equals(bean.getCatracaId()) &&
                    this.getParametroCatracaId().equals(bean.getParametroCatracaId());
	}
            return super.equals(obj);
    }
    
}