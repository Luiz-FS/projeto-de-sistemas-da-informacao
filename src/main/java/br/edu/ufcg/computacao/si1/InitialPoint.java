package br.edu.ufcg.computacao.si1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.ufcg.computacao.si1.model.usuario.Permissao;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaFisica;
import br.edu.ufcg.computacao.si1.model.usuario.PermissaoPessoaJuridica;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;

@SpringBootApplication
public class InitialPoint {

	public static void main(String[] args) {
		SpringApplication.run(InitialPoint.class, args);
	}
	
	@Bean
	public CommandLineRunner initializeDb(UsuarioRepository repository){
	   return (args) -> {
	       repository.deleteAll();
		   
		   Permissao permissao = new PermissaoPessoaFisica();
		   Usuario usuario = new Usuario("Davi", "davi@seila.com", "seila",permissao);
		   
		   Permissao permissao2 = new PermissaoPessoaJuridica();
		   Usuario usuario2 = new Usuario("DaviExecutivo", "daviLaerte@massa.com", "massa", permissao2);
		   
		   repository.save(usuario);
		   repository.save(usuario2);
	   };
	}
}
