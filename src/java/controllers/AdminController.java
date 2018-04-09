package controllers;

import DAOImpl.AdminImpl;
import DAOInterface.AdminInterface;
import beans.AdminMasterBean;
import helper.EmailSend;
import helper.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/AdminController.do")
public class AdminController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AdminController.class);
    private static final String ATTRIBUTE_EMAIL = "mail";
    private static final String ATTRIBUTE_MOBILE = "mobile";
    private static final String ATTRIBUTE_INVALIDSTRING = "invalidString";
    private static final String ATTRIBUTE_VALIDSTRING = "validString";
    private static final String ATTRIBUTE_INVALIDLENGTH = "invalidlength";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("AdminController is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        boolean result;
        try {
            PrintWriter out = response.getWriter();
            JSONObject jsonobject = new JSONObject();
            Utility _utility = new Utility();
            AdminMasterBean adminmasterbean = new AdminMasterBean();
            adminmasterbean.setStatus("Active");
            AdminInterface adminInterface = new AdminImpl();
            LOG.info("Action is retervied in the servelt :" + request.getParameter("action"));
            switch (request.getParameter("action")) {
                case "aSignIn":
                    if (null != request.getParameter("aEmail") && !request.getParameter("aEmail").trim().isEmpty()) {
                        LOG.info("emailId is not null or empty now call to checkUserLoggedInWith() method");
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("aEmail"));
                        LOG.info("Emailid validation checked successfully----------:" + _type);
                        if (!ATTRIBUTE_EMAIL.equals(_type)) {
                            jsonobject.put("message", "Admin Emailid format is not correct!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Admin Emailid format is not correct");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter  admin emailid!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Admin emailid can't be empty");
                        return;
                    }
                    if (null != request.getParameter("aPassword") && !request.getParameter("aPassword").trim().isEmpty()) {
                        LOG.info(" Password  is retervied in the servlet :" + request.getParameter("aPassword"));
                        adminmasterbean.setAdmin_password(request.getParameter("aPassword"));
                    } else {
                        jsonobject.put("message", "Please enter the Password!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info(" Password can't be empty or null");
                        return;
                    }
                    if ((null != request.getParameter("aEmail") && !request.getParameter("aEmail").isEmpty()) && (null != adminmasterbean.getAdmin_password() && !adminmasterbean.getAdmin_password().isEmpty())) {
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("aEmail"));
                        LOG.info("user is LOGgedin with :" + _type);

                        if (null != _type) {
                            LOG.info("Admin is LOGgin with _type is not null");
                            switch (_type) {
                                case ATTRIBUTE_EMAIL:
                                    adminmasterbean.setEmail_id(request.getParameter("aEmail"));
                                    AdminMasterBean adminmastbean = adminInterface.isValidAdminByEmailId(adminmasterbean);
                                    if (adminmastbean != null) {
                                        if (adminmastbean.getAdmin_password().equals(adminmasterbean.getAdmin_password())) {
                                            LOG.info("Admin password is matched successfully");
                                            try {
                                                if (null != adminmastbean.getAdmin_unique_id() && !adminmastbean.getAdmin_unique_id().isEmpty()) {
                                                    jsonobject.put("message", "success");
                                                    jsonobject.put("url", "./adminarea.jsp");
                                                    session.setAttribute("admin_unique_id", adminmastbean.getAdmin_unique_id());
                                                    session.setAttribute("admin_fname", adminmastbean.getAdmin_first_name());
                                                    LOG.info("Admin is loggedin successfully");
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
                                    adminmasterbean.setMobile_number(request.getParameter("aEmail"));
                                    result = adminInterface.isValidAdminPhoneNo(adminmasterbean);
                                    if (result == true) {
                                        LOG.info("UserName is validated with db");
                                        try {
                                            LOG.info("isValidAdminByPhoneNo method is called");
                                            AdminMasterBean adminbean = adminInterface.isValidAdminByPhoneNo(adminmasterbean);
                                            if (adminbean != null) {
                                                if (adminbean.getAdmin_password().equals(adminmasterbean.getAdmin_password())) {
                                                    LOG.info("Admin password is matched successfully");
                                                    try {
                                                        if (null != adminbean.getAdmin_unique_id() && !adminbean.getAdmin_unique_id().isEmpty()) {

                                                            jsonobject.put("message", "success");
                                                            jsonobject.put("url", "./adminarea.jsp");
                                                            session.setAttribute("admin_unique_id", adminbean.getAdmin_unique_id());
                                                            session.setAttribute("admin_fname", adminbean.getAdmin_first_name());
                                                            LOG.info("Admin is loggedin successfully");
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
                    adminmasterbean.setEmail_id(request.getParameter("emailId"));
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
                            boolean isvalidemail = adminInterface.isValidAdminEmailId(adminmasterbean);
                            if (isvalidemail) {
                                EmailSend emailsend = new EmailSend();
                                try {
                                    String otp = _utility.getOTPString();
                                    adminmasterbean.setOtp(otp);
                                    LOG.info("Getting OTP in the db:" + otp);
                                    boolean isSendOTP = emailsend.sendOTPMail(request.getParameter("emailId"), otp);
                                    if (isSendOTP) {
                                        System.out.println("OTP has been successfully send on your email id" + request.getParameter("emailId"));
                                        boolean otpSaveDB = adminInterface.setAdminOtp(adminmasterbean);
                                        if (otpSaveDB) {
                                            AdminMasterBean admin_unique_id = adminInterface.getAdminUniueId(adminmasterbean);
                                            jsonobject.put("message", "success");
                                            jsonobject.put("url", "./adminarea.jsp");

                                            session.setAttribute("admin_unique_id", admin_unique_id);
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
                        adminmasterbean.setEmail_id(request.getParameter("emailId"));
                    } else {
                        LOG.info("Emailid can't be empty!");
                        jsonobject.put("message", "Emailid can't be empty!");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (null != request.getParameter("otp") && !request.getParameter("otp").isEmpty()) {
                        adminmasterbean.setOtp(request.getParameter("otp"));
                    } else {
                        LOG.info("otp is not found at controller side ");
                        jsonobject.put("message", "OTP can't be null or empty");
                        response.getWriter().write(jsonobject.toString());
                        return;
                    }
                    if (null != request.getParameter("newpassword") && !request.getParameter("newpassword").isEmpty()) {
                        adminmasterbean.setAdmin_password(request.getParameter("newpassword"));
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
                            boolean stat = adminInterface.isValidAdminEmailId(adminmasterbean);
                            LOG.info("Method called from isValidEmailId is successfully : " + stat);
                            if (stat) {
                                LOG.info("Email id is exist in the db and now finding otp");
                                String getotp = adminInterface.getAdminOTP(adminmasterbean);
                                if (null != getotp && !getotp.isEmpty()) {
                                    LOG.info("OTP is reterived from db successfully" + getotp);
                                    if (getotp.equals(request.getParameter("otp"))) {
                                        boolean changepass = adminInterface.setAdminChangePassword(adminmasterbean);
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
                default:
                    jsonobject.put("message", "Username does not exist!");
                    LOG.info("Page is send redirect to the adminManagement.jsp");
                    break;
            }
            response.getWriter().write(jsonobject.toString());
            LOG.info("Response is send to back successfully");
        } catch (JSONException e) {
            LOG.error("JSONException from the AdminController", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("JSONException from AdminController" + errors.toString());
        }
    }
}
