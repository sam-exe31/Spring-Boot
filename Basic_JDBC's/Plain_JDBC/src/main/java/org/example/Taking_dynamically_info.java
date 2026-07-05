package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement; // Imported PreparedStatement
import java.sql.SQLException;
import java.util.Scanner;

public class Taking_dynamically_info {
    // 1. Added 'public' so Java can execute it
    public static void main(String[] args) {

        // Declare resources outside so they are accessible in the finally block
        Connection connection = null;
        PreparedStatement statement = null;
        Scanner scan = new Scanner(System.in);

        try {
            connection = jbc_learning.getConnection();

            String query = "Insert into students values(?,?,?,?,?)";
            statement = connection.prepareStatement(query);

            System.out.println("Please enter the following details:");

            System.out.println("Enter your id: ");
            Integer studentId = scan.nextInt();

            System.out.println("Enter your name: ");
            String name = scan.next();

            System.out.println("Enter your email: ");
            String email = scan.next();

            System.out.println("Enter your phone_no: ");
            String phone = scan.next();

            System.out.println("Enter your age: ");
            String age = scan.next();

            statement.setInt(1, studentId);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, age);

            // Execute update
            int rowAffected = statement.executeUpdate();
            if (rowAffected == 0) {
                System.out.println("Unable to insert data");
            } else {
                System.out.println("Data inserted successfully!");
            }

        } catch (SQLException e) {
            // This single block catches ANY database error that happens above
            System.out.println("Database operation error occurred!");
            e.printStackTrace();
        } finally {
            // 4. Properly structured clean-up block
            try {
                if (connection != null || statement != null) {
                    jbc_learning.closeConnection(connection, statement);
                }
            } catch (Exception e) {
                System.out.println("Error while closing resources.");
            }
            scan.close(); // Good practice to close scanner too
        }
    }
}