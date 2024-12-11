package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import play.db.jpa.Model;

@Entity
public class Pessoa extends Model {

	public String nome;
	public String email;
	
	public String login;
	public String senha;

	@Enumerated(EnumType.STRING)
	public Status status;
	
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;

	@Transient
	public Long idade;

	@ManyToOne
	public Departamento departamento;
	
	public Pessoa() {
		this.status = Status.ATIVO;
	}
	
	public static String autenticar(String login, String senha) {
		Pessoa p = Pessoa.find("login = ?1 and senha = ?2", login, senha).first();
		if (p == null) {
			return null;
		} else {
			return p.login;
		}
	}
	
	public Long getIdade() {
		Date d1 = this.dataNascimento;
		Date d2 = new Date();
		
		if (d1 == null) {
			return 0l;
		}
		
		long differenceInTime = d2.getTime() - d1.getTime();
		this.idade = (differenceInTime / (1000l * 60 * 60 * 24 * 365));
		
		return this.idade;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}

