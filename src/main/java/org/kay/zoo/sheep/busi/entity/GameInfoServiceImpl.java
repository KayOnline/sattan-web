package org.kay.zoo.sheep.busi.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;

@Service(value = "gameInfoService")
public class GameInfoServiceImpl implements GameInfoService {

	private static Logger logger = Logger.getLogger(GameInfoServiceImpl.class);
	
	@Autowired
	private Dao<GameInfo, String> gameInfoDao;
	
	@Autowired
	private Dao<GiftInfo, String> giftInfoDao;

	public Dao<GameInfo, String> getGameInfoDao() {
		return gameInfoDao;
	}

	public void setGameInfoDao(Dao<GameInfo, String> gameInfoDao) {
		this.gameInfoDao = gameInfoDao;
	}

	public List<GameInfo> queryForAll() {
		try {
			List<GameInfo> gameInfoList = this.gameInfoDao.queryForAll();
			for(GameInfo gameInfo : gameInfoList) {
				System.out.println(gameInfo.getGiftInfo().getGiftName());
			}
			return this.gameInfoDao.queryForAll();
		} catch (SQLException e) {
			logger.error(e.getMessage(), new RuntimeException(e));
		}
		return new ArrayList<GameInfo>();
	}
	
	public int createOrUpdate(GameInfo gameInfo) {
		try {
			CreateOrUpdateStatus status = this.gameInfoDao.createOrUpdate(gameInfo);
			return status.getNumLinesChanged();
		} catch (SQLException e) {
			logger.error(e.getMessage(), new RuntimeException(e));
		}
		return 0;
	}
	
	public int deleteById(String id) {
		try {
			return this.gameInfoDao.deleteById(id);
		} catch (SQLException e) {
			logger.error(e.getMessage(), new RuntimeException(e));
		}
		return 0;
	}
	
}
