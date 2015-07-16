package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import views.html.tutor.*;
import models.*;
import controllers.*;

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

    public static List<Course> findCourses(long id){
        return CourseController.find.where().eq("tutors.id",id).findList();
    }

}
