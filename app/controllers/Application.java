package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

//import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }

    public static void ola(String genero, String nome, Integer peso) {
    	peso++;
    	System.out.println(peso);
    	nome = nome.toUpperCase();
    	String msgBoasVindas = "Bem vindo.";
    	if ("F".equals(genero)) {
    		msgBoasVindas = "Bem vinda.";
    	}
    	
        renderText(nome, msgBoasVindas);
    }
    
    
    

}