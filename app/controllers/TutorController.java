package controllers;

import play.*;
import play.mvc.*;

import views.html.tutor.*;

public class TutorController extends Controller {

    public Result consultas(){
    	return ok(tutorConsulta.render());
    }

    public Result menu(){
    	return ok(tutorMenu.render());
    }

    public Result editarInfo(){
    	return ok(editarDatos.render());
    }

    public Result editarCuenta(){
    	return ok(editarCuenta.render());
    }

    public Result indexCuenta(){
        return ok(indexCuenta.render());
    }
}
