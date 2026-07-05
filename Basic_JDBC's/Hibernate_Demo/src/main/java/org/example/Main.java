package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Alien a1=new Alien();
        a1.setU_id(104);
        a1.setName("Rukmini");
        a1.setTech("web-dev");

        // use of hibernate
        Configuration config=new Configuration();
        config.addAnnotatedClass(org.example.Alien.class);
        config.configure("hibernate.cfg.xml");
//         this all can be done on  a same line

//        SessionFactory factory= new Configuration()
//        .addAnnotatedClass(org.example.Alien.class)
//        .configure()
//        .buildSessionFactory();

        SessionFactory factory=config.buildSessionFactory();

        Session session =factory.openSession();

        Transaction transaction=session.beginTransaction();

//        Alien a3=session.find(Alien.class,104);
//        session.remove(a3);

        session.persist(a1);
//        session.merge(a1);
//        Alien a2=session.byId(Alien.class).getReference(101);

        System.out.println(a1.toString());
//        session.persist(a1);
        transaction.commit();

            session.close();
            factory.close();

    }
}
