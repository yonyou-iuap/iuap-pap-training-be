package com.yonyou.iuap.model.service;

import com.yonyou.iuap.baseservice.intg.service.GenericIntegrateService;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import com.yonyou.iuap.model.dao.ModelMapper;
import com.yonyou.iuap.model.entity.Model;
import com.yonyou.uap.busilog.annotation.LogConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import java.util.List;

@Service

/**
 * Model CRUD 核心服务,提供逻辑删除/乐观锁
 */
public class ModelService extends GenericIntegrateService<Model> {

	private ModelMapper modelMapper;

	@Autowired
	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		super.setGenericMapper(modelMapper);
	}

	@Override
	@LogConfig(busiCode = "model_deleteBatch", busiName = "视图模型", operation = "视图模型删除", templateId = "model_deleteBatch")
	public int deleteBatch(List<Model> list) {
		return super.deleteBatch(list);
	}

	@Override
	@LogConfig(busiCode = "model_updateSelective", busiName = "视图模型", operation = "视图模型修改", templateId = "model_updateSelective")
	public Model updateSelective(Model entity) {
		return super.updateSelective(entity);
	}

	@Override
	@LogConfig(busiCode = "model_insertSelective", busiName = "视图模型", operation = "视图模型添加", templateId = "model_insertSelective")
	public Model insertSelective(Model entity) {
		return super.insertSelective(entity);
	}

	/**
	 * @CAU 可插拔设计
	 * @return 向父类 GenericIntegrateService 提供可插拔的特性声明
	 */
	@Override
	protected ServiceFeature[] getFeats() {
		return new ServiceFeature[] { REFERENCE, LOGICAL_DEL, MULTI_TENANT };
	}

}