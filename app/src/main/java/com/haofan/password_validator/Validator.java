package com.haofan.password_validator;

/**
 * Created by Haofan on 2018-02-05.
 */

public class Validator {

    private String passwd;
    private Integer passed_num;

    public Validator() {
    }

    public Validator(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer ifIsValid(String passwd){

        passed_num = 0;

        if(!passwd.equalsIgnoreCase("password"))
            passed_num++;

        if (passwd.length() >= 8)
            passed_num++;


        return passed_num;

    }

}