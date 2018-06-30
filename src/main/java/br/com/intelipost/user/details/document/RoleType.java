package br.com.intelipost.user.details.document;

public enum RoleType {

	ROLE_ADMIN("Admin"),
	ROLE_USER("User");
	
	private final String name; 
	
    private RoleType(String s) {
        name = s;
    }
    
    public String getName() {
		return name;
	}

}
