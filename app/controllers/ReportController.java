package controllers;

import java.util.*;

import com.avaje.ebean.Model;

import play.*;
import play.mvc.*;
import play.data.*;
import views.html.tutor.*;
import models.*;
import controllers.*;

public class ReportController extends Controller {

    //CREACION DE LO QUERIES DE LA CLASE TUTOR
    public static Model.Finder<Long, Report> find = new Model.Finder<Long, Report>(Long.class, Report.class);

}
