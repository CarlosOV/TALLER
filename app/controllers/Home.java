package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import play.data.*;

import models.Login;
public class Home extends Controller {

    public Result login(){
    	Form<Login> formulario = new Form(Login.class);
    	return ok(login.render(formulario));
    }

    public Result verificarUser(){
    	Form<Login> formulario = new Form(Login.class).bindFromRequest();
    	return ok(login.render(formulario));
    }
}
