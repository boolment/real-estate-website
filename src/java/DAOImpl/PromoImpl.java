package DAOImpl;

import DAOInterface.PromoInterface;
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

public class PromoImpl implements PromoInterface {

    private static final Logger LOG = Logger.getLogger(PromoImpl.class);

    @Override
    public boolean addPromoCode(PromoMasterBean promomasterbean) {
        LOG.info("method is called addPromoCode");
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
            sending.emailSending("Exception from  addPromoCode method in PromoImpl Class " + errors.toString());
        }
        query = "insert into promo_master(promo_code, promo_discount_price, promo_start_date, promo_end_date, promo_creator_id, promo_creation_date, promo_status)values(?,?,?,?,?,?,?)";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement in addPromoCode");
                    pstmt.setString(1, promomasterbean.getPromo_code());
                    pstmt.setString(2, promomasterbean.getPromo_discount_price());
                    pstmt.setString(3, promomasterbean.getPromo_start_date());
                    pstmt.setString(4, promomasterbean.getPromo_end_date());
                    pstmt.setString(5, promomasterbean.getPromo_creator_id());
                    pstmt.setString(6, promomasterbean.getPromo_creation_date());
                    pstmt.setString(7, promomasterbean.getPromo_status());
                    int result = pstmt.executeUpdate();
                    LOG.info("addPromoCode method executed");
                    if (result > 0) {
                        LOG.info("Coupan data  is updated successfully in the db addPromoCode");
                        results = true;
                    } else {
                        LOG.info("Unable to update the coupan data in the db" + result);
                    }
                } catch (SQLException e) {
                    LOG.error("Exception during the executeUpdate in the addPromoCode" + e);
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the addPromoCode in PromoImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in addPromoCode from PromoImpl !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  addPromoCode mthod in PromoImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  addPromoCode mthod in PromoImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("Prepared statement is closed successfully in the addPromoCode from PromoImpl");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("Connection is closed successfully in the addPromoCode from PromoImpl");
                }
            } catch (SQLException e) {
                LOG.error("SQLException in closing prepareStatement and connection in addPromoCode method" + e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  addPromoCode mthod in PromoImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.error("Exception in closing prepareStatement and connection in addPromoCode method from PromoImpl");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  addPromoCode mthod in PromoImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public boolean updatePromoCode(PromoMasterBean promomasterbean) {
        LOG.info("method is called updatePromoCode");
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
            sending.emailSending("Exception from  updatePromoCode method in PromoImpl Class " + errors.toString());
        }
        query = "update promo_master set  promo_code=?,promo_discount_price=?,promo_start_date=?,promo_end_date=?,promo_creator_id=?,promo_creation_date=?,promo_status=? where promo_id=? ";
        try {
            if (conn != null) {
                try {
                    LOG.info("Execution before the prepareStatement");
                    pstmt = conn.prepareStatement(query);
                    LOG.info("After the prepareStatement in updatePromoCode");
                    pstmt.setString(1, promomasterbean.getPromo_code());
                    pstmt.setString(2, promomasterbean.getPromo_discount_price());
                    pstmt.setString(3, promomasterbean.getPromo_start_date());
                    pstmt.setString(4, promomasterbean.getPromo_end_date());
                    pstmt.setString(5, promomasterbean.getPromo_creator_id());
                    pstmt.setString(6, promomasterbean.getPromo_creation_date());
                    pstmt.setString(7, promomasterbean.getPromo_status());
                    pstmt.setInt(8, promomasterbean.getPromo_id());
                    int result = pstmt.executeUpdate();
                    LOG.info("updatePromoCode method executed");
                    if (result > 0) {
                        LOG.info("Coupan data  is updated successfully in the db updatePromoCode");
                        results = true;
                    } else {
                        LOG.info("Unable to update the coupan data in the db" + result);
                    }
                } catch (SQLException e) {
                    LOG.error("Exception during the executeUpdate in the updatePromoCode" + e);
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception during the executeUpdate in the updatePromoCode in PromoImpl Class " + errors.toString());
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in updatePromoCode from PromoImpl !!!");
            }
        } catch (Exception e) {
            LOG.error("Exception from  updatePromoCode mthod in PromoImpl Class" + e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  updatePromoCode mthod in PromoImpl Class " + errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("Prepared statement is closed successfully in the updatePromoCode from PromoImpl");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("Connection is closed successfully in the updatePromoCode from PromoImpl");
                }
            } catch (SQLException e) {
                LOG.error("SQLException in closing prepareStatement and connection in updatePromoCode method" + e);
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  updatePromoCode mthod in PromoImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.error("Exception in closing prepareStatement and connection in updatePromoCode method from PromoImpl");
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  updatePromoCode mthod in PromoImpl Class" + errors.toString());
            }
        }
        return results;
    }

    @Override
    public boolean deletePromoCode(PromoMasterBean promomasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean blockPromoCode(PromoMasterBean promomasterbean) {
        LOG.info("blockPromoCode method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        boolean result = false;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection establishment successfully with database in blockPromoCode method");
        } catch (Exception e) {
            LOG.error("Connection establishment failed with database in blockPromoCode method", e);

            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  blockPromoCode method in PromoImpl Class " + errors.toString());
        }
        query = "update promo_master set promo_status=? where promo_id=?";
        try {
            if (conn != null) {
                LOG.info("Connection is establisehd and before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, promomasterbean.getPromo_status());
                pstmt.setInt(2, promomasterbean.getPromo_id());
                int status = pstmt.executeUpdate();
                if (status > 0) {
                    result = true;
                    LOG.info("Coupan is blocked successfully!");
                }
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database in the blockPromoCode method!!!");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database in the blockPromoCode method!!!");
            }
        } catch (SQLException | NumberFormatException e) {
            LOG.info("Exception is get from blockPromoCode method in PromoImpl", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending(errors.toString());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    LOG.info("preparedStatement is closed successfully in  the blockPromoCode method in PromoImpl class");
                }
                if (conn != null) {
                    conn.close();
                    LOG.info("connection is closed successfully in the blockPromoCode method in PromoImpl");
                }
            } catch (SQLException e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  blockPromoCode method in PromoImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  blockPromoCode method in PromoImpl Class" + errors.toString());
            }
        }
        return result;
    }

    @Override
    public PromoMasterBean getPromoCode(PromoMasterBean promomasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PromoMasterBean> getAllPromoCode() {
        LOG.info("getAllPromoCode Method is called");
        PreparedStatement pstmt = null;
        Connection conn = null;
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        ArrayList returnlist = new ArrayList();
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("Connection is establised successfully in the getAllPromoCode");
        } catch (Exception e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  getAllPromoCode method in PromoImpl Class " + errors.toString());
            LOG.info("Exception from  getAllPromoCode method in PromoImpl Class", e);
        }
        String query;
        query = "select promo_id, promo_code, promo_discount_price, promo_start_date, promo_end_date, promo_creator_id, promo_creation_date, promo_status from promo_master";
        try {
            if (conn != null) {
                LOG.info("Connection is not null in the getAllPromoCode");
                pstmt = conn.prepareStatement(query);
                try (ResultSet result = pstmt.executeQuery()) {
                    while (result.next()) {
                        LOG.info("ResultSet loop exeucted successfully ");
                        PromoMasterBean promomasterbean = new PromoMasterBean();
                        promomasterbean.setPromo_id(result.getInt("promo_id"));
                        promomasterbean.setPromo_code(result.getString("promo_code"));
                        promomasterbean.setPromo_discount_price(result.getString("promo_discount_price"));
                        promomasterbean.setPromo_start_date(result.getString("promo_start_date"));
                        promomasterbean.setPromo_end_date(result.getString("promo_end_date"));
                        promomasterbean.setPromo_creator_id(result.getString("promo_creator_id"));
                        promomasterbean.setPromo_creation_date(result.getString("promo_creation_date"));
                        promomasterbean.setPromo_status(result.getString("promo_status"));
                        returnlist.add(promomasterbean);
                    }
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending(errors.toString());
                    LOG.error("Exception from the ResultSet in the getAllPromoCode in PromoImpl class", e);
                }
                LOG.info("ResultSet sucessfully close");
            } else {
                LOG.info("Prepared Statement is not confirugred properly & Unable to connect from database !");
                sending.emailSending("Prepared Statement is not confirugred properly & Unable to connect from database !");
            }
        } catch (SQLException e) {
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending(errors.toString());
            LOG.info("SQLException from the getAllPromoCode method in PromoImpl", e);
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
                LOG.info("SQLException occured  in the getAllPromoCode !", e);
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("SQLException from  getAllPromoCode method in PromoImpl Class " + errors.toString());
            } catch (Exception e) {
                LOG.info("Exception in closing prepareStatement and connection !!!", e);
                System.out.println("Exception in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getAllPromoCode mthod in PromoImpl Class" + errors.toString());
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
    public Long getAllPromoCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean approvePromoCode(PromoMasterBean promomasterbean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PromoMasterBean isValidPromoCode(PromoMasterBean promomasterbean) {
        LOG.info("isValidPromoCode method is called");
        EmailSend sending = new EmailSend();
        StringWriter errors = new StringWriter();
        String query;
        ArrayList returnlist = new ArrayList();
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            conn = DBConnect.getDBConnection();
            LOG.info("connection is got from the db");
        } catch (Exception e) {
            LOG.error("Exception is got from the isValidPromoCode method ", e);
            e.printStackTrace(new PrintWriter(errors));
            sending.emailSending("Exception from  isValidPromoCode method in PromoImpl Class " + errors.toString());
        }
        query = "select promo_code, promo_discount_price, promo_start_date, promo_end_date from promo_master  where promo_code=? and promo_status=?";
        try {
            if (conn != null) {
                LOG.info("Connection is not null and log before prepareStatement");
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, promomasterbean.getPromo_code());
                pstmt.setString(2, promomasterbean.getPromo_status());
                try (ResultSet result = pstmt.executeQuery()) {
                    if (result.next()) {
                        LOG.info("ResultSet loop exeucted successfully ");
                        promomasterbean = new PromoMasterBean();
                        promomasterbean.setPromo_code(result.getString("promo_code"));
                        LOG.info("promo_code:" + result.getString("promo_code"));
                        promomasterbean.setPromo_discount_price(result.getString("promo_discount_price"));
                        LOG.info("promo_discount_price:" + result.getString("promo_discount_price"));
                        promomasterbean.setPromo_start_date(result.getString("promo_start_date"));
                        LOG.info("promo_start_date:" + result.getString("promo_start_date"));
                        promomasterbean.setPromo_end_date(result.getString("promo_end_date"));
                        LOG.info("promo_end_date:" + result.getString("promo_end_date"));
                        returnlist.add(promomasterbean);
                    }
                    result.close();
                } catch (Exception e) {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending(errors.toString());
                    LOG.error("Exception from the ResultSet in the getAllPromoCode in PromoImpl class", e);
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
                sending.emailSending("Exception from  isValidPromoCode mthod in PromoImpl Class " + errors.toString());
            } catch (Exception e) {
                System.out.println("SQLException in closing prepareStatement and connection " + e.getMessage());
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  isValidPromoCode mthod in PromoImpl Class" + errors.toString());
            }
        }
        return promomasterbean;
    }

}
