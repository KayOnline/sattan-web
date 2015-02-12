package org.kay.zoo.sheep.busi.entity;

import java.util.List;

public interface GameInfoService {
	public List<GameInfo> queryForAll();
	public int createOrUpdate(GameInfo gameInfo);
	public int deleteById(String id);
}
