package entity;

public class Customer {
    private Integer cid;
    private String name;
    private Integer aid;

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

    public Customer(Integer cid, String name, Integer aid) {
        this.cid = cid;
        this.name = name;
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", aid=" + aid +
                '}';
    }
}
