package br.com.intelipost.user.details.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.intelipost.user.details.document.Role;
import br.com.intelipost.user.details.document.RoleType;
import br.com.intelipost.user.details.document.User;
import br.com.intelipost.user.details.document.UserDetailsIntelipost;
import br.com.intelipost.user.details.repository.RoleRepository;
import br.com.intelipost.user.details.repository.UserDetailIntelipostRepository;
import br.com.intelipost.user.details.repository.UserRepository;

@Component
public class InitInMemoryRegistries {

	@Autowired
	private UserDetailIntelipostRepository userDetailIntelipostRepository;
	
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		List<UserDetailsIntelipost> details = userDetailIntelipostRepository.findAll();
		buildRoles();
		User adminUser = buildAdminUser();
		
		if (details.isEmpty()) {
			List<UserDetailsIntelipost> detailsUser = buildDefaultUsers();
			adminUser.setUserDetails(detailsUser.get(0));
			detailsUser.forEach(user -> userDetailIntelipostRepository.save(user));
		}
	}

	private List<UserDetailsIntelipost> buildDefaultUsers() {
		UserDetailsIntelipost detailsIntelipost = new UserDetailsIntelipost();
		detailsIntelipost.setAddress("Rua Silva Bueno, 09");
		detailsIntelipost.setCity("São Paulo");
		detailsIntelipost.setFullName("Robson Vieira");
		detailsIntelipost.setNickName("Rob");
		detailsIntelipost.setUserId(1L);
		
		UserDetailsIntelipost detailsIntelipost2 = new UserDetailsIntelipost();
		detailsIntelipost2.setAddress("Avenida Marechal Teodoro, 1905");
		detailsIntelipost2.setCity("São Paulo");
		detailsIntelipost2.setFullName("Alisson Suzuki");
		detailsIntelipost2.setNickName("Japa");
		detailsIntelipost2.setUserId(2L);
		
		return Arrays.asList(detailsIntelipost, detailsIntelipost2);
	}
	
	private void buildRoles() {
		for (RoleType role : RoleType.values()) {
			Role roleToPersist = new Role();
			roleToPersist.setName(role);
			roleRepository.save(roleToPersist);
		}
	}
	
	private User buildAdminUser() {
		User adminUser = new User();
		adminUser.setName("Admin");
		adminUser.setUsername("admin@intelipost.com.br");
		adminUser.setAvatarPhoto("user.jpg");
		adminUser.setStatus(Boolean.TRUE);
		adminUser.setPassword(bcryptPasswordEncoder.encode("passwd@"));
		adminUser.setRegistryDate(LocalDateTime.now());
		adminUser.setRole(roleRepository.findByName(RoleType.ROLE_ADMIN));
		return userRepository.save(adminUser);
	}
}
