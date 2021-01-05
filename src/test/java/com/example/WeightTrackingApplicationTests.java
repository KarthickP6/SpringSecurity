package com.example;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.entity.User;
import com.example.entity.Weights;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runners.MethodSorters;



@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration
@SpringBootTest
public class WeightTrackingApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
	
	@Before
	  public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	  }
	
	String name, pass;

	public String generateString() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(5);
		for (int i = 0; i < 5; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}
	
	
	@Test
	public void registerUser_Ok() throws Exception {
			
		User user = new User();
		user.setId(1);
		user.setUsername("karen");
		user.setPassword("fukuhara");
		user.setUserEmail("karen@gmail.com");
		byte[] ijson = toJson(user);
		
		mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON)
			.content(ijson)
			.accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(content().string("User registered successfully"));		
  }
	
	@Test
	//@WithMockUser("karen")
	public void getUserById_Ok() throws Exception {
		registerUser_Ok();
		mockMvc.perform(get("/user/1").with(httpBasic("karen","fukuhara")))
		.andExpect(status().isOk());
	}
	
	@Test
	public void getUserById_Unauthorized() throws Exception {
		name=generateString();
		pass=generateString();
		mockMvc.perform(get("/user/1").with(httpBasic(name, pass)))
		.andExpect(status().isUnauthorized());
	}
	
	@Test
	//@WithMockUser("karen")
	public void addNote_Ok() throws Exception {
		registerUser_Ok();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		Weights weight = new Weights(101, 55.5f, date);
		
		
		byte[] njson = toJson(weight);
		
		mockMvc.perform(post("/add/weight").with(httpBasic("karen", "fukuhara")).contentType(MediaType.APPLICATION_JSON)
		.content(njson).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
//	@Test
//	@WithMockUser("karen")
//	public void allTasks_Ok() throws Exception {
//		
//		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = fmt.parse("2013-05-07");
//		Weights weight = new Weights(101, 57.5f, date);
//		byte[] ljson = toJson(weight);
//		
//		mockMvc.perform(post("/add/weight").with(httpBasic("karen", "fukuhara")).contentType(MediaType.APPLICATION_JSON)
//		.content(ljson).accept(MediaType.APPLICATION_JSON))
//		.andExpect(status().isOk());
//		
//		mockMvc.perform(get("/all/weights").with(httpBasic("karen", "fukuhara")).contentType(MediaType.APPLICATION_JSON))
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(101))
//		.andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(102));
	//}
//	


	@Test
	//@WithMockUser("karen")
	public void deleteTask_Ok() throws Exception {
		mockMvc.perform(delete("/delete/weight/101").with(httpBasic("karen", "fukuhara")).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
	}
//	
	@Test
	//@WithMockUser("karen")
	public void deleteTask_Error() throws Exception {
		
		
		mockMvc.perform(delete("/delete/weight/1001").with(httpBasic("karen", "fukuhara")).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadGateway());
	
	}
//	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	private byte[] toJson(Object r) throws Exception {
		ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
	}	

}
