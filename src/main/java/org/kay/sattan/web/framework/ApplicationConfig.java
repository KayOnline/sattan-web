package org.kay.sattan.web.framework;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApplicationConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> props = new HashMap<String, Object>();

	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}

}
