package br.edu.ufcg.computacao.si1.model.usuario;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Permissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public abstract TiposPermissao getTipoPermissao();
	
	public abstract List<PermissoesUsuario> getPermissoes();
}
