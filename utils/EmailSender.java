package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

	// SMTP server information 
	public static String host = "smtp.gmail.com"; 
	public static String port = "587"; 
	public static String userName = "linkan2907@gmail.com"; 
	public static String password = "mkozjzoxyekwqlqf";
	public static String attachFiles = ReportHandler.path;

	public static void sendEmailWithAttachment(String toAddress, String subject, String message) throws AddressException, MessagingException { 

		// Sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true"); 
		properties.put("mail.smtp.starttls.enable", "true"); 

		// Creates a new session with an authenticator
		Authenticator auth = new Authenticator() { 
			@Override
			public PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		// Creates a new e-mail message 
		Message msg = new MimeMessage(session); 
		msg.setFrom(new InternetAddress(userName)); 
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject); msg.setSentDate(new java.util.Date()); 
		// Creates message part 
		MimeBodyPart messageBodyPart = new MimeBodyPart(); 
		messageBodyPart.setContent(message, "text/html"); 

		// Creates multipart
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart); 
		// Adds attachments 
		if (attachFiles != null) { 
			MimeBodyPart attachPart = new MimeBodyPart();
			try { attachPart.attachFile(attachFiles); 
			} catch (Exception ex) {
				ex.printStackTrace();
			} 
			multipart.addBodyPart(attachPart); 
		} 
		// Sets the multipart as e-mail's content
		msg.setContent(multipart); 
		// Sends the e-mail 
		Transport.send(msg);
	}
}

