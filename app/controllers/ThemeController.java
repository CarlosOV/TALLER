package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import java.util.*;
import com.avaje.ebean.Model;

import views.html.master.*;
import controllers.*;

import models.*;

public class ThemeController extends Controller {

    //CREACION DE LO QUERIES DE LA CLASE THEME
    public static Model.Finder<Long, Theme> find = new Model.Finder<Long, Theme>(Long.class, Theme.class);

    public static Map<String, String> showThemes(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        for(Theme theme : ThemeController.find.orderBy("name").findList()){
            map.put(theme.getId() + "", theme.getName());
        }
        return map;
    }
}