package beans;

public class PgMasterBean {

    private int pg_property_id;
    private String type_of_occupancy;
    private String pg_owner_id;
    private String pg_unique_id;
    private String creation_date;
    private String status;
    private PropertyMasterBean propertymasterbean;
    private AmenitiesMasterBean amenitiesmasterbean;
    private AddressPropertyBean addresspropertybean;
    private ImagesMasterBean imagemasterbean;
    private String room_owner_unique_id;

    public int getPg_property_id() {
        return pg_property_id;
    }

    public void setPg_property_id(int pg_property_id) {
        this.pg_property_id = pg_property_id;
    }

    public String getType_of_occupancy() {
        return type_of_occupancy;
    }

    public void setType_of_occupancy(String type_of_occupancy) {
        this.type_of_occupancy = type_of_occupancy;
    }

    public String getPg_owner_id() {
        return pg_owner_id;
    }

    public void setPg_owner_id(String pg_owner_id) {
        this.pg_owner_id = pg_owner_id;
    }

    public String getPg_unique_id() {
        return pg_unique_id;
    }

    public void setPg_unique_id(String pg_unique_id) {
        this.pg_unique_id = pg_unique_id;
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
