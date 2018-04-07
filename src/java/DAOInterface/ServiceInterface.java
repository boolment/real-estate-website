package DAOInterface;

import beans.ServiceMasterBean;
import java.util.List;

public interface ServiceInterface {

    public boolean addService(ServiceMasterBean servicemasterbean);

    public String updateService(ServiceMasterBean servicemasterbean);

    public boolean deleteService(ServiceMasterBean servicemasterbean);

    public boolean blockService(ServiceMasterBean servicemasterbean);

    public ServiceMasterBean getService(ServiceMasterBean servicemasterbean);

    public List<ServiceMasterBean> getAllService();

    public Long getAllServiceCount();

    public boolean renewService(ServiceMasterBean servicemasterbean);

    public String updateServiceCustomerDetail(ServiceMasterBean servicemasterbean);

    public String updateServiceOwnerDetail(ServiceMasterBean servicemasterbean);

    public String updatepropertyDetail(ServiceMasterBean servicemasterbean);

    public boolean addServiceMembership(ServiceMasterBean servicemasterbean);

    public String updateServiceMembership(ServiceMasterBean servicemasterbean);

    public boolean blockServiceMembership(ServiceMasterBean servicemasterbean);

    public boolean deleteServiceMembership(ServiceMasterBean servicemasterbean);

    public Long getMembershipCount();

    public boolean addServicePromoCode(ServiceMasterBean servicemasterbean);

    public String updateServicePromoCode(ServiceMasterBean servicemasterbean);

    public boolean deleteServicePromoCode(ServiceMasterBean servicemasterbean);

    public Long getAllServicePromoCodeCount();
}
