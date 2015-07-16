package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import java.util.*;

import views.html.master.*;
import controllers.*;

import models.*;

public class MasterController extends Controller {

    //FORMULARIO PARA ADMINISTRADORES
    public Result createFormAdmin(){
        Form<Administrador> formulario = Form.form(Administrador.class);
    	return ok(registrarAdmin.render(formulario));
    }

    public Result saveFormAdmin(){
    	Form<Administrador> formulario = Form.form(Administrador.class).bindFromRequest();
        Administrador admin = new Administrador();
        String name = formulario.get().getName();
        String last_name = formulario.get().getLast_name();
        String phone = formulario.get().getPhone();
        String email = formulario.get().getEmail();
        String user = formulario.get().getUser_admin();
        String[] lastNames = last_name.split(" ");
        String password;

        if(lastNames.length > 1){
            password = "a"+lastNames[0].substring(0,3)+lastNames[1].substring(0,3)+name.substring(0,2);
        }
        else{
            password = "a"+lastNames[0].substring(0,3)+name.substring(0,2);
        }
        password.toLowerCase();
        admin.setName(name);
        admin.setLast_name(last_name);
        admin.setPhone(phone);
        admin.setEmail(email);
        admin.setUser_admin(user);
        admin.setPassword(password);
        admin.save();
    	return redirect("/master/registrarAdmin");
    }

    public Result listOfAdmin(){
        List<Administrador> admins = AdminController.listAdmins();
        return ok(eliminarAdmin.render(admins));
    }

    public Result deleteAdmin(Long id){
        AdminController.find.ref(id).delete();
        return redirect("/master/eliminarAdmin");
    }


    //FORMULARIO PARA TUTORES
    public Result createFormTutor(){
        Form<Tutor> formulario = Form.form(Tutor.class);
        Form<Variable> variable = Form.form(Variable.class);

        return ok(registrarTutor.render(formulario, variable));
    }

    public Result saveFormTutor(){
        Form<Tutor> formulario = Form.form(Tutor.class).bindFromRequest();
        Form<Variable> formu = Form.form(Variable.class).bindFromRequest(); 
        Tutor tutor = new Tutor();

        String name = formulario.get().getName();
        String last_name = formulario.get().getLast_name();
        String phone = formulario.get().getPhone();
        String email = formulario.get().getEmail();
        String user = formulario.get().getUser_tutor();
        String[] lastNames = last_name.split(" ");
        String password;

        if(lastNames.length > 1){
            password = "t"+lastNames[0].substring(0,3)+lastNames[1].substring(0,3)+name.substring(0,2);
        }
        else{
            password = "t"+lastNames[0].substring(0,3)+name.substring(0,2);
        }
        password.toLowerCase();
        tutor.setName(name);
        tutor.setLast_name(last_name);
        tutor.setPhone(phone);
        tutor.setEmail(email);
        tutor.setUser_tutor(user);
        tutor.setPassword(password);
        tutor.setAdmin(AdminController.find.where().eq("id", formu.get().getIdAdmin()).findUnique());
        tutor.save();
        return redirect("/master/registrarAdmin");
    }

    public Result listOfTutor(){
        List<Tutor> tutors = TutorController.find.all();
        return ok(eliminarTutor.render(tutors));
    }

    public Result deleteTutor(Long id){
        TutorController.find.ref(id).delete();
        return redirect("/master/eliminarTutor");
    }

    
    //FORMULARIOS PARA NIVELES
    public Result createFormLevel(){
        Form<Level> formulario = Form.form(Level.class);
        return ok(registrarLevel.render(formulario));
    }

    public Result saveFormLevel(){
        Form<Level> formulario = Form.form(Level.class).bindFromRequest();

        formulario.get().save();
        return redirect("/master/registrarLevel");
    }

    public Result editLevel(){
        List<Level> levels = LevelController.find.all();
        return ok(actualizarLevel.render(levels));
    }

    public Result updateLevel(Long id){
        DynamicForm requestData = Form.form().bindFromRequest();
        Level level = LevelController.find.byId(id);
        Level_Aux level_aux = Level_Aux_Controller.find.where().eq("level.id", id).findUnique();
        String name = requestData.get("nameLevel");
        
        level.setName(name);
        level.update();
        level_aux.setLevel(level);
        level_aux.update();
        return redirect("/master/actualizarLevel");
    }

