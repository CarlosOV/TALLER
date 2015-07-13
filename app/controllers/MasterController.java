package controllers;

import play.*;
import play.mvc.*;
import play.data.*;


import views.html.master.*;

import models.*;

public class MasterController extends Controller {

    //FORMULARIO PARA ADMINISTRADORES
    public Result createFormAdmin(){
        Form<Administrador> formulario = Form.form(Administrador.class);
    	return ok(registrarAdmin.render(formulario));
    }

    public Result saveFormAdmin(){
    	Form<Administrador> formulario = Form.form(Administrador.class).bindFromRequest();
    	formulario.get().save();
    	return redirect("/master/registrarAdmin");
    }


    //FORMULARIO PARA TUTORES
    public Result createFormTutor(){
        Form<Tutor> formulario = Form.form(Tutor.class);
        Form<Variable> variable = Form.form(Variable.class);

        return ok(registrarTutor.render(formulario, variable));
    }

    public Result saveFormTutor(){
        Form<Tutor> formulario = Form.form(Tutor.class).bindFromRequest();
        Form<Variable> formu = Form.form(Variable.class).bindFromRequest(); 


        formulario.get().setAdmin(AdminController.find.where().eq("id", formu.get().getIdAdmin()).findUnique());

        formulario.get().save();
        return redirect("/master/registrarTutor");
    }

    
    //FORMULARIOS PARA NIVELES
    public Result createFormLevel(){
        Form<Level> formulario = Form.form(Level.class);
        return ok(registrarLevel.render(formulario));
    }

    public Result saveFormLevel(){
        Form<Level> formulario = Form.form(Level.class).bindFromRequest();

        formulario.get().save();
        return redirect("/master/registrarLevel");
    }


    //FORMULARIOS PARA AREAS
    public Result createFormArea(){
        Form<Area> formulario = Form.form(Area.class);
        return ok(registrarArea.render(formulario));
    }

    public Result saveFormArea(){
        Form<Area> formulario = Form.form(Area.class).bindFromRequest();

        formulario.get().save();
        return redirect("/master/registrarArea");
    }


    //FORMULARIOS PARA CURSOS
    public Result createFormCourse(){
        Form<Course> formulario = Form.form(Course.class);
        Form<Variable> variable = Form.form(Variable.class);

        return ok(registrarCourse.render(formulario, variable));
    }

    public Result saveFormCourse(){
        Form<Course> formulario = Form.form(Course.class).bindFromRequest();
        formulario.get().save();
        return redirect("/master/registrarCourse");
    }


    //FORMULARIOS PARA TEMAS
    public Result createFormTheme(){
        Form<Theme> formulario = Form.form(Theme.class);
        return ok(registrarTheme.render(formulario));
    }

    public Result saveFormTheme(){
        Form<Theme> formulario = Form.form(Theme.class).bindFromRequest();
        formulario.get().save();
        return redirect("/master/registrarTheme");
    }
}