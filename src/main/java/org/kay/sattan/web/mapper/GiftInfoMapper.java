package org.kay.sattan.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.kay.sattan.web.entity.GiftInfo;

public interface GiftInfoMapper {
	@Select("select * from giftInfo")
	public List<GiftInfo> queryForAll();
}
