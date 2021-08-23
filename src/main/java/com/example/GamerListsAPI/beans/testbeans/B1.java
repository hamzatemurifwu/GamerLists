package com.example.GamerListsAPI.beans.testbeans;

import com.example.GamerListsAPI.beans.GameInfo_Bean;

import java.util.ArrayList;
import java.util.List;

public class B1 {
    private int gamerId;
    private String gamerFName = "";
    private String gamerLName = "";
    private String emailAddress = "";
    private String gender = "";
    private List<GameInfo_Bean> gameInfo = new ArrayList<>();

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

    public List<GameInfo_Bean> getGameInfo() {
        return gameInfo;
    }

    public void setGameInfo(List<GameInfo_Bean> gameInfo) {
        this.gameInfo = gameInfo;
    }
}
