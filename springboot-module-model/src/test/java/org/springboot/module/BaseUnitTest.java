package org.springboot.module;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = modelApplication.class)
public class BaseUnitTest {

	@Before
	public void beforeDo() {
		System.out.println("------------------------");
	}
	
	@After
	public void afterDo() {
		System.out.println("########################\n");
	}

}
