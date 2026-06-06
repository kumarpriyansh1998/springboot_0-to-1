package com.priyansh.code.project;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    int val;

    public void setVal(int val){
        this.val = val;
        System.out.println("val is set to"+val);
    }


    @PostConstruct
    public void postConstruct(){
        System.out.println("Post Constructing");
    }

//    @PreDestroy
//    public void preDestroy(){
//        System.out.println("Pre Destroying");
//    }

    public void pay(){
        System.out.println("Paying...");
    }
}
