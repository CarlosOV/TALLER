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
        Administrador admin = new Administrador();
        String name = formulario.get().getName();
        String last_name = formulario.get().getLast_name();
        String phone = formulario.get().getPhone();
        String email = formulario.get().getEmail();
        String user = formulario.get().getUser_admin();
        String[] lastNames = last_name.split(" ");
        String password;
        if(lastNames.length>1){
        password = "a"+lastNames[0].substring(0,3)+lastNames[1].substring(0,3)+name.substring(0,2);
        }
        else{
        password = "a"+lastNames[0].substring(0,3)+name.substring(0,2);
        }
        password.toLowerCase();
        admin.setName(name);
        admin.setLast_name(last_name);
        admin.setPhone(phone);
        admin.setEmail(email);
        admin.setUser_admin(user);
        admin.setPassword(password);
        admin.save();
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