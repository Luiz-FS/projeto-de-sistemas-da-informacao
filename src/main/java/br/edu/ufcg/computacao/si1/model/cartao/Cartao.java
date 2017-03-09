package br.edu.ufcg.computacao.si1.model.cartao;

import br.edu.ufcg.computacao.si1.util.Validador;

/**
 * @author Lucas Vieira
 */

public class Cartao {

    private Long idUsuario;

    private double valorDebito;
    private double valorSaque;
    private double saldoTotal;

    public Cartao(Long idUsuario) {
        this.idUsuario = idUsuario;

        this.valorDebito = 0;
        this.valorSaque = 0;
        this.saldoTotal = 0;
    }

    public void debitar(double valor) {
        if (! Validador.isValorNegativo(valor)) {
            this.valorDebito += valor;

            atualizarSaldoTotal();
        }
    }

    public void sacar(double valor) {
        if (! Validador.isValorNegativo(valor)) {
            this.valorSaque += valor;

            atualizarSaldoTotal();
        }
    }

    private void atualizarSaldoTotal() {
        this.saldoTotal = valorDebito - valorSaque;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public double getValorDebito() {
        return valorDebito;
    }

    public double getValorSaque() {
        return valorSaque;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Cartao cartao = (Cartao) object;

        return idUsuario != null ? idUsuario.equals(cartao.idUsuario) : cartao.idUsuario == null;

    }

    @Override
    public int hashCode() {
        return idUsuario != null ? idUsuario.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "idUsuario=" + idUsuario +
                ", valorDebito=" + valorDebito +
                ", valorSaque=" + valorSaque +
                ", saldoTotal=" + saldoTotal +
                '}';
    }


}

