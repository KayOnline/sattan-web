package org.kay.sattan.web.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.kay.sattan.web.dao.GameInfoDao;
import org.kay.sattan.web.dao.GiftInfoDao;
import org.kay.sattan.web.entity.GameInfo;
import org.kay.sattan.web.service.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "gameInfoService")
public class GameInfoServiceImpl implements GameInfoService {

	private static Logger logger = Logger.getLogger(GameInfoServiceImpl.class);
	
	@Autowired
	private GameInfoDao gameInfoDao;
	
	@Autowired
	private GiftInfoDao giftInfoDao;


	public List<GameInfo> queryForAll() {
		List<GameInfo> gameInfoList = this.gameInfoDao.queryForAll();
		return gameInfoList;
	}
	
	public int createOrUpdate(GameInfo gameInfo) {
		return this.gameInfoDao.createOrUpdate(gameInfo);
	}
	
	public int deleteById(String id) {
		return this.gameInfoDao.deleteById(id);
	}
	
}
