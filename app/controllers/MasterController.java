package controllers;

import play.*;
import play.mvc.*;
import play.data.*;


import views.html.master.*;

import models.*;

public class MasterController extends Controller {

    public Result registrarTutor(){
    	return ok(registrarTutor.render());
    }


    public Result createFormAdmin(){
    Form<Administrador> formulario = Form.form(Administrador.class);
    	return ok(registrarAdmin.render(formulario));
    }

    public Result saveFormAdmin(){
    	Form<Administrador> formulario = Form.form(Administrador.class).bindFromRequest();
    	formulario.get().save();
    	return redirect("/master/registrarAdmin");
    }
}