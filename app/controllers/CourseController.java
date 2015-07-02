package controllers;
import java.util.List;
import com.avaje.ebean.Model;
import play.*;
import play.mvc.*;
//import views.html.course.*;
import models.*;
public class CourseController extends Controller {
    public Result consultas(){
      return ok(courseConsulta.render());
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
//CREACION DE LO QUERIES DE LA CLASE CURSO
public static Model.Finder<Long, Curso> find = new Model.Finder<Long, Curso>(Long.class, Curso.class);

}
