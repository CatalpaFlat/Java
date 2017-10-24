package Channel;

/**
 * @author 陈梓平
 * @date 2017/10/20.
 */
public class Persion {
    private String name;
    private String phone;
    private String idCard;
    private String address;

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Persion setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Persion setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public Persion setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Persion setAddress(String address) {
        this.address = address;
        return this;
    }
}
