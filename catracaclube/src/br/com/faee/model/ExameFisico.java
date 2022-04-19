/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.model;

import org.joda.time.LocalDate;




/**
 *
 * @author mauricio
 */
public class ExameFisico {
    
    private Integer id;
    private Integer pessoa_id;
    private LocalDate data_validade;
    
    
    public ExameFisico() {
        super();
    }
    
    public ExameFisico(Integer id,Integer pessoa_id, LocalDate data_validade) {
	super();
        this.id = id;
	this.pessoa_id = pessoa_id;
	this.data_validade = data_validade;
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
    
    public LocalDate getDataValidade() {
        return data_validade;
    }

    public void setDataValidade(LocalDate data_validade) {
	this.data_validade = data_validade;
    }
    
    public boolean equals(Object obj) {
        if (!(obj instanceof ExameFisico)) {
            return false;
	}
	ExameFisico bean = (ExameFisico) obj;
        if (getId() != null && getPessoaId()!= null && getDataValidade()!= null) {
            return this.getId().equals(bean.getId()) && this.getPessoaId().equals(bean.getPessoaId()) &&
                    this.getDataValidade().equals(bean.getDataValidade());
	}
            return super.equals(obj);
    }
}
