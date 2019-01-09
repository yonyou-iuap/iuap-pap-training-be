package com.yonyou.iuap.allowances.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.statistics.service.StatCommonService;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.mvc.type.SearchParams;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:t-service-persistence.xml" })
public class AllowancesServiceTest {
	@Autowired
	private AllowancesService allowancesService;

	@Autowired
	private StatCommonService statCommonService;
			
	Allowances entity = null;
	List<Allowances> listData = null;
    @Before
    public void init(){
    	Assert.assertNotNull(allowancesService);
    	
    	InvocationInfoProxy.setTenantid("tenant");//租户信息
    	
    	entity = new Allowances();
    	entity.setId("test2");
    	entity.setCode("test2");
    	entity.setDr(0);
    	entity.setTs("test2");
    	entity.setBpmState(0);
    	entity.setTenantid("tenant");
    	
    	listData = new ArrayList<>();
		listData.add(entity);
    }

    @Test
	public void testInsertSelective() {
		Allowances allowances = allowancesService.insertSelective(entity);
		Assert.assertNotNull(allowances);
	}
    
	@Test
	public void testUpdateSelective() {
		Allowances allowances = allowancesService.updateSelective(entity);
		Assert.assertNotNull(allowances);
	}
	/*
	@Test
	public void testSaveMultiple() {
		allowancesService.saveMultiple(listData);
	}
	
	@Test
	public void testUpdateMultiple() {
		allowancesService.updateMultiple(listData);
	}*/
	/*//debug模式
	@Test
	public void testSelectAllByPage() {
		PageRequest pageRequest = new PageRequest(0, 10, null);
    	SearchParams searchParams = new SearchParams();
    	Page<Map> selectFieldsByPage = statCommonService.selectFieldsByPage(pageRequest, searchParams, "Allowances");
    	Assert.assertNotNull(selectFieldsByPage.getContent());
    	System.out.println("selectFieldsByPageCount======"+selectFieldsByPage.getContent().size());
	}
	//debug模式
	@Test
	public void testDistinct() {
    	SearchParams searchParams = new SearchParams();
    	List<String> list = new ArrayList<>();
    	list.add("dept");
    	searchParams.getSearchMap().put("distinctParams",list);
    	List<Map> findDistinct = statCommonService.findDistinct(searchParams, "Allowances");
    	Assert.assertNotNull(findDistinct);
    	System.out.println("findDistinctCount======"+findDistinct.size());
	}*/

}
