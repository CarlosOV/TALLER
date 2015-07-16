package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.master.*;
import models.*;

public class Course_Aux_Controller extends Controller {

    public static Model.Finder<Long, Course_Aux> find = new Model.Finder<Long, Course_Aux>(Long.class, Course_Aux.class);

    
}