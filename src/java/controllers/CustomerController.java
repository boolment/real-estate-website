package controllers;

import DAOImpl.CustomerImpl;
import DAOInterface.CustomerInterface;
import beans.CustomerMasterBean;
import helper.EmailSend;
import helper.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/CustomerController.do")
public class CustomerController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CustomerController.class);
    private static final String ATTRIBUTE_EMAIL = "mail";
    private static final String ATTRIBUTE_MOBILE = "mobile";
    private static final String ATTRIBUTE_INVALIDSTRING = "invalidString";
    private static final String ATTRIBUTE_VALIDSTRING = "validString";
    private static final String ATTRIBUTE_INVALIDLENGTH = "invalidlength";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        boolean result;
        try {
            PrintWriter out = response.getWriter();
            JSONObject jsonobject = new JSONObject();
            Utility _utility = new Utility();
            CustomerMasterBean customermasterbean = new CustomerMasterBean();
            CustomerInterface customerInterface = new CustomerImpl();

            switch (request.getParameter("action")) {
                case "getAllCustomer":
                    LOG.info("getAllCustomer is called");
                    List arrayListCustomer = customerInterface.getAllCustomer();
                    if (arrayListCustomer != null) {
                        JSONArray customerJSONArray = new JSONArray();
                        JSONObject customerJSONObject;
                        Iterator itr = arrayListCustomer.iterator();
                        while (itr.hasNext()) {
                            customermasterbean = (CustomerMasterBean) itr.next();
                            customerJSONObject = new JSONObject();
                            LOG.info("This log is executed successfully");
                            customerJSONObject.put("Id", customermasterbean.getCustomer_id());
                            customerJSONObject.put("customerFirstName", customermasterbean.getCustomer_first_name());
                            customerJSONObject.put("customerLastName", customermasterbean.getCustomer_last_name());
                            customerJSONObject.put("customerUserName", customermasterbean.getCustomer_unique_id());
                            customerJSONObject.put("customermailId", customermasterbean.getCustomer_email_id());
                            customerJSONObject.put("customerMobileNo", customermasterbean.getCustomer_phone_number());
                            customerJSONObject.put("photo", customermasterbean.getCustomer_photo());
                            customerJSONObject.put("Gender", customermasterbean.getCustomer_gender());
                            customerJSONObject.put("DOB", customermasterbean.getCustomer_date_of_birth());
                            customerJSONObject.put("Address", customermasterbean.getCustomer_address_type());
                            customerJSONObject.put("MembershipType", customermasterbean.getCustomer_membership_type());
                            customerJSONObject.put("noOfTimesPropChanged", customermasterbean.getCustomer_number_of_times_property_changed());
                            customerJSONObject.put("PaymentStatus", customermasterbean.getCustomer_payment_status());
                            customerJSONObject.put("Date", customermasterbean.getCustomer_creation_date());
                            customerJSONObject.put("MembershipStartDate", customermasterbean.getCustomer_membership_start_date());
                            customerJSONObject.put("MembershipEndDate", customermasterbean.getCustomer_membership_end_date());
                            customerJSONObject.put("OwnerUnqId", customermasterbean.getCustomer_owner_unique_id());
                            customerJSONObject.put("PropUnqId", customermasterbean.getCustomer_property_unique_id());
                            customerJSONObject.put("Status", customermasterbean.getCustomer_status());
                            customerJSONArray.put(customerJSONObject);
                        }
                        jsonobject.put("customers", customerJSONArray);
                        jsonobject.put("message", "success");
                        LOG.info("Customer data is found in the database");
                    } else {
                        jsonobject.put("message", "No record found in the database");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("No Customer data is found in the database");
                    }
                    break;
                case "updateCustomer":
                    if (null != request.getParameter("fname") && !request.getParameter("fname").isEmpty()) {
                        customermasterbean.setCustomer_first_name(request.getParameter("fname"));
                        LOG.info(" First Name  is retervied in the servlet :" + request.getParameter("fname"));
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
                        LOG.info(" First Name can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("lname") && !request.getParameter("lname").isEmpty()) {
                        customermasterbean.setCustomer_last_name(request.getParameter("lname"));
                        LOG.info(" Last Name  is retervied in the servlet :" + request.getParameter("lname"));
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
                        LOG.info(" Last Name can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("mobno") && !request.getParameter("mobno").isEmpty()) {
                        customermasterbean.setCustomer_phone_number(request.getParameter("mobno"));
                        LOG.info(" phoneno. is retervied in the servlet :" + request.getParameter("mobno"));
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("mobno"));
                        LOG.info("Phone No. checkUserLoggedInWith retrun value is :" + _type);
                        if (!ATTRIBUTE_MOBILE.equals(_type)) {
                            jsonobject.put("message", "Staff Mobile number is not valid.Please enter valid 10 digit number followed by 0 or +91");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info(" mobile number is not valid.Please enter valid 10 digit number");
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
                        LOG.info(" phoneno can't be empty or null!");
                        return;
                    }
                    if (null != request.getParameter("emailId") && !request.getParameter("emailId").isEmpty()) {
                        customermasterbean.setCustomer_email_id(request.getParameter("emailId"));
                        LOG.info("mailId is not null or empty now call to checkUserLoggedInWith() method");
                        String _type = _utility.checkUserLoggedInWith(request.getParameter("emailId"));
                        LOG.info("mailId validation checked successfully----------:" + _type);
                        if (!ATTRIBUTE_EMAIL.equals(_type)) {
                            jsonobject.put("message", "Staff mailId format is not correct!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info(" mailId format is not correct");
                            return;
                        }
                        boolean emailValidate = false;
                        if (emailValidate == true) {
                            jsonobject.put("message", "This mailid already exist!");
                            response.getWriter().write(jsonobject.toString());
                            LOG.info("This mailid is already exist in the database");
                            return;
                        }
                        LOG.info(" Mail id  is retervied in the servlet :" + request.getParameter("emailId"));
                    } else {
                        jsonobject.put("message", "Please enter The Mail id!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info(" mail id can't be empty or null");
                        return;
                    }

                    if (null != request.getParameter("address") && !request.getParameter("address").isEmpty()) {
                        customermasterbean.setCustomer_address_type(request.getParameter("address"));
                        LOG.info("Address  is retervied in the servlet :" + request.getParameter("address"));
                    } else {
                        jsonobject.put("message", "Please enter The Address!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Address can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("ostatus") && !request.getParameter("ostatus").isEmpty()) {
                        customermasterbean.setCustomer_status(request.getParameter("ostatus"));
                        LOG.info("Status  is retervied in the servlet :" + request.getParameter("ostatus"));
                    } else {
                        jsonobject.put("message", "Please enter The Status!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Status Age can't be empty or null");
                        return;
                    }
                    customermasterbean.setCustomer_id(Integer.parseInt(request.getParameter("customerUniqueid")));
                    LOG.info("Id  is retervied in the servlet :" + request.getParameter("customerUniqueid"));
                    result = customerInterface.updateCustomer(customermasterbean);
                    if (result == true) {
                        jsonobject.put("message", "success");
                        LOG.info("Customer is updated successfully");
                    } else {
                        LOG.info("Customer updated is failed");
                    }
                    break;
                     case "blockCustomer":
                    customermasterbean = new CustomerMasterBean();
                    if (null != request.getParameter("id") && !request.getParameter("id").trim().isEmpty()) {
                        customermasterbean.setCustomer_unique_id((request.getParameter("id").trim()));
                        LOG.info("Customer id is reterived in the controller :" + customermasterbean.getCustomer_unique_id());
                    } else {
                        jsonobject.put("message", "owner id is not retervied in the controller!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Customer id can't be empty or null");
                        return;
                    }
                    customermasterbean.setCustomer_status("Block");
                    boolean blockedResult = customerInterface.blockCustomer(customermasterbean);
                    if (blockedResult) {
                        LOG.info("Customer is Blocked successfully");
                        jsonobject.put("message", "success");
                    } else {
                        LOG.info("Customer Block is failed");
                        jsonobject.put("message", "Something went wrong controller side");
                        return;
                    }
                    break;
                case "activeCustomer":
                    customermasterbean = new CustomerMasterBean();
                    if (null != request.getParameter("id") && !request.getParameter("id").trim().isEmpty()) {
                        customermasterbean.setCustomer_unique_id((request.getParameter("id").trim()));
                        LOG.info("Customer id is reterived in the controller :" + customermasterbean.getCustomer_unique_id());
                    } else {
                        jsonobject.put("message", "owner id is not retervied in the controller!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Customer id can't be empty or null");
                        return;
                    }
                    customermasterbean.setCustomer_status("Active");
                    boolean activeResult = customerInterface.blockCustomer(customermasterbean);
                    if (activeResult) {
                        LOG.info("Customer is Active successfully");
                        jsonobject.put("message", "success");
                    } else {
                        LOG.info("Customer Active is failed");
                        jsonobject.put("message", "Something went wrong controller side");
                        return;
                    }
                    break;
                default:
                    LOG.info("Array list is null or empty in the getAllCustomer loop");
                    jsonobject.put("message", "No record found in the database");
                    LOG.info("Page is send redirect to the customermanagement.jsp");
                    break;
            }
            response.getWriter().write(jsonobject.toString());
        } catch (JSONException e) {
            LOG.error("JSONException from the CustomersController", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("JSONException from CustomersController" + e.toString());
        }
    }

}
