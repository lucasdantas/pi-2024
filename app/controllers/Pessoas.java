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
		String mensagem = "Cadastrado com sucesso!";
		if (pessoa.id != null) {
			mensagem = "Editado com sucesso!";
		}
		pessoa.nome = pessoa.nome.toUpperCase();
		pessoa.email = pessoa.email.toLowerCase();
		pessoa.save();
		flash.success(mensagem);
		listar(null);
	}
	
	public static void remover(Long id) {
		Pessoa p = Pessoa.findById(id);
		p.delete();
		flash.success("Removido com sucesso!");
		listar(null);
	}
	
	public static void listar(String termo) {
		List<Pessoa> pessoas = null;
		if (termo == null) {
			pessoas = Pessoa.findAll();
		} else {
			pessoas = Pessoa.find("lower(nome) like ?1 or email like ?1",
					"%" + termo.toLowerCase() + "%").fetch();
		}
		render(pessoas, termo);
	}
	
	public static void editar(Long id) {
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p);
	}

	
	
}
