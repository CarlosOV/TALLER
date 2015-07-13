package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.master.*;
import models.*;

public class AreaController extends Controller {

    public static Model.Finder<Long, Area> find = new Model.Finder<Long, Area>(Long.class, Area.class);

    //LISTAR TODOS LAS AREAS REGISTRADAS
    public static Map<String, String> showAreas(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Area area : AreaController.find.orderBy("name").findList()){
            map.put(area.getId() + "", area.getName());
        }
        return map;
    }
}