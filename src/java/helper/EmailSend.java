
package helper;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSend 
{
        private final String host = "mail.breezebeauties.com";
    private final String user = "mahi@breezebeauties.com";//change accordingly  
    private final String password = "Admin@123";//change accordingly 
    public void emailSending(String error)
    {
        String to = "vkchoudhary128@gmail.com,divyachaudharyyy@gmail.com";//change accordingly  

        //Get the session object  
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("javatpoint");
            message.setText("This is simple program of sending email using JavaMail API"+"\n"+error);

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully... by mahipal");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        
    }
    public boolean sendOTPMail(String toEmailAddress,String otpCode)
	{
        String to = toEmailAddress;//change accordingly  
        //Get the session object  
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });

        //Compose the message  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Step 2 Verification OTP");
            message.setText("Hi Dear, OTP for Step2 verification"+"\n"+otpCode);

            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully... by mahipal");

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
        }
}

