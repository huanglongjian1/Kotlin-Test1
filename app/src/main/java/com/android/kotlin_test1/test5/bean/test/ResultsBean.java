package com.android.kotlin_test1.test5.bean.test;

public class ResultsBean {
    /**
     * gender : female
     * name : {"title":"Mrs","first":"Ayida","last":"Andrusyak"}
     * location : {"street":{"number":1572,"name":"Kolodyazna"},"city":"Zavodske","state":"Harkivska","country":"Ukraine","postcode":24496,"coordinates":{"latitude":"79.2701","longitude":"107.9680"},"timezone":{"offset":"-1:00","description":"Azores, Cape Verde Islands"}}
     * email : ayida.andrusyak@example.com
     * login : {"uuid":"0096265c-2da2-4882-af44-ef66b2576142","username":"crazytiger996","password":"cowboys","salt":"YNkHGiO7","md5":"867e4e1ffcac15ba1bfbd118e276f7ab","sha1":"eb648f23d2d62499f70fbda5f17c24bdf96efe76","sha256":"269ce16e8efc30411c0d66e6d8ed6cce3c07c6925c3c3d01d46306f3c9d99c08"}
     * dob : {"date":"1968-08-25T08:26:24.355Z","age":55}
     * registered : {"date":"2010-11-24T22:50:21.835Z","age":12}
     * phone : (067) I44-0216
     * cell : (097) E63-1806
     * id : {"name":"","value":null}
     * picture : {"large":"https://randomuser.me/api/portraits/women/72.jpg","medium":"https://randomuser.me/api/portraits/med/women/72.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/72.jpg"}
     * nat : UA
     */

    private String gender;
    private NameBean name;
    private LocationBean location;
    private String email;
    private LoginBean login;
    private DobBean dob;
    private DobBean registered;
    private String phone;
    private String cell;
    private IdBean id;
    private PictureBean picture;
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public NameBean getName() {
        return name;
    }

    public void setName(NameBean name) {
        this.name = name;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LoginBean getLogin() {
        return login;
    }

    public void setLogin(LoginBean login) {
        this.login = login;
    }

    public DobBean getDob() {
        return dob;
    }

    public void setDob(DobBean dob) {
        this.dob = dob;
    }

    public DobBean getRegistered() {
        return registered;
    }

    public void setRegistered(DobBean registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public IdBean getId() {
        return id;
    }

    public void setId(IdBean id) {
        this.id = id;
    }

    public PictureBean getPicture() {
        return picture;
    }

    public void setPicture(PictureBean picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }
}
