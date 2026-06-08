package com.priyansh.code.project.serviceImpl;

import com.priyansh.code.project.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("mail")
//@ConditionalOnProperty(name="notification.type",havingValue = "email")
public class emailNotification implements NotificationService {
    @Override
    public void send() {
        System.out.println("sending email notification");

    }
}
