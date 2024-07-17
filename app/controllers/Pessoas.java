package controllers;

import java.util.List;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void detalhar(Pessoa pessoa) {
		render(pessoa);
	}
	
	public static void salvar(Pessoa pessoa) {
		pessoa.nome = pessoa.nome.toUpperCase();
		pessoa.email = pessoa.email.toLowerCase();
		pessoa.save();
		listar();
	}
	
	public static void remover(Long id) {
		Pessoa p = Pessoa.findById(id);
		p.delete();
		listar();
	}
	
	public static void listar() {
		List<Pessoa> pessoas = Pessoa.findAll();
		render(pessoas);
	}

	
	
}
