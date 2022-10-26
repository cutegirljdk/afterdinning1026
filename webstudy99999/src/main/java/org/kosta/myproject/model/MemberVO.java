package org.kosta.myproject.model;

import java.io.Serializable;

public class MemberVO implements Serializable {
	private static final long serialVersionUID = -3089654915065187978L;
	private String id;
	private String password;
	private String name;

	public MemberVO(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "회원정보 [id=" + id + ", password=" + password + ", name=" + name + "]";
	}
	
}
