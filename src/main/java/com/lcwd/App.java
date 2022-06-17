package com.lcwd;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello This is Ajit..!!!" );
        
        System.out.println("Preparing to send the message");
        String message = "Hello, Dear This message for security purpose";
        String subject = "CodersArea : confimatio";
        String to = "vibhuteajit752@gmail.com";
        String from = "vibhuteajit3@gmail.com";
        
        sendEmail(message,subject,to,from);
       
    }

	private static void sendEmail(String message, String subject, String to, String from) {
		
		// Variable for gmail
		String host ="smtp.gmail.com";
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"  +properties);
		
		//setting important to properties object
		
		// host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		// Step 1: to get the session object
		Session session =Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
			
				return new PasswordAuthentication("vibhuteajit752@gmail.com", "9850962723");
			}
			
		});
		
		session.setDebug(true);
		
		// Step 2: compose the message [ Text , Multimedia ]
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			// from email
			m.setFrom(from);
			
			// Addding recipient to message
			m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			
			// Adding subject to message
			m.setSubject(subject);
			
			//Adding text to message
			m.setText(message);
			
			// Send
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		}
}
