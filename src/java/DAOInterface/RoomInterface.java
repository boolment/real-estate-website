package DAOInterface;

import beans.RoomMasterBean;
import java.util.List;

public interface RoomInterface {

    public boolean addRoomProperty(RoomMasterBean roomMasterBean);

    public String updateRoomProperty(RoomMasterBean roomMasterBean);

    public boolean deleteRoomProperty(RoomMasterBean roomMasterBean);

    public boolean blockRoomProperty(RoomMasterBean roomMasterBean);

    public boolean bookedRoomProperty(RoomMasterBean roomMasterBean);

    public RoomMasterBean getRoomPropertyLocation(RoomMasterBean roomMasterBean);

    public RoomMasterBean getRoomPropertyOwner(RoomMasterBean roomMasterBean);

    public RoomMasterBean getRoomPropertyCustomer(RoomMasterBean roomMasterBean);

    public RoomMasterBean getRoomPropertyImages(RoomMasterBean roomMasterBean);

    public RoomMasterBean getRoomProperty(RoomMasterBean roomMasterBean);

    public RoomMasterBean getRoomPropertyAmenities();

    public RoomMasterBean getRoomPropertyAddress();

    public Long getRoomPropertyCount();

    public List<RoomMasterBean> getAllRoomProperty();

    public String updateRoomPropertyOwner(RoomMasterBean roomMasterBean);

    public String updateRoomPropertyCustomer(RoomMasterBean roomMasterBean);
}
