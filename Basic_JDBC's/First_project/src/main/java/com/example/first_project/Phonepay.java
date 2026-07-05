package com.example.first_project;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name ="payment",havingValue = "Phonepay")
public class Phonepay implements PaymentInterface {
// just made for practise sam
    public String pay(){
        int no=36;
        String name="Phonepay";
        String Color="purple";
        return "paid with "+name+" of theme "+Color+" number "+no+" done ";
    }
}
