package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "administrador")
public class Administrador{

	@Id
	Long id;
	String user_admin;
	@OneToMany(mappedBy = "admin" ,cascade=CascadeType.ALL)
	List<Tutor> tutors;
	String password;
	String name;
	String last_name;
	String phone;
	String email;

}