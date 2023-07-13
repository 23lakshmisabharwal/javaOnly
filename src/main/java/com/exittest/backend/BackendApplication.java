package com.exittest.backend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author aryanverma
 * 
 * The main class for the backend application.
 */
@SpringBootApplication
public class BackendApplication 

{
	/**
     * The entry point of the application.
     *
     * @param args The command line arguments.
     */
    public static void main( String[] args )
    {
    	SpringApplication.run(BackendApplication.class, args);
        System.out.println( "Hello World!" );
    }

}