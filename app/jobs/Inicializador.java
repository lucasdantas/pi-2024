package jobs;

import models.Departamento;
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
			d3.nome = "Almoxerifado";
			d3.ramal = 300;
			d3.save();
		}
	}

}
