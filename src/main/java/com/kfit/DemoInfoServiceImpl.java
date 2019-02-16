package com.kfit;

import javax.annotation.Resource;
//import javax.transaction.Transactional;
//import javax.persistence.Cacheable;

import com.kfit.dao.RoleMapper;
import com.kfit.dao.StuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
//import org.apache.el.stream.Optional;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.kfit.domain.Stu;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoInfoServiceImpl implements DemoInfoService {
    //这里的单引号不能少，否则会报错，被识别是一个对象;
//    public static final String CACHE_KEY = "'demoInfo'";
//    public static final String DEMO_CACHE_NAME = "demo";

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    //@Resource
    // private RedisTemplate<String, String> redisTemplate;

    //@Resource
    private DemoInfoRepository demoInfoRepository;

    @Resource
    private StuMapper stuMapper;

    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleServiceImpl1 roleServiceImpl1;

    //@Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    void test2(Stu stu) {
        stuMapper.insert(stu);
        //int z = 1/0;
    }

    //Acquired Connection
    //@Override
    //@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void test() {

        int num = 0;
        String str = "";
        Stu stu = null;

        //注册
        num =  new Double(Math.random() * 1000000).intValue();
        str = String.valueOf(num);
        stu = new Stu();
        //stu.setName("YOUQIANG" + str);
        stu.setSex("male"+str);
        stu.setAge("35"+str);
        stuMapper.insert(stu);

        //加积分
        try{
            stu = new Stu();
            stu.setName("YOUQIANG" + str);
            stu.setSex("male"+str);
            stu.setAge("35"+str);
            roleService.test2(stu);
        }catch (Exception e){
            e.printStackTrace();
        }




//
//        List<Stu> list = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            num = new Double(Math.random() * 1000000).intValue();
//            str = String.valueOf(num);
//            stu = new Stu();
//            if (i == 0) {
//                stu.setName("hell0" + str);
//            }
//            if (i == 2) {
//                stu.setName("hell2" + str);
//            }
//            if (i == 4) {
//                stu.setName("hell4" + str);
//            }
//            stu.setSex("male" + str);
//            stu.setAge("35t" + str);
//            try {
//                roleService.test2(stu);
//                //roleServiceImpl1.test2(stu);
//               // this.test2(stu);
//            } catch (Exception e) {
//                e.printStackTrace();
//              //  throw e;
//                //throw new RuntimeException("排除自定义异常，让spring回归事务");
//            }
//        }




        // ValueOperations<String, String> valueOperations =
        // redisTemplate.opsForValue();
        // valueOperations.set("mykey4", "random1=" + Math.random());
        // System.out.println(valueOperations.get("mykey4"));
    }


    @Override
    //@Transactional //事务
    public void save(demoinfo User) {


        // return demoInfoRepository.save(User);
    }

    // keyGenerator="myKeyGenerator"
    // @Cacheable(value="demoInfo") //缓存,这里没有指定key.
    //Cacheable(cacheNames="EvrAlarms",key="'EvrAlarm-'+#accountId")
    //@Cacheable(cacheNames="EvrAlarms")
    //@EnableElastiCache({@CacheClusterConfig(name = "fs-redis-cache")})
    @Override
    @Cacheable(value = "users", key = "'user_'+#id", unless = "#result == null")
    //@Cacheable(value="mysql:findByid:role", keyGenerator="simpleKey")
    public demoinfo findById(int id) {

        demoinfo info1 = new demoinfo();
        info1.setId(1);
        Example<demoinfo> exam = Example.of(info1);
        //List<demoinfo> lists = demoInfoRepository.findAll(exam);

        System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
//        return demoInfoRepository.findById(id).get();
        demoinfo info = null;
        try {
            // info = demoInfoRepository.findById(id).get();
        } catch (Exception e) {
            System.err.println("程序抛出异常 youqiang");
            e.printStackTrace();
        }

        // demoInfoRepository.findById(id);

        return info;
    }

    // @CacheEvict(value = "demoInfo")
    //@Override
    public void deleteFromCache(int id) {
        System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
    }

//    public  demoinfo getdemoinfoById(int id){
//        return demoInfoRepository.getdemoinfoById(id);
//    }
//    public List<demoinfo> querydemoinfosByNameLike(String name){
//        return demoInfoRepository.querydemoinfosByNameLike(name);
//    }

}
