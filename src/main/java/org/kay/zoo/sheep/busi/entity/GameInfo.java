package org.kay.zoo.sheep.busi.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "gameInfo")
public class GameInfo {
	@DatabaseField(generatedId = true)
	private int gameId;

	@DatabaseField
	private String gameName;

	@DatabaseField
	private int bookSize;

	@DatabaseField(columnName = "giftId", foreign = true, foreignAutoRefresh = true)
	private GiftInfo giftInfo;

	@DatabaseField(dataType = DataType.BYTE_ARRAY)
	private byte[] coverImage;

	@DatabaseField
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
