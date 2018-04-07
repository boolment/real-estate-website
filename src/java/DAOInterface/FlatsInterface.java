package DAOInterface;

import beans.FlatsMasterBean;
import java.util.List;

public interface FlatsInterface {

    public boolean addFlatProperty(FlatsMasterBean flatsMasterBean);

    public String updateFlatProperty(FlatsMasterBean flatsMasterBean);

    public boolean deleteFlatProperty(FlatsMasterBean flatsMasterBean);

    public boolean blockFlatProperty(FlatsMasterBean flatsMasterBean);

    public boolean bookedFlatProperty(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatPropertyLocation(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatPropertyOwner(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatPropertyCustomer(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatPropertyImages(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatProperty(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatPropertyAmenities(FlatsMasterBean flatsMasterBean);

    public FlatsMasterBean getFlatPropertyAddress(FlatsMasterBean flatsMasterBean);

    public Long getFlatPropertyCount();

    public List<FlatsMasterBean> getAllFlatProperty();

    public String updateFlatPropertyOwner(FlatsMasterBean flatsMasterBean);

    public String updateFlatPropertyCustomer(FlatsMasterBean flatsMasterBean);
}
