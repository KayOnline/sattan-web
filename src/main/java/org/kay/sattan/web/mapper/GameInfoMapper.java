package org.kay.sattan.web.mapper;

import java.util.List;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.kay.sattan.web.entity.GameInfo;

@CacheNamespace(implementation = org.mybatis.caches.ehcache.EhcacheCache.class)
public interface GameInfoMapper {
	
	@Lang(XMLLanguageDriver.class)
	@Options(flushCache=false, useCache=true)
	@Select("<script>select * from gameInfo <if test=\"gameId!=null\">where gameId = #{gameId}</if></script>")
	@Results({
//		@Result(column = "gameId", property = "gameId"),
//		@Result(column = "gameName", property = "gameName"),
//		@Result(column = "bookSize", property = "bookSize"),
//		@Result(column = "createTime", property = "createTime", javaType = java.util.Date.class),
		@Result(property = "giftInfos", column = "gameId", javaType = List.class, many = @Many(select="org.kay.sattan.web.mapper.GiftInfoMapper.queryByGameId"))
	})
	public List<GameInfo> query(@Param(value="gameId") String gameId);
	
	@Select("select * from gameInfo where gameId = #{gameId}")
	public GameInfo queryById(@Param(value="gameId") String gameId);
	
	@Options(flushCache=true, useCache=false)  
	@Insert("insert into gameInfo(gameName, bookSize, createTime) values (#{gameInfo.gameName}, #{gameInfo.bookSize}, #{gameInfo.createTime}")
	public int save(@Param(value="gameInfo") GameInfo gameInfo);
	
	@Options(flushCache=true, useCache=false)
	@Update("update gameInfo set gameName=#{gameInfo.gameName}, bookSize=#{gameInfo.bookSize}, createTime=#{gameInfo.createTime} where gameId=#{gameInfo.gameId}")
	public int update(@Param(value="gameInfo") GameInfo gameInfo);
	
	@Options(flushCache=true, useCache=false)
	@Delete("delete from gameInfo where gameId = #{gameId}")
	public int remove(@Param(value="gameId") String gameId);
	 
}
