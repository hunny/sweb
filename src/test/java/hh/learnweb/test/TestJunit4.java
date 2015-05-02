package hh.learnweb.test;

import hh.learnweb.model.User;
import hh.learnweb.service.IUserService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * junit4的单元测试方式
 * @author hunnyhu
 *
 */
public class TestJunit4 {
	
	private ClassPathXmlApplicationContext applicationContext;
	private IUserService userService;
	
	@Before
	public void before() {
		System.out.println("before");
		applicationContext = new ClassPathXmlApplicationContext(new String [] {"spring-base.xml", "spring-mybatis.xml"});
		userService = (IUserService)applicationContext.getBean("userService");
	}
	
	@Test
	public void testUser() {
		System.out.println("testing");
		User user = userService.findUserById(1L);
		System.out.println(user);
	}
	
	@Test
	public void testMethod() {
		System.out.println("testing");
	}
	
	@After
	public void after() {
		System.out.println("after");
		applicationContext.close();
	}
	
	public void test1() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String [] {"spring-base.xml", "spring-mybatis.xml"});
		IUserService userService = (IUserService)ac.getBean("userService");
		User user = userService.findUserById(1L);
		System.out.println(user);
		ac.close();
	}

}
