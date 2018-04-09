package DAOImpl;

import DAOInterface.OwnerInterface;
import beans.OwnerMasterBean;
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

public class OwnerImpl implements OwnerInterface {

    private static final Logger LOG = Logger.getLogger(PgImpl.class);

    @Override
    public String addOwner(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateOwner(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean blockOwner(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteOwner(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OwnerMasterBean getOwner(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OwnerMasterBean> getAllOwner() {
LOG.info("getAllOwner Method is called");
        PreparedStatement pstmt = null;
        Connection conn = null;
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        ArrayList returnlist = new ArrayList();
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection is establised successfully in the getAllOwner");
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAllOwner method in OwnerImpl Class " + errors.toString());
            LOG.info("Exception from  getAllOwner method in OwnerImpl Class", e);
        }
        String query;
        query = "select owner_id, owner_fname, owner_lname, owner_unique_id, owner_email_id, owner_phone_no,owner_date_of_birth, owner_address_type, owner_gender, owner_creation_date, owner_status from owner_master";
        try {
            if (conn != null) {
                LOG.info("Connection is not null in the getAllOwner");
                pstmt = conn.prepareStatement(query);
                try (ResultSet result = pstmt.executeQuery()) {
                    while (result.next()) {
                        LOG.info("ResultSet loop exeucted successfully ");
                        OwnerMasterBean ownermasterbean = new OwnerMasterBean();
                        ownermasterbean.setOwner_id(result.getInt("owner_id"));
                        ownermasterbean.setOwner_first_name(result.getString("owner_fname"));
                        ownermasterbean.setOwner_last_name(result.getString("owner_lname"));
                        ownermasterbean.setOwner_unique_id(result.getString("owner_unique_id"));
                        ownermasterbean.setOwner_email_id(result.getString("owner_email_id"));
                        ownermasterbean.setOwner_phone_number(result.getString("owner_phone_no"));
                        ownermasterbean.setOwner_date_of_birth(result.getString("owner_date_of_birth"));
                        ownermasterbean.setOwner_address_type(result.getString("owner_address_type"));
                        ownermasterbean.setOwner_gender(result.getString("owner_gender"));
                        ownermasterbean.setOwner_creation_date(result.getString("owner_creation_date"));
                        ownermasterbean.setOwner_status(result.getString("owner_status"));
                        returnlist.add(ownermasterbean);
                    }
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending(errors.toString());
                    LOG.error("Exception from the ResultSet in the getAllOwner in OwnerImpl class", e);
                }
                LOG.info("ResultSet sucessfully close");
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !");
            }
        } catch (SQLException e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending(errors.toString());
            LOG.info("SQLException from the getAllOwner method in OwnerImpl", e);
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
                LOG.info("SQLException occured  in the getAllOwner !", e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getAllOwner method in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!", e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getAllOwner mthod in OwnerImpl Class" + errors.toString());
            }
        }
        if (!returnlist.isEmpty()) {
            LOG.info("Size of the returnlist is " + returnlist.size());
        } else {
            LOG.info("Size of the returnlist is zero");
        }
        return returnlist;    }

    @Override
    public String getOwnerUniqueId(OwnerMasterBean ownermasterbean) {
        LOG.info("getOwnerUniqueId method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        String UniqueId =null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getOwnerUniqueId mthod in OwnerImpl Class " + errors.toString());
        }
        query = "select owner_unique_id from owner_master where owner_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, ownermasterbean.getOwner_email_id());
                rs = pstmt.executeQuery();
                LOG.info("ExecuteQuery is executed successfully");
                if (rs.next()) {
                    LOG.info("Iterating ResultSet");
                    UniqueId = rs.getString("owner_unique_id");
                } else {
                    LOG.info("Emailid is not found in the db");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception occured  in the getOwnerUniqueId !!!" + e);
            System.out.println("Exception from  getOwnerUniqueId mthod in OwnerImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getOwnerUniqueId mthod in OwnerImpl Class " + errors.toString());
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
                sending.emailSending("SQLException from  getUserUniqueId mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getUserUniqueId mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return UniqueId;
    }

    @Override
    public boolean isValidOwner(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getOwnerCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnerEmailId(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidOwnerEmailId(OwnerMasterBean ownermasterbean) {
        LOG.info("isValidOwnerEmailId is called");
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
            sending.emailSending("Exception from  isValidOwnerEmailId mthod in OwnerImpl Class " + errors.toString());
        }
        query = "select owner_email_id from owner_master where owner_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is not null");
                try {
                    LOG.info("Before prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After prepareStatement");
                    pstmt.setString(1, ownermasterbean.getOwner_email_id());
                    rs = pstmt.executeQuery();
                    LOG.info("executeQuery executed successfully");
                    if (rs.next()) {
                        validity = rs.getString("owner_email_id").equals(ownermasterbean.getOwner_email_id());
                        LOG.info("ResultSet iterating");
                    } else {
                        LOG.info("Unable to find the emailid in the db");
                    }
                } catch (SQLException e) {
                    LOG.info("Exectpion occured during prepareStatement exectuion and executeQuery");

                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception from  isValidOwnerEmailId mthod in OwnerImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in the isValidOwnerEmailId !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception occured  in the isValidOwnerEmailId !!!" + e);
            System.out.println("Exception from  isValidOwnerEmailId mthod in OwnerImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidOwnerEmailId mthod in OwnerImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the isValidOwnerEmailId !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  isValidOwnerEmailId mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {

                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidOwnerEmailId mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return validity;
    }

    @Override
    public String getOwnerPhoneNo(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidOwnerPhoneNo(OwnerMasterBean ownermasterbean) {
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
            sending.emailSending("Exception from  isValidOwnerPhoneNo method in OwnerImpl Class " + errors.toString());
        }
        query = "select owner_phone_no from owner_master where owner_phone_no=? and owner_status=?";
        try {
            if (conn != null) {
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, ownermasterbean.getOwner_email_id());
                pstmt.setString(2, ownermasterbean.getOwner_status());
                rs = pstmt.executeQuery();
                if (rs.next()) {

                    validity = rs.getString("owner_phone_no").equals(ownermasterbean.getOwner_email_id());
                } else {
                    sending.emailSending("Mobileno doesn't exist in isValidOwnerPhoneNo !!!");
                }
            } else {
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            System.out.println("Exception from  isValidOwnerPhoneNo mthod in OwnerImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidOwnerPhoneNo mthod in OwnerImpl Class " + errors.toString());
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
                sending.emailSending("Exception from  isValidOwnerPhoneNo mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidOwnerPhoneNo mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return validity;
    }

    @Override
    public String getOwnerUserName(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidOwnerUserName(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnerPassword(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValidOwnerPassword(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setOwnerChangePassword(OwnerMasterBean ownermasterbean) {
 LOG.info("method is called setOwnerChangePassword");
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
            sending.emailSending("Exception from  setOwnerChangePassword mthod in OwnerImpl Class " + errors.toString());
        }
        query = "update owner_master set owner_password=? where owner_email_id=?";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement");
                    pstmt.setString(1, ownermasterbean.getOwner_password());
                    pstmt.setString(2, ownermasterbean.getOwner_email_id());
                    int result = pstmt.executeUpdate();
                    LOG.info("ExecuteUpdate method executed");
                    if (result > 0) {
                        LOG.info("Password is updated successfully in the db");
                        results = true;
                    } else {
                        LOG.info("Unable to update the password in the db" + result);
                    }
                } catch (SQLException e) {
                    LOG.error("Exception during the executeUpdate in the setOwnerChangePassword");

                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the setOwnerChangePassword in OwnerImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  setOwnerChangePassword mthod in OwnerImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  setOwnerChangePassword mthod in OwnerImpl Class " + errors.toString());
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
                sending.emailSending("SQLException from  setOwnerChangePassword mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {

                LOG.error("Exception in closing prepareStatement and connection in setOwnerChangePassword method");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  setOwnerChangePassword mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public String getOwnerOTP(OwnerMasterBean ownermasterbean) {
 LOG.info("getOwnerOTP method is called");
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
            sending.emailSending("Exception from  getOwnerOTP mthod in OwnerImpl Class " + errors.toString());
        }
        query = "select owner_otp from owner_master where owner_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, ownermasterbean.getOwner_email_id());
                rs = pstmt.executeQuery();
                LOG.info("ExecuteQuery is executed successfully");
                if (rs.next()) {
                    LOG.info("Iterating ResultSet");
                    otp = rs.getString("owner_otp");
                } else {
                    LOG.info("Emailid is not found in the db");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception occured  in the getOwnerOTP !!!" + e);
            System.out.println("Exception from  getOwnerOTP mthod in OwnerImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getOwnerOTP mthod in OwnerImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the getOwnerOTP !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getOwnerOTP mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getOwnerOTP mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return otp;
    }

    @Override
    public boolean setOwnerOTP(OwnerMasterBean ownermasterbean) {
        LOG.info("function is called in setOwnerOTP");
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
            sending.emailSending("Exception from  setOwnerOTP mthod in OwnerImpl Class " + errors.toString());
        }
        query = "update owner_master set owner_otp=? where owner_email_id=? and owner_status!=?";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement");
                    pstmt.setString(1, ownermasterbean.getOwner_otp());
                    pstmt.setString(2, ownermasterbean.getOwner_email_id());
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
                    LOG.error("Exception during the executeUpdate in the setOwnerOTP");

                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the setOwnerOTP in OwnerImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  setOwnerOTP mthod in OwnerImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  setOwnerOTP mthod in UserImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.error("SQLException in closing prepareStatement and connection in setOwnerOTP method" + e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  setOwnerOTP mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.error("Exception in closing prepareStatement and connection in setOwnerOTP method");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  setOwnerOTP mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public OwnerMasterBean isValidOwnerByPhoneNo(OwnerMasterBean ownermasterbean) {
        LOG.info("isValidOwnerByPhoneNo method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        ResultSet rs;
        Connection conn = null;
        OwnerMasterBean ownerbean = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidOwnerByPhoneNo mthod in OwnerImpl Class " + errors.toString());
        }
        query = "select owner_unique_id from owner_master where owner_email_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, ownermasterbean.getOwner_email_id());
                rs = pstmt.executeQuery();
                LOG.info("ExecuteQuery is executed successfully");
                if (rs.next()) {
                    LOG.info("Iterating ResultSet");
                    ownerbean = new OwnerMasterBean();
                    ownerbean.setOwner_unique_id(rs.getString("owner_unique_id"));
                    LOG.info("owner_unique_id:" + rs.getString("owner_unique_id"));
                    ownerbean.setOwner_first_name(rs.getString("owner_fname"));
                    LOG.info("owner_fname:" + rs.getString("owner_fname"));
                    ownerbean.setOwner_password(rs.getString("owner_password"));
                    LOG.info("owner_password:" + rs.getString("owner_password"));
                } else {
                    LOG.info("Emailid is not found in the db");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !!!");
            }
        } catch (SQLException e) {
            LOG.error("Exception occured  in the isValidOwnerByPhoneNo !!!" + e);
            System.out.println("Exception from  isValidOwnerByPhoneNo mthod in OwnerImpl Class" + e.getMessage());
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidOwnerByPhoneNo mthod in OwnerImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOG.info("SQLException occured  in the isValidOwnerByPhoneNo !!!" + e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  isValidOwnerByPhoneNo mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!" + e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidOwnerByPhoneNo mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return ownerbean;
    }

    @Override
    public OwnerMasterBean isValidOwnerByEmailId(OwnerMasterBean ownermasterbean) {
        LOG.info("isValidOwnerByEmailId method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        PreparedStatement pstmt = null;
        Connection conn = null;
        OwnerMasterBean ownerbean = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("connection is got from the db");
        } catch (Exception e) {
            LOG.error("Exception is got from the isValidOwnerByEmailId method ", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidOwnerByEmailId method in OwnerImpl Class " + errors.toString());
        }
        query = "select owner_unique_id,owner_fname,owner_password from owner_master  where owner_email_id=? and owner_status=? and owner_password=?";
        try {
            if (conn != null) {
                LOG.info("Connection is not null and log before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, ownermasterbean.getOwner_email_id());
                pstmt.setString(2, ownermasterbean.getOwner_status());
                pstmt.setString(3, ownermasterbean.getOwner_password());
                try (ResultSet result = pstmt.executeQuery()) {
                    if (result.next()) {
                        LOG.info("ResultSet loop exeucted successfully ");
                        ownerbean = new OwnerMasterBean();
                        ownerbean.setOwner_unique_id(result.getString("owner_unique_id"));
                        LOG.info("owner_unique_id:" + result.getString("owner_unique_id"));
                        ownerbean.setOwner_first_name(result.getString("owner_fname"));
                        LOG.info("owner_fname:" + result.getString("owner_fname"));
                        ownerbean.setOwner_password(result.getString("owner_password"));
                        LOG.info("owner_password:" + result.getString("owner_password"));
                    }
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending(errors.toString());
                    LOG.error("Exception from the ResultSet in the isValidOwnerByEmailId in OwnerImpl class", e);
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
                sending.emailSending("Exception from  isValidOwnerByEmailId mthod in OwnerImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidOwnerByEmailId mthod in OwnerImpl Class" + errors.toString());
            }
        }
        return ownerbean;
    }

}
