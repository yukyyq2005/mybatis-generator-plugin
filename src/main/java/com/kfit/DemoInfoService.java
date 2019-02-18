package com.kfit;

import com.kfit.domain.Stu;

import java.util.List;

public interface DemoInfoService {
    public void save(demoinfo User);

    public demoinfo findById(int id);

    public void deleteFromCache(int id);

    Stu test();

    //public  demoinfo getdemoinfoById(int id);
//    public List<demoinfo> querydemoinfosByNameLike(String name);
}
