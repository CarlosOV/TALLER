package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "report_auxs")
public class ReportAux extends Model{

	@Id
	protected Long id;
	@ManyToOne(cascade=CascadeType.ALL)
  	Report report;

  	@OneToMany(mappedBy = "report_aux" ,cascade=CascadeType.ALL)
	List<FileAux> file_aux;

}