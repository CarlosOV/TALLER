package controllers;
import java.util.List;
import com.avaje.ebean.Model;
import play.*;
import play.mvc.*;
import views.html.course.*;
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
//CREACION DE LO QUERIES DE LA CLASE TUTOR
public static Model.Finder<Long, Tutor> find = new Model.Finder<Long, Tutor>(Long.class, Tutor.class);
//CREACION DE LOS METODOS DEL CONTROLLER
public static Result loginTutor(String user_tutor, String password){
List<Tutor> tutorArray = TutorController.find.all();
Tutor tutor = null;
int index = 0;
boolean flag = false;
while(index < tutorArray.size() && !flag){
tutor = tutorArray.get(index);
if(tutor.getUser_tutor().equals(user_tutor) && tutor.getPassword().equals(password)){
flag = true;
}
index++;
}
if(flag){
session("user", tutor.getName() + " " + tutor.getLast_name());
return redirect(routes.TutorController.menu());
}else{
return redirect(routes.Home.login());
}
}
}
