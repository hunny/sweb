package hh.learnweb.test;

import hh.learnweb.model.User;
import hh.learnweb.service.IUserService;
import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 最原始的junit测试案例
 * @author hunnyhu
 */
public class TestJunit3 extends TestCase {

	public void testUser() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String [] {"spring-base.xml", "spring-mybatis.xml"});
		IUserService userService = (IUserService)ac.getBean("userService");
		User user = userService.findUserById(1L);
		System.out.println(user);
		ac.close();
	}
	
}
