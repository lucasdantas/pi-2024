package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Departamento;
import models.Pessoa;
import models.Projeto;
import models.Status;
import play.mvc.Controller;

public class Projetos extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void salvar(Projeto projeto) {
		String mensagem = "Cadastrado com sucesso!";
		projeto.save();
		flash.success(mensagem);
		listar();
	}
	
	public static void listar() {
		List<Projeto> projetos = Projeto.findAll(); 
		render(projetos);
	}
	
	public static void formMembro(Long id) {
		Projeto projeto = Projeto.findById(id);
		List<Pessoa> pessoas = Pessoa.findAll();
		render(projeto, pessoas);
	}
	
	public static void adicionar(Long idProjeto, Long idPessoa) {
		Projeto projeto = Projeto.findById(idProjeto);
		Pessoa pessoa = Pessoa.findById(idPessoa);
		
		if (projeto.membros == null) {
			projeto.membros = new ArrayList<>();
		}
		projeto.membros.add(pessoa);
		projeto.save();
		formMembro(idProjeto);
	}
	
}
