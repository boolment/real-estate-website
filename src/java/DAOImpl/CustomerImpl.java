package DAOImpl;

import DAOInterface.CustomerInterface;
import beans.CustomerMasterBean;
import helper.DBConnect;
import helper.EmailSend;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CustomerImpl implements CustomerInterface {

    private static final Logger LOG = Logger.getLogger(PgImpl.class);

    @Override
    public String addCustomer(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomer(CustomerMasterBean customermasterbean) {
        LOG.info("method is called updateCustomer");
        StringWriter errors = new StringWriter();
        EmailSend sending = new EmailSend();
        String query;
        PreparedStatement pstmt = null;
        boolean results = false;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("DB Connection established");
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  updateCustomer method in CustomerImpl Class " + errors.toString());
        }
        query = "update customer_master set  customer_fname=?,customer_lname=?,customer_email_id=?,customer_phone_no=?,customer_address_type=?,customer_status=? where customer_id=? ";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement in updateCustomer");
                    pstmt.setString(1, customermasterbean.getCustomer_first_name());
                    pstmt.setString(2, customermasterbean.getCustomer_last_name());
                    pstmt.setString(3, customermasterbean.getCustomer_email_id());
                    pstmt.setString(4, customermasterbean.getCustomer_phone_number());
                    pstmt.setString(5, customermasterbean.getCustomer_address_type());
                    pstmt.setString(6, customermasterbean.getCustomer_status());
                    pstmt.setInt(7, customermasterbean.getCustomer_id());
                    int result = pstmt.executeUpdate();
                    LOG.info("updateCustomer method executed");
                    if (result > 0) {
                        LOG.info("Coupan data  is updated successfully in the db updateCustomer");
                        results = true;
                    } else {
                        LOG.info("Unable to update the coupan data in the db" + result);
                    }
                } catch (SQLException e) {
                    LOG.error("Exception during the executeUpdate in the updateCustomer" + e);
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the updateCustomer in CustomerImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in updateCustomer from CustomerImpl !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  updateCustomer mthod in CustomerImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  updateCustomer mthod in CustomerImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("Prepared statement is closed successfully in the updateCustomer from CustomerImpl");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("Connection is closed successfully in the updateCustomer from CustomerImpl");
                }
            } catch (SQLException e) {
                LOG.error("SQLException in closing prepareStatement and connection in updateCustomer method" + e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  updateCustomer mthod in CustomerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.error("Exception in closing prepareStatement and connection in updateCustomer method from CustomerImpl");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  updateCustomer mthod in CustomerImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public boolean blockCustomer(CustomerMasterBean customermasterbean) {
 LOG.info("blockCustomer method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        boolean result = false;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database in blockCustomer method");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database in blockCustomer method", e);

            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  blockCustomer method in CustomerImpl Class " + errors.toString());
        }
        query = "update customer_master set customer_status=? where customer_unique_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, customermasterbean.getCustomer_status());
                pstmt.setString(2, customermasterbean.getCustomer_unique_id());
                int status = pstmt.executeUpdate();
                if (status > 0) {
                    result = true;
                    LOG.info("Customer is blocked successfully!");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in the blockCustomer method!!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database in the blockCustomer method!!!");
            }
        } catch (SQLException | NumberFormatException e) {
            LOG.info("Exception is get from blockCustomer method in CustomerImpl", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending(errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("preparedStatement is closed successfully in  the blockCustomer method in CustomerImpl class");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("connection is closed successfully in the blockCustomer method in CustomerImpl");
                }
            } catch (SQLException e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  blockCustomer method in CustomerImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  blockCustomer method in CustomerImpl Class" + errors.toString());
            }
        }
        return result;
    }

    @Override
    public boolean deleteCustomer(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerMasterBean getCustomer(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CustomerMasterBean> getAllCustomer() {
        LOG.info("getAllCustomer Method is called");
        PreparedStatement pstmt = null;
        Connection conn = null;
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        ArrayList returnlist = new ArrayList();
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection is establised successfully in the getAllCustomer");
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAllCustomer method in CustomerImpl Class " + errors.toString());
            LOG.info("Exception from  getAllCustomer method in CustomerImpl Class", e);
        }
        String query = "select customer_id, customer_fname, customer_lname, customer_unique_id, customer_email_id, customer_phone_no, customer_photo, customer_gender, customer_date_of_birth, customer_address_type, customer_membership_type, customer_no_of_property_changed, customer_payment_status, customer_creation_date, customer_membership_start_date, customer_membership_end_date, customer_owner_unique_id, customer_property_unique_id, customer_status from customer_master";
        try {
            if (conn != null) {
                LOG.info("Connection is not null in the getAllCustomer");
                pstmt = conn.prepareStatement(query);
                try (ResultSet result = pstmt.executeQuery()) {
                    while (result.next()) {
                        LOG.info("ResultSet loop exeucted successfully ");
                        CustomerMasterBean customerBean = new CustomerMasterBean();
                        customerBean.setCustomer_id(result.getInt("customer_id"));
                        customerBean.setCustomer_first_name(result.getString("customer_fname"));
                        customerBean.setCustomer_last_name(result.getString("customer_lname"));
                        customerBean.setCustomer_unique_id(result.getString("customer_unique_id"));
                        customerBean.setCustomer_email_id(result.getString("customer_email_id"));
                        customerBean.setCustomer_phone_number(result.getString("customer_phone_no"));
                        customerBean.setCustomer_photo(result.getString("customer_photo"));
                        customerBean.setCustomer_gender(result.getString("customer_gender"));
                        customerBean.setCustomer_date_of_birth(result.getString("customer_date_of_birth"));
                        customerBean.setCustomer_address_type(result.getString("customer_address_type"));
                        customerBean.setCustomer_membership_type(result.getString("customer_membership_type"));
                        customerBean.setCustomer_number_of_times_property_changed(result.getString("customer_no_of_property_changed"));
                        customerBean.setCustomer_payment_status(result.getString("customer_payment_status"));
                        customerBean.setCustomer_creation_date(result.getString("customer_creation_date"));
                        customerBean.setCustomer_membership_start_date(result.getString("customer_membership_start_date"));
                        customerBean.setCustomer_membership_end_date(result.getString("customer_membership_end_date"));
                        customerBean.setCustomer_owner_unique_id(result.getString("customer_owner_unique_id"));
                        customerBean.setCustomer_property_unique_id(result.getString("customer_property_unique_id"));
                        customerBean.setCustomer_status(result.getString("customer_status"));
                        returnlist.add(customerBean);
                    }
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending(errors.toString());
                    LOG.error("Exception from the ResultSet in the getAllCustomer in CustomerImpl class");
                }
                LOG.info("ResultSet sucessfully close");
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending(errors.toString());
            LOG.info("SQLException from the getAllCustomer method in CustomerImpl", e);
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("Prepared statement is closed successfully");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("Connection is closed successfully");
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the getAllCustomer !!!", e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getAllCustomer method in CustomerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!", e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getAllCustomer mthod in CustomerImpl Class" + errors.toString());
            }
        }
        if (!returnlist.isEmpty()) {
            LOG.info("Size of the returnlist is " + returnlist.size());
        } else {
            LOG.info("Size of the returnlist is zero");
        }
        return returnlist;
    }

    @Override
    public String getCustomerUniqueId(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidCustomer(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getCustomerCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomerEmailId(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidCustomerEmailId(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomerPhoneNo(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidCustomerPhoneNo(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomerUserName(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidCustomerUserName(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomerPassword(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidCustomerPassword(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setCustomerChangePassword(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCustomerOTP(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setCustomerOTP(CustomerMasterBean customermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
