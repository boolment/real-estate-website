package DAOInterface;

import beans.OwnerMasterBean;
import java.util.List;

public interface OwnerInterface {

    public String addOwner(OwnerMasterBean ownermasterbean);

    public boolean updateOwner(OwnerMasterBean ownermasterbean);

    public boolean blockOwner(OwnerMasterBean ownermasterbean);

    public boolean deleteOwner(OwnerMasterBean ownermasterbean);

    public OwnerMasterBean getOwner(OwnerMasterBean ownermasterbean);

    public List<OwnerMasterBean> getAllOwner();

    public String getOwnerUniqueId(OwnerMasterBean ownermasterbean);

    public boolean isValidOwner(OwnerMasterBean ownermasterbean);

    public Long getOwnerCount();

    public String getOwnerEmailId(OwnerMasterBean ownermasterbean);

    public boolean isValidOwnerEmailId(OwnerMasterBean ownermasterbean);

    public String getOwnerPhoneNo(OwnerMasterBean ownermasterbean);

    public boolean isValidOwnerPhoneNo(OwnerMasterBean ownermasterbean);

    public String getOwnerUserName(OwnerMasterBean ownermasterbean);

    public boolean isValidOwnerUserName(OwnerMasterBean ownermasterbean);

    public String getOwnerPassword(OwnerMasterBean ownermasterbean);

    public boolean isValidOwnerPassword(OwnerMasterBean ownermasterbean);

    public boolean setOwnerChangePassword(OwnerMasterBean ownermasterbean);

    public String getOwnerOTP(OwnerMasterBean ownermasterbean);

    public boolean setOwnerOTP(OwnerMasterBean ownermasterbean);

    public OwnerMasterBean isValidOwnerByPhoneNo(OwnerMasterBean ownermasterbean);

    public OwnerMasterBean isValidOwnerByEmailId(OwnerMasterBean ownermasterbean);

}
