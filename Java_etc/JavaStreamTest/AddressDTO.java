package dto;

public class AddressDTO {
    private Integer aid;
    private String city;
    private String state;

    public AddressDTO() {
    }

    public AddressDTO(Integer aid, String city, String state) {
        this.aid = aid;
        this.city = city;
        this.state = state;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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
        return "AddressDTO{" +
                "aid=" + aid +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
