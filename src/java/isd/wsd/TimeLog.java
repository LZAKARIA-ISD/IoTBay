/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isd.wsd;

/**
 *
 * @author chris
 */
public class TimeLog {
    private String userEmail;
    private String loginTime;

    public TimeLog(String loginTime, String userEmail) {
        this.userEmail = userEmail;
        this.loginTime = loginTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }
    
    
}
