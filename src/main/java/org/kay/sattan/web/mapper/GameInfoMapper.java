package org.kay.sattan.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.kay.sattan.web.entity.GameInfo;

public interface GameInfoMapper {
	
	@Select("select * from gameInfo")
	public List<GameInfo> queryForAll();
	
	@Insert("insert into gameInfo(gameName, bookSize, createTime) values (#{gameInfo.gameName}, #{gameInfo.bookSize}, #{gameInfo.createTime}")
	public int save(@Param(value="gameInfo") GameInfo gameInfo);
	
	@Update("update gameInfo set gameName=#{gameInfo.gameName}, bookSize=#{gameInfo.bookSize}, createTime=#{gameInfo.createTime} where gameId=#{gameInfo.gameId}")
	public int update(@Param(value="gameInfo") GameInfo gameInfo);
	
	@Delete("delete from gameInfo where gameId = #{gameId}")
	public int remove(@Param(value="gameId") String gameId);
	
}
