package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.master.*;
import models.*;

public class LevelController extends Controller {

    //CREACION DE LO QUERIES DE LA CLASE LEVEL
    public static Model.Finder<Long, Level> find = new Model.Finder<Long, Level>(Long.class, Level.class);

    public static Map<String, String> showLevels(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Level level : LevelController.find.orderBy("name").findList()){
            map.put(level.getId() + "", level.getName());
        }
        return map;
    }
}
