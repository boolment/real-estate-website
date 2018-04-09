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
