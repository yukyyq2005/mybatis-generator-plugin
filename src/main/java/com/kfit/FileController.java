package com.kfit;


import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
