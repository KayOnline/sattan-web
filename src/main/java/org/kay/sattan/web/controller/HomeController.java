package org.kay.sattan.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.kay.sattan.web.entity.GameInfo;
import org.kay.sattan.web.framework.JsonUtils;
import org.kay.sattan.web.service.GameInfoService;
import static org.kay.sattan.web.framework.JsonResponse.*;


@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private GameInfoService gameInfoService;

	/*@RequestMapping(value = "upload")
	public String upload(@RequestParam("Filedata") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		long fileSize = file.getSize() / 1024;
		System.out.println(fileName + "~~" + fileSize);
		try {
			InputStream is = file.getInputStream();
			FileOutputStream fos = new FileOutputStream("D:\\" + fileName);
			byte[] buffer = new byte[1024];
			while (is.read(buffer) != -1) {
				fos.write(buffer);
			}
			;
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/shee_res/jsp/upload";
	}*/

	@RequestMapping(value = "init")
	public ModelAndView init() {
		List<GameInfo> gameInfoList = this.gameInfoService.queryForAll();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gameInfoList", gameInfoList);
		return new ModelAndView("home", model);
	}
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
		String pattern = "yyyy-MM-dd HH:mm:ss";
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat(pattern), true, 19);
		binder.registerCustomEditor(Date.class, dateEditor);   
	}
	
	@RequestMapping(value="del/{id}")
	@ResponseBody
	public String delRecord(@PathVariable String id) {
		int ret = this.gameInfoService.deleteById(id);
		BaseJsonResponse response = ret > 0 ? new SuccessJsonResponse() : new FailureJsonResponse();
		String json = JsonUtils.writeValueAsString(response);
		return json;
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public String saveRecord(@ModelAttribute("gameInfo") GameInfo gameInfo, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
		}
		int ret = this.gameInfoService.createOrUpdate(gameInfo);
		BaseJsonResponse response = ret > 0 ? new SuccessJsonResponse() : new FailureJsonResponse();
		String json = JsonUtils.writeValueAsString(response);
		return json;
	}

	public GameInfoService getGameInfoService() {
		return gameInfoService;
	}

	public void setGameInfoService(GameInfoService gameInfoService) {
		this.gameInfoService = gameInfoService;
	}

}
