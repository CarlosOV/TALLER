package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.master.*;
import models.*;

public class Level_Aux_Controller extends Controller {

    public static Model.Finder<Long, Level_Aux> find = new Model.Finder<Long, Level_Aux>(Long.class, Level_Aux.class);

    
}