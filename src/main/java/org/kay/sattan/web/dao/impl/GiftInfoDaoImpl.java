package org.kay.sattan.web.dao.impl;

import java.util.List;

import org.kay.sattan.web.dao.GiftInfoDao;
import org.kay.sattan.web.entity.GiftInfo;
import org.kay.sattan.web.mapper.GiftInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GiftInfoDaoImpl implements GiftInfoDao {

	@Autowired
	private GiftInfoMapper giftInfoMapper;

	public List<GiftInfo> queryForAll() {
		return this.giftInfoMapper.queryForAll();
	}

	public void setMapper(GiftInfoMapper mapper) {
		this.giftInfoMapper = mapper;
	}
	
}
