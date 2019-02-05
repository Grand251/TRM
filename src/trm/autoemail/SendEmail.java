package trm.autoemail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

public class SendEmail {

    private static String USER_NAME = "trm.syntel";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "12345Qwerty"; // GMail password
    //private static String RECIPIENT = "niwdex00@gmail.com";

    public static void main(String[] args) {
        new SendEmail().sendToRecipient("niwdex00@gmail.com", "Josh");
    }
    
    public void sendToRecipient(String recipientEmailAddress, String recipientName) {
    	String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { recipientEmailAddress }; // list of recipient email addresses
        String subject = "Welcome to TRM";
        String body = "Thank you for signing up, " + recipientName +"\r\n\n" + 
        		"We give hight quality of trainings to our employees.\r\n" + 
        		"You can now start to request a training now.\r\n" + 
        		"\r\n" + 
        		"All the best,\r\n" + 
        		"\r\n" + 
        		"TRM team";

        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
