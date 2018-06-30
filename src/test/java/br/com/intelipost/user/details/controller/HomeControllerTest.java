package br.com.intelipost.user.details.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.intelipost.user.details.document.UserDetailsIntelipost;
import br.com.intelipost.user.details.endpoint.UserDetailsIntellipostEndpoint;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    private static final String HOME_PATH = "/dashboard";

	@Autowired
    protected MockMvc mockMvc;
	
	@MockBean
	private UserDetailsIntellipostEndpoint userEndpoint;
	
    @Autowired
    private WebApplicationContext webApplicationContext;
	
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }

	
	@Test
	public void testHome() throws Exception {
		UserDetailsIntelipost detailsIntellipostEndpoint = buildUserDetails();
		ResponseEntity<UserDetailsIntelipost> responseEntity = new ResponseEntity<>(detailsIntellipostEndpoint, HttpStatus.OK);
		when(userEndpoint.getDetails(Mockito.anyLong())).thenReturn(responseEntity);
		
		mockMvc.perform(
				get(HOME_PATH).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk());

	}

	private UserDetailsIntelipost buildUserDetails() {
		UserDetailsIntelipost detailsIntellipostEndpoint = new UserDetailsIntelipost();
		detailsIntellipostEndpoint.setAddress("Some Address");
		detailsIntellipostEndpoint.setCity("Some City");
		detailsIntellipostEndpoint.setFullName("Some FullName");
		detailsIntellipostEndpoint.setNickName("Some NickName");
		detailsIntellipostEndpoint.setUserId(1L);
		return detailsIntellipostEndpoint;
	}

}
