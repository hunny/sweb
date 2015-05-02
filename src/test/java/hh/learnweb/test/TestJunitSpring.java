package hh.learnweb.test;

import hh.learnweb.model.User;
import hh.learnweb.service.IUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-base.xml", "classpath:spring-mybatis.xml"})
public class TestJunitSpring {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testUser() {
		System.out.println("testing.");
		User user = userService.findUserById(1l);
		System.out.println(user);
	}

}
