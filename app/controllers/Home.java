package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Home extends Controller {

    public Result login(){
    	return ok(login.render());
    }
}
