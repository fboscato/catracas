/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.model;

import java.sql.Date;
import org.joda.time.LocalDate;

/**
 *
 * @author mauricio
 */
public class LancamentoConta {

    private Integer id;
    private Integer pessoa_id;
    private LocalDate data_vencimento;
    private LocalDate data_pagamento;

    public LancamentoConta() {
        super();
    }

    public LancamentoConta(Integer id, Integer pessoa_id, LocalDate data_vencimento, LocalDate data_pagamento) {
        super();
        this.id = id;
        this.pessoa_id = pessoa_id;
        this.data_vencimento = data_vencimento;
        this.data_pagamento = data_pagamento;
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

    public LocalDate getDataVencimento() {
        if (data_vencimento != null) {
            return data_vencimento;
        } else {
            return null;
        }
    }

    public Date getDataVencimentoSQL() {
        return getDataVencimento() != null ? new java.sql.Date(getDataVencimento().toDate().getTime()) : null;
    }

    public void setDataVencimento(LocalDate data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public LocalDate getDataPagamento() {
        if (data_pagamento != null) {
            return data_pagamento;
        } else {
            return null;
        }
    }

    public Date getDataPagamentoSQL() {
        return getDataPagamento() != null ? new java.sql.Date(getDataPagamento().toDate().getTime()) : null;
    }

    public void setDataPagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LancamentoConta)) {
            return false;
        }
        LancamentoConta bean = (LancamentoConta) obj;
        if (getId() != null && getPessoaId() != null && getDataVencimento() != null && getDataPagamento() != null) {
            return this.getId().equals(bean.getId()) && this.getPessoaId().equals(bean.getPessoaId())
                    && this.getDataVencimento().equals(bean.getDataVencimento())
                    && this.getDataPagamento().equals(bean.getDataPagamento());
        }
        return super.equals(obj);
    }

}
