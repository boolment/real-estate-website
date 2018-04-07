package controllers;

import helper.EmailSend;
import helper.Utility;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.JSONObject;

@WebServlet("/MembershipController.do")
public class MembershipController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(MembershipController.class);
    private static final String ATTRIBUTE_EMAIL = "mail";
    private static final String ATTRIBUTE_MOBILE = "mobile";
    private static final String ATTRIBUTE_INVALIDSTRING = "invalidString";
    private static final String ATTRIBUTE_VALIDSTRING = "validString";
    private static final String ATTRIBUTE_INVALIDLENGTH = "invalidlength";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            JSONObject jsonobject = new JSONObject();
            Utility _utility = new Utility();
            EmailSend emailsend = new EmailSend();

        } catch (IOException e) {

        }
    }

}
