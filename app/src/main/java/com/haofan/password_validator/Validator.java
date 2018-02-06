package com.haofan.password_validator;

/**
 * Created by Haofan on 2018-02-05.
 */

public class Validator {

    private String passwd;

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

        Integer passed_num = 0;

        //Is there at least one special character contained? If so, if_specialchar=true
        boolean if_specialchar = false;

        //Is there at least one digit contained? If so, if_digit=true
        boolean if_digit = false;

        //Is there at least one upper case contained? If so, if_uppercase=true
        boolean if_uppercase = false;

        //Is there at least one lower case contained? If so, if_lowercase=true
        boolean if_lowercase = false;

        char[] special_char = new char[] {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*',
                '+', '-', ',', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
                '_', '`', '{', '|', '}', '~'};

        if(!passwd.equalsIgnoreCase("password"))
            passed_num++;

        if (passwd.length() >= 8)
            passed_num++;

        for (int i = 0; i < passwd.length(); i++){

            char char_passwd = passwd.charAt(i);

            if(Character.isUpperCase(char_passwd)) {
                if_uppercase = true;
            }else if(Character.isLowerCase(char_passwd)) {
                if_lowercase = true;
            }else if (Character.isDigit(char_passwd)){
                if_digit = true;
            }else{
                for (char aSpecial_char : special_char) {
                    if (char_passwd == aSpecial_char) {
                        if_specialchar = true;
                        break;
                    }
                }
            }

        }

        if(if_digit)
            passed_num++;

        if(if_lowercase && if_uppercase)
            passed_num++;

        if(if_specialchar)
            passed_num++;

        return passed_num;

    }

}