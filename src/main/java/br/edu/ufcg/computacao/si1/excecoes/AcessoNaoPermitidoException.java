package br.edu.ufcg.computacao.si1.excecoes;

public class AcessoNaoPermitidoException extends AdExtremeException {

	public AcessoNaoPermitidoException() {
		super("Usuario nao tem permissao, para executar essa acao!");
	}
}
