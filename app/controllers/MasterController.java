package controllers;

import play.*;
import play.mvc.*;
import play.data.*;


import views.html.master.*;

import models.*;

public class MasterController extends Controller {

    public Result createFormAdmin(){
        Form<Administrador> formulario = Form.form(Administrador.class);
    	return ok(registrarAdmin.render(formulario));
    }

    public Result saveFormAdmin(){
    	Form<Administrador> formulario = Form.form(Administrador.class).bindFromRequest();
    	formulario.get().save();
    	return redirect("/master/registrarAdmin");
    }

    public Result createFormTutor(){
        Form<Tutor> formulario = Form.form(Tutor.class);
        return ok(registrarTutor.render(formulario));
    }

    public Result saveFormTutor(){
        Form<Tutor> formulario = Form.form(Tutor.class).bindFromRequest();
        formulario.get().save();
        return redirect("/master/registrarTutor");
    }
}