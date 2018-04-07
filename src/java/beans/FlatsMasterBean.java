package beans;

public class FlatsMasterBean {

    private int flat_property_id;
    private String type_of_flat;
    private String flat_owner_id;
    private String flat_unique_id;
    private String creation_date;
    private String status;
    private PropertyMasterBean propertymasterbean;
    private AmenitiesMasterBean amenitiesmasterbean;
    private AddressPropertyBean addresspropertybean;
    private ImagesMasterBean imagemasterbean;
    private String room_owner_unique_id;

    public int getFlat_property_id() {
        return flat_property_id;
    }

    public void setFlat_property_id(int flat_property_id) {
        this.flat_property_id = flat_property_id;
    }

    public String getType_of_flat() {
        return type_of_flat;
    }

    public void setType_of_flat(String type_of_flat) {
        this.type_of_flat = type_of_flat;
    }

    public String getFlat_owner_id() {
        return flat_owner_id;
    }

    public void setFlat_owner_id(String flat_owner_id) {
        this.flat_owner_id = flat_owner_id;
    }

    public String getFlat_unique_id() {
        return flat_unique_id;
    }

    public void setFlat_unique_id(String flat_unique_id) {
        this.flat_unique_id = flat_unique_id;
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
