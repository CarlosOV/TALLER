package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "tutor")
public class Tutor{

	@Id
	Long id;
	String user_tutor;

	@ManyToOne(cascade=CascadeType.ALL)
  	Administrador admin;

  	@ManyToMany(cascade=CascadeType.ALL)
  	List<Course> courses;

  	@OneToMany(mappedBy = "tutor" ,cascade=CascadeType.ALL)
	List<Report> reports;

	String password;
	String name;
	String last_name;
	String phone;
	String email;

}