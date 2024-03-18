package br.com.ediwaldoneto.fastdelivery.domain.entities;

import java.util.Map;

public class User {

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String type;
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static User fromMap(Map<String, Object> map) {
	    User user = new User();
	    user.setId((Long) map.get("id"));
	    user.setName((String) map.get("name"));
	    user.setEmail((String) map.get("email"));
	    user.setPhone((String) map.get("phone"));
	    user.setAddress((String) map.get("address"));
	    user.setType((String) map.get("type"));
	    user.setPassword((String) map.get("password"));
	    return user;
	}


}
