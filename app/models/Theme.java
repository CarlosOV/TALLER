package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "theme")
public class Theme extends Model{

	@Id
	Long id;

	@ManyToOne(cascade=CascadeType.ALL)
  	Course course;

  	@ManyToOne(cascade=CascadeType.ALL)
  	Level level;

  	@OneToMany(mappedBy = "theme" ,cascade=CascadeType.ALL)
	List<Report> reports;

	String name;


}