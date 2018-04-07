package DAOInterface;

import beans.LeadMasterBean;
import java.util.List;

public interface LeadInterface {

    public boolean addLead(LeadMasterBean leadmasterbean);

    public boolean updateLead(LeadMasterBean leadmasterbean);

    public boolean deleteLead(LeadMasterBean leadmasterbean);

    public boolean blockLead(LeadMasterBean leadmasterbean);

    public LeadMasterBean getLead(LeadMasterBean leadmasterbean);

    public List<LeadMasterBean> getAllLead();

    public boolean assignToLead(LeadMasterBean leadmasterbean);

    public Long getLeadCount();
}
