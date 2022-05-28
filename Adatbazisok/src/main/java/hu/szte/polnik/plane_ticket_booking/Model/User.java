package hu.szte.polnik.plane_ticket_booking.Model;

import java.io.Serializable;

public class User implements Serializable {


    int userid;
    String first_name;
    String last_name;
    String citizenship;
    String mobile;
    String password;
    String email;

    public User(int user_ID, String first_name, String last_name, String citizenship, String mobile, String password, String email) {
        this.userid = user_ID;
        this.first_name = first_name;
        this.last_name = last_name;
        this.citizenship = citizenship;
        this.mobile = mobile;
        this.password = password;
        this.email = email;
    }
    public User(){

    }
    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {this.first_name = first_name;}
    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {this.last_name = last_name;}
    public String getCitizenship() {return citizenship;}
    public void setCitizenship(String citizenship) {this.citizenship = citizenship;}
    public String getMobile() {return mobile;}
    public void setMobile(String mobile) {this.mobile = mobile;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }


}