package com.kodilla.bytebuddy;

public class BuddyApp {

    public static void main(String[] args) {

        JavaAgentController javaAgentController = new JavaAgentController();
        javaAgentController.createUser();
        javaAgentController.createUser();

    }
}