package controllers;

import DAOImpl.OwnerImpl;
import DAOInterface.OwnerInterface;
import beans.OwnerMasterBean;
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
                            jsonobject.put("message", "Admin Emailid format is not correct!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("Owner Emailid format is not correct");
                            return;
                        }
                    } else {
                        jsonobject.put("message", "Please enter  admin emailid!");
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
                            LOG.info("Admin is LOGgin with _type is not null");
                            switch (_type) {
                                case ATTRIBUTE_EMAIL:
                                    ownermasterbean.setOwner_email_id(request.getParameter("oEmail"));
                                    OwnerMasterBean ownermastbean = ownerInterface.isValidOwnerByEmailId(ownermasterbean);
                                    if (ownermastbean != null) {
                                        if (ownermastbean.getOwner_password().equals(ownermasterbean.getOwner_password())) {
                                            LOG.info("Admin password is matched successfully");
                                            try {
                                                if (null != ownermastbean.getOwner_unique_id() && !ownermastbean.getOwner_unique_id().isEmpty()) {
                                                    jsonobject.put("message", "success");
                                                    jsonobject.put("url", "./ownerArea.jsp");
                                                    session.setAttribute("owner_unique_id", ownermastbean.getOwner_unique_id());
                                                    session.setAttribute("owner_fname", ownermastbean.getOwner_first_name());
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
