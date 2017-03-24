package br.edu.ufcg.computacao.si1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.computacao.si1.excecoes.AcaoNaoPermitidaException;
import br.edu.ufcg.computacao.si1.excecoes.AnuncioInexistenteException;
import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.anuncio.Anuncio;
import br.edu.ufcg.computacao.si1.model.anuncio.AnuncioServico;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;

@Service
public class ServiceAnuncio {

	@Autowired
	private AnuncioRepository repositorioAnuncio;


	public Anuncio salvarAnuncio(Anuncio anuncio) {
		return this.repositorioAnuncio.save(anuncio);
	}
	
	public Double getValorAnuncioPorId(Long idAnuncio) {
		return this.repositorioAnuncio.findOne(idAnuncio).getValor();
	}
	
	public Long getIdDonoAnuncio(Long idAnuncio) {
		return this.repositorioAnuncio.findOne(idAnuncio).getIdUsuario();
	}

	public List<Anuncio> getAnunciosPorUsuario(Long idUsuario) {
		return this.repositorioAnuncio.findByIdUsuario(idUsuario);
	}
	
	public List<Anuncio> getAnuncios() {
		return this.repositorioAnuncio.findAll();
	}

	public void deletarAnuncio(Anuncio anuncio) {
		this.repositorioAnuncio.delete(anuncio);
	}
	
	public void deletarAnuncioPorId(Long idAnuncio) {
		this.repositorioAnuncio.delete(idAnuncio);
	}
	
	public void idAnuncioExiste(Long idAnuncio) throws AnuncioInexistenteException {
		if(!this.repositorioAnuncio.exists(idAnuncio)) {
			throw new AnuncioInexistenteException();
		}
	}
	
	public void addDataAgendamento(Long idAnuncio, Date dataDeAgendamento) {
		AnuncioServico anuncioServico = (AnuncioServico)this.repositorioAnuncio.getOne(idAnuncio);
		
		anuncioServico.setDataDeAgendamento(dataDeAgendamento);
		
		this.salvarAnuncio(anuncioServico);
	}
	
	public String gerarMensagemNotificacaoContratacao(Long idAnuncio) {
		return this.repositorioAnuncio.getOne(idAnuncio).gerarMensagemNotificacaoContratacao();
	}
	
	public Avaliacao addAvaliacao(Long idAnuncio, Long idUsuario, Avaliacao avaliacao) throws AcaoNaoPermitidaException {
		Anuncio anuncio = this.repositorioAnuncio.findOne(idAnuncio);
		
		if(anuncio.getIdUsuario() != idUsuario) {
			anuncio.addAvaliacao(avaliacao);
			
			return this.salvarAnuncio(anuncio).getAvaliacao(avaliacao);
		} else {
			throw new AcaoNaoPermitidaException();
		}
	}
	
	public List<Avaliacao> getAvaliacoesAnuncio(Long idAnuncio) {
		return this.repositorioAnuncio.findOne(idAnuncio).getAvaliacoes();
	}
}
