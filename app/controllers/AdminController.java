package controllers;

import java.util.*;
import java.text.ParseException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.administrator.*;
import models.*;

public class AdminController extends Controller {

    public Result reportes(){
        Form<Reporte> reporte = Form.form(Reporte.class);
        Date fecha = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, 7);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return ok(adminReportes.render(reporte, formatter.format(calendar.getTime())));
    }

    public Result saveFormReport(){
        Form<Reporte> reporte = Form.form(Reporte.class).bindFromRequest();
        Report report = new Report();
        Date date = null;

        Tutor tutor = TutorController.find.byId(reporte.get().getIdTutor());
        Theme theme = ThemeController.find.byId(reporte.get().getIdTema());
        report.setTutor(tutor);
        report.setTheme(theme);
        report.setVar_state(false);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = formatter.parse(reporte.get().getFecha());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        report.setDate_registry(date);
        report.save();

        return redirect(routes.AdminController.menu());
    }

    public Result consultas(){
        return ok(adminConsulta.render());
    }

    public Result menu(){
    	return ok(adminMenu.render());
    }

    public Result editarInfo(){
        long id = Integer.parseInt(session("id"));
        Administrador admin = AdminController.find.byId(id);
        Form<Administrador> formulario = Form.form(Administrador.class);
    	return ok(editarDatos.render(formulario, admin));
    }

    public Result updateInfo(){
        Form<Administrador> formulario = Form.form(Administrador.class).bindFromRequest();
        long id = Integer.parseInt(session("id"));
        Administrador admin = AdminController.find.byId(id);
        String name = formulario.get().getName();
        String last_name = formulario.get().getLast_name();
        String phone = formulario.get().getPhone();
        String email = formulario.get().getEmail();
        admin.setName(name);
        admin.setLast_name(last_name);
        admin.setPhone(phone);
        admin.setEmail(email);
        admin.save();
        return redirect(routes.AdminController.indexCuenta());
    }

    public Result updateCount(){
        Form<Password> pass = Form.form(Password.class).bindFromRequest();
        long id = Integer.parseInt(session("id"));

        Administrador admin = AdminController.find.byId(id);
        if(pass.get().getOld_pass().equals(admin.getPassword())){
            if(pass.get().getPass().equals(pass.get().getRe_pass())){
                admin.setPassword(pass.get().getPass());
                admin.update();
            }
        }
        
        return redirect(routes.AdminController.indexCuenta());
    }

    public Result editarCuenta(){
        Form<Password> pass = Form.form(Password.class);
    	return ok(editarCuenta.render(pass));
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
            session("user", admin.getName() + " " + admin.getLast_name());
            session("id", admin.getId() + "");
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

    public static Map<String, String> showTutores(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Tutor tutor : TutorController.find.where().eq("admin.id", session("id")).findList()){
            map.put(tutor.getId() + "", tutor.getLast_name() + " " + tutor.getName());
        }
        return map;
    }

    //LISTADO DE TODOS LOS ADMINISTRADORES COMO OBJETOS
    public static List<Administrador> listAdmins(){
        return AdminController.find.all();
    }
}
