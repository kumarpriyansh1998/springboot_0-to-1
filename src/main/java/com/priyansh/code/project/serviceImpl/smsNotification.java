package com.priyansh.code.project.serviceImpl;

import com.priyansh.code.project.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
@Primary
//@ConditionalOnProperty(name="notification.type",havingValue = "sms")
public class smsNotification implements NotificationService {
    @Override
    public void send() {
        System.out.println("sending sms notification");
    }
}
