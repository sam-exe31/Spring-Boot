package org.example;

public class Laptop implements Computer {
    public Laptop() {
        System.out.println("construct laptop");
    }

    public void start(){
        System.out.println("started things ");
    }
}
