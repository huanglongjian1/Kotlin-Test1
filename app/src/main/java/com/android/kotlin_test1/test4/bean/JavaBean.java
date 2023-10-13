package com.android.kotlin_test1.test4.bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class JavaBean {

    /**
     * id : 1
     * name : Roman
     * email : rpenburton0@yellowbook.com
     * avatar : https://dummyimage.com/100x100.png/5fa2dd/ffffff
     * userId : 22873363
     * userToken : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMjI4NzMzNjMifQ.qyBRqpBCmi9JxCcyMSRwciX1IZSW4AWyYSXs-mZw_zA
     * device_Token : d-fMma7mTmWKJdJqXygdn2:APA91bHfvMqXzrEhSqo-AH3xePNa5JoIQlMmPH1hXvTGVc63GCr38lkwP4AVHgV-0iiktxuO_sMapoWIRDlHWgThkm-PpQqmfLweX4Vy-U4jlO8RglyohJzUTaCjqf7hHBTLJSG2GYAJ
     */
    @PrimaryKey
    private int id;
    private String name;
    private String email;
    private String avatar;
    private String userId;
    private String userToken;
    private String device_Token;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getDevice_Token() {
        return device_Token;
    }

    public void setDevice_Token(String device_Token) {
        this.device_Token = device_Token;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userId='" + userId + '\'' +
                ", userToken='" + userToken + '\'' +
                ", device_Token='" + device_Token + '\'' +
                '}';
    }
}
