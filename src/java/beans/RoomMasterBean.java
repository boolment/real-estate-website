package beans;

public class RoomMasterBean {

    private int room_property_id;
    private String type_of_occupancy;
    private String room_owner_id;
    private String room_unique_id;
    private String creation_date;
    private String status;
    private PropertyMasterBean propertymasterbean;
    private AmenitiesMasterBean amenitiesmasterbean;
    private AddressPropertyBean addresspropertybean;
    private ImagesMasterBean imagemasterbean;
    private String room_owner_unique_id;

    public int getRoom_property_id() {
        return room_property_id;
    }

    public void setRoom_property_id(int room_property_id) {
        this.room_property_id = room_property_id;
    }

    public String getType_of_occupancy() {
        return type_of_occupancy;
    }

    public void setType_of_occupancy(String type_of_occupancy) {
        this.type_of_occupancy = type_of_occupancy;
    }

    public String getRoom_owner_id() {
        return room_owner_id;
    }

    public void setRoom_owner_id(String room_owner_id) {
        this.room_owner_id = room_owner_id;
    }

    public String getRoom_unique_id() {
        return room_unique_id;
    }

    public void setRoom_unique_id(String room_unique_id) {
        this.room_unique_id = room_unique_id;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PropertyMasterBean getPropertymasterbean() {
        return propertymasterbean;
    }

    public void setPropertymasterbean(PropertyMasterBean propertymasterbean) {
        this.propertymasterbean = propertymasterbean;
    }

    public AmenitiesMasterBean getAmenitiesmasterbean() {
        return amenitiesmasterbean;
    }

    public void setAmenitiesmasterbean(AmenitiesMasterBean amenitiesmasterbean) {
        this.amenitiesmasterbean = amenitiesmasterbean;
    }

    public AddressPropertyBean getAddresspropertybean() {
        return addresspropertybean;
    }

    public void setAddresspropertybean(AddressPropertyBean addresspropertybean) {
        this.addresspropertybean = addresspropertybean;
    }

    public ImagesMasterBean getImagemasterbean() {
        return imagemasterbean;
    }

    public void setImagemasterbean(ImagesMasterBean imagemasterbean) {
        this.imagemasterbean = imagemasterbean;
    }

    public String getRoom_owner_unique_id() {
        return room_owner_unique_id;
    }

    public void setRoom_owner_unique_id(String room_owner_unique_id) {
        this.room_owner_unique_id = room_owner_unique_id;
    }

}
