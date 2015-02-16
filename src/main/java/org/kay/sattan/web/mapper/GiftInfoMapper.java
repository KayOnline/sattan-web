package org.kay.sattan.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.kay.sattan.web.entity.GameInfo;
import org.kay.sattan.web.entity.GiftInfo;

public interface GiftInfoMapper {
	
	@Options(useCache=true, flushCache = false)
	@Results({
		@Result(property = "gameInfo", column = "gameId", javaType = GameInfo.class, one = @One(select = "org.kay.sattan.web.mapper.GameInfoMapper.queryById"))
	})
	@Select("select * from giftInfo")
	public List<GiftInfo> queryForAll();
	
	@Select("select * from giftInfo where giftId = #{giftId}")
	public GiftInfo queryById(@Param(value="giftId") String giftId);
	
	@Options(useCache = true, flushCache = false)
	@Select("select * from giftInfo where gameId = #{gameId}")
	public List<GiftInfo> queryByGameId(@Param(value="gameId") String gameId);
}
