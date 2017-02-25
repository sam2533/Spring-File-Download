package com.um.myapp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String INTERNAL_FILE = "Resume-for-Job.pdf";
	private static final String EXTERNAL_FILE = "C:/myTemp/Resume of Saidul.odt";

	@RequestMapping(value = {"/","/welcome"}, method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome To Download Page");
		return "home";
	}
	@RequestMapping(value="/download/{type}", method=RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException{
		File file = null;
		
		if(type.equalsIgnoreCase("internal")){
			ClassLoader loadder = Thread.currentThread().getContextClassLoader();
			file = new File(loadder.getResource(INTERNAL_FILE).getFile());
		}else{
			file = new File (EXTERNAL_FILE);
		}
		if(!file.exists()){
			String errorMsg = "Sorry, File cannot be found";
			System.out.println(errorMsg);
			OutputStream outStream = response.getOutputStream();
			outStream.write(errorMsg.getBytes(Charset.forName("UTF-8")));
			outStream.close();
			return ;
		}
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType == null){
			System.out.println("Mime Type is not detectable, will take default....");
			mimeType = "application/octet-stream";
		}
		System.out.println("Mime Type: "+mimeType);
		response.setContentType(mimeType);
		
		/* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
        while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
		response.setHeader("Content-Disposition", String.format("inline;filename=\""+ file.getName() + "\""));
		response.setContentLength((int) file.length());
		
		InputStream inStream = new BufferedInputStream(new FileInputStream(file));
		
		//Copy file from storage to the destination
		FileCopyUtils.copy(inStream, response.getOutputStream());
	}
	
}
