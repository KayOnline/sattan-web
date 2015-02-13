package org.kay.sattan.web.entity;

import java.io.Serializable;
import java.util.Date;

public class GameInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int gameId;
	private String gameName;
	private int bookSize;
	private GiftInfo giftInfo;
	private byte[] coverImage;
	private Date createTime;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int getBookSize() {
		return bookSize;
	}

	public void setBookSize(int bookSize) {
		this.bookSize = bookSize;
	}

	public byte[] getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public GiftInfo getGiftInfo() {
		return giftInfo;
	}

	public void setGiftInfo(GiftInfo giftInfo) {
		this.giftInfo = giftInfo;
	}

}
