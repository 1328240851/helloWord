package com.example.hello;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Before
	public void setUp() throws Exception{
		this.base = new URL("http://localhost" + port +"/" );
	}

	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = testRestTemplate.getForEntity(base.toString(),
				String.class);
	}

}
