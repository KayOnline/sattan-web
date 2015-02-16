package org.kay.sattan.web.service.impl;

import org.kay.sattan.web.service.DataReloadService;
import org.springframework.stereotype.Service;

@Service("dataReloadService")
public class DataReloadServiceImpl implements DataReloadService {

	public void execute() {
		System.out.println("OK");
	}

}
