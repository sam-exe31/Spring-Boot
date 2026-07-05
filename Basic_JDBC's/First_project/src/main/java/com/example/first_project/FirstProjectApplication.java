package com.example.first_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FirstProjectApplication.class, args);
    }

//    @Autowired
//    private Rajorpay paymentService; // no new keyword
////    @Autowired
//    private Phonepay payService;

//    public FirstProjectApplication(Rajorpay paymentService ,Phonepay payService){
////        this.paymentService=paymentService;
////        this.payService=payService;
//    }

        private final PaymentInterface activePaymentService;
        public FirstProjectApplication(PaymentInterface activePaymentService){
            this.activePaymentService=activePaymentService;
        }


//    private Rajorpay payment_service=new Rajorpay();
    // it is very much dependent on rajor pay if we want to add phone pay we nned to change all code so we use beans
    // beans are java object managed by java component

    @Override
    public void run(String... args) throws Exception{
//        String payment=paymentService.pay();
//        String phonepay=payService.pay();
//        System.out.println("Payment done" +payment);
//        System.out.println(phonepay);

        String result = activePaymentService.pay();
        System.out.println("Payment Result: " + result);
    }
}
