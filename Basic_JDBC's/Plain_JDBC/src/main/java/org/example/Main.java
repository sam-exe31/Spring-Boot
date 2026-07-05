package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivver Loaded");
            Class.forName("org.example.Demo");
            // this for name method can be used to load the class only the static part

        }
        catch(ClassNotFoundException e){
            System.out.println("could not found the file");
            e.printStackTrace();
        }
    }
    }

    class Demo
    {
        static
        {
            System.out.println("static block=>");
        }
        {
            System.out.println("Instance_here");
        }
    }

