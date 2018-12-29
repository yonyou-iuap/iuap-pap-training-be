package com.yonyou.iuap.purchaseorder.dao;
import com.yonyou.iuap.purchaseorder.entity.PurchaseOrder;
import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;


@MyBatisRepository
public interface PurchaseOrderMapper extends GenericExMapper<PurchaseOrder> {

}

