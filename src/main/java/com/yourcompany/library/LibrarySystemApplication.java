package com.yourcompany.library;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class LibrarySystemApplication {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        tomcat.getConnector(); // Creates and initializes the HTTP connector

        try {
            tomcat.addWebapp("", new java.io.File("src/main/webapp").getAbsolutePath());
            System.out.println("Configuring app with basedir: " + new java.io.File("./" + "src/main/webapp").getAbsolutePath());

            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
