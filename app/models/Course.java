package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "course")
public class Course extends Model{

	@Id
	Long id;
	String name;
	@ManyToOne(cascade=CascadeType.ALL)
  	AreaCourse area;

  	@ManyToMany(cascade=CascadeType.ALL)
  	List<Tutor> tutors;

  	@OneToMany(mappedBy = "course" ,cascade=CascadeType.ALL)
	List<Theme> themes;

}