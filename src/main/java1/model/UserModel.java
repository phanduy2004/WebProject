package model;

import java.io.Serializable;
import java.util.Date;
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1;

    //klhai bao
    private int id;
    private String name;
    private String email;
    private String fullname;
    private String password;
    private String image;
    private int roleid;
    private String phone;
    private Date createData;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    @Override
    public String toString() {
        return "model.UserModel{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", images='" + image + '\'' +
                ", roleId=" + roleid +
                ", phone='" + phone + '\'' +
                ", createData=" + createData +
                '}';
    }
}