package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "report_aux")
public class Report_Aux extends Model{

	@Id
	protected Long id;
	@ManyToOne(cascade=CascadeType.ALL)
  	Report report;

  	@OneToMany(mappedBy = "report_aux" ,cascade=CascadeType.ALL)
	List<File_Aux> files_aux;

}