package org.springboot.module.others;

import org.junit.After;
import org.junit.Before;

public class BaseJunit {
	
	@Before
	public void before() {
		System.out.println("*******begin*********");
	}
	
	@After
	public void after() {
		System.out.println("********end**********");
	}

}
