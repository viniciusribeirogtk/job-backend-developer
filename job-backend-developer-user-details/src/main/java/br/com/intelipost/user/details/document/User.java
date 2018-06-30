package br.com.intelipost.user.details.document;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "user")
public class User implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String name;
	
	private String username;
	private String password;
	
    private String avatarPhoto;
    private Role role ;
    @NotNull(message="Usuario necessita de um status")
    private Boolean status;
    private LocalDateTime registryDate;
    
    private UserDetailsIntelipost userDetails;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public Role getRole() {
        return role;
    }

    public void setRole(Role roles) {
        this.role = roles;
    }
    
    public String getName() {
		return name;
	}
    
    public void setName(String name) {
		this.name = name;
	}
    
    public String getAvatarPhoto() {
		return avatarPhoto;
	}
    public void setAvatarPhoto(String avatarPhoto) {
		this.avatarPhoto = avatarPhoto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(role);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return status;
	}
	
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Boolean getStatus() {
		return status;
	}
	
	public void setRegistryDate(LocalDateTime dataCadastro) {
		this.registryDate = dataCadastro;
	}
	
	public LocalDateTime getRegistryDate() {
		return registryDate;
	}
	
    public UserDetailsIntelipost getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsIntelipost userDetails) {
		this.userDetails = userDetails;
	}

	@Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + name + ", login=" + username 
                + ", status=" + status + "]";
    }
}
