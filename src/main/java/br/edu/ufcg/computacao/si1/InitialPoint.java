package br.edu.ufcg.computacao.si1;

import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.Notificacao;
import br.edu.ufcg.computacao.si1.model.TipoNotificacao;
import br.edu.ufcg.computacao.si1.model.anuncio.*;
import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.AnuncioRepository;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class InitialPoint {

	public static void main(String[] args) {
		SpringApplication.run(InitialPoint.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(UsuarioRepository repository, AnuncioRepository anuncioRepository){
		return (args) -> {
			repository.deleteAll();
			anuncioRepository.deleteAll();

			Permissao permissaoPessoaFisica = new PermissaoPessoaFisica();
			Usuario usuarioDavi = new Usuario("Davi", "davi@seila.com", "seila", permissaoPessoaFisica);

			Permissao permissaoPessoaJuridica = new PermissaoPessoaJuridica();
			Usuario usuarioLucas = new Usuario("Lucas", "lucas@massa.com", "massa", permissaoPessoaJuridica);

			repository.save(usuarioDavi);

			usuarioLucas.getListaDeAvaliacoes().add(new Avaliacao(ConceitoAnuncio.NOTA_CINCO, "massa"));
			usuarioLucas.getListaDeNotificacoes().add(new Notificacao("Hora do Show", usuarioDavi.getId(), TipoNotificacao.COMPRA));

			repository.save(usuarioLucas);


			Anuncio anuncioEmprego = new AnuncioEmprego("titulo padrao", new Date(), usuarioDavi.getId(), "Programador");

			Anuncio anuncioProduto = new AnuncioProduto("titulo padrao", new Date(), 30, CategoriaAnuncio.IMOVEL, usuarioDavi.getId(),"DVDS && CDS");

			Anuncio anuncioServico = new AnuncioServico("titulo padrao", new Date(), 49, usuarioDavi.getId() , "Programador");

			((AnuncioServico) anuncioServico).setDataDeAgendamento( new Date());

			anuncioRepository.save(anuncioEmprego);
			anuncioRepository.save(anuncioServico);
			anuncioRepository.save(anuncioProduto);

			anuncioEmprego.getAvaliacoes().add( new Avaliacao(ConceitoAnuncio.NOTA_CINCO, "EMPREGO MUITO BOM"));

			anuncioRepository.save(anuncioEmprego);

		};
	}
}
