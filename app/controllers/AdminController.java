package controllers;

import java.util.List;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import views.html.administrator.*;
import models.*;

public class AdminController extends Controller {

    public Result menu(){
    	return ok(adminMenu.render());
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
    
    //CREACION DE LO QUERIES DE LA CLASE ADMINISTRATOR
    public static Model.Finder<Long, Administrador> find = new Model.Finder<Long, Administrador>(Long.class, Administrador.class);
    
    //CREACION DE LOS METODOS DEL CONTROLLER
    public static void loginAdministrador(String user_admin, String password){
    	List<Administrador> adminArray = AdminController.find.all();
    	int index = 0;
    	boolean flag  = false;
    	
    	while(index < adminArray.size() && !flag){
    		Administrador admin = adminArray.get(index);
    		if(admin.getUser_admin().equals(user_admin) && admin.getPassword().equals(password)){
    			flag = true;
    		}
    		index++;
    	}
    }
}
