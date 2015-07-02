package models;


public class Login{

	private String user_name;
	private String password;
	private Integer tipo;

	public Login(){
		user_name = "";
		password = "";
		tipo = 0;
	}

	public void setUser_name(String user_name){
		this.user_name = user_name;
	}

	public String getUser_name(){
		return user_name;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setTipo(Integer tipo){
		this.tipo = tipo;
	}

	public Integer getTipo(){
		return tipo;
	}
}