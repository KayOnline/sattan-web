package org.kay.sattan.web.framework;

import java.util.HashMap;
import java.util.Map;

public class JsonResponse {

	public static enum CODE {
		SUCCESS, FAILURE
	}

	public static abstract class BaseJsonResponse {

		private CODE code;
		private Map<String, Object> model = new HashMap<String, Object>();

		public BaseJsonResponse(CODE code) {
			this.code = code;
		}

		public BaseJsonResponse(CODE code, Map<String, Object> model) {
			this.code = code;
			this.model = model;
		}

		public CODE getCode() {
			return code;
		}

		public Map<String, Object> getModel() {
			return model;
		}

	}

	public static class SuccessJsonResponse extends BaseJsonResponse {

		public SuccessJsonResponse(Map<String, Object> model) {
			super(CODE.SUCCESS, model);
		}

		public SuccessJsonResponse() {
			super(CODE.SUCCESS);
		}

	}

	public static class FailureJsonResponse extends BaseJsonResponse {

		public FailureJsonResponse(Map<String, Object> model) {
			super(CODE.FAILURE, model);
		}

		public FailureJsonResponse() {
			super(CODE.FAILURE);
		}

	}

}
