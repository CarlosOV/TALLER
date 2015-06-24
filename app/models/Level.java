package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "level")
public class Level{

	@Id
	Long id;
	String name;

	@OneToMany(mappedBy = "level" ,cascade=CascadeType.ALL)
	List<Theme> themes;

}