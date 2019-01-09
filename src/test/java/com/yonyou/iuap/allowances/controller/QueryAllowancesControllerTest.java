package com.yonyou.iuap.allowances.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.pap.base.utils.http.RestRequestUtil;
import com.yonyou.iuap.test.JUnit4SpringRootConfig;
import com.yonyou.iuap.test.TestContextConfig;

public class QueryAllowancesControllerTest extends JUnit4SpringRootConfig {
	private MockMvc mockMvc;

	@Autowired
	private AllowancesService allowancesService;

	@Autowired
	private StatCommonService statCommonService;
	
	@Before
	public void setup() {

		Assert.notNull(allowancesService);

		QueryAllowancesController demoCtrl = new QueryAllowancesController();

		// demoService = mock(DemoService.class);

		ReflectionTestUtils.setField(demoCtrl, "allowancesService", allowancesService);
		ReflectionTestUtils.setField(demoCtrl, "statCommonService", statCommonService);

		mockMvc = MockMvcBuilders.standaloneSetup(demoCtrl)
				.setMessageConverters(TestContextConfig.objectMapperHttpMessageConverter()).build();
		
		InvocationInfoProxy.setTenantid("tenant");//租户信息
	}
	
	//debug模式 SearchParamUtil.processServiceParams方法断点 
	@Test
	public void testDistinct() throws Exception {
		Map<String, Object> searchMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("dept");
		searchMap.put("distinctParams", list);
		ResultActions result = mockMvc.perform(post("/query_allowances/distinct").contentType(MediaType.APPLICATION_JSON)
				.content(convertObjectToJsonBytes(searchMap)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}
	//PageRequest 没有默认构造方法 需要删除controller中PageRequest
	/*@Test
	public void testList() throws Exception {
		Map<String, Object> searchMap = new HashMap<>();
		ResultActions result = mockMvc.perform(post("/query_allowances/list?pageIndex=0&pageSize=10")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(searchMap)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}*/

}
