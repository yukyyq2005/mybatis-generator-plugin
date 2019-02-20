package com.kfit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KfitApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
    @Test
    public void contextLoads() {
    	
    	System.out.println("hello");
    	TestCase.assertEquals(1, 1);
    }
    @Test
    public void webappBookIsbnApi() throws Exception {
        System.out.println("中文测试");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/get")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = result.getResponse().getStatus();
        System.out.println(status);
    }
    @Test
    public void webappBookIsbnApidd() {
        System.out.println("中文测试1");
    }
    
//    @Before
//    public void testBeforedfad() {
//    	System.out.println("before_aa");
//    }
//    @After
//    public void testddAfter() {
//    	System.out.println("after_bb");
//    }
}

