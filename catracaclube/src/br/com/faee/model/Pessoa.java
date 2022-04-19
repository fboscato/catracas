/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faee.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.joda.time.LocalDateTime;

/**
 *
 * @author mauricio
 */
public class Pessoa {

    private Integer id;
    private String nome;
    private BigDecimal barcode;
    private BigDecimal rfid;
    private Integer biometria;
    private String cpf;
    private LocalDateTime ultimo_acesso;

    public Pessoa() {
        super();
    }

    public Pessoa(Integer id, String nome, BigDecimal barcode, BigDecimal rfid, Integer biometria, String cpf, LocalDateTime ultimo_acesso) {
        super();
        this.id = id;
        this.nome = nome;
        this.barcode = barcode;
        this.rfid = rfid;
        this.biometria = biometria;
        this.cpf = cpf;
        this.ultimo_acesso = ultimo_acesso;
    }

    public Pessoa(Integer id, String nome, BigDecimal barcode, BigDecimal rfid, Integer biometria, String cpf) {
        super();
        this.id = id;
        this.nome = nome;
        this.barcode = barcode;
        this.rfid = rfid;
        this.biometria = biometria;
        this.cpf = cpf;
    }

    public Pessoa(Integer id, String nome, BigDecimal barcode, BigDecimal rfid) {
        super();
        this.id = id;
        this.nome = nome;
        this.barcode = barcode;
        this.rfid = rfid;
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

    public BigDecimal getBarcode() {
        if (barcode == null) {
            return BigDecimal.ZERO;
        } else {
            return barcode;
        }
    }

    public void setBarcode(BigDecimal barcode) {
        this.barcode = barcode;
    }

    public BigDecimal getRfid() {
        if (rfid == null) {
            return BigDecimal.ZERO;
        } else {
            return rfid;
        }
    }

    public void setRfid(BigDecimal rfid) {
        this.rfid = rfid;
    }

    public Integer getBiometria() {
        if (biometria == null) {
            return 0;
        } else {
            return biometria;
        }
    }

    public void setBiometria(Integer biometria) {
        this.biometria = biometria;
    }

    public String getCpf() {
        if (cpf == null) {
            return "";
        } else {
            return cpf;
        }
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getUltimoAcesso() {
        if (ultimo_acesso == null) {
            return null;
        } else {
            return ultimo_acesso;
        }
    }

    public void setUltimoAcesso(LocalDateTime ultimo_acesso) {
        this.ultimo_acesso = ultimo_acesso;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pessoa)) {
            return false;
        }
        Pessoa bean = (Pessoa) obj;
        if (getId() != null && getNome() != null && getBarcode() != null && getRfid() != null) {
            return this.getId().equals(bean.getId()) && this.getNome().equals(bean.getNome())
                    && this.getBarcode().equals(bean.getBarcode())
                    && this.getRfid().equals(bean.getRfid()) && this.getBiometria().equals(bean.getBiometria());
        }
        return super.equals(obj);
    }

}
