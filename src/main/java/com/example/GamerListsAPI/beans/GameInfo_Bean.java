package com.example.GamerListsAPI.beans;

public class GameInfo_Bean {
    private Integer gameId;
    private String gameName = "";
    private String publisher = "";
    private String version = "";
    private String launchDate = "";
    private Specs_Bean specs;

    public Integer getGameId() {
        return gameId;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public Specs_Bean getSpecs() {
        return specs;
    }

    public void setSpecs(Specs_Bean specs) {
        this.specs = specs;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }
}
