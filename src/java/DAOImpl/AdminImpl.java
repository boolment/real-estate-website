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
 LOG.info("getAdminEmailId method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        String email = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAdminEmailId mthod in AdminImpl Class " + errors.toString());
        }
        query = "select admin_email_id from admin_master where admin_unique_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, adminmasterbean.getAdmin_unique_id());
                rs = pstmt.executeQuery();
                LOG.info("ExecuteQuery is executed successfully");
                if (rs.next()) {
                    LOG.info("Iterating ResultSet");
                    email = rs.getString("admin_email_id");
                } else {
                    LOG.info("Emailid is not found in the db");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception occured  in the getAdminEmailId !!!" + e);

            System.out.println("Exception from  getAdminEmailId mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAdminEmailId mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the getAdminEmailId !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getAdminEmailId mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);

                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getAdminEmailId mthod in AdminImpl Class" + errors.toString());
            }
        }
        return email;
    }

    @Override
    public boolean isValidAdminEmailId(AdminMasterBean adminmasterbean) {
        LOG.info("isValidAdminEmailId is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        boolean validity = false;
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection is established");
        } catch (Exception e) {
            LOG.info("Exception in Connection established" + e);

            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidAdminEmailId mthod in AdminImpl Class " + errors.toString());
        }
        query = "select admin_email_id from admin_master where admin_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is not null");
                try {
                    LOG.info("Before prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After prepareStatement");
                    pstmt.setString(1, adminmasterbean.getEmail_id());
                    rs = pstmt.executeQuery();
                    LOG.info("executeQuery executed successfully");
                    if (rs.next()) {
                        validity = rs.getString("admin_email_id").equals(adminmasterbean.getEmail_id());
                        LOG.info("ResultSet iterating");
                    } else {
                        LOG.info("Unable to find the emailid in the db");
                    }
                } catch (SQLException e) {
                    LOG.info("Exectpion occured during prepareStatement exectuion and executeQuery");

                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception from  isValidAdminEmailId mthod in AdminImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in the isValidAdminEmailId !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception occured  in the isValidAdminEmailId !!!" + e);
            System.out.println("Exception from  isValidAdminEmailId mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidAdminEmailId mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the isValidAdminEmailId !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  isValidAdminEmailId mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {

                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidAdminEmailId mthod in AdminImpl Class" + errors.toString());
            }
        }
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
            sending.emailSending("Exception from  isValidAdminPhoneNo method in AdminImpl Class " + errors.toString());
        }
        query = "select admin_mobile_no from admin_master where admin_mobile_no=? and admin_status=?";
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, adminmasterbean.getEmail_id());
                pstmt.setString(2, adminmasterbean.getStatus());
                rs = pstmt.executeQuery();
                if (rs.next()) {

                    validity = rs.getString("admin_mobile_no").equals(adminmasterbean.getEmail_id());
                } else {
                    sending.emailSending("Mobileno doesn't exist in isValidAdminPhoneNo !!!");
                }
            } else {
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            System.out.println("Exception from  isValidAdminPhoneNo mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidAdminPhoneNo mthod in AdminImpl Class " + errors.toString());
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
                sending.emailSending("Exception from  isValidAdminPhoneNo mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidAdminPhoneNo mthod in AdminImpl Class" + errors.toString());
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
        LOG.info("method is called setAdminChangePassword");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        boolean results = false;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("DB Connection established");
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  setAdminChangePassword mthod in AdminImpl Class " + errors.toString());
        }
        query = "update admin_master set admin_password=? where admin_email_id=?";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement");
                    pstmt.setString(1, adminmasterbean.getAdmin_password());
                    pstmt.setString(2, adminmasterbean.getEmail_id());
                    int result = pstmt.executeUpdate();
                    LOG.info("ExecuteUpdate method executed");
                    if (result > 0) {
                        LOG.info("Password is updated successfully in the db");
                        results = true;
                    } else {
                        LOG.info("Unable to update the password in the db" + result);
                    }
                } catch (SQLException e) {
                    LOG.error("Exception during the executeUpdate in the setAdminChangePassword");

                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the setAdminChangePassword in AdminImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  setAdminChangePassword mthod in AdminImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  setAdminChangePassword mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("PreparedStatement is closed successfully");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("Connection is closed successfully");
                }
            } catch (SQLException e) {
                LOG.error("SQLException in closing prepareStatement and connection in ActivateUser method" + e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  setAdminChangePassword mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {

                LOG.error("Exception in closing prepareStatement and connection in setAdminChangePassword method");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  setAdminChangePassword mthod in AdminImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public String getAdminOTP(AdminMasterBean adminmasterbean) {
        LOG.info("getAdminOTP method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        String otp = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database" + e);

            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAdminOTP mthod in AdminImpl Class " + errors.toString());
        }
        query = "select admin_otp from admin_master where admin_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, adminmasterbean.getEmail_id());
                rs = pstmt.executeQuery();
                LOG.info("ExecuteQuery is executed successfully");
                if (rs.next()) {
                    LOG.info("Iterating ResultSet");
                    otp = rs.getString("admin_otp");
                } else {
                    LOG.info("Emailid is not found in the db");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception occured  in the getAdminOTP !!!" + e);
            System.out.println("Exception from  getAdminOTP mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAdminOTP mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the getAdminOTP !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getAdminOTP mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getAdminOTP mthod in AdminImpl Class" + errors.toString());
            }
        }
        return otp;
    }

    @Override
    public boolean setAdminOtp(AdminMasterBean adminmasterbean) {
        LOG.info("function is called in setAdminOtp");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        boolean results = false;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("DB Connection established");
        } catch (Exception e) {

            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  setAdminOtpByEmail mthod in AdminImpl Class " + errors.toString());
        }
        query = "update admin_master set admin_otp=? where admin_email_id=? and admin_status!=?";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement");
                    pstmt.setString(1, adminmasterbean.getOtp());
                    pstmt.setString(2, adminmasterbean.getEmail_id());
                    pstmt.setString(3, "Block");
                    int result = pstmt.executeUpdate();
                    LOG.info("ExecuteUpdate method executed");
                    if (result > 0) {
                        LOG.info("OTP is updated successfully in the db");
                        results = true;
                    } else {
                        LOG.info("Unable to update the OTP in the db" + result);
                    }
                } catch (SQLException e) {
                    LOG.error("Exception during the executeUpdate in the setAdminOtp");

                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the setAdminOtpByEmail in AdminImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  setAdminOtp mthod in AdminImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  setAdminOtp mthod in UserImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.error("SQLException in closing prepareStatement and connection in setAdminOtpByEmail method" + e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  setAdminOtpByEmail mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.error("Exception in closing prepareStatement and connection in setAdminOtpByEmail method");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  setAdminOtpByEmail mthod in AdminImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public AdminMasterBean isValidAdminByPhoneNo(AdminMasterBean adminmasterbean) {
        LOG.info("isValidAdminByPhoneNo method is called");
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
            sending.emailSending("Exception from  isValidAdminByPhoneNo mthod in AdminImpl Class " + errors.toString());
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
            LOG.error("Exception occured  in the isValidAdminByPhoneNo !!!" + e);
            System.out.println("Exception from  isValidAdminByPhoneNo mthod in AdminImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidAdminByPhoneNo mthod in AdminImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the isValidAdminByPhoneNo !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  isValidAdminByPhoneNo mthod in AdminImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidAdminByPhoneNo mthod in AdminImpl Class" + errors.toString());
            }
        }
        return adminbean;
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
            sending.emailSending("Exception from  getAdminUniqueId mthod in AdminImpl Class " + errors.toString());
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
