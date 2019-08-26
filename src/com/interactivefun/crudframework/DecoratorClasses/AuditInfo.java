package com.interactivefun.crudframework.DecoratorClasses;

import java.util.Date;

public class AuditInfo {

    private String userName;
    public String getUserName() { return userName; }
    public void setUserName(String userName) {this.userName = userName; }

    private Date timeStamp;
    public Date getTimeStamp() {return timeStamp; }
    public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }

}
