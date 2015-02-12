package org.kay.zoo.sheep.framework;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class ExtFreeMarkerView extends FreeMarkerView {
	
	private static final String CONTEXT_PATH = "basePath";

	@Override
	protected void exposeHelpers(Map<String, Object> model,
			HttpServletRequest request) throws Exception {
		// Can use ${basePath} in ftl
		model.put(CONTEXT_PATH, request.getContextPath());
		super.exposeHelpers(model, request);
	}

}
