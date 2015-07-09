package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.administrator.*;
import models.*;

public class AdminController extends Controller {

    public Result menu(){
    	return ok(adminMenu.render());
    }

    public Result editarInfo(){
        long id = Integer.parseInt(session("user_id"));
        Administrador admin = AdminController.find.byId(id);
        Form<Administrador> formulario = Form.form(Administrador.class);
    	return ok(editarDatos.render(admin));
    }

    public Result updateInfo(){
        Form<Administrador> formulario = Form.form(Administrador.class).bindFromRequest();
        formulario.get().save();
        return redirect("/master/registrarAdmin");
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
    public static boolean loginAdministrador(String user_admin, String password){
    	List<Administrador> adminArray = AdminController.find.all();
        Administrador admin = null;
    	int index = 0;
    	boolean flag  = false;
    	
    	while(index < adminArray.size() && !flag){
    		admin = adminArray.get(index);
    		if(admin.getUser_admin().equals(user_admin) && admin.getPassword().equals(password)){
    			flag = true;
    		}
    		index++;
    	}
        if(flag){
            session("user_id", ""+admin.getId());
            return true;
        }else{
            return false;
        }
    }

    //LISTADO DE TODOS LOS ADMINISTRADORES
    public static Map<String, String> showAdministradores(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Administrador admin : AdminController.find.orderBy("last_name").findList()){
            map.put(admin.getId() + "", admin.last_name + " " + admin.name);
        }
        return map;
    }
}
