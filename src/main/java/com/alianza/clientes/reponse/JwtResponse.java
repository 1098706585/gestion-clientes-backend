package com.alianza.clientes.reponse;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
	private String clavetemporal;
	private String encodedMessage;

	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles,String clavetemporal,String encodedMessage) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.clavetemporal=clavetemporal;
		this.encodedMessage=encodedMessage;
	}		

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}


	public String getClavetemporal() {
		return clavetemporal;
	}

	public void setClavetemporal(String clavetemporal) {
		this.clavetemporal = clavetemporal;
	}

	public String getEncodedMessage() {
		return encodedMessage;
	}

	public void setEncodedMessage(String encodedMessage) {
		this.encodedMessage = encodedMessage;
	}
	
	
	
}

