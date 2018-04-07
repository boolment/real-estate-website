package DAOInterface;

import beans.CustomerMasterBean;
import java.util.List;

public interface CustomerInterface {

    public String addCustomer(CustomerMasterBean customermasterbean);

    public boolean updateCustomer(CustomerMasterBean customermasterbean);

    public boolean blockCustomer(CustomerMasterBean customermasterbean);

    public boolean deleteCustomer(CustomerMasterBean customermasterbean);

    public CustomerMasterBean getCustomer(CustomerMasterBean customermasterbean);

    public List<CustomerMasterBean> getAllCustomer();

    public String getCustomerUniqueId(CustomerMasterBean customermasterbean);

    public boolean isValidCustomer(CustomerMasterBean customermasterbean);

    public Long getCustomerCount();

    public String getCustomerEmailId(CustomerMasterBean customermasterbean);

    public boolean isValidCustomerEmailId(CustomerMasterBean customermasterbean);

    public String getCustomerPhoneNo(CustomerMasterBean customermasterbean);

    public boolean isValidCustomerPhoneNo(CustomerMasterBean customermasterbean);

    public String getCustomerUserName(CustomerMasterBean customermasterbean);

    public boolean isValidCustomerUserName(CustomerMasterBean customermasterbean);

    public String getCustomerPassword(CustomerMasterBean customermasterbean);

    public boolean isValidCustomerPassword(CustomerMasterBean customermasterbean);

    public boolean setCustomerChangePassword(CustomerMasterBean customermasterbean);

    public String getCustomerOTP(CustomerMasterBean customermasterbean);

    public boolean setCustomerOTP(CustomerMasterBean customermasterbean);
}
