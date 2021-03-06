package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.master.*;
import models.*;

public class CourseController extends Controller {

    public static Model.Finder<Long, Course> find = new Model.Finder<Long, Course>(Long.class, Course.class);

    //LISTAR TODOS LOS CURSOS REGISTRADOS
    public static Map<String, String> showCourses(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Course course : CourseController.find.orderBy("name").findList()){
            map.put(course.getId() + "", course.getName());
        }
        return map;
    }

    public static List<Variable> courseInfo(){
    	List<Course> courses = CourseController.find.all();
    	ArrayList<Variable> info = new ArrayList<Variable>();

    	for(Course c : courses){
    		Variable var = new Variable();
    		var.setName(c.getName());
    		var.setArea(c.getArea().getName());
            if(c.getTutor() != null){
                var.setTutor(c.getTutor().getLast_name() + " " + c.getTutor().getName());    
            }else{
                var.setTutor("-");    
            }
    		info.add(var);
    	}

    	return info;
    }
}