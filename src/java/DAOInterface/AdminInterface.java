package DAOInterface;

import beans.AdminMasterBean;
import java.util.List;

public interface AdminInterface {

    public String addAdmin(AdminMasterBean adminmasterbean);

    public boolean updateAdmin(AdminMasterBean adminmasterbean);

    public boolean blockAdmin(AdminMasterBean adminmasterbean);

    public boolean deleteAdmin(AdminMasterBean adminmasterbean);

    public AdminMasterBean getAdmin(AdminMasterBean adminmasterbean);

    public List<AdminMasterBean> getAllAdmin();

    public String getAdminUniueId(AdminMasterBean adminmasterbean);

    public boolean isValidAmin(AdminMasterBean adminmasterbean);

    public Long getAdminCount();

    public AdminMasterBean getAdminEmailId(AdminMasterBean adminmasterbean);

    public boolean isValidAdminEmailId(AdminMasterBean adminmasterbean);

    public String getAdminPhoneNo(AdminMasterBean adminmasterbean);

    public boolean isValidAdminPhoneNo(AdminMasterBean adminmasterbean);

    public String getAdminUserName(AdminMasterBean adminmasterbean);

    public boolean isValidAdminUserName(AdminMasterBean adminmasterbean);

    public String getAdminPassword(AdminMasterBean adminmasterbean);

    public boolean setAdminChangePassword(AdminMasterBean adminmasterbean);

    public String getAdminOTP(AdminMasterBean adminmasterbean);

    public boolean setAdminOtp(AdminMasterBean adminmasterbean);
}
