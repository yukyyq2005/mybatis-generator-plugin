package com.kfit;


import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@RequestMapping("/user")
public class FileController {
	@RequestMapping(value = "/youq1")
	public Object index() {
		return "index";
	}
	@RequestMapping("/youq")
	@ResponseBody
    public  Object testjson( ){
    	return  new Product(new Long(10),"dddd","dddd", new Date());
    }
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImage(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) throws Exception {
		
		File dest = new File("/Users/tsningning",file.getOriginalFilename());
		file.transferTo(dest);
		
        return file.getOriginalFilename()+"上传成功！";
    }
	
}
