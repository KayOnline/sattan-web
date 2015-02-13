package org.kay.sattan.web.dao.impl;

import java.util.List;

import org.kay.sattan.web.dao.GameInfoDao;
import org.kay.sattan.web.entity.GameInfo;
import org.kay.sattan.web.mapper.GameInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameInfoDaoImpl implements GameInfoDao {
	
	@Autowired
	private GameInfoMapper gameInfoMapper;

	public List<GameInfo> queryForAll() {
		return this.gameInfoMapper.queryForAll();
	}

	public int createOrUpdate(GameInfo gameInfo) {
		if (gameInfo.getGameId() < 1) {
			return this.gameInfoMapper.save(gameInfo);
		} else {
			return this.gameInfoMapper.update(gameInfo);
		}
	}

	public int deleteById(String id) {
		return this.gameInfoMapper.remove(id);
	}
	
}
