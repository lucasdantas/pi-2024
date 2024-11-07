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
	
	public Long getIdade() {
		Date d1 = this.dataNascimento;
		Date d2 = new Date();
		
		long differenceInTime = d2.getTime() - d1.getTime();
		this.idade = (differenceInTime / (1000l * 60 * 60 * 24 * 365));
		
		return this.idade;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}