    public Result deleteLevel(Long id){
        LevelController.find.ref(id).delete();
        return redirect("/master/actualizarLevel");
    }


    //FORMULARIOS PARA AREAS
    public Result createFormArea(){
        Form<Area> formulario = Form.form(Area.class);
        return ok(registrarArea.render(formulario));
    }

    public Result saveFormArea(){
        Form<Area> formulario = Form.form(Area.class).bindFromRequest();

        formulario.get().save();
        return redirect("/master/registrarArea");
    }

    public Result editArea(){
        List<Area> areas = AreaController.find.all();
        return ok(actualizarArea.render(areas));
    }

    public Result updateArea(Long id){
        DynamicForm requestData = Form.form().bindFromRequest();
        Area area = AreaController.find.byId(id);
        String name = requestData.get("nameArea");
        area.setName(name);
        area.save();
        return redirect("/master/actualizarArea");
    }

    public Result deleteArea(Long id){
        AreaController.find.ref(id).delete();
        return redirect("/master/actualizarArea");
    }


    //FORMULARIOS PARA CURSOS
    public Result createFormCourse(){
        Form<Course> formulario = Form.form(Course.class);
        Form<Variable> variable = Form.form(Variable.class);

        return ok(registrarCourse.render(formulario, variable));
    }

    public Result saveFormCourse(){
        Form<Course> formulario = Form.form(Course.class).bindFromRequest();
        Form<Variable> variable = Form.form(Variable.class).bindFromRequest();
        
        long id = Integer.parseInt(formulario.field("idArea").value());
        String nameCourse = formulario.field("name").value();
        Course course = new Course();
        Area area = AreaController.find.byId(id);
        
        course.setName(nameCourse);
        course.setArea(area);
        course.setTutor(TutorController.find.where().eq("id", variable.get().getIdTutor()).findUnique());
        course.save();
        
        return redirect("/master/registrarCourse");
    }

    public Result unionCourse(){
        Form<Variable> variable = Form.form(Variable.class);

        return ok(vincularCourse.render(variable));
    }

    public Result unionSave(){
        Form<Variable> variable = Form.form(Variable.class).bindFromRequest();
        Level_Aux level_aux = new Level_Aux();
        Course_Aux course_aux = new Course_Aux();
        
        level_aux.setLevel(LevelController.find.where().eq("id", variable.get().getIdLevel()).findUnique());
        course_aux.setCourse(CourseController.find.where().eq("id", variable.get().getIdCourse()).findUnique());

        course_aux.setLevel_aux(level_aux);
        level_aux.save();
        course_aux.save();
        return redirect("/master/vincularCourse");
    }

    public Result editCourse(){
        List<Variable> variable = CourseController.courseInfo();
        return ok(actualizarCourse.render(variable));
    }



    //FORMULARIOS PARA TEMAS
    public Result createFormTheme(){
        Form<Theme> formulario = Form.form(Theme.class);
        return ok(registrarTheme.render(formulario));
    }

    public Result saveFormTheme(){
        /*Form<Theme> formulario = Form.form(Theme.class).bindFromRequest();
        long idCourse = Integer.parseInt(formulario.field("idArea").value());
        long idLevel = Integer.parseInt(formulario.field("idAdmin").value());
        Course course = CourseController.find.byId(idCourse);
        Level level = LevelController.find.byId(idLevel);
        Theme theme = new Theme();
        theme.setLevel(level);
        theme.setCourse(course);
        theme.setName(formulario.field("name").value());
        theme.save();
        if(course.getLevels().indexOf(level)<0){
            course.setLevel(level);
            course.save();  
        }
        */
        return redirect("/master/registrarTheme");
    }
    public Result editTheme(){

        List<Tema> temas = findTemas();
        return ok(actualizarTheme.render(temas));
    }

    public List<Tema> findTemas(){
        /*
        List<Tema> temas = new ArrayList<Tema>();
        List<Course> courses = CourseController.find.all();
        for (Course course : courses) {
            List<Level> levels = course.getLevels();
            for(Level level: levels){
            List<Theme> themes = level.getThemes();
                for(Theme theme: themes){
                    if(theme.getCourse().getId()==course.getId()){
                      Tema tema = new Tema();
                    tema.setIdTheme(theme.getId());
                    tema.setIdCurso(course.getId());
                    tema.setIdNivel(level.getId());
                    temas.add(tema);  
                    }  
                }
                
            }
        }
        return temas;*/
        return null;
    }
}