package com.tripfilms.camel.server.start;

import org.apache.camel.spring.Main;

public class StartServer {

    private Main main;
    
    public static void main(String[] args) throws Exception
    {
    	StartServer example = new StartServer();
        example.boot();
    }
     
    private void boot() throws Exception
    {
        main = new Main();
        main.enableHangupSupport();
        main.setApplicationContextUri("applicationContext.xml");
         
        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
        main.run(); 
    }
}
