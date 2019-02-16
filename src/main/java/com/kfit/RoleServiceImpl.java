package com.kfit;

import com.kfit.dao.StuMapper;
import com.kfit.domain.Stu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ：youq
 * @date ：Created in 2019/2/16 23:17
 * @modified By：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private StuMapper stuMapper;

    @Override
    //@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public void test2(Stu s) {
//        Stu stu1 = new Stu();
//        stu1.setName("hell2" );
//        stu1.setSex("male");
//        stu1.setAge("350");
//        stuMapper.insert(stu1);
//
//        stu1 = new Stu();
//        //stu1.setName("hell2" );
//        stu1.setSex("male");
//        stu1.setAge("350");
//        try {
            stuMapper.insert(s);
            //roleServiceImpl1.test2(stu);
            // this.test2(stu);
//        } catch (Exception e) {
//            throw new RuntimeException("子方法异常，让spring回归子方法事务");
//        }
    }
}
