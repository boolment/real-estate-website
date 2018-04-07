package DAOInterface;

import beans.PgMasterBean;
import java.util.List;

public interface PgInterface {

    public boolean addPgProperty(PgMasterBean pgMasterBean);

    public String updatePgProperty(PgMasterBean pgMasterBean);

    public boolean deletePgProperty(PgMasterBean pgMasterBean);

    public boolean blockPgProperty(PgMasterBean pgMasterBean);

    public boolean bookedPgProperty(PgMasterBean pgMasterBean);

    public PgMasterBean getPgPropertyLocation(PgMasterBean pgMasterBean);

    public PgMasterBean getPgPropertyOwner(PgMasterBean pgMasterBean);

    public PgMasterBean getPgPropertyCustomer(PgMasterBean pgMasterBean);

    public PgMasterBean getPgPropertyImages(PgMasterBean pgMasterBean);

    public PgMasterBean getPgProperty(PgMasterBean pgMasterBean);

    public PgMasterBean getPgPropertyAmenities(PgMasterBean pgMasterBean);

    public PgMasterBean getPgPropertyAddress(PgMasterBean pgMasterBean);

    public Long getPgPropertyCount();

    public List<PgMasterBean> getAllRoomProperty();

    public String updatePgPropertyOwner(PgMasterBean pgMasterBean);

    public String updatePgPropertyCustomer(PgMasterBean pgMasterBean);

}
