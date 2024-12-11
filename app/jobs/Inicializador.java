package jobs;

import models.Departamento;
import models.Pessoa;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		if (Departamento.count() == 0) {
			Departamento d1 = new Departamento();
			d1.nome = "Gestão de Pessoas";
			d1.ramal = 100;
			d1.save();
			
			Departamento d2 = new Departamento();
			d2.nome = "Financeiro";
			d2.ramal = 200;
			d2.save();
			
			Departamento d3 = new Departamento();
			d3.nome = "Almoxarifado";
			d3.ramal = 300;
			d3.save();
			
			Pessoa p1 = new Pessoa();
			p1.nome = "Maria Joaquina";
			p1.departamento = d2;
			p1.login = "maria";
			p1.senha = "1234";
			p1.save();
			
			Pessoa p2 = new Pessoa();
			p2.nome = "Cirilo";
			p2.login = "cirilo";
			p2.senha = "1234";
			p2.departamento = d1;
			p2.save();
		}
	}

}
