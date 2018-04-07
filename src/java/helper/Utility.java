package helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mahipal
 */
public class Utility {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String ATTRIBUTE_EMAIL = "mail";
    private static final String ATTRIBUTE_MOBILE = "mobile";
    private static final String ATTRIBUTE_AADHAAR = "aadharNumber";
    private static final String ATTRIBUTE_PIN = "pin";
    private static final String ATTRIBUTE_INVALIDSTRING = "invalidString";
    private static final String ATTRIBUTE_VALIDSTRING = "validString";
    private static final String ATTRIBUTE_INVALIDLENGTH = "invalidlength";
    String MOBILE_PATTERN = "([7-9]{1})([0-9]{9})$";
    String AADHAAR_PATTERN = "[0-9]{12}";
    String PIN_PATTERN = "([1-9]{1})([0-9]{5})$";
    String ID_PATTERN = "[0-9]+";
    String STRING_PATTERN = "[a-zA-Z ]+";
    String ALPHANUMERIC_PATTERN = "[A-Za-z0-9]+";
    String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private Pattern pattern;
    private Matcher matcher;

    public String getCurrentDateTimeMS() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String datetime = ft.format(dNow);
        return datetime;
    }

    public int randomGenerator() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public String generateUniqueId(String firstName, String mobileNumber) {
        String uniqueId = "";
        if (firstName.length() > 9) {
            uniqueId = firstName.substring(0, 8) + mobileNumber;
        } else {
            uniqueId = firstName + mobileNumber;
        }

        return uniqueId;
    }

    public String checkUserLoggedInWith(String _userId) {
        //String _
        if (_userId.contains("@")) {
            pattern = Pattern.compile(EMAIL_PATTERN);
            matcher = pattern.matcher(_userId);
            if (!matcher.matches()) {
                return null;
            } else {
                return ATTRIBUTE_EMAIL;
            }
        } else if (_userId.length() == 10) {
            pattern = Pattern.compile(MOBILE_PATTERN);
            matcher = pattern.matcher(_userId);
            if (!matcher.matches()) {
                return null;
            } else {
                return ATTRIBUTE_MOBILE;
            }
        } else if (_userId.length() == 12) {
            pattern = Pattern.compile(AADHAAR_PATTERN);
            matcher = pattern.matcher(_userId);
            if (!matcher.matches()) {
                return null;
            } else {
                return ATTRIBUTE_AADHAAR;
            }
        } else if (_userId.length() == 6) {
            pattern = Pattern.compile(PIN_PATTERN);
            matcher = pattern.matcher(_userId);
            if (!matcher.matches()) {
                return null;
            } else {
                return ATTRIBUTE_PIN;
            }
        }

        return null;
    }

    public String getOTPString() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) {
            int index = (int) (rnd.nextFloat() * CHARS.length());
            salt.append(CHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public String validateString(String checkString) {
        pattern = Pattern.compile(STRING_PATTERN);
        matcher = pattern.matcher(checkString);
        if (!matcher.matches()) {
            return ATTRIBUTE_INVALIDSTRING;

        } else if (checkString.length() > 20) {
            return ATTRIBUTE_INVALIDLENGTH;
        }

        return ATTRIBUTE_VALIDSTRING;
    }
    /*public boolean sendOTPMail(String toEmailAddress,String otpCode)
	{
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "NEGDPORTAL");
		//props.put("mail.smtp.socketFactory.port", "587");
		//props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.port", "25");
		//props.setProperty("mail.smtp.starttls.enable", "true");
		//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		//props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props);
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("negdkms@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
			message.setSubject("OTP code Negd");
			message.setText("Dear User," +"\n\n Please find your OTP code "+otpCode);
			Transport.send(message);
			log.info("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		catch(Exception e)
		{
			log.info("exception occurs for mail sending "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
//	public boolean sendOTPMail(String toEmailAddress,String otpCode)
//	{
//		log.info("inside sendOTPMail "+toEmailAddress+" "+otpCode);
//		
//		final String username = "negdkm@gmail.com";
//		final String password = "Welcome@1";
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		
//		/*final String username = "kmsupport@velocis.in";
//        final String password = "Gyan@123";
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//       	props.put("mail.smtp.host", "velocis-in.mail.protection.outlook.com");
//        props.put("mail.smtp.port", "25");*/
//	
//		
//		try{
//	//	Session session = Session.getInstance(props,
//				  new javax.mail.Authenticator() {
//					protected PasswordAuthentication getPasswordAuthentication() {
//						return new PasswordAuthentication(username, password);
//					}
//				  });
//			
//		//	Message message = new MimeMessage(session);
//		//	message.setFrom(new InternetAddress("kmsupport@velocis.in"));
//		//	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
//			message.setSubject("NeGD KMS new registration");
//			message.setText("Dear User," +"\n\n Please find your registration code "+otpCode);
//		//	Transport.send(message);
//			log.info("Done");
//		} 
//		catch(Exception e)
//		{
//		//	log.error("Exception occurs for mail sending "+e.getMessage());
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
}
