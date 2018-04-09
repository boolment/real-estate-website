package controllers;

import DAOImpl.OwnerImpl;
import DAOInterface.OwnerInterface;
import beans.OwnerMasterBean;
import helper.EmailSend;
import helper.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/OwnerController.do")
public class OwnerController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(OwnerController.class);
    private static final String ATTRIBUTE_EMAIL = "mail";
    private static final String ATTRIBUTE_MOBILE = "mobile";
    private static final String ATTRIBUTE_INVALIDSTRING = "invalidString";
    private static final String ATTRIBUTE_VALIDSTRING = "validString";
    private static final String ATTRIBUTE_INVALIDLENGTH = "invalidlength";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("OwnerController is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        boolean result;
        try {
            PrintWriter out = response.getWriter();
            JSONObject jsonobject = new JSONObject();
            Utility _utility = new Utility();
            OwnerMasterBean ownermasterbean = new OwnerMasterBean();
            ownermasterbean.setOwner_status("Active");
            OwnerInterface ownerInterface = new OwnerImpl();
            switch (request.getParameter("action")) {
                case "aSignIn":
                    if (null != request.getParameter("oEmail") && !request.getParameter("oEmail").isEmpty()) {
                        LOG.info("emailId is not null or empty now call to checkUserLoggedInWith() method");
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("oEmail"));
                        LOG.info("Emailid validation checked successfully----------:" + _type);
                        if (!ATTRIBUTE_EMAIL.equals(_type)) {
                            jsonobject.put("message", "Owner Emailid format is not correct!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Owner Emailid format is not correct");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter  Owner emailid!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Owner emailid can't be empty");
                        return;
                    }
                    if (null != request.getParameter("oPassword") && !request.getParameter("oPassword").isEmpty()) {
                        LOG.info(" Password  is retervied in the servlet :" + request.getParameter("oPassword"));
                        ownermasterbean.setOwner_password(request.getParameter("oPassword"));
                    } else {
                        jsonobject.put("message", "Please enter the Password!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info(" Password can't be empty or null");
                        return;
                    }
                    if ((null != request.getParameter("oEmail") && !request.getParameter("oEmail").isEmpty()) && (null != ownermasterbean.getOwner_password() && !ownermasterbean.getOwner_password().isEmpty())) {
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("oEmail"));
                        LOG.info("user is LOGgedin with :" + _type);

                        if (null != _type) {
                            LOG.info("Owner is LOGgin with _type is not null");
                            switch (_type) {
                                case ATTRIBUTE_EMAIL:
                                    ownermasterbean.setOwner_email_id(request.getParameter("oEmail"));
                                    OwnerMasterBean ownermastbean = ownerInterface.isValidOwnerByEmailId(ownermasterbean);
                                    if (ownermastbean != null) {
                                        if (ownermastbean.getOwner_password().equals(ownermasterbean.getOwner_password())) {
                                            LOG.info("Owner password is matched successfully");
                                            try {
                                                if (null != ownermastbean.getOwner_unique_id() && !ownermastbean.getOwner_unique_id().isEmpty()) {
                                                    jsonobject.put("message", "success");
                                                    jsonobject.put("url", "./ownerArea.jsp");
                                                    session.setAttribute("owner_unique_id", ownermastbean.getOwner_unique_id());
                                                    session.setAttribute("owner_fname", ownermastbean.getOwner_first_name());
                                                    LOG.info("Owner is loggedin successfully");
                                                } else {
                                                    LOG.info("Login failed");
                                                    jsonobject.put("message", "Something went wrong.Please try after some time!");
                                                }
                                            } catch (JSONException e) {
                                                e.printStackTrace(new PrintWriter(errors));
                                                sending.emailSending("Exception from Login Servlet in ATTRIBUTE_MOBILE" + errors.toString());
                                                LOG.error("Exception from the LoginServlet", e);
                                                jsonobject.put("message", "Something went wrong.Please try after some time!");
                                            }
                                        } else {
                                            LOG.info("Password is not matched ");
                                            jsonobject.put("message", "Password is incorrect!");
                                        }
                                    } else {
                                        LOG.info("Plese enter valid username and password");
                                        jsonobject.put("message", "Plese enter valid username and password!");
                                    }
                                    break;
                                case ATTRIBUTE_MOBILE:
                                    ownermasterbean.setOwner_phone_number(request.getParameter("oEmail"));
                                    result = ownerInterface.isValidOwnerPhoneNo(ownermasterbean);
                                    if (result == true) {
                                        LOG.info("UserName is validated with db");
                                        try {
                                            LOG.info("findUserByMobile method is called");
                                            OwnerMasterBean ownerbean = ownerInterface.isValidOwnerByPhoneNo(ownermasterbean);
                                            if (ownerbean != null) {
                                                if (ownerbean.getOwner_password().equals(ownermasterbean.getOwner_password())) {
                                                    LOG.info("Owner password is matched successfully");
                                                    try {
                                                        if (null != ownerbean.getOwner_unique_id() && !ownerbean.getOwner_unique_id().isEmpty()) {

                                                            jsonobject.put("message", "success");
                                                            jsonobject.put("url", "./ownerArea.jsp");
                                                            session.setAttribute("owner_unique_id", ownerbean.getOwner_unique_id());
                                                            session.setAttribute("owner_fname", ownerbean.getOwner_first_name());
                                                            LOG.info("Owner is loggedin successfully");
                                                        } else {
                                                            LOG.info("Login failed");
                                                            jsonobject.put("message", "Something went wrong.Please try after some time!");
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace(new PrintWriter(errors));
                                                        sending.emailSending("Exception from Login Servlet in ATTRIBUTE_MOBILE" + errors.toString());
                                                        LOG.error("Exception from the LoginServlet", e);
                                                        jsonobject.put("message", "Something went wrong.Please try after some time!");
                                                    }
                                                } else {
                                                    LOG.info("Password is not matched ");
                                                    jsonobject.put("message", "Password is incorrect!");
                                                }
                                            } else {
                                                LOG.info("Plese enter valid username and password");
                                                jsonobject.put("message", "Plese enter valid username and password!");
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace(new PrintWriter(errors));
                                            sending.emailSending("Exception from Login Servlet in ATTRIBUTE_MOBILE" + errors.toString());
                                            LOG.error("Exception from the LoginServlet", e);
                                            jsonobject.put("message", "Something went wrong.Please try after some time!");
                                        }
                                    } else {
                                        LOG.info("Mobile doesn't exist. Please enter valid userid");
                                        jsonobject.put("message", "Mobile doesn't exist. Please enter valid userid");
                                    }
                                    break;
                                default:
                                    LOG.info("please enter valid username & password");
                                    jsonobject.put("message", "please enter valid username & password!");
                                    break;
                            }
                        } else {
                            LOG.info("Username is neither email or phoneno");
                            jsonobject.put("message", "Please enter valid username!");
                        }
                    } else {
                        LOG.info("username & password is not valid!");
                        jsonobject.put("message", "username & password is not valid!");
                    }
                    break;
                case "ForgotPassword":
                    ownermasterbean.setOwner_email_id(request.getParameter("emailId"));
                    if (request.getParameter("emailId") != null) {
                    } else {
                        LOG.info("Unable to find the emailId from the session in AdminForgotPassOTP");
                        jsonobject.put("message", "Please enter valid emailid");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (!request.getParameter("emailId").isEmpty()) {
                        LOG.info("Before the validation format of email ");
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("emailId"));
                        LOG.info("After the validation format of email ");
                        if (_type.equals(ATTRIBUTE_EMAIL)) {
                            LOG.info("Finding emailid from the database");
                            boolean isvalidemail = ownerInterface.isValidOwnerEmailId(ownermasterbean);
                            if (isvalidemail) {
                                EmailSend emailsend = new EmailSend();
                                try {
                                    String otp = _utility.getOTPString();
                                    ownermasterbean.setOwner_otp(otp);
                                    LOG.info("Getting OTP in the db:" + otp);
                                    boolean isSendOTP = emailsend.sendOTPMail(request.getParameter("emailId"), otp);
                                    if (isSendOTP) {
                                        System.out.println("OTP has been successfully send on your email id" + request.getParameter("emailId"));
                                        boolean otpSaveDB = ownerInterface.setOwnerOTP(ownermasterbean);
                                        if (otpSaveDB) {
                                            String owner_unique_id = ownerInterface.getOwnerUniqueId(ownermasterbean);
                                            jsonobject.put("message", "success");
                                            jsonobject.put("url", "./adminarea.jsp");
                                            session.setAttribute("owner_unique_id", owner_unique_id);
                                        } else {
                                            LOG.info("Admin is blocked and try to login.!");
                                            jsonobject.put("message", "Admin is blocked. Please try to communicate with Support Team!");

                                        }
                                    } else {
                                        LOG.info("Send otp is failed");
                                        jsonobject.put("message", "Send OTP is failed. Please try after sometime!");

                                    }
                                } catch (JSONException e) {
                                    LOG.error("Something went wrong with AdminForgotPassController");
                                    jsonobject.put("message", "Something went wrong.Please try after sometime!");
                                    response.getWriter().write(jsonobject.toString());
                                    e.printStackTrace(new PrintWriter(errors));
                                    sending.emailSending("Exception in sendOTPMail" + errors.toString());
                                }
                            } else {
                                LOG.info("Emailid is not found in the db");
                                jsonobject.put("message", "Emailid is not registered with us");

                            }
                        } else {
                            LOG.info("Email id is not in the correct format");
                            jsonobject.put("message", "Emailid format is not correct!");

                        }
                    }
                    break;
                case "OtpSubmit":
                    if (null != request.getParameter("emailId") && !request.getParameter("emailId").isEmpty()) {
                        ownermasterbean.setOwner_email_id(request.getParameter("emailId"));
                    } else {
                        LOG.info("Emailid can't be empty!");
                        jsonobject.put("message", "Emailid can't be empty!");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (null != request.getParameter("otp") && !request.getParameter("otp").isEmpty()) {
                        ownermasterbean.setOwner_otp(request.getParameter("otp"));
                    } else {
                        LOG.info("otp is not found at controller side ");
                        jsonobject.put("message", "OTP can't be null or empty");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (null != request.getParameter("newpassword") && !request.getParameter("newpassword").isEmpty()) {
                        ownermasterbean.setOwner_password(request.getParameter("newpassword"));
                    } else {
                        LOG.info(" New Password can't be empty!");
                        jsonobject.put("message", "New Password can't be empty!");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    String confirmnewpassword;
                    if (null != request.getParameter("confirmnewpassword") && !request.getParameter("confirmnewpassword").isEmpty()) {
                        confirmnewpassword = request.getParameter("confirmnewpassword");
                    } else {
                        LOG.info("Confirm password can't be empty!");
                        jsonobject.put("message", "Confirm password can't be empty!");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (!request.getParameter("newpassword").equals(confirmnewpassword)) {
                        LOG.info("Passowrd doesn't match.");
                        jsonobject.put("message", "Passowrd doesn't match.");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (null != request.getParameter("emailId") && !request.getParameter("emailId").isEmpty()) {
                        LOG.info("Before the validation format of email ");
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("emailId"));
                        LOG.info("After the validation format of email ");
                        if (_type.equals(ATTRIBUTE_EMAIL)) {
                            LOG.info("Emailid format is correct ");
                            boolean stat = ownerInterface.isValidOwnerEmailId(ownermasterbean);
                            LOG.info("Method called from isValidEmailId is successfully : " + stat);
                            if (stat) {
                                LOG.info("Email id is exist in the db and now finding otp");
                                String getotp = ownerInterface.getOwnerOTP(ownermasterbean);
                                if (null != getotp && !getotp.isEmpty()) {
                                    LOG.info("OTP is reterived from db successfully" + getotp);
                                    if (getotp.equals(request.getParameter("otp"))) {
                                        boolean changepass = ownerInterface.setOwnerChangePassword(ownermasterbean);
                                        if (changepass) {
                                            session.setAttribute("emailId", request.getParameter("emailId"));
                                            jsonobject.put("message", "success");
                                            jsonobject.put("url", "../index.jsp");

                                            LOG.info("Admin password has been successfully changed!!!!");
                                        } else {
                                            LOG.info("User activation is failed!");
                                            jsonobject.put("message", "Something went wrong .Please try after sometime!");

                                        }
                                    } else {
                                        LOG.info("Please enter correct OTP!");
                                        jsonobject.put("message", "Please enter correct OTP!");

                                    }
                                } else {
                                    LOG.info("OTP reterive failed from db");
                                    jsonobject.put("message", "Something went wrong .Please try after sometime!");

                                }
                            } else {
                                jsonobject.put("message", "Emailid  is not exist in the Database please enter correct mail Id!");

                            }
                        } else {
                            LOG.info("Email id is not in the correct format");
                            jsonobject.put("message", "Emailid format is not correct!");

                        }
                    }
                    break;
                case "getAllOwner":
                    LOG.info("getAllOwner is called");
                    List listViewPromo = ownerInterface.getAllOwner();
                    if (listViewPromo != null) {
                        JSONArray coupanJSONArray = new JSONArray();
                        JSONObject coupanJSONObject;
                        Iterator itr = listViewPromo.iterator();
                        while (itr.hasNext()) {
                            ownermasterbean = (OwnerMasterBean) itr.next();
                            coupanJSONObject = new JSONObject();
                            LOG.info("This log is executed successfully");
                            coupanJSONObject.put("ownerId", ownermasterbean.getOwner_id());
                            coupanJSONObject.put("Firstname", ownermasterbean.getOwner_first_name());
                            coupanJSONObject.put("Lastname", ownermasterbean.getOwner_last_name());
                            coupanJSONObject.put("UnqId", ownermasterbean.getOwner_unique_id());
                            coupanJSONObject.put("PhnNo", ownermasterbean.getOwner_phone_number());
                            coupanJSONObject.put("Address", ownermasterbean.getOwner_address_type());
                            coupanJSONObject.put("Email", ownermasterbean.getOwner_email_id());
                            coupanJSONObject.put("Gender", ownermasterbean.getOwner_gender());
                            coupanJSONObject.put("DOB", ownermasterbean.getOwner_date_of_birth());
                            coupanJSONObject.put("Date", ownermasterbean.getOwner_creation_date());
                            coupanJSONObject.put("Status", ownermasterbean.getOwner_status());
                            coupanJSONArray.put(coupanJSONObject);
                        }
                        jsonobject.put("owner", coupanJSONArray);
                        jsonobject.put("message", "success");
                        LOG.info("Owner data is found in the database");
                    } else {
                        jsonobject.put("message", "No record found in the database");
                        LOG.info("No Owner data is found in the database");
                    }
                    break;
                case "blockOwner":
                    ownermasterbean = new OwnerMasterBean();
                    if (null != request.getParameter("id") && !request.getParameter("id").trim().isEmpty()) {
                        ownermasterbean.setOwner_unique_id((request.getParameter("id").trim()));
                        LOG.info("owner id is reterived in the controller :" + ownermasterbean.getOwner_unique_id());
                    } else {
                        jsonobject.put("message", "owner id is not retervied in the controller!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("owner id can't be empty or null");
                        return;
                    }
                    ownermasterbean.setOwner_status("Block");
                    boolean blockedResult = ownerInterface.blockOwner(ownermasterbean);
                    if (blockedResult) {
                        LOG.info("Owner is Blocked successfully");
                        jsonobject.put("message", "success");
                    } else {
                        LOG.info("Owner Block is failed");
                        jsonobject.put("message", "Something went wrong controller side");
                        return;
                    }
                    break;
                case "activeOwner":
                    ownermasterbean = new OwnerMasterBean();
                    if (null != request.getParameter("id") && !request.getParameter("id").trim().isEmpty()) {
                        ownermasterbean.setOwner_unique_id((request.getParameter("id").trim()));
                        LOG.info("owner id is reterived in the controller :" + ownermasterbean.getOwner_unique_id());
                    } else {
                        jsonobject.put("message", "owner id is not retervied in the controller!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("owner id can't be empty or null");
                        return;
                    }
                    ownermasterbean.setOwner_status("Active");
                    boolean activeResult = ownerInterface.blockOwner(ownermasterbean);
                    if (activeResult) {
                        LOG.info("Owner is Active successfully");
                        jsonobject.put("message", "success");
                    } else {
                        LOG.info("Owner Active is failed");
                        jsonobject.put("message", "Something went wrong controller side");
                        return;
                    }
                    break;
                case "updateOwner":
                    if (null != request.getParameter("fname") && !request.getParameter("fname").isEmpty()) {
                        ownermasterbean.setOwner_first_name(request.getParameter("fname"));
                        LOG.info("Staff First Name  is retervied in the servlet :" + request.getParameter("fname"));
                        String validate = _utility.validateString(request.getParameter("fname"));
                        if (validate.equals(ATTRIBUTE_INVALIDSTRING)) {
                            jsonobject.put("message", "Enter valid First Name!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Enter valid First Name");
                            return;
                        } else if (validate.equals(ATTRIBUTE_INVALIDLENGTH)) {
                            jsonobject.put("message", "First Name can't be more than 20 characters!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("First Name can't be more than 20 characters");
                            return;
                        } else if (!validate.equals(ATTRIBUTE_VALIDSTRING)) {
                            jsonobject.put("message", "Something went wrong. Please try after seomtime!!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Something went wrong from first name utility class");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter The First Name!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff First Name can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("lname") && !request.getParameter("lname").isEmpty()) {
                        ownermasterbean.setOwner_last_name(request.getParameter("lname"));
                        LOG.info("Staff Last Name  is retervied in the servlet :" + request.getParameter("lname"));
                        String validate = _utility.validateString(request.getParameter("lname"));
                        if (validate.equals(ATTRIBUTE_INVALIDSTRING)) {
                            jsonobject.put("message", "Enter valid Last Name!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Enter valid Last Name");
                            return;
                        } else if (validate.equals(ATTRIBUTE_INVALIDLENGTH)) {
                            jsonobject.put("message", "Last Name can't be more than 20 characters!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Last Name can't be more than 20 characters");
                            return;
                        } else if (!validate.equals(ATTRIBUTE_VALIDSTRING)) {
                            jsonobject.put("message", "Something went wrong. Please try after seomtime!!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Something went wrong from Last name utility class");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter The Last Name!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff Last Name can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("mobno") && !request.getParameter("mobno").isEmpty()) {
                        ownermasterbean.setOwner_phone_number(request.getParameter("mobno"));
                        LOG.info("Staff phoneno. is retervied in the servlet :" + request.getParameter("mobno"));
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("mobno"));
                        LOG.info("Phone No. checkUserLoggedInWith retrun value is :" + _type);
                        if (!ATTRIBUTE_MOBILE.equals(_type)) {
                            jsonobject.put("message", "Staff Mobile number is not valid.Please enter valid 10 digit number followed by 0 or +91");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Staff mobile number is not valid.Please enter valid 10 digit number");
                            return;
                        }
                        boolean phoneValidate = false;
                        if (phoneValidate == true) {
                            jsonobject.put("message", "This phoneno already exist!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("This phoneno is already exist respective this");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter staff phoneno!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff phoneno can't be empty or null!");
                        return;
                    }
                    if (null != request.getParameter("emailId") && !request.getParameter("emailId").isEmpty()) {
                        ownermasterbean.setOwner_email_id(request.getParameter("emailId"));
                        LOG.info("mailId is not null or empty now call to checkUserLoggedInWith() method");
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("emailId"));
                        LOG.info("mailId validation checked successfully----------:" + _type);
                        if (!ATTRIBUTE_EMAIL.equals(_type)) {
                            jsonobject.put("message", "Staff mailId format is not correct!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Staff mailId format is not correct");
                            return;
                        }
                        boolean emailValidate = false;
                        if (emailValidate == true) {
                            jsonobject.put("message", "This mailid already exist!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("This mailid is already exist in the database");
                            return;
                        }
                        LOG.info("Staff Mail id  is retervied in the servlet :" + request.getParameter("emailId"));
                    } else {
                        jsonobject.put("message", "Please enter The Mail id!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff mail id can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("dob") && !request.getParameter("dob").isEmpty()) {
                       ownermasterbean.setOwner_date_of_birth(request.getParameter("dob"));
                        LOG.info("Staff Age  is retervied in the servlet :" + request.getParameter("dob"));
                    } else {
                        jsonobject.put("message", "Please enter The Age!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff Age can't be empty or null");
                        return;
                    }
                      if (null != request.getParameter("address") && !request.getParameter("address").isEmpty()) {
                       ownermasterbean.setOwner_address_type(request.getParameter("address"));
                        LOG.info("Staff Age  is retervied in the servlet :" + request.getParameter("address"));
                    } else {
                        jsonobject.put("message", "Please enter The Age!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff Age can't be empty or null");
                        return;
                    }
                        if (null != request.getParameter("ostatus") && !request.getParameter("ostatus").isEmpty()) {
                       ownermasterbean.se(request.getParameter("ostatus"));
                        LOG.info("Staff Age  is retervied in the servlet :" + request.getParameter("ostatus"));
                    } else {
                        jsonobject.put("message", "Please enter The Age!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff Age can't be empty or null");
                        return;
                    }
                    status = request.getParameter("status");
                    jobprofile = request.getParameter("jobprofile");
                    department = request.getParameter("department");
                    if (null != request.getParameter("password") && !request.getParameter("password").isEmpty()) {
                        password = request.getParameter("password");
                        LOG.info("Password  is retervied in the servlet :" + password);
                    } else {
                        jsonobject.put("message", "Please enter The password!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Password can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("sconfirmpassword") && !request.getParameter("sconfirmpassword").isEmpty()) {
                        sconfirmpassword = request.getParameter("sconfirmpassword");
                        LOG.info("Customer confirm password is retervied in the servlet :" + sconfirmpassword);
                        if (!sconfirmpassword.equals(password)) {
                            jsonobject.put("message", "Customer re-password doesn't match. Please enter password again.");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Customer re-password doesn't match. Please enter password again.");
                            return;
                        } else {
                        }
                    } else {
                        jsonobject.put("message", "Please confirm Staff password!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Staff repassword can't be empty or null");
                        return;
                    }

                    result = staffInterface.addStaff(staffBean);
                    if (result == true) {
                        jsonobject.put("message", "success");
                        LOG.info("staff account is created successfully");
                    } else {
                        LOG.info("staff account creation is failed");
                    }
                    break;
                default:
                    jsonobject.put("message", "Username does not exist!");
                    LOG.info("Page is send redirect to the ownerManagement.jsp");
                    break;
            }
            response.getWriter().write(jsonobject.toString());
            LOG.info("Response is send to back successfully");
        } catch (JSONException e) {
            LOG.error("JSONException from the OwnerController", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("JSONException from OwnerController" + errors.toString());
        }
    }

}
