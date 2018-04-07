package DAOInterface;

import beans.PromoMasterBean;
import java.util.List;

public interface PromoInterface {

    public boolean addPromoCode(PromoMasterBean promomasterbean);

    public boolean updatePromoCode(PromoMasterBean promomasterbean);

    public boolean deletePromoCode(PromoMasterBean promomasterbean);

    public boolean blockPromoCode(PromoMasterBean promomasterbean);

    public PromoMasterBean getPromoCode(PromoMasterBean promomasterbean);

    public List<PromoMasterBean> getAllPromoCode();

    public List<PromoMasterBean> getAllPromoCodeReport(PromoMasterBean promomasterbean);

    public Long getAllPromoCount();

    public boolean approvePromoCode(PromoMasterBean promomasterbean);

    public PromoMasterBean isValidPromoCode(PromoMasterBean promomasterbean);

}
