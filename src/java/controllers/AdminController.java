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
            switch (request.getParameter("action")) {
                case "aSignIn":
                    if (null != request.getParameter("aEmail") && !request.getParameter("aEmail").isEmpty()) {
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
                    if (null != request.getParameter("aPassword") && !request.getParameter("aPassword").isEmpty()) {
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
                                            LOG.info("findUserByMobile method is called");
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
                    }
                    else
                    {
                         LOG.info("username & password is not valid!");
                            jsonobject.put("message", "username & password is not valid!");
                    }
                    break;
                default:
                    jsonobject.put("message", "Username does not exist!");
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
