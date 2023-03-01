package com.coetusstudio.poetryhunter.Model;

public class poetryModel {

    String poetryId, poetName, poetryDescription, poetryDate;

    public poetryModel(String poetryId, String poetName, String poetryDescription, String poetryDate) {
        this.poetryId = poetryId;
        this.poetName = poetName;
        this.poetryDescription = poetryDescription;
        this.poetryDate = poetryDate;
    }

    public poetryModel() {
    }

    public String getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(String poetryId) {
        this.poetryId = poetryId;
    }

    public String getPoetName() {
        return poetName;
    }

    public void setPoetName(String poetName) {
        this.poetName = poetName;
    }

    public String getPoetryDescription() {
        return poetryDescription;
    }

    public void setPoetryDescription(String poetryDescription) {
        this.poetryDescription = poetryDescription;
    }

    public String getPoetryDate() {
        return poetryDate;
    }

    public void setPoetryDate(String poetryDate) {
        this.poetryDate = poetryDate;
    }
}
