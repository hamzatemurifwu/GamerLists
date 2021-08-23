package com.example.GamerListsAPI.beans;

public class GamerInfo_Bean {
    private int gamerId;
    private String gamerFName = "";
    private String gamerLName = "";
    private String emailAddress = "";
    private String gender = "";
    private GameInfo_Bean gameInfo;

    public GameInfo_Bean getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(GameInfo_Bean gameInfo) {
        this.gameInfo = gameInfo;
    }

    public int getGamerId() {
        return gamerId;
    }

    public void setGamerId(int gamerId) {
        this.gamerId = gamerId;
    }

    public String getGamerFName() {
        return gamerFName;
    }

    public void setGamerFName(String gamerFName) {
        this.gamerFName = gamerFName;
    }

    public String getGamerLName() {
        return gamerLName;
    }

    public void setGamerLName(String gamerLName) {
        this.gamerLName = gamerLName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
