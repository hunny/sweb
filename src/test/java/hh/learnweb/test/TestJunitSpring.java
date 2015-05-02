package hh.learnweb.test;

import hh.learnweb.model.User;
import hh.learnweb.service.IUserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-base.xml", "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class TestJunitSpring {
	
	private Logger logger = LoggerFactory.getLogger(TestJunitSpring.class);
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testUser() {
		logger.debug("testing.");
		User user = userService.findUserById(1l);
		logger.debug("" + user);
	}

}
