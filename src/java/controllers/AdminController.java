package controllers;

import DAOImpl.AdminImpl;
import DAOInterface.AdminInterface;
import beans.AdminMasterBean;
import helper.EmailSend;
import helper.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
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
        String aEmail, aPassword;
        boolean result;
        AdminMasterBean adminmasterbean;
        try {
            PrintWriter out = response.getWriter();
            JSONObject jsonobject = new JSONObject();
            Utility _utility = new Utility();
            switch (request.getParameter("action")) {
                case "aSignIn":
                    if (null != request.getParameter("aEmail") && !request.getParameter("aEmail").isEmpty()) {
                        aEmail = request.getParameter("aEmail");
                        LOG.info("Admin Emailid is retervied in the servlet :" + aEmail);
                        LOG.info("emailId is not null or empty now call to checkUserLoggedInWith() method");
                        String _type = _utility.checkUserLoggedInWith(aEmail);
                        LOG.info("Emailid validation checked successfully----------:" + _type);
                        if (!ATTRIBUTE_EMAIL.equals(_type)) {
                            jsonobject.put("message", "Admin Emailid format is not correct!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Admin Emailid format is not correct");
                            return;
                        }
                        boolean emailValidate = false;
                        if (emailValidate == true) {
                            jsonobject.put("message", "This mailid already exist!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("This mailid is already exist in the database");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter  admin emailid!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Admin emailid can't be empty");
                        return;
                    }
                    if (null != request.getParameter("aPassword") && !request.getParameter("aPassword").isEmpty()) {
                        aPassword = request.getParameter("aPassword");
                        LOG.info(" Password  is retervied in the servlet :" + aPassword);
                    } else {
                        jsonobject.put("message", "Please enter the Password!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info(" Password can't be empty or null");
                        return;
                    }
                    if ((null != aEmail && !aEmail.isEmpty()) && (null != aPassword && !aPassword.isEmpty())) {
                        LOG.info("Loing password or email is reterived here ");
                        LOG.info("Utility class object is created");
                        String _type = _utility.checkUserLoggedInWith(aEmail);
                        LOG.info("user is LOGgedin with :" + _type);
                        String adminAttributes;
                        AdminInterface adminInterface = new AdminImpl();
                        LOG.info("AdminImpl class object is created here ");
                        if (null != _type) {
                            LOG.info("Admin is LOGgin with _type is not null");
                            switch (_type) {
                                case ATTRIBUTE_EMAIL:
                                    adminmasterbean = new AdminMasterBean();
                                    adminmasterbean.setEmail_id(aEmail);
                                    LOG.info("Admin is logged with email id & call to isValidUserByEmail");
                                    result = adminInterface.isValidAdminEmailId(adminmasterbean);
                                    if (result) {
                                        LOG.info("Admin is verified with database and it's valid");
                                        try {
                                            LOG.info("call to findUserByEmail");
                                            adminmasterbean = new AdminMasterBean();
                                            adminmasterbean.setEmail_id(aEmail);
                                           AdminMasterBean adminbean = adminInterface.getAdminEmailId(adminmasterbean);
                                            if (adminAttributes != null) {
                                                LOG.info("userAttributes is not null");
                                                String admin_password = adminbean.getAdmin_password();
                                                String admin_unique_name = adminbean.getAdmin_unique_id();
                                                String admin_fname = adminbean.getAdmin_first_name();
                                                if (null != admin_password && !admin_password.isEmpty()) {
                                                    LOG.info("admin_password is not null or empty");
                                                    if (admin_password.equals(aPassword)) {
                                                        LOG.info("Password has been validated!!");

                                                        try {
                                                            if (null != admin_unique_name && !admin_unique_name.isEmpty()) {
                                                                jsonobject.put("message", "success");
                                                                jsonobject.put("url", "./adminArea.jsp");
                                                                session.setAttribute("admin_uniquename", admin_unique_name);
                                                                session.setAttribute("admin_fname", admin_fname);
                                                                LOG.info("Admin is Logged in successfully & user_uniquename :" + admin_unique_name);
                                                            } else {
                                                                LOG.info("Login failed");
                                                                jsonobject.put("message", "Something went wrong.Please try after some time!");
                                                            }
                                                        } catch (JSONException e) {
                                                            LOG.info("Something went wrong.Please try after some time!");
                                                            jsonobject.put("message", "Something went wrong.Please try after some time!");
                                                        }
                                                    } else {
                                                        LOG.info("Password is incorrect");
                                                        jsonobject.put("message", "Password is incorrect!");
                                                    }
                                                } else {
                                                    LOG.info("Admin is blocked and try to login.!");
                                                    jsonobject.put("message", "Admin is blocked. Please try to communicate with Support Team!");
                                                }
                                            } else {
                                                LOG.info("adminAttribute is found null");
                                                jsonobject.put("message", "Something went wrong.Please try after some time!");
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace(new PrintWriter(errors));
                                            sending.emailSending("Exception from Login Servlet in ATTRIBUT_EMAIL" + errors.toString());
                                            LOG.error("Exception from Login Servlet in ATTRIBUT_EMAIL", e);
                                            jsonobject.put("message", "Something went wrong.Please try after some time!");
                                        }
                                    } else {
                                        LOG.info("Emailid doesn't exist.Please enter correct Emailid");
                                        jsonobject.put("message", "Emailid doesn't exist.Please enter correct Emailid");
                                    }
                                    break;
                                case ATTRIBUTE_MOBILE:
                                    LOG.info("Admin is trying to LOGin with ATTRIBUTE_MOBILE username , Now call to isValidUserByMobile function");
                                    isValidUserName = adminInterface.isValidAdminPhoneNo(aEmail);
                                    if (isValidUserName == true) {
                                        LOG.info("UserName is validated with db");
                                        try {
                                            LOG.info("findUserByMobile method is called");
                                            adminAttributes = adminInterface.getAdminPhoneNo(aEmail);
                                            if (adminAttributes != null) {
                                                LOG.info("adminAttribute object is got from the database and it's not null");
                                                String admin_password = adminAttributes.get("admin_password");
                                                String admin_uniquename = adminAttributes.get("admin_unique_id");
                                                String admin_fname = adminAttributes.get("admin_fname");
                                                if (null != admin_password && !admin_password.isEmpty()) {
                                                    if (admin_password.equals(aPassword)) {
                                                        LOG.info("Admin password is matched successfully");
                                                        try {
                                                            if (null != admin_uniquename && !admin_uniquename.isEmpty()) {

                                                                jsonobject.put("message", "success");
                                                                jsonobject.put("url", "./adminArea.jsp");
                                                                session.setAttribute("admin_uniquename", admin_uniquename);
                                                                session.setAttribute("admin_fname", admin_fname);
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
                                                    jsonobject.put("message", "Something went wrong.Please try after some time!");
                                                }
                                            } else {
                                                LOG.info("UserAttribute is null reterived from the database");
                                                jsonobject.put("message", "Something went wrong.Please try after some time!!");
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
                                    LOG.info("It's not entered Valid user name . It's not email or mobileno");
                                    jsonobject.put("message", "Something went wrong.Please try after some time!");
                                    break;
                            }
                        } else {
                            LOG.info("Username is neither email or phoneno");
                            jsonobject.put("message", "Please enter either valid emailid or mobileno!");
                        }

                    }

                default:
                    LOG.info("Array list is null or empty in the addPromoCode loop");
                    jsonobject.put("message", "No record found in the database");
                    LOG.info("Page is send redirect to the coupanManagement.jsp");
                    break;

            }
            response.getWriter().write(jsonobject.toString());
            LOG.info("Response is send to back successfully");
        } catch (JSONException e) {
            LOG.error("JSONException from the AdminLoginController", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("JSONException from AdminLoginController" + errors.toString());

        }
    }

}
