package com.yonyou.iuap.allowances.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.allowances.service.AllowancesEnumService;
import com.yonyou.iuap.allowances.service.AllowancesService;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.test.JUnit4SpringRootConfig;
import com.yonyou.iuap.test.TestContextConfig;

public class AllowancesControllerTest extends JUnit4SpringRootConfig {
	private MockMvc mockMvc;

	@Autowired
	private AllowancesService allowancesService;

	@Autowired
	private StatCommonService statCommonService;

	Allowances entity = null;
	List<Allowances> listData = null;

	@Before
	public void setup() {

		Assert.notNull(allowancesService);

		PopupAllowancesController demoCtrl = new PopupAllowancesController();

		// demoService = mock(DemoService.class);

		ReflectionTestUtils.setField(demoCtrl, "allowancesService", allowancesService);
		ReflectionTestUtils.setField(demoCtrl, "statCommonService", statCommonService);

		mockMvc = MockMvcBuilders.standaloneSetup(demoCtrl)
				.setMessageConverters(TestContextConfig.objectMapperHttpMessageConverter()).build();

		entity = new Allowances();
		entity.setId("test3");
		entity.setCode("test3");
		entity.setDr(0);
		entity.setTs("test3");
		entity.setBpmState(0);
		entity.setTenantid("tenant");

		listData = new ArrayList<>();
		listData.add(entity);
	}

//	@Test
//	public void testGet() throws Exception {
//		ResultActions result = mockMvc.perform(get("/allowances/get?search_id=0788f30730204b0983401b28fd99288c"));
//		String contentAsString = result.andReturn().getResponse().getContentAsString();
//		System.out.println("contentAsString====" + contentAsString);
//	}

	@Test
	public void testInsertSelective() throws Exception {
		ResultActions result = mockMvc.perform(post("/allowances/insertSelective")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(entity)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}

	@Test
	public void testUpdateSelective() throws Exception {
		ResultActions result = mockMvc.perform(post("/allowances/updateSelective")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(entity)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}

	@Test
	public void testSaveMultiple() throws Exception {
		ResultActions result = mockMvc.perform(post("/allowances/saveMultiple").contentType(MediaType.APPLICATION_JSON)
				.content(convertObjectToJsonBytes(listData)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}

	@Test
	public void testUpdateMultiple() throws Exception {
		ResultActions result = mockMvc.perform(post("/allowances/updateMultiple")
				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(listData)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}
	//debug模式
	@Test
	public void testDistinct() throws Exception {
		Map<String, Object> searchMap = new HashMap<>();
		List<String> list = new ArrayList<>();
		list.add("dept");
		searchMap.put("distinctParams", list);
		ResultActions result = mockMvc.perform(post("/allowances/distinct").contentType(MediaType.APPLICATION_JSON)
				.content(convertObjectToJsonBytes(searchMap)));
		String contentAsString = result.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
	}
	
//	@Test
//	public void testList() throws Exception {
//		Map<String, Object> searchMap = new HashMap<>();
//		ResultActions result = mockMvc.perform(post("/allowances/list?pageIndex=0&pageSize=10")
//				.contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonBytes(searchMap)));
//		String contentAsString = result.andReturn().getResponse().getContentAsString();
//		System.out.println(contentAsString);
//	}

}
