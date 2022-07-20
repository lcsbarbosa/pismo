package com.pismo.test;

import com.pismo.test.controller.TestControler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private TestControler testControler;

	@Test
	void contextLoads() {
		assertThat(testControler).isNotNull();
	}

}
