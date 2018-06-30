package br.com.intelipost.user.details.document;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document(collection = "role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = -9090544336478891767L;
	
	@Id
	@NotNull
	private RoleType name;
	
	
	public RoleType getName() {
		return name;
	}

	public void setName(RoleType name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name.toString();
	}
	
}
