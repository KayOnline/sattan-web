package org.kay.sattan.web.service;

import java.util.List;

import org.kay.sattan.web.entity.GameInfo;

public interface GameInfoService {
	public List<GameInfo> queryForAll();
	public int createOrUpdate(GameInfo gameInfo);
	public int deleteById(String id);
}
