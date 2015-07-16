package models;

import java.util.*;

public class Variable{

	private int idAdmin;
	private int idArea;

	//CAMPOS PARA LA TABLA DE CURSOS
	private String name;
	private String area;
	private List<Level> levels;
	private String tutor;

	public Variable(){
		this.idAdmin = 0;
		this.idArea = 0;
	}

	public void setIdAdmin(int idAdmin){
		this.idAdmin = idAdmin;
	}

	public int getIdAdmin(){
		return idAdmin;
	}

	public void setIdArea(int idArea){
		this.idArea = idArea;
	}

	public int getIdArea(){
		return idArea;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return this.area;
	}

	public void setLevels(Level level){
		this.levels.add(level);
	}

	public List<Level> getLevels(){
		return this.levels;
	}

	public void setTutor(String tutor){
		this.tutor = tutor;
	}

	public String getTutor(){
		return this.tutor;
	}
}