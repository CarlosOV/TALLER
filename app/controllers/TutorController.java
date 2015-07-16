package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.tutor.*;
import models.*;
import controllers.*;

public class TutorController extends Controller {

    public Result consultas(){
        List<Report> report = ReportController.find.all();
    	return ok(tutorConsulta.render(report));
    }

    public Result menu(){
    	return ok(tutorMenu.render());
    }

    public Result editarInfo(){
        long id = Integer.parseInt(session("id"));
        Tutor tutor = TutorController.find.byId(id);
        Form<Tutor> formulario = Form.form(Tutor.class);
    	return ok(editarDatos.render(formulario, tutor));
    }

    public Result updateInfo(){
        Form<Tutor> formulario = Form.form(Tutor.class).bindFromRequest();
        long id = Integer.parseInt(session("id"));
        Tutor tutor = TutorController.find.byId(id);

        tutor.setName(formulario.get().getName());
        tutor.setLast_name(formulario.get().getLast_name());
        tutor.setEmail(formulario.get().getEmail());
        tutor.setPhone(formulario.get().getPhone());
        tutor.save();

        return redirect(routes.TutorController.indexCuenta());
    }

    public Result editarCuenta(){
        Form<Password> pass = Form.form(Password.class);
    	return ok(editarCuenta.render(pass));
    }

    public Result updateCount(){
        Form<Password> pass = Form.form(Password.class).bindFromRequest();
        long id = Integer.parseInt(session("id"));

        Tutor tutor = TutorController.find.byId(id);
        if(pass.get().getOld_pass().equals(tutor.getPassword())){
            if(pass.get().getPass().equals(pass.get().getRe_pass())){
                tutor.setPassword(pass.get().getPass());
                tutor.update();
            }
        }
        
        return redirect(routes.TutorController.indexCuenta());
    }

    public Result indexCuenta(){
        return ok(indexCuenta.render());
    }

    //CREACION DE LO QUERIES DE LA CLASE TUTOR
    public static Model.Finder<Long, Tutor> find = new Model.Finder<Long, Tutor>(Long.class, Tutor.class);
    
    //CREACION DE LOS METODOS DEL CONTROLLER
    public static boolean loginTutor(String user_tutor, String password){
        List<Tutor> tutorArray = TutorController.find.all();
        Tutor tutor = null;
        int index = 0;
        boolean flag  = false;
        
        while(index < tutorArray.size() && !flag){
            tutor = tutorArray.get(index);
            if(tutor.getUser_tutor().equals(user_tutor) && tutor.getPassword().equals(password)){
                flag = true;
            }
            index++;
        }
        if(flag){
            session("user", tutor.getName() + " " + tutor.getLast_name());
            session("id", tutor.getId() + "");
            return true;
        }else{
            return false;
        }

    }

    public static Map<String, String> showTutores(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Tutor tutor : TutorController.find.orderBy("last_name").findList()){
            map.put(tutor.getId() + "", tutor.getLast_name() + " " + tutor.getName());
        }
        return map;
    }

    public static List<Course> findCourses(long id){
        return CourseController.find.where().eq("tutors.id",id).findList();
    }

}
