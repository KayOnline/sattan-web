package org.kay.sattan.web.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class GiftInfo {

	@DatabaseField(generatedId = true)
	private int giftId;

	@DatabaseField(canBeNull = false)
	private String giftName;

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

}
