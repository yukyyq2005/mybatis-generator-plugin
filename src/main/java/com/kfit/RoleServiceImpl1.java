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
 * @date ：Created in 2019/2/16 23:28
 * @modified By：
 */
@Service
public class RoleServiceImpl1 {
    @Resource
    private StuMapper stuMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void test2(Stu s) {

        stuMapper.insert(s);
    }
}
