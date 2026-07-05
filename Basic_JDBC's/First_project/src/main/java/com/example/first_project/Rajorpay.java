package com.example.first_project;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@ConditionalOnProperty(name = "payment",havingValue="Rajorpay")

public class Rajorpay implements PaymentInterface{
    public String pay(){
        String payment =" razor pay";
        System.out.println(payment);
        return payment;
    }
}
