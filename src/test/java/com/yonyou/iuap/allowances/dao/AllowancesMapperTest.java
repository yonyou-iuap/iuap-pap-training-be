package com.yonyou.iuap.allowances.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yonyou.iuap.allowances.entity.Allowances;
import com.yonyou.iuap.baseservice.statistics.dao.StatCommonMapper;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.mybatis.type.PageResult;


@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = { "com.yonyou.iuap" })
@ContextConfiguration(locations = { "classpath:t-dao-persistence.xml" })
public class AllowancesMapperTest {
    @Autowired
    AllowancesMapper allowancesMapper;
    
    @Autowired
	private StatCommonMapper StatCommonMapper;
    
    Allowances entity = null;
    @Before
    public void init(){
    	Assert.assertNotNull(allowancesMapper);
    	
    	InvocationInfoProxy.setTenantid("tenant");//租户信息
    	
    	entity = new Allowances();
    	entity.setId("test1");
    	entity.setCode("test1");
    	entity.setDr(0);
    	entity.setTs("test1");
    	entity.setBpmState(0);
    	entity.setTenantid("tenant");
    }
        
    @Test
    public void testList(){
    	PageRequest paramPageRequest = new PageRequest(0, 10, null);
    	SearchParams paramSearchParams = new SearchParams();
    	Set<String> groupStatements = new HashSet<>();
    	groupStatements.add("*");
    	PageResult<Map> pageResult = StatCommonMapper.selectAllByPage(paramPageRequest, paramSearchParams, "IUAPD_ALLOWANCES", null, groupStatements, null);
    	Assert.assertNotNull(pageResult.getContent());
    	System.out.println("count======"+pageResult.getContent().size());
    }
    
  /* @Test
    public void testInsertSelective(){
    	int insertSelective = allowancesMapper.insertSelective(entity);
    	Assert.assertEquals(1, insertSelective);
    	System.out.println("insertSelective="+insertSelective);
    }
    
    @Test
    public void testUpdateSelective(){
    	entity.setName("test1");
    	int updateSelective = allowancesMapper.updateSelective(entity);
    	Assert.assertEquals(1, updateSelective);
    	System.out.println("updateSelective="+updateSelective);
    }
    
    @Test
    public void testGet() {
    	Map<String, Object> paramMap = new HashMap<>();
    	paramMap.put("id", "test1");
    	List<Allowances> queryList = allowancesMapper.queryList(paramMap);
    	Assert.assertNotNull(queryList);
    	System.out.println("queryList的size="+queryList.size());
    	if(queryList.size()>0){
    		entity = queryList.get(0);
    	}
    }
    @Test
    public void testDelete() {
    	int deleted = allowancesMapper.update(entity);
    	Assert.assertEquals(1, deleted);
    	System.out.println("deleted="+deleted);
    }
    
    @Test
    public void testDistinct(){
    	Set<String> statStatements = new HashSet<>();
    	statStatements.add("DEPT");
    	List<Map<String, Object>> whereStatements = new ArrayList<>();
    	List<Map> findDistinct = StatCommonMapper.findDistinct(statStatements, "iuapd_allowances", whereStatements);
    	Assert.assertNotNull(findDistinct);
    	System.out.println("findDistinctCount======"+findDistinct.size());
    }
*/
}
