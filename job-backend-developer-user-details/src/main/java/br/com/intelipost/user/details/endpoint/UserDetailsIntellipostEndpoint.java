package br.com.intelipost.user.details.endpoint;

import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.intelipost.user.details.document.UserDetailsIntelipost;
import br.com.intelipost.user.details.repository.UserDetailIntelipostRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "User Details Endpoints", tags = { "User Details Endpoints" })
public class UserDetailsIntellipostEndpoint {

	@Autowired
	private UserDetailIntelipostRepository userDetailsRepository;
	
	@GetMapping("getDetailsById/{userId}")
	@ApiOperation(value = "Return details of an Intelipost User", response = UserDetailsIntelipost.class)
	@Cacheable(value = "userDetails")
	public ResponseEntity<UserDetailsIntelipost> getDetails(@PathVariable(name="userId") Long userId){
		UserDetailsIntelipost userDetails= userDetailsRepository.findByUserId(userId);
		if (isNull(userDetails)) {
			return new ResponseEntity<>(userDetails, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}
}
