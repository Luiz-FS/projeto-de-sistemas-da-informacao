package br.edu.ufcg.computacao.si1;

import br.edu.ufcg.computacao.si1.model.Avaliacao;
import br.edu.ufcg.computacao.si1.model.anuncio.ConceitoDoAnuncio;
import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InitialPoint {

	public static void main(String[] args) {
		SpringApplication.run(InitialPoint.class, args);
	}
	
	@Bean
	public CommandLineRunner initializeDb(UsuarioRepository repository){
	   return (args) -> {
	       repository.deleteAll();

		   Permissao permissaoPessoaFisica = new PermissaoPessoaFisica();
		   Usuario usuarioDavi = new Usuario("Davi", "davi@seila.com", "seila", permissaoPessoaFisica);

		   Permissao permissaoPessoaJuridica = new PermissaoPessoaJuridica();
		   Usuario usuarioLucas = new Usuario("Lucas", "lucas@massa.com", "massa", permissaoPessoaJuridica);

//		   Anuncio anuncioEmprego = new AnuncioEmprego("titulo padrao", new Date(), ConceitoDoAnuncio.NOTA_CINCO);
//
//		   Anuncio anuncioProduto = new AnuncioProduto("titulo padrao", new Date(), 30, ConceitoDoAnuncio.NOTA_CINCO, AnuncioProduto.Categoria.IMOVEL);
//
//		   Anuncio anuncioServico = new AnuncioServico("titulo padrao", new Date(), 49, ConceitoDoAnuncio.NOTA_CINCO);
//
//		   ((AnuncioServico) anuncioServico).setDataDeAgendamento( new Date());
//
//		   repository.save(anuncioEmprego);
//		   repository.save(anuncioServico);
//		   repository.save(anuncioProduto);
		   
		   
		   usuarioLucas.getListaDeAvaliacoes().add(new Avaliacao(ConceitoDoAnuncio.NOTA_CINCO, "massa"));
		   
		   repository.save(usuarioDavi);
		   repository.save(usuarioLucas);
	   };
	}
}
