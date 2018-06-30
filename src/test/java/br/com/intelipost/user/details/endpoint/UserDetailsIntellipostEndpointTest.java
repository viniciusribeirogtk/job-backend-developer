package br.com.intelipost.user.details.endpoint;

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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.intelipost.user.details.document.UserDetailsIntelipost;
import br.com.intelipost.user.details.repository.UserDetailIntelipostRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(UserDetailsIntellipostEndpoint.class)
public class UserDetailsIntellipostEndpointTest {

    private static final String USER_DETAILS_URL = "/getDetailsById/{userId}";

	@Autowired
    protected MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
	private UserDetailIntelipostRepository userDetailsRepository;
	
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void testGetDetails() throws Exception {
		when(userDetailsRepository.findByUserId(Mockito.anyLong())).thenReturn(buildUserDetails());
		mockMvc.perform(
				get(USER_DETAILS_URL, 1L).contentType(MediaType.APPLICATION_JSON_VALUE))
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
