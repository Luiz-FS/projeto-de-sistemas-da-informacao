package br.edu.ufcg.computacao.si1.model.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Lucas Vieira
 */

@Entity
public class SaldoDeUsuario {

    @Column(name = "debito")
    private double debito;

    @Column(name = "credito")
    private double credito;

    public SaldoDeUsuario() {
        this.debito = 0;
        this.credito = 0;
    }

    public void debitar(double valor) {
        this.debito += valor;
    }

    public void creditar(double valor) {
        this.credito += valor;
    }

    public double obterSaldoTotal() {
        return (this.credito - this.debito);
    }

    public double getDebito() {
        return this.debito;
    }

    public double getCredito() {
        return this.credito;
    }

    @Override
    public String toString() {
        return "SaldoDeUsuario{" +
                ", debito=" + debito +
                ", credito=" + credito +
                '}';
    }
}
