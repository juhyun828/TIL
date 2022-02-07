package dto;

public class CustomerAddressDTO {
    private Integer cid;
    private String name;
    private Integer aid;
    private Integer aaid;
    private String city;
    private String state;

    public CustomerAddressDTO() {
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

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getAaid() {
        return aaid;
    }

    public void setAaid(Integer aaid) {
        this.aaid = aaid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "CustomerAddressDTO{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", aid=" + aid +
                ", aaid=" + aaid +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
