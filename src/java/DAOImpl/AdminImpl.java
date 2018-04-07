package DAOImpl;

import DAOInterface.AdminInterface;
import beans.AdminMasterBean;
import beans.PromoMasterBean;
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

public class AdminImpl implements AdminInterface {

    private static final Logger LOG = Logger.getLogger(AdminImpl.class);

    @Override
    public String addAdmin(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAdmin(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean blockAdmin(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAdmin(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminMasterBean getAdmin(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AdminMasterBean> getAllAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//
//    @Override
//    public String getAdminUniueId(AdminMasterBean adminmasterbean) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public boolean isValidAmin(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getAdminCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdminEmailId(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidAdminEmailId(AdminMasterBean adminmasterbean) {
        LOG.info("isValidUserByEmail method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        boolean validity = false;
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        ArrayList returnlist = new ArrayList();
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("DB connection establised ");
        } catch (Exception e) {
            LOG.error("Exception occured during get connection from db");

            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidUserByEmail method in AdminImpl Class " + errors.toString());
        }
        query = "select admin_email_id from admin_master where admin_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is not null");
                try {
                    pstmt = conn.prepareStatement(query);
                    LOG.info("PreparedStatement value assigned");
                    pstmt.setString(1, adminmasterbean.getEmail_id());
                    rs = pstmt.executeQuery();
                    LOG.info("ExecuteQuery is executed");
                    if (rs.next()) {
                        validity = rs.getString("admin_email_id").equals(adminmasterbean.getEmail_id());
                        LOG.info("******************************" + validity);
                        LOG.info("ResultSet is iterated successfully");
                    } else {
                        LOG.info("Record is not found in the database");

                    }
                    rs.close();
                    LOG.info("ResultSet is closed");
                } catch (SQLException e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception from  isValidUserByEmail mthod in AdminImpl Class " + errors.toString());
                    LOG.error("Exception from the isValidUser", e);
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {

            LOG.error("Exception from  isValidUserByEmail mthod in AdminImpl Class", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidUserByEmail mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {

                LOG.error("SQLException in closing prepareStatement and connection ", e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidUserByEmail mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {

                LOG.error("SQLException in closing prepareStatement and connection ", e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidUserByEmail mthod in AdminImpl Class" + errors.toString());
            }
        }
        LOG.info("Admin is validated and status is :" + validity);
        return validity;
    }

    @Override
    public String getAdminPhoneNo(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidAdminPhoneNo(AdminMasterBean adminmasterbean) {
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        boolean validity = false;
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("DB connection establised ");
        } catch (Exception e) {
            LOG.error("Exception occured during get connection from db");
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidUserByMobile method in AdminImpl Class " + errors.toString());
        }
        query = "select admin_mobile_no from admin where admin_mobile_no=? and admin_status=?";
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, adminmasterbean.getEmail_id());
                pstmt.setString(2, adminmasterbean.getStatus());
                rs = pstmt.executeQuery();
                if (rs.next()) {

                    validity = rs.getString("admin_mobile_no").equals(adminmasterbean.getEmail_id());
                } else {
                    sending.emailSending("Mobileno doesn't exist in isValidUserByMobile !!!");
                }
            } else {
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            System.out.println("Exception from  isValidUserByMobile mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidUserByMobile mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidUserByMobile mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidUserByMobile mthod in AdminImpl Class" + errors.toString());
            }
        }
        return validity;
    }

    @Override
    public String getAdminUserName(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidAdminUserName(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdminPassword(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setAdminChangePassword(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdminOTP(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setAdminOtp(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminMasterBean isValidAdminByPhoneNo(AdminMasterBean adminmasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AdminMasterBean isValidAdminByEmailId(AdminMasterBean adminmasterbean) {
        LOG.info("isValidAdminByEmailId method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        Connection conn = null;
        AdminMasterBean adminbean = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("connection is got from the db");
        } catch (Exception e) {
            LOG.error("Exception is got from the isValidAdminByEmailId method ", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidAdminByEmailId method in AdminImpl Class " + errors.toString());
        }
        query = "select admin_unique_id,admin_fname,admin_password from admin_master  where admin_email_id=? and admin_status=? and admin_password=?";
        try {
            if (conn != null) {
                LOG.info("Connection is not null and log before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, adminmasterbean.getEmail_id());
                pstmt.setString(2, adminmasterbean.getStatus());
                pstmt.setString(3, adminmasterbean.getAdmin_password());
                try (ResultSet result = pstmt.executeQuery()) {
                    if (result.next()) {
                        // result.getString("admin_email_id").equals(adminmasterbean.getEmail_id());
                        LOG.info("ResultSet loop exeucted successfully ");
                        adminbean = new AdminMasterBean();
                        adminbean.setAdmin_unique_id(result.getString("admin_unique_id"));
                        LOG.info("admin_unique_id:" + result.getString("admin_unique_id"));
                        adminbean.setAdmin_first_name(result.getString("admin_fname"));
                        LOG.info("admin_fname:" + result.getString("admin_fname"));
                        adminbean.setAdmin_password(result.getString("admin_password"));
                        LOG.info("admin_password:" + result.getString("admin_password"));
                    }
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending(errors.toString());
                    LOG.error("Exception from the ResultSet in the isValidAdminByEmailId in AdminImpl class", e);
                }
                LOG.info("ResultSet sucessfully close");
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!  Connection is null");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database Connection is null!!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception from the isValidPromoCode", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending(errors.toString());
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
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidAdminByEmailId mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidAdminByEmailId mthod in AdminImpl Class" + errors.toString());
            }
        }
        return adminbean;
    }

    @Override
    public AdminMasterBean getAdminUniueId(AdminMasterBean adminmasterbean) {
        LOG.info("getAdminUniueId method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        AdminMasterBean adminbean = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAdminUniueId mthod in AdminImpl Class " + errors.toString());
        }
        query = "select admin_unique_id from admin_master where admin_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, adminmasterbean.getEmail_id());
                rs = pstmt.executeQuery();
                LOG.info("ExecuteQuery is executed successfully");
                if (rs.next()) {
                    LOG.info("Iterating ResultSet");
                    adminbean = new AdminMasterBean();
                    adminbean.setAdmin_unique_id(rs.getString("admin_unique_id"));
                    LOG.info("admin_unique_id:" + rs.getString("admin_unique_id"));
                    adminbean.setAdmin_first_name(rs.getString("admin_fname"));
                    LOG.info("admin_fname:" + rs.getString("admin_fname"));
                    adminbean.setAdmin_password(rs.getString("admin_password"));
                    LOG.info("admin_password:" + rs.getString("admin_password"));
                } else {
                    LOG.info("Emailid is not found in the db");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception occured  in the getAdminUniqueId !!!" + e);
            System.out.println("Exception from  getAdminUniqueId mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAdminUniqueId mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the getUserUniqueId !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getUserUniqueId mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getUserUniqueId mthod in AdminImpl Class" + errors.toString());
            }
        }
        return adminbean;
    }

}
