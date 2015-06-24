package controllers;

import play.*;
import play.mvc.*;

import views.html.master.*;

public class MasterController extends Controller {

    public Result registrarTutor(){
    	return ok(registrarTutor.render());
    }

    public Result registrarAdmin(){
    	return ok(registrarAdmin.render());
    }
}