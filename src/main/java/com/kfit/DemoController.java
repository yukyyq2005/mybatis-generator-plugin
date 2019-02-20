package com.kfit;

import com.kfit.domain.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.kfit.Product;

import static java.lang.StrictMath.random;

@RestController
//@RequestMapping("/demo")
public class DemoController {

//    @Value("${live.accessKeyId}")
//    private String accessKeyId;

	@Autowired
	DemoInfoService demoInfoService;

	@Autowired
	private RoleService roleService;
	static int i = 1;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	// 有注解参数，RequestParam默认参数不允许为空，可以配置required进行改变
	@RequestMapping(value = "/add.do", method = RequestMethod.GET)
	public ResponseVo addManageType(@RequestParam(value = "parentId") String parentId,
			@RequestParam(value = "typeName", required = false, defaultValue = "333") String typeName,
			HttpServletRequest request) throws Exception {

//        System.out.println(parentId + typeName);

		boolean allEmpty = false;
		Enumeration paraEnum = request.getParameterNames();
		while (paraEnum.hasMoreElements()) {
			String param = (String) paraEnum.nextElement();
//            String[] params = request.getParameterValues(param);
			String params = request.getParameter(param);
			System.out.println(param + ": " + params);
//            if(params!=null&params.length>0){
//                System.out.println(params);
//                allEmpty = true;
//                break;
//            }
		}

		return ResponseVo.getSuccResult(3);
	}

	@PostMapping("/pojo")
	public Product pojo(@Valid @RequestBody Product pojo, Error error) {
		return pojo;
	}

    @GetMapping("/testd")
    public  Object testjson( ){
    	return  new Product(new Long(247823),"rrr","helloworld12dd", new Date());
    }

	@GetMapping("/name")
	// 无注解参数，要求和前端参数名称保持一致，参数允许为空
	public Map<String, Object> paramName(String[] names, @RequestParam("nums") Long[] ids) {
		Map<String, Object> result = new HashMap<>();
		result.put("names", names);
		result.put("ids", ids);
		return result;
	}

	@GetMapping("/test")
	public String test() {
		try {
			demoInfoService.test();

//            Stu stu = new Stu();
//            stu.setName("hell2");
//            stu.setSex("male");
//            stu.setAge("350");
//            roleService.test2(stu);

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
			// throw new RuntimeException("排除自定义异常，让spring回归事务");
		}

		// demoinfo loaded = demoInfoService.findById(1);
//		System.out.println("loaded=" + loaded);
//		DemoInfo cached = demoInfoService.findById(1);
//		System.out.println("cached=" + cached);
//		loaded = demoInfoService.findById(2);
//		System.out.println("loaded2=" + loaded);
//
//        for (int g = 0; g <= 2000000; g++) {
//            int num = new Double(Math.random() * 1000000).intValue();
//            String str = String.valueOf(num);
//            demoinfo user = new demoinfo();
//            user.setId(i++);
//            user.setName("youqiang" + str);
//            user.setPwd("123478" + str);
//            demoinfo demoInfo2 = demoInfoService.save(user);
//        }

		// System.out.println(demoInfoService.findById(4));

//        ValueOperations<String, String> ops = redisTemplate.opsForValue();
//        ops.set("user", "HELLO", 1, TimeUnit.MINUTES);

		// 加载java配置类获取Spring应用上下文
//        ApplicationContext ac = new AnnotationConfigApplicationContext(MediePlayerConfig.class);
//        //获取播放器
//        MediaPlayer player= ac.getBean(MediaPlayer.class);
//        //播放
//        player.play();

		return "ok";
	}

	@RequestMapping("/zeroException")
	public int zeroException() {
		return 100 / 2;
	}
}
