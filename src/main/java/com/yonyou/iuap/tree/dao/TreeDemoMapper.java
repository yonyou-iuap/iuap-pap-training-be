package com.yonyou.iuap.tree.dao;
import com.yonyou.iuap.tree.entity.TreeDemo;
import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import java.util.List;

import org.apache.ibatis.annotations.Param;


@MyBatisRepository
public interface TreeDemoMapper extends GenericExMapper<TreeDemo> {
	
}

