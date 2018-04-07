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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnerUniqueId(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            sending.emailSending("Exception from  isValidAdminPhoneNo method in AdminImpl Class " + errors.toString());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnerOTP(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setOwnerOTP(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OwnerMasterBean isValidOwnerByPhoneNo(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OwnerMasterBean isValidOwnerByEmailId(OwnerMasterBean ownermasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
