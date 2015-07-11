package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import play.data.*;

import models.*;

public class Home extends Controller {

	private boolean negado;

	public Home(){
		negado = true;
	}

    public Result login(){
        session().clear();
    	Form<Login> formulario = new Form(Login.class);

    	return ok(login.render(formulario, negado));
    }

    public Result verificarUser(){
    	Form<Login> formulario = new Form(Login.class).bindFromRequest();
    	boolean login;

    	if(formulario.get().getTipo() == 1){
    		login = TutorController.loginTutor(formulario.get().getUser_name(), formulario.get().getPassword());
    		if(login){
    			return redirect(routes.TutorController.menu());
    		}
    	}
    	else if(formulario.get().getTipo() == 2){
    		login = AdminController.loginAdministrador(formulario.get().getUser_name(), formulario.get().getPassword());
    		if(login){
    			return redirect(routes.AdminController.menu());
    		}
    	}
    	negado = false;
    	return redirect(routes.Home.login());
    }

    public void setNegado(boolean negado){
    	this.negado = negado;
    }

    public boolean getNegado(){
    	return this.negado;
    }
}
