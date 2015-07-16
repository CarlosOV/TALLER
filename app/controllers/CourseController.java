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
    	List<Variable> info = null;

    	for(Course c : courses){
    		Variable var = new Variable();
    		var.setName(c.getName());
    		var.setArea(c.getArea().getName());
    		var.setTutor(c.getTutor().getLast_name() + " " + c.getTutor().getName());
    		List<Course_Aux> courses_aux = Course_Aux_Controller.find.where().eq("course.id", c.getId()).findList();
    		for(Course_Aux course_aux : courses_aux){
    			List<Level_Aux> levels_aux = Level_Aux_Controller.find.where().eq("course_aux.level_aux.id", course_aux.getLevel_Aux().getId()).findList();
    			for(Level_Aux level_aux : levels_aux){
    				Level level = LevelController.find.byId(level_aux.getLevel().getId());
    				var.setLevels(level);
    			}
    		}
    		info.add(var);
    	}

    	return info;
    }
}