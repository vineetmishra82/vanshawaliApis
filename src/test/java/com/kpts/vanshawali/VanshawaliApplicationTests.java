package com.kpts.vanshawali;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.kpts.vanshawali.controller.ControllerClass;
import com.kpts.vanshawali.service.ServiceData;

@SpringBootTest(classes = {com.kpts.vanshawali.main.VanshawaliApplication.class})
class VanshawaliApplicationTests {
	
	@Autowired
	ControllerClass controllerClass;
	
	@Autowired
	ServiceData serviceData;

	@Test
	void contextLoads() throws Exception {
        assertThat(controllerClass).isNotNull();
        assertThat(serviceData).isNotNull();
	}

}
