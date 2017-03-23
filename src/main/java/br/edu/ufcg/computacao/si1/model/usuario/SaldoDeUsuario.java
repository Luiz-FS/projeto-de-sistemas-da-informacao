package br.edu.ufcg.computacao.si1.model.usuario;

import javax.persistence.*;

/**
 * @author Lucas Vieira
 */

@Entity
public class SaldoDeUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "debito")
    private double debito;

    @Column(name = "credito")
    private double credito;

    public SaldoDeUsuario() {
        this.debito = 0;
        this.credito = 0;
    }

    public void debitar(double valor) {
        this.debito -= valor;
    }

    public void creditar(double valor) {
        this.credito += valor;
    }

    public double obterSaldoTotal() {
        return (this.credito - this.debito);
    }

    public Long getId() {
        return id;
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
                "id=" + id +
                ", debito=" + debito +
                ", credito=" + credito +
                '}';
    }
}
