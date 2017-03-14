package br.edu.ufcg.computacao.si1.model.usuario;

import br.edu.ufcg.computacao.si1.util.Validador;

/**
 * @author Lucas Vieira
 */

public class SaldoDeUsuario {

    private Long idUsuario;

    private double debito;
    private double credito;

    public SaldoDeUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;

        this.debito = 0;
        this.credito = 0;
    }

    public void debitar(double valor) {
        if (! Validador.isValorNegativo(valor)) {
            this.debito += valor;
        }
    }

    public void creditar(double valor) {
        if (! Validador.isValorNegativo(valor)) {
            this.credito += valor;
        }
    }

    public double obterSaldoTotal() {
        return debito - credito;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public double getDebito() {
        return debito;
    }

    public double getCredito() {
        return credito;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        SaldoDeUsuario saldoDeUsuario = (SaldoDeUsuario) object;

        return idUsuario != null ? idUsuario.equals(saldoDeUsuario.idUsuario) : saldoDeUsuario.idUsuario == null;

    }

    @Override
    public int hashCode() {
        return idUsuario != null ? idUsuario.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SaldoDeUsuario{" +
                "idUsuario=" + idUsuario +
                ", debito=" + debito +
                ", credito=" + credito +
                '}';
    }


}

