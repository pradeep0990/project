package com.practise.model;

public class Account {
private String userName;
private String password;
private String email;
private String phno;
private String room_Name;


public String getRoom_Name() {
    return room_Name;
}
public void setRoom_Name(String room_Name) {
    this.room_Name = room_Name;
}


public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public long getPhno() {
    return Long.parseLong(phno);
}
public void setPhno(String phno) {
    this.phno = phno;
}
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
@Override
public String toString() {
    return "Account [userName=" + userName + ", password=" + password + ", email=" + email + ", phno=" + phno
	    + ", room_Name=" + room_Name + "]";
}

}
