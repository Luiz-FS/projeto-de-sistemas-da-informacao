package br.edu.ufcg.computacao.si1.excecoes;

public class AcaoNaoPermitidaException extends AdExtremeException {

	public AcaoNaoPermitidaException() {
		super("Usuario nao tem permissao, para executar essa acao!");
	}
}
