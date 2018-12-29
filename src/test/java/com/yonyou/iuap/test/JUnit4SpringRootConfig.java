package com.yonyou.iuap.test;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static com.yonyou.iuap.test.TestContextConfig.objectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//@ComponentScan(basePackages = { "com.yonyou.iuap" })
@ContextConfiguration(locations = { "classpath:t-controller-persistence.xml" })
//@WebAppConfiguration
public class JUnit4SpringRootConfig {
	
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = objectMapper();
        return mapper.writeValueAsBytes(object);
    }

}
