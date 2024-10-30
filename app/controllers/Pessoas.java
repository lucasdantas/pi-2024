package controllers;

import java.util.List;

import models.Departamento;
import models.Pessoa;
import models.Status;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void form() {
		List<Departamento> departamentos = Departamento.findAll();
		render(departamentos);
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
		p.status = Status.INATIVO;
		p.save();
		flash.success("Removido com sucesso!");
		listar(null);
	}
	
	public static void listar(String termo) {
		List<Pessoa> pessoas = null;
		if (termo == null) {
			pessoas = Pessoa.find("status = ?1", Status.ATIVO).fetch();
		} else {
			pessoas = Pessoa.find("(lower(nome) like ?1 or email like ?1) AND status = ?2",
					"%" + termo.toLowerCase() + "%", Status.ATIVO).fetch();
		}
		render(pessoas, termo);
	}
	
	public static void editar(Long id) {
		Pessoa p = Pessoa.findById(id);
		List<Departamento> departamentos = Departamento.findAll();
		renderTemplate("Pessoas/form.html", p, departamentos);
	}

	
	
}
