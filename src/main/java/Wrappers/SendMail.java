package Wrappers;

import java.util.Properties;
import static Wrappers.LoggingHandling.logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

    public static boolean mailIsEnabled = false ;

    public static void sendTheLog(String error) {
        String host = PropertiesFileHandler.getProperty("mailHost");
        final String user = PropertiesFileHandler.getProperty("sender");
        final String password = PropertiesFileHandler.getProperty("pass");
        String to = PropertiesFileHandler.getProperty("sendTo");

        // Get the session object
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        // Compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Alert Error");
            // message.setFileName("Logs/6-2-2019 13-29-46.log");
            message.setText(error);
            Multipart multipart = new MimeMultipart();

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart = new MimeBodyPart();
            String file = "Logs/"+LoggingHandling.logFileName;
            String fileName = LoggingHandling.logFileName;
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Log Report Mail has been sent successfully...");
            logger.info("Log Report Mail has been sent successfully...");
            SendMail.mailIsEnabled=true;


        } catch (MessagingException e) {
            LoggingHandling.reportMailingError(e);
        }
    }
}