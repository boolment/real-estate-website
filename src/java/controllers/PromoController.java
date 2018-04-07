package controllers;

import DAOImpl.PromoImpl;
import DAOInterface.PromoInterface;
import beans.PromoMasterBean;
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
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/PromoController.do")
public class PromoController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(PromoController.class);
    private static final String ATTRIBUTE_EMAIL = "mail";
    private static final String ATTRIBUTE_MOBILE = "mobile";
    private static final String ATTRIBUTE_INVALIDSTRING = "invalidString";
    private static final String ATTRIBUTE_VALIDSTRING = "validString";
    private static final String ATTRIBUTE_INVALIDLENGTH = "invalidlength";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("PromoController is called");
        StringWriter errors = new StringWriter();
        EmailSend sending = new EmailSend();
        try {
            PrintWriter out = response.getWriter();
            JSONObject jsonobject = new JSONObject();
            Utility _utility = new Utility();
            PromoInterface promoInterface = new PromoImpl();
            PromoMasterBean promomasterbean;
            boolean result;
            String code, sdate, edate, discount, coupanStatus, coupanId;
            LOG.info("Action is retervied in the servelt :" + request.getParameter("action"));
            switch (request.getParameter("action")) {
                case "addPromoCode":
                    if (null != request.getParameter("code") && !request.getParameter("code").isEmpty()) {
                        code = request.getParameter("code");
                        LOG.info("Coupan Code  is retervied in the servlet :" + code);
                    } else {
                        jsonobject.put("message", "Please enter The Coupan Code!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Coupan Code can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("sdate") && !request.getParameter("sdate").isEmpty()) {
                        sdate = request.getParameter("sdate");
                        LOG.info("Start Date  is retervied in the servlet :" + sdate);
                    } else {
                        jsonobject.put("message", "Please enter The Start Date!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Start Date can't be empty or null");
                        return;
                    }

                    if (null != request.getParameter("edate") && !request.getParameter("edate").isEmpty()) {
                        edate = request.getParameter("edate");
                        LOG.info("Expiry Date is retervied in the servlet :" + edate);
                    } else {
                        jsonobject.put("message", "Please enter The Expiry Date!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Expiry Date can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("discount") && !request.getParameter("discount").isEmpty()) {
                        discount = request.getParameter("discount");
                        LOG.info("Discount  is retervied in the servlet :" + discount);
                    } else {
                        jsonobject.put("message", "Please enter The Discount!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Discount can't be empty or null");
                        return;
                    }

                    promomasterbean = new PromoMasterBean();
                    promomasterbean.setPromo_code(code);
                    promomasterbean.setPromo_start_date(sdate);
                    promomasterbean.setPromo_end_date(edate);
                    promomasterbean.setPromo_creation_date(_utility.getCurrentDateTimeMS());
                    promomasterbean.setPromo_discount_price(discount);
                    promomasterbean.setPromo_status("Pending");
                    promomasterbean.setPromo_creator_id("Divya");
                    result = promoInterface.addPromoCode(promomasterbean);
                    if (result == true) {
                        jsonobject.put("message", "success");
                        LOG.info("Coupan is created successfully");
                    } else {
                        LOG.info("Coupan creation is failed");
                    }
                    break;
                case "getAllPromoCode":
                    LOG.info("getAllPromoCode is called");
                    List listViewPromo = promoInterface.getAllPromoCode();
                    if (listViewPromo != null) {
                        JSONArray coupanJSONArray = new JSONArray();
                        JSONObject coupanJSONObject;
                        Iterator itr = listViewPromo.iterator();
                        while (itr.hasNext()) {
                            promomasterbean = (PromoMasterBean) itr.next();
                            coupanJSONObject = new JSONObject();
                            LOG.info("This log is executed successfully");
                            coupanJSONObject.put("coupanId", promomasterbean.getPromo_id());
                            coupanJSONObject.put("CoupanCode", promomasterbean.getPromo_code());
                            coupanJSONObject.put("StartDate", promomasterbean.getPromo_start_date());
                            coupanJSONObject.put("EndDate", promomasterbean.getPromo_end_date());
                            coupanJSONObject.put("Date", promomasterbean.getPromo_creation_date());
                            coupanJSONObject.put("Discount", promomasterbean.getPromo_discount_price());
                            coupanJSONObject.put("CreatorId", promomasterbean.getPromo_creator_id());
                            coupanJSONObject.put("Status", promomasterbean.getPromo_status());
                            coupanJSONArray.put(coupanJSONObject);
                        }
                        jsonobject.put("coupan", coupanJSONArray);
                        jsonobject.put("message", "success");
                        LOG.info("coupan data is found in the database");
                    } else {
                        jsonobject.put("message", "No record found in the database");
                        LOG.info("No coupan data is found in the database");
                    }
                    break;
                case "updatePromoCode":
                    if (null != request.getParameter("code") && !request.getParameter("code").isEmpty()) {
                        code = request.getParameter("code");
                        LOG.info("Coupan Code  is retervied in the servlet :" + code);
                    } else {
                        jsonobject.put("message", "Please enter The Coupan Code!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Coupan Code can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("sdate") && !request.getParameter("sdate").isEmpty()) {
                        sdate = request.getParameter("sdate");
                        LOG.info("Start Date  is retervied in the servlet :" + sdate);
                    } else {
                        jsonobject.put("message", "Please enter The Start Date!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Start Date can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("edate") && !request.getParameter("edate").isEmpty()) {
                        edate = request.getParameter("edate");
                        LOG.info("Expiry Date  is retervied in the servlet :" + edate);
                    } else {
                        jsonobject.put("message", "Please enter The Expiry Date!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Expiry Date can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("discount") && !request.getParameter("discount").isEmpty()) {
                        discount = request.getParameter("discount");
                        LOG.info("Discount  is retervied in the servlet :" + discount);
                    } else {
                        jsonobject.put("message", "Please enter The Discount!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Discount can't be empty or null");
                        return;
                    }
                    if (null != request.getParameter("coupanStatus") && !request.getParameter("coupanStatus").isEmpty()) {
                        coupanStatus = request.getParameter("coupanStatus");
                        LOG.info("Status  is retervied in the servlet :" + coupanStatus);
                    } else {
                        jsonobject.put("message", "Please enter The Status!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Status can't be empty or null");
                        return;
                    }
                    coupanId = request.getParameter("coupanId");
                    LOG.info("Coupan Id  is retervied in the servlet :" + coupanId);
                    promomasterbean = new PromoMasterBean();
                    promomasterbean.setPromo_code(code);
                    promomasterbean.setPromo_start_date(sdate);
                    promomasterbean.setPromo_end_date(edate);
                    promomasterbean.setPromo_creation_date(_utility.getCurrentDateTimeMS());
                    promomasterbean.setPromo_discount_price(discount);
                    promomasterbean.setPromo_status(coupanStatus);
                    promomasterbean.setPromo_creator_id("Divya");
                    promomasterbean.setPromo_id(Integer.parseInt(coupanId));
                    result = promoInterface.updatePromoCode(promomasterbean);
                    if (result == true) {
                        jsonobject.put("message", "success");
                        LOG.info("Coupan is updated successfully");
                    } else {
                        LOG.info("Coupan updated is failed");
                    }
                    break;
                case "blockCoupan":
                    promomasterbean = new PromoMasterBean();
                    if (null != request.getParameter("id") && !request.getParameter("id").isEmpty()) {
                        promomasterbean.setPromo_id(Integer.parseInt(request.getParameter("id")));
                        LOG.info("Coupan id is reterived in the controller :" + promomasterbean.getPromo_id());
                    } else {
                        jsonobject.put("message", "Coupan id is not retervied in the controller!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Coupan id can't be empty or null");
                        return;
                    }
                    promomasterbean.setPromo_status("Block");
                    boolean blockedResult = promoInterface.blockPromoCode(promomasterbean);
                    if (blockedResult) {
                        LOG.info("Coupan is Blocked successfully");
                        jsonobject.put("message", "success");
                    } else {
                        LOG.info("Coupan Block is failed");
                        jsonobject.put("message", "Something went wrong controller side");
                        return;
                    }
                    break;
                case "activeCoupan":
                    promomasterbean = new PromoMasterBean();
                    if (null != request.getParameter("id") && !request.getParameter("id").isEmpty()) {
                        promomasterbean.setPromo_id(Integer.parseInt(request.getParameter("id")));
                        LOG.info("Coupan id is reterived in the controller :" + promomasterbean.getPromo_id());
                    } else {
                        jsonobject.put("message", "Coupan id is not retervied in the controller!");
                        response.getWriter().write(jsonobject.toString());
                        LOG.info("Coupan id can't be empty or null");
                        return;
                    }
                    promomasterbean.setPromo_status("Active");
                    boolean activeResult = promoInterface.blockPromoCode(promomasterbean);
                    if (activeResult) {
                        LOG.info("Coupan is Active successfully");
                        jsonobject.put("message", "success");
                    } else {
                        LOG.info("Coupan Active is failed");
                        jsonobject.put("message", "Something went wrong controller side");
                        return;
                    }
                    break;
                case "isValidPromoCode":
                    promomasterbean = new PromoMasterBean();
                    promomasterbean.setPromo_code("abcd");
                    promomasterbean.setPromo_status("Active");
                    PromoMasterBean promobean = promoInterface.isValidPromoCode(promomasterbean);
                    LOG.info("Promo Code:" +promobean.getPromo_code());
                    LOG.info("Promo Start Date:" +promobean.getPromo_start_date());
                    LOG.info("Promo End Date:" +promobean.getPromo_end_date());
                    LOG.info("Promo Discount Price:" +promobean.getPromo_discount_price());
                    break;
                    
                default:
                    LOG.info("Array list is null or empty in the addPromoCode loop");
                    jsonobject.put("message", "No record found in the database");
                    LOG.info("Page is send redirect to the coupanManagement.jsp");
                    break;
            }
            response.getWriter().write(jsonobject.toString());
        } catch (JSONException e) {
            LOG.error("JSONException from the PromoController", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("JSONException from PromoController" + e.toString());
        }
    }

}
