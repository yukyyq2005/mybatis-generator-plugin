package com.kfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kfit.Role;

import javax.annotation.Resource;

import static java.lang.Thread.sleep;

@RestController
@SpringBootApplication
public class KfitApplication {

    @Resource
    private Role roledd;

    @RequestMapping("/")
    public String hello() {


        Runnable x = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println(this.getClass());
                }
            }
        };
        Thread t = new Thread(x);
        t.start();

        System.out.println("hello" + roledd.a);

        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(KfitApplication.class, args);

    }

}

