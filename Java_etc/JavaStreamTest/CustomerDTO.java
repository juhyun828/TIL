package dto;

public class CustomerDTO {
    private Integer cid;
    private String name;
    private AddressDTO address;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer cid, String name, AddressDTO address) {
        this.cid = cid;
        this.name = name;
        this.address = address;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
