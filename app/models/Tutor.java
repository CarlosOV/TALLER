package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;


@Entity
@Table(name = "tutor")
public class Tutor extends Model{

	@Id
	protected Long id;
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

	public Tutor(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_tutor() {
		return user_tutor;
	}

	public void setUser_tutor(String user_tutor) {
		this.user_tutor = user_tutor;
	}

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}