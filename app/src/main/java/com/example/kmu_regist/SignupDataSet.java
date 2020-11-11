package com.example.kmu_regist;

public class SignupDataSet {

    private Integer id;
    private String email;
    private String pw;
    public boolean isRight = false;

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setId(Integer id){
        this.id = id;
    }

//    public Integer getId() {
//        return id;
//    }

    public SignupDataSet(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right){
        isRight = right;
    }

}
