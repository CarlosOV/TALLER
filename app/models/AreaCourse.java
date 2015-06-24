package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "area_course")
public class AreaCourse{

	@Id
	Long id;
	String name;
	@OneToMany(mappedBy = "area" ,cascade=CascadeType.ALL)
	List<Course> courses;
}