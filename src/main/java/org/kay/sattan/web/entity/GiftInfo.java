package org.kay.sattan.web.entity;

import java.io.Serializable;

public class GiftInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int giftId;
	private String giftName;
	private GameInfo gameInfo;

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

	public String getGiftName() {
		return giftName;
	}

	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}

	public GameInfo getGameInfo() {
		return gameInfo;
	}

	public void setGameInfo(GameInfo gameInfo) {
		this.gameInfo = gameInfo;
	}

}
