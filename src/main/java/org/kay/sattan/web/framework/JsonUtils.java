package org.kay.sattan.web.framework;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

public abstract class JsonUtils {
	
	private static Logger logger = Logger.getLogger(JsonUtils.class);
	
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper(); 
	}
	
	public static String writeValueAsString(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		} 
	}
	
}
