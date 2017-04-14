package active;


import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mumway.active.exam.domain.User;
import com.mumway.active.exam.service.IUserService;
import com.mumway.active.exam.service.impl.UserService;

public class TestMybatis {
	@Resource
	private IUserService userService = null;
	@SuppressWarnings("resource")
	@Before
	 public void befre() {
	  try {
		ApplicationContext aCtx = new FileSystemXmlApplicationContext(
		    "classpath:spring/applicationContext-tx.xml");
		  UserService userService = (UserService) aCtx
		    .getBean("userService");
		  this.userService = userService;
	} catch (BeansException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	 }
	@Test
	public void test1(){
		User user = userService.getUserById(1);
		System.out.println(user.getUserName());
	}
}
