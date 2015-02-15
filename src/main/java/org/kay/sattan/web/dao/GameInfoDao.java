package org.kay.sattan.web.dao;

import java.util.List;

import org.kay.sattan.web.entity.GameInfo;

public interface GameInfoDao {
	public List<GameInfo> queryForAll();
	public GameInfo queryById(String gameId);
	public int createOrUpdate(GameInfo gameInfo);
	public int deleteById(String id);
}
