package hh.learnweb.test;

import hh.learnweb.model.User;
import hh.learnweb.service.IUserService;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//事务回滚
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
//事务
@Transactional 
@ContextConfiguration(locations = {"classpath:spring-base.xml", "classpath:spring-mybatis.xml"})
public class TestJunitSpring {
	
	private static final Logger logger = Logger.getLogger(TestJunitSpring.class);
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void testUser() {
		logger.debug("testing.");
		User user = userService.findUserById(1l);
		logger.debug(user);
	}
	
	@Test
	public void testInsertUser() {
		User user = new User();
		int random = new Random().nextInt();
		user.setNickName("哈吧" + random);
		user.setUsername("用户" + random);
		user.setPassword(String.valueOf(random + "" + random));
		user.setDateCreated(new Date());
		user.setUserCreated(new Long(random));
		user.setLastUpdated(new Date());
		user.setUserUpdated(new Long(random));
		logger.debug("Insert User Testing" + userService.insertUser(user));
	}

}
