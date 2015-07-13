package models;

public class Variable{

	private int idAdmin;
	private int idArea;

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
}