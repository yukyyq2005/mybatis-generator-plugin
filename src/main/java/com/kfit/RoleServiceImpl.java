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

    //

    /*
    NESTED和REQUIRED修饰的内部方法都属于外围方法事务，如果外围方法抛出异常，这两种方法的事务都会被回滚。
    但是REQUIRED是加入外围方法事务，所以和外围事务同属于一个事务，一旦REQUIRED事务抛出异常被回滚，外围方法事务也将被回滚。
    而NESTED是外围方法的子事务，有单独的保存点，所以NESTED方法抛出异常被回滚，不会影响到外围方法的事务。

    NESTED和REQUIRES_NEW都可以做到内部方法事务回滚而不影响外围方法事务。
    但是因为NESTED是嵌套事务，所以外围方法回滚之后，作为外围方法事务的子事务也会被回滚。
    而REQUIRES_NEW是通过开启新的事务实现的，内部事务和外围事务是两个事务，外围事务回滚不会影响内部事务。
    原文：https://blog.csdn.net/haoxin963/article/details/81776718
    */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
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
