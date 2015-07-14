package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "file")
public class File extends Model{

	@Id
	protected Long id;
	String name;

	@OneToMany(mappedBy = "file" ,cascade=CascadeType.ALL)
	List<FileAux> file_aux;

}