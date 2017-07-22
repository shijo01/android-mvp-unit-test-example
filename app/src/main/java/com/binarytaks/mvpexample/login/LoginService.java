package com.binarytaks.mvpexample.login;

/**
 * Created by shijo on 22/7/17.
 */

class LoginService {
    boolean login(String username, String password) {
        return username.length() > 5 && password.length() > 4;
    }
}
